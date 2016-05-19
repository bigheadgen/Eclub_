var pino1 = {
	name: "Marco Zero",
	lat: -8.063167002249708, 
	long:-34.871083450000015
};

var pino2 = { 
	name: "FG", 
	lat: -8.162551662756185,
	long:-34.91668672513958
};

//FUNÇÃO QUE FAZ O MARCADOR CAIR NO MAPA
function toggleBounce() {
 	
 	if (marker.getAnimation() !== null){
   		 marker.setAnimation(null);
   	}
   	else {
    	marker.setAnimation(google.maps.Animation.BOUNCE);
  	}
}
// AQUI VAI SER A FUNÇÃO QUE CRIA E ADICIONA AO MAPA O MARCARDOR
function addMarker(){

}
function initMap() {
  		var map;
  		//VARIAVEL QUE TEM O LOCAL DO MARCADOR
		var myLatLng = {lat: pino1.lat, lng: pino1.long};

  		var options ={
		 zoom: 8,
    	 center: myLatLng,
   		 mapTypeControl: false
		}
		map = new google.maps.Map(document.getElementById('map'), options);
		//AQUI CRIA O MARCADOR 
		var marker = new google.maps.Marker({
    	position: myLatLng,
    	animation: google.maps.Animation.DROP,
    	map: map,
  		title: pino1.name

   	 });
		  marker.addListener('click', toggleBounce);
}


