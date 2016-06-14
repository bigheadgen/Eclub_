

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
    //aqui é o texto da janela do evento
    var contentString = location.descricao;

  var infowindow = new google.maps.InfoWindow({
    content: contentString
  });
  if(location.iconEvento == ""){
    var marker = new google.maps.Marker({
    position: myLatlng,
    animation: google.maps.Animation.DROP,
    title: location.descricao
  });
  }else{
    var image  = location.iconEvento;
    var marker = new google.maps.Marker({
    position: myLatlng,
    icon: image,
    animation: google.maps.Animation.DROP,
    title: location.descricao
  });
  }
  marker.addListener('click', function() {
    infowindow.open(map, marker);
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
  };
  var map = new google.maps.Map(document.getElementById("map"),
       mapOptions);
  addEventos(eventos,queryString("local"),map);
}
var p1 = {
  name: "recife",
  lat: -8.0518067, 
  long:-34.9101193,
  zoom: 14
};
var p2 = { 
  name: "jaboatao", 
  lat: -8.1677612,
  long:-34.922719,
  zoom: 12
};
var p3 = { 
  name: "cabo", 
  lat: -8.2981555,
  long:-35.065986,
  zoom: 14
};
var locais = new Array(p1, p2, p3);
//eventos em recife
var ev1 ={
  cidade:"recife",
  nom: "Boteco",
  descricao: "O Bistrô & Boteco Recife Antigo oferece, além do tradicional happy hour da rede, almoço com buffet em um ambiente aconchegante.",
  lat: -8.065735,
  long: -34.8728405,
  iconEvento: ""
};
var ev2 ={
  cidade:"recife",
  nom: "DownTown Pub",
  descricao: "Shows de vários estilos de rock para curtir com os amigos e paquerar, diversas cervejas e clima intimista.",
  lat: -8.0640424,
  long: -34.8725146,
  iconEvento: "../assets/images/joW.png"
};
var ev3 ={
  cidade:"recife",
  nom: "Rouge Club",
  descricao: "Nosso evento de teste3",
  lat: -8.0644187,
  long: -34.8843229,
  iconEvento: ""
};
var ev4 ={
  cidade:"recife",
  nom: "Profana Pub",
  descricao: "Nosso evento de teste4",
  lat: -8.0642381,
  long: -34.8726629,
  iconEvento: ""
};
var ev5 ={
  cidade:"jaboatao",
  nom: "O Puxadinho",
  descricao: "Se aproxegue, a casa é pequena mas cabe tudin. Pode ir puxando o tamburete meu fio se sente e fique a vontade. Se sinta como se tivesse na sua casa.",
  lat: -8.1628837,
  long: -34.9168949,
  iconEvento: "../assets/images/cerva.png"
};
var ev6 ={
  cidade:"jaboatao",
  nom: "ZEN Comida Japonesa",
  descricao: "Restaurante japonês e bar com aclamados espetinhos de peixe, ambiente moderno com jardim e espelhos d'água.",
  lat: -8.1603233,
  long: -34.9141522,
  iconEvento: "../assets/images/sushi.png"
};
var ev7 ={
  cidade:"jaboatao",
  nom: "Restaurante e Pizzaria Atlântico",
  descricao: "Rede de restaurantes serve carnes, saladas, massas e pizzas",
  lat: -8.1608764,
  long: -34.9137035,
  iconEvento: "../assets/images/pizzariaA.png"
};
var ev8 ={
  cidade:"jaboatao",
  nom: "O Jabá",
  descricao: "Comida nordestina e pizzas, além de cervejas e cachaças, em espaço informal com artesanato e música ao vivo.",
  lat: -8.1623286,
  long: -34.9133276,
  iconEvento: ""
};
var ev9 ={
  cidade:"jaboatao",
  nom: "MPBar",
  descricao: "Bar com menu de carnes e pescados promove shows de bandas de estilos diversos em noites temáticas à beira-mar.",
  lat: -8.1628523,
  long: -34.9128659,
  iconEvento: ""
};
var ev10 ={
  cidade:"jaboatao",
  nom: "Connect Club",
  descricao: "Nosso evento de teste10",
  lat: -8.2155692,
  long: -34.930016,
  iconEvento: ""
};
var ev11 ={
  cidade:"jaboatao",
  nom: "Anexo Pub",
  descricao: "Nosso evento de teste11",
  lat: -8.1794505,
  long: -34.917899,
  iconEvento: ""
};
var ev12 ={
  cidade:"jaboatao",
  nom: "Big House",
  descricao: "Nosso evento de teste12",
  lat: -8.1884023,
  long: -34.9194243,
  iconEvento: ""
};
var ev13 ={
  cidade:"recife",
  nom: "Chevrolet Hall",
  descricao: "Nosso evento de teste13",
  lat: -8.0342658,
  long: -34.8712582,
  iconEvento: ""
};
var eventos = new Array(ev1, ev2, ev3, ev4, ev5, ev6, ev7, ev8, ev9, ev10, ev11, ev12, ev13);