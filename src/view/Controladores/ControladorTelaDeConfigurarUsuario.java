package view.Controladores;

import business.entities.Usuario;
import business.exceptions.ElementoNaoEncontradoException;
import business.service.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import view.MainAplication;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorTelaDeConfigurarUsuario {

    @FXML
    private TextField endereco;

    @FXML
    private TextField senha;

    @FXML
    void atuaEndereco(ActionEvent event) throws ElementoNaoEncontradoException {
        if(PessoaService.getInstance().getuService().getUsuarioAtivo() == null){
            endereco.setText("");
            senha.setText("");
        } else{
            PessoaService.getInstance().atualizarEmderecoDoUsuario(PessoaService.getInstance().getuService().
                    getUsuarioAtivo().getNumeroDeCadastro(), endereco.getText());
        }
    }

    @FXML
    void atuaSenha(ActionEvent event) throws ElementoNaoEncontradoException {
        PessoaService.getInstance().atualizarSenhaDoUsuario(PessoaService.getInstance().getuService().
                getUsuarioAtivo().getLogin(), PessoaService.getInstance().getuService().getUsuarioAtivo().
                getPassword(), senha.getText());
    }

    @FXML
    void voltar(ActionEvent event) {
        endereco.setText("");
        senha.setText("");
        MainAplication.mudarTela("telaDoCliente");
    }

}
