function myDivulgadores (){

	window.location = 'page_login_divulgador.html';

}
function myPesquisar(){
    var valor_busca;
	var valor_busca = document.getElementById("busca").value;

if(valor_busca == "recife" ||valor_busca == "jaboatao" || 
	valor_busca == "olinda"|| valor_busca == "caruaru" || valor_busca == "petrolina" ||
	 valor_busca == "cabo" || valor_busca == "camaragibe" || valor_busca == "garanhuns" || 
	 valor_busca == "vitoria"){

window.location = 'page_principal_mapa.html';
}
else{
if (valor_busca == "" || valor_busca == null){
   	window.alert("Ops, digite uma cidade!");
}
else{
 window.alert("Ops, essa cidade não existe!");
}
}
}
