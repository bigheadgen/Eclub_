

// AQUI VAI SER A FUNÇÃO QUE CRIA E ADICIONA AO MAPA O MARCARDOR
// FUNÇÃO QUE ADICONA N LOCAIS AO MAPA
function queryString(parameter) {  
              var loc = location.search.substring(1, location.search.length);   
              var param_value = false;   
              var params = loc.split("&");   
              for (i=0; i<params.length;i++) {   
                  param_name = params[i].substring(0,params[i].indexOf('='));   
                  if (param_name == parameter) {                                          
                      param_value = params[i].substring(params[i].indexOf('=')+1)   
                  }   
              }   
              if (param_value) {   
                  return param_value;   
              }   
              else {   
                  return false;   
              }   
        }

function  addEventos(eventos,city,map){
  for (var i = 0; i < eventos.length; i++) {
      if(eventos[i].cidade == city){
          addMarker(eventos[i],map);
      }
  }
}
function addMarker(location, map) {
  var myLatlng = new google.maps.LatLng(location.lat, location.long);
  var marker = new google.maps.Marker({
    position: myLatlng,
    animation: google.maps.Animation.DROP,
    title: location.descricao
});
marker.setMap(map);
}
function getCidade(){
 var variavel = queryString("local");
  variavel = variavel.toLowerCase();
  for (var i = 0; i < locais.length; i++) {
    if(variavel == locais[i].name.toLowerCase()){
      return locais[i];
    }
  }
}
function initMap() {
  var cidade;
  if(queryString("local") == false){
    cidade = p1;
  }else{
    cidade = getCidade();
  }
    var mapOptions = {
    zoom: cidade.zoom,
    center: {lat: cidade.lat, lng:cidade.long},
    disableDefaultUI: true
  }
  var map = new google.maps.Map(document.getElementById("map"),
       mapOptions);
  addEventos(eventos,queryString("local"),map);
}
var p1 = {
  name: "recife",
  lat: -8.0518067, 
  long:-34.9101193,
  zoom: 13,
};
var p2 = { 
  name: "olinda", 
  lat: -7.9872432,
  long:-34.853892,
  zoom: 13
};
var p2 = { 
  name: "jaboatao", 
  lat: -8.1725308,
  long:-34.9656504,
  zoom: 14
};
var p3 = { 
  name: "caruaru", 
  lat: -8.2850489,
  long:-35.9664043,
  zoom:14
};
var p4 = { 
  name: "petrolina", 
  lat: -9.3810223,
  long:-40.5250625,
  zoom: 14
};
var p5 = { 
  name: "cabo", 
  lat: -8.2981555,
  long:-35.065986,
  zoom: 13
};
var p6 = { 
  name: "camaragibe", 
  lat: -8.0078622,
  long:-34.9972643,
  zoom: 14
};
var p7 = { 
  name: "garanhuns", 
  lat: -8.8831071,
  long:-36.4965562,
  zoom: 14
};
var p8 = { 
  name: "vitoria", 
  lat: -8.1168932,
  long:-35.3067268,
  zoom: 14
};
var locais = new Array(p1, p2, p3, p4, p5, p6, p7, p8);
//eventos
var ev1 ={
  cidade:"recife",
  descricao: "Nosso evento de teste1",
  lat: -8.063696,
  long: -34.8709444
};
var ev2 ={
  cidade:"recife",
  descricao: "Nosso evento de teste2",
  lat: -8.0607854,
  long: -34.8788971
};
var ev3 ={
  cidade:"recife",
  descricao: "Nosso evento de teste3",
  lat: -8.0436238,
  long: -34.8665268
};
var ev4 ={
  cidade:"vitoria",
  descricao: "Nosso evento de teste2",
  lat: -8.1165094,
  long: -35.2985695
};
var ev5 ={
  cidade:"vitoria",
  descricao: "Nosso evento de teste3",
  lat: -8.1082988,
  long: -35.2975834
};
var ev6 ={
  cidade:"recife",
  descricao: "Nosso evento de teste2",
  lat: -8.0955762,
  long: -34.8840217
};
var eventos = new Array(ev1, ev2, ev3, ev4, ev5,ev6);