package view.Controladores;

import business.exceptions.ElementoNaoEncontradoException;
import business.service.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDeEmprestimo {
    @FXML
    private TextField itemEmprestado;
    @FXML
    private TextField nDeCadastro;
    @FXML
    private void mostrarAlertaElemento() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERRO AO EMPRESTAR LIVRO");
        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }

    private PessoaService usuario = PessoaService.getInstance();

    @FXML
    void addEmprestimo(ActionEvent event) {
        if(!itemEmprestado.getText().isEmpty()&&!nDeCadastro.getText().isEmpty()){
            try {
                this.usuario.emprestrarObra(this.nDeCadastro.getText(), this.itemEmprestado.getText());
                MainAplication.mudarTela("telaDoAdministrador");
                itemEmprestado.setText("");
                nDeCadastro.setText("");
                System.out.println("Livro Emprestado");
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
