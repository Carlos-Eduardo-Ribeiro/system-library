package view.Controladores;

import business.exceptions.ElementoJaExisteException;
import business.exceptions.ElementoNaoEncontradoException;
import business.service.ObraService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDeRemoverObra {

    @FXML
    private TextField nomeObra;
    @FXML
    private void mostrarAlertaElemento() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERRO AO REMOVER OBRA");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }

    private ObraService obra = ObraService.getInstance();

    @FXML
    void remObra(ActionEvent event){
        if(!nomeObra.getText().isEmpty()){
            try{
                obra.excluirObra(nomeObra.getText());
            } catch (Exception e) {
                mostrarAlertaElemento();
                throw new RuntimeException(e);
            }
        }

    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDeAdmObras");
    }

}
