package view.Controladores;

import business.entities.Usuario;
import business.exceptions.ElementoNaoEncontradoException;
import business.service.PessoaService;
import business.service.UsuarioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDeRemoverAutor {

    @FXML
    private TextField nomeAutor;

    private PessoaService autor = PessoaService.getInstance();

    @FXML
    void remAutor(ActionEvent event) throws ElementoNaoEncontradoException {
        autor.removerUsuario(nomeAutor.getText());
    }
    @FXML

    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDeAdmAutor");
    }

}
