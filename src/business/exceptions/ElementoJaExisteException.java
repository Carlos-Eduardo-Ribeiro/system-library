package business.exceptions;

public class ElementoJaExisteException extends Exception{
	
	private String numeroDeCadastro;  

	public ElementoJaExisteException(String num) {  
		  
	super("\n(O objeto "+num+" já esta cadastrado no repositorio)\n");	    
	this.numeroDeCadastro = num;    
	    
	 }

	public String getNumero() {	  
    return numeroDeCadastro; 
	    
    }
}