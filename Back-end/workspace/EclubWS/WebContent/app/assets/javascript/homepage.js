
var cidades = ["recife", "olinda", "jaboatao", "caruaru", "petrolina","cabo", "camaragibe", 
"garanhuns", "vitoria"];

function myDivulgadores (){

	window.location = 'page_login_divulgador.html';

}
function validarCidades(valor_busca){

	for (var i = cidades.length - 1; i >= 0; i--) {
		
		if(valor_busca == cidades[i]){
				
			window.location = 'page_principal_mapa.html?local=' + valor_busca;
			return true;
		}
	}
	return false;
}
function myPesquisar(){

	var valor_busca = document.getElementById("busca").value.toLowerCase();
	
	var cidadeEncontrada = validarCidades(valor_busca);
	
	if(cidadeEncontrada ==  false){
		
		if(valor_busca == "" || valor_busca == null){
   			window.alert("Ops, digite uma cidade!");
   			document.getElementById("busca").focus();		
		}
		else{
			document.getElementById("busca").value="";
			window.alert("Ops, essa cidade não existe!");
			document.getElementById("busca").focus();
		}
	}
}
function logarRedes(rede){
  if(rede == 'facebook'){
     window.open("http://www.facebook.com/", "facebook", "height=400,width=600");
     window.location = 'page_user.html';
  }
  if(rede == 'google'){
     window.open("https://accounts.google.com/", "Gmail", "height=400,width=600");
     window.location = 'page_user.html';
  }
  if(rede == 'Twitter'){
     window.open("https://twitter.com/login?lang=pt", "Twitter", "height=400,width=600");
     window.location = 'page_user.html';
  }
  if(rede == 'Instagram'){
     window.open("https://www.instagram.com/accounts/login/?force_classic_login", "Instagram", "height=400,width=600");
     window.location = 'page_user.html';
  }
}