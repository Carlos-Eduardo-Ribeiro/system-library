package view.Controladores;

import business.exceptions.ElementoNaoEncontradoException;
import business.service.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDeDevolverLivro {

    @FXML
    private TextField itemEmprestado;
    @FXML
    private TextField nDeCadastro;
    @FXML
    private void mostrarAlertaElemento() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERRO AO DEVOLVER LIVRO");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }
    @FXML
    private void mostrarAlertaElemento1() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ALERTA");
        alerta.setHeaderText("LIVRO DEVOLVIDO");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }
    private PessoaService devolverObra = PessoaService.getInstance();

    @FXML
    void devolverLivro(ActionEvent event) {
        if(!itemEmprestado.getText().isEmpty()&&!nDeCadastro.getText().isEmpty()){
            try {
                this.devolverObra.devolverLivro(this.nDeCadastro.getText(), this.itemEmprestado.getText());
                mostrarAlertaElemento1();
                itemEmprestado.setText("");
                nDeCadastro.setText("");
                MainAplication.mudarTela("telaDoAdministrador");

            } catch (Exception e) {
                mostrarAlertaElemento();
                itemEmprestado.setText("");
                nDeCadastro.setText("");
                System.out.println(e.getMessage());
            }
        }

    }

    @FXML
    void voltar(ActionEvent event) {
        itemEmprestado.setText("");
        nDeCadastro.setText("");
        MainAplication.mudarTela("telaDoAdministrador");
    }
}