function mostra(id){
	if(document.getElementById(id).style.display == 'block'){
		
		document.getElementById(id).style.display = 'none';
	}else{
		
		document.getElementById(id).style.display = 'block';
	}
}
function goMap(){
	window.location = 'page_principal_mapa.html';
}