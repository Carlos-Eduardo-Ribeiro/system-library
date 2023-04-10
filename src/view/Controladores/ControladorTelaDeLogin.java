package view.Controladores;

import business.entities.Usuario;
import business.service.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDeLogin {

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    void TelaDeCadastro(ActionEvent event) {
        limparCampos();
        MainAplication.mudarTela("telaDeCadastro");
    }

    @FXML
    void TesteDeLogin(ActionEvent event) {
        try {
            Usuario a = PessoaService.getInstance().getuService().loginUsuario(this.login.getText(), this.password.getText());
            System.out.println("Conta E");
            if (a.isAdmin()) {
                limparCampos();
                MainAplication.mudarTela("telaDoAdministrador");
            } else {
                limparCampos();
                MainAplication.mudarTela("telaDoCliente");
            }

        } catch (Exception e) {
            limparCampos();
            System.out.println("Error 404");
            throw new RuntimeException(e);
        }
    }

    void limparCampos() {
        login.clear();
        password.clear();
    }
}