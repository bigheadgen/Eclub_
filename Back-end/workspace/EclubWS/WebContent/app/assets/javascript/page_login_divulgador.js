var emailsValidos = ["hotmal.com" , "outlook.com", "gmail.com"];

	function cadastraDivulgador(){

		var email = prompt("Informe seu email");	
	}

	function validarEmail(){

		var email = document.getElementById("boxEmail").value.toLowerCase();
		 var usuario;
		 var dominio;
		 usuario = email.substring(0, email.indexOf("@"));
		 dominio = email.substring(email.indexOf("@")+ 1, email.length);
		
		if ((usuario.length >=1) && (dominio.length >=3) && (usuario.search("@")==-1) && (dominio.search("@")==-1) &&
    	    (usuario.search(" ")==-1) && (dominio.search(" ")==-1) && (dominio.search(".")!=-1) &&   
    	    (dominio.indexOf(".") >=1)&& (dominio.lastIndexOf(".") < dominio.length - 1)) {
				return true;
			}

	else{ 
	alert("E-mail invalido");
	}

}
function getDivulgador(email){
	for (var i = 0; i < divulgadores.length; i++) {
		if(email.localeCompare(divulgadores[i].email)){
			return divulgadores[i];
		}
	}
	return false;
}
function goPageDivulgador(){
	window.location = "page_divulgador.html";
}
function logarDivulgador(){
	
	var email = document.getElementById("boxEmail").value.toLowerCase();
	var senha = document.getElementById("boxSenha").value;
	var userDivul = getDivulgador(email);
	
	if(validarEmail() == true && userDivul != false ){	
		goPageDivulgador();
	}else{
		alert("Senha invalida");
	}
}
var divulgador1 ={
	nome: "gustavo",
	emailDivul: "gustavo@gmail.com",
	senha: "0000"
};
var divulgador2 ={
	nome: "teste2",
	emailDivul: "teste2@hotmail.com",
	senha: "1234"
};
var divulgadores = new  Array(divulgador1, divulgador2);
