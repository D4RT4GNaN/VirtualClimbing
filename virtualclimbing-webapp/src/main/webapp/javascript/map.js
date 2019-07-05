var $lat = Number(strLat);
var $lon = Number(strLon);

var mymap = L.map('leafmapid').setView([$lat, $lon], 15);

L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
            attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
            maxZoom: 18,
            id: 'mapbox.streets',
            accessToken: 'pk.eyJ1IjoiZDR0NGduYW4iLCJhIjoiY2p1MnFtZ3NnMGUzODRldGF4NGx1b3d6dSJ9.ARJozZy1FxDunFo7yGxU9A'
            }).addTo(mymap);

var marker = L.marker([$lat, $lon]).addTo(mymap);

function mapChange() {
	mymap.setView([$lat, $lon], 15);
	mymap.removeLayer(marker);
	marker = L.marker([$lat, $lon]).addTo(mymap);
}