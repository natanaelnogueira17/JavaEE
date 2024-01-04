/**
 * Confirmacao de exclusao de contato
 * @author Natanael nogueira
 */

 function confirmar(id){
	 let resposta = confirm("confirma a exclusao deste contato?");
	 if(resposta === true){
		 window.location.href = "delete?id=" + id;
	 }
 }