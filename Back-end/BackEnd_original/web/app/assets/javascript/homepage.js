
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
