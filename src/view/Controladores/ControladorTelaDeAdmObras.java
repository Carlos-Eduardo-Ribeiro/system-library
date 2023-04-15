package view.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.MainAplication;

public class ControladorTelaDeAdmObras {

    @FXML
    void atuaObra(ActionEvent event) {

    }

    @FXML
    void cadObra(ActionEvent event) {
        MainAplication.mudarTela("telaDoCrudObra");
    }

    @FXML
    void remObra(ActionEvent event) {
        MainAplication.mudarTela("telaDeRemoverObra");
    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDoAdministrador");
    }

}
