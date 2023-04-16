package view.Controladores;

import business.exceptions.ElementoJaExisteException;
import business.exceptions.ElementoNaoEncontradoException;
import business.service.PessoaService;
import business.service.UsuarioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDeCadastro {
    @FXML
    private TextField cpfDoUsuario;
    @FXML
    private DatePicker dataDeNascimentoDoUsuario;
    @FXML
    private TextField enderecoDoUsuario;
    @FXML
    private TextField loginDoUsuario;
    @FXML
    private TextField nomeDoUsuario;
    @FXML
    private PasswordField senhaDoUsuario;

    private UsuarioService a = PessoaService.getInstance().getuService();

    @FXML
    void CadastrarUsuario(ActionEvent event) throws ElementoJaExisteException, ElementoNaoEncontradoException {
        try {
            this.a.adicionarUsuario(this.nomeDoUsuario.getText(), this.cpfDoUsuario.getText(),
                    dataDeNascimentoDoUsuario.getValue(), this.enderecoDoUsuario.getText(),
                    this.loginDoUsuario.getText(), this.senhaDoUsuario.getText(), false);
            PessoaService.getInstance().getuService().loginUsuario(loginDoUsuario.getText(), senhaDoUsuario.getText());
            limparCampos();
            MainAplication.mudarTela("telaDoCliente");
        } catch (Exception e) {
            limparCampos();
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void VoltarParaTelaDeLogin(ActionEvent event) {
        limparCampos();
        MainAplication.mudarTela("telaDeLogin");
    }

    void limparCampos() {
        cpfDoUsuario.clear();
        nomeDoUsuario.clear();
        loginDoUsuario.clear();
        senhaDoUsuario.clear();
        enderecoDoUsuario.clear();
        dataDeNascimentoDoUsuario.setValue(null);
    }
}
