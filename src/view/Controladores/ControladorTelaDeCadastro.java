package view.Controladores;

import business.exceptions.ElementoJaExisteException;
import business.exceptions.ElementoNaoEncontradoException;
import business.service.PessoaService;
import business.service.UsuarioService;
import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    @FXML
    private void mostrarAlertaElemento() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERRO AO CADASTRAR");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }

    private UsuarioService a = PessoaService.getInstance().getuService();

    @FXML
    void CadastrarUsuario(ActionEvent event) throws ElementoJaExisteException, ElementoNaoEncontradoException {
        if(!cpfDoUsuario.getText().isEmpty()&&!loginDoUsuario.getText().isEmpty()&&!senhaDoUsuario.getText().isEmpty()&&
                !enderecoDoUsuario.getText().isEmpty()&&dataDeNascimentoDoUsuario.getValue() != null){
            try {
                this.a.adicionarUsuario(this.nomeDoUsuario.getText(), this.cpfDoUsuario.getText(),
                        dataDeNascimentoDoUsuario.getValue(), this.enderecoDoUsuario.getText(),
                        this.loginDoUsuario.getText(), this.senhaDoUsuario.getText(), false);
                PessoaService.getInstance().getuService().loginUsuario(loginDoUsuario.getText(), senhaDoUsuario.getText());
                limparCampos();
                MainAplication.mudarTela("telaDoCliente");
            } catch (Exception e) {
                mostrarAlertaElemento();
                limparCampos();
                System.out.println(e.getMessage());
                MainAplication.mudarTela("telaDeCadastro");
            }
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
