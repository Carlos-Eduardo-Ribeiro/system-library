package business.exceptions;

public class ArgumentoInvalidoException extends Exception {
	
	private String elemento;

    public ArgumentoInvalidoException(String arg){
    	
    super("\n(Voce digitou o argumento errado, digite corretamente)\n");
    this.elemento = arg;  
   
    }

    public String getElemento() {
    return elemento;
    
    }
}
