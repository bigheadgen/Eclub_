var emailsValidos = ["hotmal.com" , "outlook.com", "gmail.com"];
	
	function esqueciMinhaSenha(){

		var email = prompt("Enviaremos uma nova senha para seu email");
	}

	function cadastraDivulgador(){

		var email = prompt("Informe seu email");	
	}

	function validarEmail(){

		var email = document.getElementById("box").value.toLowerCase();
		 var usuario;
		 var dominio;
		 usuario = email.substring(0, email.indexOf("@"));
		 dominio = email.substring(email.indexOf("@")+ 1, email.length);
		
		if ((usuario.length >=1) && (dominio.length >=3) && (usuario.search("@")==-1) && (dominio.search("@")==-1) &&
    	    (usuario.search(" ")==-1) && (dominio.search(" ")==-1) && (dominio.search(".")!=-1) &&   
    	    (dominio.indexOf(".") >=1)&& (dominio.lastIndexOf(".") < dominio.length - 1)) {

				alert("E-mail valido");
			}

	else{ 
	alert("E-mail invalido");
	}

}

	function logarDivulgador(){
		
	}
