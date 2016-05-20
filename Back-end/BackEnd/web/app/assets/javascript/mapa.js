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
var pino3 = { 
  name: "Paiva", 
  lat: -8.26005792,
  long:-34.94514942
};
var pino4 = { 
  name: "Ponta Negra ", 
  lat: -5.89562116,
  long:-35.15552044
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


