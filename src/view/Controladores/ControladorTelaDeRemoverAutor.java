package view.Controladores;

import business.entities.Usuario;
import business.exceptions.ElementoNaoEncontradoException;
import business.service.PessoaService;
import business.service.UsuarioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDeRemoverAutor {

    @FXML
    private TextField nomeAutor;

    private PessoaService autor = PessoaService.getInstance();
    @FXML
    private void mostrarAlertaElemento() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERRO AO REMOVER AUTOR");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }

    @FXML
    void remAutor(ActionEvent event) {
        if(!nomeAutor.getText().isEmpty()){
            try{
                autor.removerUsuario(nomeAutor.getText());
            } catch (Exception e) {
                mostrarAlertaElemento();
                nomeAutor.setText("");
                throw new RuntimeException(e);
            }
        }

    }
    @FXML

    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDeAdmAutor");
    }

}
