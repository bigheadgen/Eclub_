var pino1 = {
	name: "Recife",
	lat: -8.0581882, 
	long:-34.88242
};
var pino2 = { 
	name: "Jaboatao", 
	lat: -8.1693708,
	long:-35.0025508
};
var pino3 ={
name: "Olinda", 
  lat: -7.9934558,
  long:-34.8497768
};

var locais1 = [pino1, pino2, pino3];

// AQUI A CAIXA DE INFORMAÇÕES DO PONTO E CRIADA
function contentString(map , marker){
    var contentString = "Aqui vai as informações sobre o evento";

    
    var infowindow = new google.maps.InfoWindow({
    content: contentString,
    });
      
      marker.addListener('click', function(){
      infowindow.open(map , marker);
     });

}
// AQUI VAI SER A FUNÇÃO QUE CRIA E ADICIONA AO MAPA O MARCARDOR
// FUNÇÃO QUE ADICONA N LOCAIS AO MAPA
function addMarker(map, locais){
    
    var bounds = new google.maps.LatLngBounds();
    for (var i = 0; i < locais.length; i++) {  
    var marker = new google.maps.Marker({
      position: new google.maps.LatLng(locais[i].lat, locais[i].long),
      map: map,
      title: locais[i].name,
      animation: google.maps.Animation.DROP
    });
      
      contentString(map , marker);
      bounds.extend(new google.maps.LatLng(locais[i].lat, locais[i].long));
  }
     
     map.fitBounds(bounds);
}
function initMap() {
  		var map;
  		//VARIAVEL QUE TEM O LOCAL DO MARCADOR
		  var myLatLng = {lat: -8.18345560, lng: -34.92274761};
  		var options ={
		   zoom: 8,
    	 center: myLatLng,
   		 mapTypeControl: false
		}
  map = new google.maps.Map(document.getElementById('map'), options);
  
  if(locais1.length != -1){
    addMarker(map, locais1);
  }
}


