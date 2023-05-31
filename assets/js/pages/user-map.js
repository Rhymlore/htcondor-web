---
   layout: blank
---

// Powers the HTCSS User Map

const defaultIconScale = 42

function getIcon(iconScale){
    let iconSize = [iconScale*2.8, iconScale]
    let iconConfig = {
        iconUrl: "{{ '/assets/images/HTCondor_Bird.svg' | relative_url }}",
        iconSize: iconSize,
        iconAnchor: [iconSize[0]*.5, iconSize[1]],
        shadowUrl: "{{ '/assets/images/HTCondor_Bird_Shadow.svg' | relative_url }}",
        shadowAnchor: [iconSize[1], iconSize[1]*.6],
        shadowSize: iconSize
    }
    return L.icon(iconConfig)
}

function getScale(zoom){
    return defaultIconScale * (.5 + (.03*zoom))
}

function create_marker(location, iconScale){
    return [...Array(9).keys()]
        .map(x => x-5)
        .map(x => L.marker([location[0], location[1] + (x*360)], {icon: getIcon(iconScale)}))
}

async function get_spreadsheet_values(){
    let res = await fetch("https://docs.google.com/spreadsheets/d/18dMo5d89HkyzFGnsQaCPw843LPUG-czAneBR7rVThHI/export?format=csv")

    let text = await res.text()

    let data = Papa.parse(text, {header:true})

    let geocodes = data['data'].map(x => [parseFloat(x['Longitude']), parseFloat(x['Latitude'])])

    let cleanGeocodes = geocodes.reduce((p, c) => {
        if(isNaN(c[0]) || isNaN(c[1])){
            return p
        }
        p.push(c)
        return p
    }, [])

    if(cleanGeocodes.length === 0) {
        console.error("No clean values were returned from the spreadsheet")
    }

    return cleanGeocodes
}

async function get_manual_values() {
    let response = await fetch("{{ '/assets/data/htcss-users.json' | relative_url }}")

    return response.json()
}

class UserMap {
    constructor() {
        let urlParams = new URLSearchParams(window.location.search)
        this.zoom = urlParams.get("zoom") ? urlParams.get("zoom") : 3
        this.viewerLatitude = urlParams.get("latitude") ? urlParams.get("latitude") : 35
        this.viewerLongitude = urlParams.get("longitude") ? urlParams.get("longitude") : -90
        this.scrollWheelZoom = urlParams.get("scrollWheelZoom") ? urlParams.get("scrollWheelZoom") !== '0' : true

        var map = L.map('map', {scrollWheelZoom: this.scrollWheelZoom}).setView([this.viewerLatitude, this.viewerLongitude], this.zoom);

        L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
            attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
            maxZoom: 17,
            id: 'mapbox/light-v11',
            tileSize: 512,
            zoomOffset: -1,
            accessToken: 'pk.eyJ1IjoidGFraW5nZHJha2UiLCJhIjoiY2wya3IyZGNvMDFyOTNsbnhyZjBteHRycSJ9.g6tRaqN8_iJxHgAQKNP6Tw',
        }).addTo(map);

        this.markerLayer = L.layerGroup()
        this.markerLayer.addTo(map)

        map.on("zoomend", () => {
            this.zoom = map.getZoom();
            this.markerLayer.eachLayer(x => x.setIcon(getIcon(getScale(this.zoom))))
        })

        this.markerCount = 0
    }

    updateMarkerCount(numOfNewMarkers) {
        this.markerCount += numOfNewMarkers
        document.getElementById("org-count").textContent = this.markerCount
    }

    addIcon([longitude, latitude]) {
        const markers = create_marker([longitude, latitude], getScale(this.zoom))
        markers.forEach(x => this.markerLayer.addLayer(x))
    }


    async addIcons(getter) {
        let iconLocations = await getter()
        iconLocations.forEach(x => this.addIcon(x))
        this.updateMarkerCount(iconLocations.length)
    }
}

function main(){
    const map = new UserMap();
    map.addIcons(get_spreadsheet_values)
    map.addIcons(get_manual_values)
}

main()