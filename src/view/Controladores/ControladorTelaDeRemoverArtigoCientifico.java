package view.Controladores;

import business.service.ObraService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDeRemoverArtigoCientifico {

    @FXML
    private TextField nomeArtCien;

    private ObraService obra = ObraService.getInstance();
    @FXML
    private void mostrarAlertaElemento() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERRO AO REMOVER O ARTIGO");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }
    @FXML
    private void mostrarAlertaElemento1() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ALERTA");
        alerta.setHeaderText("REMOÇÃO REALIZADA");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }

    @FXML
    void remArtCien(ActionEvent event){
        if(!nomeArtCien.getText().isEmpty()){
            try{
                obra.excluirObra(nomeArtCien.getText());
                mostrarAlertaElemento1();
            } catch (Exception e) {
                mostrarAlertaElemento();
                nomeArtCien.setText("");
                throw new RuntimeException(e);
            }
        }

    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDeAdmObras");
    }

}
