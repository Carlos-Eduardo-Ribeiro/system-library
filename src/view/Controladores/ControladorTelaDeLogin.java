package view.Controladores;

import business.entities.Usuario;
import business.service.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private void mostrarAlertaElemento() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERRO AO LOGAR");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }

    @FXML
    void TesteDeLogin(ActionEvent event) {
        if(!login.getText().isEmpty()&&!password.getText().isEmpty()){
            try {
                Usuario a = PessoaService.getInstance().getuService().loginUsuario(login.getText(), password.getText());
                if (a.isAdmin()) {
                    limparCampos();
                    MainAplication.mudarTela("telaDoAdministrador");
                } else {
                    limparCampos();
                    MainAplication.mudarTela("telaDoCliente");
                }
            } catch (Exception e) {
                mostrarAlertaElemento();
                limparCampos();
                System.out.println("Error 404");
            }
        }
    }

    void limparCampos() {
        login.clear();
        password.clear();
    }
}