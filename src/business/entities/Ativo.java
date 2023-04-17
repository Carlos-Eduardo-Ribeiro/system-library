package business.entities;

public class Ativo {
    private Usuario usuarioAtivo;
    private static Ativo instance;

    public static Ativo getInstance(){
        if(instance == null){
            instance = new Ativo();
        }
        return instance;
    }

    public Usuario getUsuarioAtivo() {
        return usuarioAtivo;
    }

    public void setUsuarioAtivo(Usuario usuarioAtivo) {
        this.usuarioAtivo = usuarioAtivo;
    }
}
