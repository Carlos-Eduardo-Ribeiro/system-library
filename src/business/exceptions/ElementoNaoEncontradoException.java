package business.exceptions;

public class ElementoNaoEncontradoException extends Exception{

	private String numeroInexistente;
    public ElementoNaoEncontradoException(String num) {
        super("\n(O objeto "+num+" não existe)\n");
        this.numeroInexistente = num;
    }

    public String getNumeroInexistente() {
        return numeroInexistente;
    }

}


