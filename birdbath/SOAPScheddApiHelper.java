import condor.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class JobSubmissionException extends Exception
{
      public JobSubmissionException()
      {
            super();
      }
      public JobSubmissionException(String s)
      {
            super(s);
      }
}


class SendFileException extends Exception
{
      public SendFileException()
      {
            super();
      }
      public SendFileException(String s)
      {
            super(s);
      }
}


class GetFileException extends Exception
{
    public GetFileException()
    {
	super();
    }
    public GetFileException(String s)
    {
	super(s);
    }
}


/** SOAPScheddApiHelper - A Helper Library for Java Clients to the schedd
 * It is meant to be used to simplify communication with the schedd using
 * the Stubs generated by Axis from the schedd's WSDL
 *
 * @author Swaroop Sayeram
 */
public class SOAPScheddApiHelper {

    /**
     * Files are sent/got from the schedd-spool in these byte-blocks
     */
    final static int FILE_TRAN_BUFF = 4096;


    /**
     * The most complex (in terms of client-intelligence) of submitJobHelpers,
     * Since the client would have to fully-form the jobAd to be submitted
     *
     * @param schedd The schedd where the job is to be submitted
     *
     * @param transaction The transaction you would like to use to submit
     * the job. A "null" value, would invoke a new Transaction.
     * NOTE: the transaction will be committed after the job is submitted
     * if it's value is "null", else the calling program is expected to
     * commit the transaction
     *
     * @param jobAd The fully-formed jobAd, describing the job to be submitted
     *
     * @param files List of files to be sent to the schedd
     *
     * @exception JobSubmissionException raised when<br>
     * 1.the JobAd is null<br>
     * 2.schedd fails to begin transaction<br>
     * 3.unable to submit job to the schedd<br>
     * 4.schedd fails to commit transaction
     *
     * @exception SendFileException Unable to perform file-transfer with schedd
     *
     * @exception java.io.IOException Unable to access client file
     *
     * @exception java.rmi.RemoteException Unable to make remote calls to schedd
     */
    public static void submitJobHelper(CondorScheddPortType schedd,
				       Transaction transaction,
				       ClassAdStructAttr[] jobAd,
				       String[] files)
	throws JobSubmissionException, SendFileException,
	       java.io.IOException, java.rmi.RemoteException {

	int clusterId, jobId;

	if(jobAd != null) {
	    clusterId = Integer.parseInt(getAttributeValue(jobAd,"ClusterId"));
	    jobId = Integer.parseInt(getAttributeValue(jobAd,"ProcId"));
	}
	else {
	    System.err.println("jobAd attribute is NULL");
	    throw new JobSubmissionException("jobAd attribute is NULL");
	}

	boolean dontCommit = true;

	if(transaction == null) {
	    dontCommit = false;
	    TransactionAndStatus trans_s = schedd.beginTransaction(60);
	    if(!(trans_s.getStatus()).getCode().equals(StatusCode.SUCCESS)) {
		System.err.println("Failed to begin Transaction");
		throw new JobSubmissionException("Failed to begin Transaction");
	    }
	    transaction = trans_s.getTransaction();
	}

	// Send the files
	if(files != null) {
	    for(int i=0; i<files.length; i++) {
		sendFileHelper(schedd,
			       files[i], transaction, clusterId, jobId);
	    }
	}

   RequirementsAndStatus reqs_s = schedd.submit(transaction,
                                                clusterId,
                                                jobId,
                                                new ClassAdStruct(jobAd));
	if(!(reqs_s.getStatus()).getCode().equals(StatusCode.SUCCESS)) {
	    System.err.println("Failed to submit successfully");
	    throw new JobSubmissionException("Failed to submit successfully");
	}
	Requirements reqs = reqs_s.getRequirements();
	if(reqs.getItem() != null) {
	    System.err.println("Requirements not met");
	// file transfer?
	}

	if(!dontCommit) {
	    Status st = schedd.commitTransaction(transaction);
	    if(!(st.getCode()).equals(StatusCode.SUCCESS)) {
		System.err.println("Failed to commit");
		throw new JobSubmissionException("Failed to commit");
	    }
	}

    }



    /**
     * A Submit Job helper function which provides a very simple interface
     *
     * @param schedd The schedd where the job is to be submitted
     *
     * @param transaction The transaction you would like to use to submit
     * the job. A "null" value, would invoke a new Transaction.
     * NOTE: the transaction will be committed after the job is submitted
     * if it's value is "null", else the calling program is expected to
     * commit the transaction
     *
     * @param clusterId The cluster-number where you would like to submit
     * the job. A negative integer would invoke a new clusterID.
     *
     * @param jobId The job-number of the job to be submitted.
     * A negative integer would invoke a new clusterID.
     *
     * @param owner The attribute-value for the job's owner attribute.
     * A "null" value for owner, would choose the current user of the program
     *
     * @param type The attribute-value for the job's JobUniverse attribute.
     * A "null" value for type, would choose the STANDARD Universe
     *
     * @param cmd The attribute-value for the job's executable/Cmd attribute.
     *
     * @param args The attribute-value for the job's Arguments attribute
     * A "null" value for args, would choose an empty string
     *
     * @param requirements The attribute-value for the job's Requirements attribute
     * A "null" value for Requirements, would choose the Boolean value - True
     *
     * @param newAttr used to specify new Attributes, to either update the
     * default classad generated by createJobTemplate(),
     * or append new attributes to it
     *
     * @param files List of files to be sent to the schedd
     *
     * @exception JobSubmissionException raised when<br>
     * 1.schedd fails to begin new Transaction<br>
     * 2.schedd fails to create new Cluster<br>
     * 3.schedd fails to create new Job<br>
     * 4.schedd fails to commit<br>
     * 5.cmd argument is null<br>
     * 6.schedd fails to create job-template<br>
     * 7.unable to submit job to the schedd
     *
     * @exception SendFileException Unable to perform file-transfer with schedd
     *
     * @exception java.io.IOException Unable to access client file
     *
     * @exception java.rmi.RemoteException Unable to make remote calls to schedd
     */
    public static void submitJobHelper(CondorScheddPortType schedd,
				       Transaction transaction,
				       int clusterId, int jobId, String owner,
				       UniverseType type,
				       String cmd, String args,
				       String requirements,
				       ClassAdStructAttr[] newAttr,
				       String[] files)
	throws JobSubmissionException, SendFileException,
	       java.io.IOException, java.rmi.RemoteException {

	boolean dontCommit = true;
	boolean nullTransaction = false;

	if(transaction == null) {
	    dontCommit = false;
	    nullTransaction = true;
	    TransactionAndStatus trans_s = schedd.beginTransaction(60);
	    if(!(trans_s.getStatus()).getCode().equals(StatusCode.SUCCESS)) {
		System.err.println("Failed to begin Transaction");
		throw new JobSubmissionException("Failed to begin Transaction");
	    }
	    transaction = trans_s.getTransaction();
	}

	if(clusterId < 0) {
	    IntAndStatus clust_s = schedd.newCluster(transaction);
	    if(!(clust_s.getStatus()).getCode().equals(StatusCode.SUCCESS)) {
		System.err.println("Failed to create new cluster");
		throw new JobSubmissionException("Failed to create new cluster");
	    }
	    clusterId = (clust_s.getInteger()).intValue();
	}

	if(jobId < 0) {
	    IntAndStatus jobid_s = schedd.newJob(transaction, clusterId);
	    if(!(jobid_s.getStatus()).getCode().equals(StatusCode.SUCCESS)) {
		System.err.println("Failed to create new Job");
		throw new JobSubmissionException("Failed to create new Job");
	    }
	    jobId = (jobid_s.getInteger()).intValue();
	}

	if(!dontCommit) {
	    Status st = schedd.commitTransaction(transaction);
	    if(!(st.getCode()).equals(StatusCode.SUCCESS)) {
		System.err.println("Failed to commit");
		throw new JobSubmissionException("Failed to commit");
	    }
	}

	if(owner == null) {
	    owner = System.getProperty("user.name");
	}

	if(type == null) {
	    type = UniverseType.STANDARD;
	}

	if(args == null) {
	    args = "";
	}

	if(requirements == null) {
	    requirements = "TRUE";
	}

	if(cmd == null) {
	    System.err.println("Illegal Job Template parameter - CommandName has to be specified");
	    throw new JobSubmissionException("Illegal Job Template parameters - CommandName has to be specified");
	}
	ClassAdStructAndStatus cas_s =
	    schedd.createJobTemplate(clusterId, jobId, owner,
				     type, cmd, args, requirements);
	if(!(cas_s.getStatus()).getCode().equals(StatusCode.SUCCESS)) {
	    System.err.println("Failed to create Job Template");
	    throw new JobSubmissionException("Failed to create Job Template");
	}
	ClassAdStructAttr[] jobAd = cas_s.getClassAd().getItem();

	if(newAttr != null) {
	    for(int i=0; i<newAttr.length; i++) {
		jobAd = setAttributeValue(jobAd, newAttr[i]);
	    }
	}

	if(nullTransaction)
	    transaction = null;

	submitJobHelper(schedd, transaction, jobAd, files);

    }



    /**
     * A Submit Job helper function which provides the simplest of interfaces
     * (for a client with the least intelligence)
     *
     * @param schedd The schedd where the job is to be submitted
     *
     * @param cmd attribute-values for the job's executable
     *
     * @param args attribute-values for the job's arguments
     *
     * @param files List of files to be sent to the schedd
     *
     * @exception JobSubmissionException raised when<br>
     * 1.schedd fails to begin new Transaction<br>
     * 2.schedd fails to create new Cluster<br>
     * 3.schedd fails to create new Job<br>
     * 4.schedd fails to commit<br>
     * 5.cmd argument is null<br>
     * 6.schedd fails to create job-template<br>
     * 7.unable to submit job to the schedd<br>
     *
     * @exception SendFileException Unable to perform file-transfer with schedd
     *
     * @exception java.io.IOException Unable to access client file
     */
    public static void submitJobHelper(CondorScheddPortType schedd,
				       String cmd, String args,
				       String[] files)
	throws JobSubmissionException, SendFileException, java.io.IOException {

	submitJobHelper(schedd, null, -1, -1,
			null, null, cmd, args, null, null, files);

    }



    /**
     * A helper function which provides a simple interface to
     * directly submit a DAG job
     *
     * @param schedd The schedd where the job is to be submitted
     *
     * @param transaction The transaction you would like to use to submit
     * the job. A "null" value, would invoke a new Transaction.
     * NOTE: the transaction will be committed after the job is submitted
     * if it's value is "null", else the calling program is expected to
     * commit the transaction
     *
     * @param clusterId The cluster-number where you would like to submit
     * the job. A negative integer would invoke a new clusterID.
     *
     * @param jobId The job-number of the job to be submitted.
     * A negative integer would invoke a new clusterID.
     *
     * @param dagFileName dag's file name
     * NOTE: It has to be a member of files[],(if it has to be transferred too)
     *
     * @param dagmanExecutableLocation dagman executable filename
     * (or path to location)
     *
     * @param newAttr used to specify new Attributes, to either update the
     * default classad generated by createJobTemplate(),
     * or append new attributes to it
     * NOTE: This function sets LeaveJobInQueue, Env, UserLog, Out, Err
     * attributes to certain standard default values as indicated by the code
     * The entries in newAttr can overwrite the ones set by the helper function
     *
     * @param files List of files to be sent to the schedd
     * (Should include the dag file, & the submit files)
     *
     * @exception JobSubmissionException raised when<br>
     * 1.schedd fails to begin new Transaction<br>
     * 2.schedd fails to create new Cluster<br>
     * 3.schedd fails to create new Job<br>
     * 4.schedd fails to commit<br>
     * 5.cmd argument is null<br>
     * 6.schedd fails to create job-template<br>
     * 7.unable to submit job to the schedd
     *
     * @exception SendFileException Unable to perform file-transfer with schedd
     *
     * @exception java.io.IOException Unable to access client file
     *
     * @exception java.rmi.RemoteException Unable to make remote calls to schedd
     */
    public static void submitDAGHelper(CondorScheddPortType schedd,
				       Transaction transaction,
				       int clusterId, int jobId,
				       String dagFileName,
				       String dagmanExecutableLocation,
				       ClassAdStructAttr[] newAttr,
				       String[] files)
	throws java.rmi.RemoteException, JobSubmissionException,
	       SendFileException, java.io.IOException  {

	boolean dontCommit = true;
	boolean nullTransaction = false;

	if(transaction == null) {
	    dontCommit = false;
	    nullTransaction = true;
	    TransactionAndStatus trans_s = schedd.beginTransaction(60);
	    if(!(trans_s.getStatus()).getCode().equals(StatusCode.SUCCESS)) {
		System.err.println("Failed to begin Transaction");
		throw new
		    JobSubmissionException("Failed to begin Transaction");
	    }
	    transaction = trans_s.getTransaction();
	}

	if(clusterId < 0) {
	    IntAndStatus clust_s = schedd.newCluster(transaction);
	    if(!(clust_s.getStatus()).getCode().equals(StatusCode.SUCCESS)) {
		System.err.println("Failed to create new cluster");
		throw new
		    JobSubmissionException("Failed to create new cluster");
	    }
	    clusterId = (clust_s.getInteger()).intValue();
	}

	if(jobId < 0) {
	    IntAndStatus jobid_s = schedd.newJob(transaction, clusterId);
	    if(!(jobid_s.getStatus()).getCode().equals(StatusCode.SUCCESS)) {
		System.err.println("Failed to create new Job");
		throw new JobSubmissionException("Failed to create new Job");
	    }
	    jobId = (jobid_s.getInteger()).intValue();
	}

	if(!dontCommit) {
	    Status st = schedd.commitTransaction(transaction);
	    if(!(st.getCode()).equals(StatusCode.SUCCESS)) {
		System.err.println("Failed to commit");
		throw new JobSubmissionException("Failed to commit");
	    }
	}


	String dagOutputFileLocation = dagFileName + ".dagman.out";
	String dagLogFileLocation = dagFileName + ".dagman.log";
	String stdOutLocation = dagFileName + ".stdout";
	String stdErrLocation = dagFileName + ".stderr";
	String dagmanLockFile = dagFileName + ".lock";
	String rescueDag = dagFileName + ".rescue";
	String condorLog = dagFileName + ".log";

	int newAttrLength = 0;
	if(newAttr != null) {
	    newAttrLength = newAttr.length;
	}

	ClassAdStructAttr[] DagAttrs = new ClassAdStructAttr[5+newAttrLength];
	for(int i=0; i<(5+newAttrLength); i++)
	    DagAttrs[i] = new ClassAdStructAttr();

	DagAttrs[0].setName("LeaveJobInQueue");
	DagAttrs[0].setValue("((JobStatus==4) && ((ServerTime - CompletionDate) < (60 * 60 * 24)))") ;
	DagAttrs[0].setType(ClassAdAttrType.fromString("EXPRESSION-ATTR"));

	DagAttrs[1].setName("Env");
	DagAttrs[1].setValue("_CONDOR_DAGMAN_LOG=" + dagOutputFileLocation + ";_CONDOR_MAX_DAGMAN_LOG=0");
	DagAttrs[1].setType(ClassAdAttrType.fromString("STRING-ATTR"));


	DagAttrs[2].setName("UserLog");
	DagAttrs[2].setValue(dagLogFileLocation);
	DagAttrs[2].setType(ClassAdAttrType.fromString("STRING-ATTR"));

	DagAttrs[3].setName("Out");
	DagAttrs[3].setValue(stdOutLocation);
	DagAttrs[3].setType(ClassAdAttrType.fromString("STRING-ATTR"));

	DagAttrs[4].setName("Err");
	DagAttrs[4].setValue(stdErrLocation);
	DagAttrs[4].setType(ClassAdAttrType.fromString("STRING-ATTR"));

	if(newAttr != null) {
	    int j=0;
	    for(int i=5; i<(5+newAttrLength); i++,j++) {
		DagAttrs[i].setName(newAttr[j].getName());
		DagAttrs[i].setValue(newAttr[j].getValue());
		DagAttrs[i].setType(newAttr[j].getType());
	    }
	}

	if(nullTransaction)
	    transaction = null;

	submitJobHelper(schedd, transaction, clusterId, jobId,
			null, UniverseType.SCHEDULER, dagmanExecutableLocation,
			"-f -l . -Debug 3 " +
			"-Lockfile " + dagmanLockFile + " " +
			"-Dag " + dagFileName + " " +
			"-Rescue " + rescueDag + " " +
			"-Condorlog " + condorLog, null, DagAttrs, files);

    }



    /**
     * A helper function which provides a simple interface to transfer a
     * file to the schedd.
     *
     * @param schedd The schedd where the job is to be submitted
     *
     * @param filenameWithPath Can be the file's pathname (qualified filename),
     * i.e. the file does not have to exist in the same directory as the client
     * (but note that the file is placed in a flat directory (i.e. a directory
     * corresponding to the job) in the schedd). This parameter can also be just
     * the name of the file without any parent directories, in which case, it is
     * assumed that the file exists in the same directory as the client.
     *
     * @param transaction The transaction you would like to use to submit
     * the job. A "null" value, would invoke a new Transaction.
     * NOTE: the transaction will be committed after the job is submitted
     * if it's value is "null", else the calling program is expected to
     * commit the transaction
     *
     * @param clusterId cluster-ID of the job
     *
     * @param jobId job-ID of the job
     *
     * @exception SendFileException raised when<br>
     * 1.schedd fails to begin a transaction for the file-transfer<br>
     * 2.there is an error declaring the file<br>
     * 3.there is an error while sending the file as chunks to the schedd<br>
     * 4.schedd fails to commit the transaction
     *
     * @exception java.rmi.RemoteException Unable to make remote calls to schedd
     *
     * @exception java.io.IOException Unable to access client file
     *
     * @exception java.io.FileNotFoundException Unable to locate client file
     */
    public static void sendFileHelper(CondorScheddPortType schedd,
				      String filenameWithPath,
				      Transaction transaction,
				      int clusterId, int jobId)
	throws SendFileException, java.rmi.RemoteException,
	       java.io.IOException, java.io.FileNotFoundException {

	boolean dontCommit = true;

	if(transaction == null) {
	    dontCommit = false;
	    TransactionAndStatus trans_s = schedd.beginTransaction(60);
	    if(!(trans_s.getStatus()).getCode().equals(StatusCode.SUCCESS)) {
		System.err.println("Failed to begin Transaction");
		throw new SendFileException("Failed to begin Transaction");
	    }
	    transaction = trans_s.getTransaction();
	}

	File file = new File(filenameWithPath);
	int fileLen = (int) file.length();
	FileInputStream inputStream = new FileInputStream(file);

	int index = filenameWithPath.lastIndexOf('/');
	String filename;
	if(index != -1) {
	    filename = filenameWithPath.substring(index+1);
	}
	else {
	    filename = filenameWithPath;
	}

	Status status =
	    schedd.declareFile(transaction,clusterId,jobId,
			       filename,fileLen,HashType.NOHASH,null);
	if(!status.getCode().equals(StatusCode.SUCCESS)){
	    System.err.println("Error Declaring File");
	    throw new SendFileException("Error Declaring File");
	}

	int exBuffLen =  fileLen % FILE_TRAN_BUFF;
	byte[] exBuffer = new byte[exBuffLen];
	inputStream.read(exBuffer);
	status = schedd.sendFile(transaction, clusterId,
				 jobId, filename, 0, exBuffer);
	if(!status.getCode().equals(StatusCode.SUCCESS)) {
	    System.err.println("Error Sending File");
	    throw new SendFileException("Error Sending File");
	}

	if(exBuffLen < fileLen) {
	    byte[] buffer = new byte[FILE_TRAN_BUFF]; // 4K buffer.
	    int offset = exBuffLen;
	    while(offset < fileLen){
		inputStream.read(buffer);
		status = schedd.sendFile(transaction, clusterId,
					 jobId, filename,offset,buffer);
		if(!status.getCode().equals(StatusCode.SUCCESS)) {
		    System.err.println("Error Sending File");
		    throw new SendFileException("Error Sending File");
		}
		offset += FILE_TRAN_BUFF;
	    }
	}
	inputStream.close();

	if(!dontCommit) {
	    Status st = schedd.commitTransaction(transaction);
	    if(!(st.getCode()).equals(StatusCode.SUCCESS)) {
		System.err.println("Failed to commit");
		throw new SendFileException("Failed to commit");
	    }
	}
    }



    /**
     * A helper function which provides a simple interface to transfer a
     * file from the schedd.
     *
     * @param schedd The schedd where the job is to be submitted
     *
     * @param filenameWithPath Can be the file's pathname (qualified filename),
     * i.e. the destination where you'd like the file to be fetched from
     * the schedd and placed. If this argument just contains the filename
     * without any parent directory, then the file is fetched to the client's
     * working directory. NOTE: The destination-fully-qualified-filename's
     * filename should match the filename present in the schedd's spool.
     *
     * @param transaction Transaction used to fetch the file
     * NOTE: Here a "null" transaction, will fetch the files from the
     * schedd out of a transaction.
     *
     * @param clusterId cluster-ID of the job
     *
     * @param jobId job-ID of the job
     *
     * @exception GetFileException raised when<br>
     * 1.There is an error accessing the spool<br>
     * 2.The file is not found in the spool<br>
     * 3.Error transferring file to the client in chunks
     *
     * @exception java.rmi.RemoteException Unable to make remote calls to schedd
     *
     * @exception java.io.IOException Unable to write to client file
     *
     * @exception java.io.FileNotFoundException Unable to create destination-client file
     */
    public static void getFileHelper(CondorScheddPortType schedd,
				     String filenameWithPath,
				     Transaction transaction,
				     int clusterId, int jobId)
	throws GetFileException, java.rmi.RemoteException,
	       java.io.FileNotFoundException, java.io.IOException{

	int index = filenameWithPath.lastIndexOf('/');
	String filename;
	if(index != -1) {
	    filename = filenameWithPath.substring(index+1);
	}
	else {
	    filename = filenameWithPath;
	}

	// find file-length
	FileInfoArrayAndStatus fia_s = schedd.listSpool(transaction,
							clusterId, jobId);
	if(!fia_s.getStatus().getCode().equals(StatusCode.SUCCESS)) {
	    System.err.println("Error accessing Spool");
	    throw new GetFileException("Error accessing Spool");
	}
	FileInfo[] fi = fia_s.getInfo().getItem();
	int fileLength = 0;
	boolean found = false;
	for(int i=0;i<fi.length;i++) {
	    if(filename.equals(fi[i].getName())) {
		fileLength = (int)fi[i].getSize();
		found = true;
		break;
	    }
	}
	if(!found) {
	    System.err.println("File not found in Spool");
	    throw new GetFileException("File not found in Spool");
	}

	File file = new File(filenameWithPath);
	FileOutputStream outputStream = new FileOutputStream(file);

	int exBuffLen =  fileLength % FILE_TRAN_BUFF;
	byte[] exBuffer = new byte[exBuffLen];

	Base64DataAndStatus b64d_s =
	    schedd.getFile(transaction, clusterId, jobId,
			   filename, 0, exBuffLen);
	if(!b64d_s.getStatus().getCode().equals(StatusCode.SUCCESS)) {
	    System.err.println("Error Getting File");
	    throw new GetFileException("Error Getting File");
	}
	exBuffer = b64d_s.getData();
	outputStream.write(exBuffer);

	if(exBuffLen < fileLength) {
	    byte[] buffer = new byte[FILE_TRAN_BUFF]; // 4K buffer.
	    int offset = exBuffLen;

	    while(offset < fileLength) {
		b64d_s =
		    schedd.getFile(transaction, clusterId, jobId,
				   filename, offset,FILE_TRAN_BUFF);
		if(!b64d_s.getStatus().getCode().equals(StatusCode.SUCCESS)) {
		    System.err.println("Error Getting File");
		    throw new GetFileException("Error Getting File");
		}
		buffer = b64d_s.getData();
		outputStream.write(buffer);
		offset += FILE_TRAN_BUFF;
	    }
	}
	outputStream.close();

    }



    /**
     * To Either modify the value of an existing attribute in a classad
     * or add the new attribute to the classad
     *
     * @param classAd classAd to be modified
     *
     * @param newAttr the attribute to be updated or added
     *
     * @return the updated classAd
     */
    public static ClassAdStructAttr[] setAttributeValue(
					 ClassAdStructAttr[] classAd,
					 ClassAdStructAttr newAttr) {
	int len = classAd.length;
        for(int i=0;i<len;i++) {
            if((newAttr.getName()).compareToIgnoreCase(classAd[i].getName()) == 0) {
		classAd[i].setValue(newAttr.getValue());
		classAd[i].setType(newAttr.getType());
		return classAd;
	    }
        }
	//add new entry
	ClassAdStructAttr[] newClassAd = new ClassAdStructAttr[len+1];
	for(int i=0;i<len+1;i++)
	    newClassAd[i] = new ClassAdStructAttr();

	for(int i=0;i<len;i++) {
	    newClassAd[i].setName(classAd[i].getName());
	    newClassAd[i].setValue(classAd[i].getValue());
	    newClassAd[i].setType(classAd[i].getType());
	}
	newClassAd[len].setName(newAttr.getName());
	newClassAd[len].setValue(newAttr.getValue());
	newClassAd[len].setType(newAttr.getType());
	return newClassAd;
    }



    /**
     * Getting the value of a certain attribute in a classad
     *
     * @param classAd The classad being queried
     *
     * @param AttrName The name of the attribute being queried
     *
     * @return The value of the attribute
     */
    public static String getAttributeValue(ClassAdStructAttr[] classAd,String AttrName) {
        int len = classAd.length;
        for(int i=0;i<len;i++) {
            if(AttrName.compareToIgnoreCase(classAd[i].getName()) == 0)
                return classAd[i].getValue();
        }
        return null;
    }

}

