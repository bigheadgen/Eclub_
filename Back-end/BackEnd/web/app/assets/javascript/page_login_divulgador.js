var emailsValidos = ["hotmal.com" , "outlook.com", "gmail.com"];
	
	function esqueciMinhaSenha(){

		var email = prompt("Enviaremos uma nova senha para seu email");
	}

	function cadastraDivulgador(){

		var email = prompt("Informe seu email");	
	}

	function validarEmail(){

		var email = document.getElementById("box").value.toLowerCase();
		var letra = email.indexOf("@");

		for (var i = 0; i < emailsValidos.length; i++) {
		 
			if(email == emailsValidos[i]){
				return true;
			}
		}
		return false;
	}

	function logarDivulgador(){
		
		if(validarEmail){

			alert("email valido");
		}

	}
