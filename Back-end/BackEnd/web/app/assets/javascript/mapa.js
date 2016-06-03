var p1 = {
  name: "recife",
  lat: -8.0518067, 
  long:-34.9101193,
  zoom: 13
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

var locais = [p1, p2, p3, p4, p5, p6, p7, p8];
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
var variavel = queryString("local");
function getCidade(){
 
  variavel = variavel.toLowerCase();
  for (var i = 0; i < locais.length; i++) {
    if(variavel == locais[i].name.toLowerCase()){
      return locais[i];
    }
  }
}
function initMap() {
  var cidade;
  if(variavel == false){
    cidade = p1;
  }else{
    cidade = getCidade;
  }
    var mapOptions = {
    zoom: cidade.zoom,
    center: {lat: cidade.lat, lng:cidade.long},
    disableDefaultUI: true
  }
  var map = new google.maps.Map(document.getElementById("map"),
       mapOptions);

}