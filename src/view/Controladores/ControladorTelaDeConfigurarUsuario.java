package view.Controladores;


import business.service.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDeConfigurarUsuario {

    @FXML
    private TextField endereco;

    @FXML
    private TextField senha;
    @FXML
    private void mostrarAlertaElemento() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ALERTA");
        alerta.setHeaderText("ENDEREÇO ATUALIZADO");
        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }
    @FXML
    private void mostrarAlertaElemento1() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ALERTA");
        alerta.setHeaderText("SENHA ATUALIZADA");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }

    @FXML
    void atuaEndereco(ActionEvent event) throws Exception {
        if(PessoaService.getInstance().getuService().getUsuarioAtivo() == null){
            endereco.setText("");
            senha.setText("");
        } else{
            PessoaService.getInstance().atualizarEmderecoDoUsuario(PessoaService.getInstance().getuService().
                    getUsuarioAtivo().getNumeroDeCadastro(), endereco.getText());
                mostrarAlertaElemento();
        }
    }

    @FXML
    void atuaSenha(ActionEvent event) throws Exception {
        PessoaService.getInstance().atualizarSenhaDoUsuario(PessoaService.getInstance().getuService().
                getUsuarioAtivo().getLogin(), PessoaService.getInstance().getuService().getUsuarioAtivo().
                getPassword(), senha.getText());
        mostrarAlertaElemento1();
    }

    @FXML
    void voltar(ActionEvent event) {
        endereco.setText("");
        senha.setText("");
        MainAplication.mudarTela("telaDoCliente");
    }

}
