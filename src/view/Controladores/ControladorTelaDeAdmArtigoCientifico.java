package view.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.MainAplication;

public class ControladorTelaDeAdmArtigoCientifico {

    @FXML
    void atuaArtCien(ActionEvent event) {

    }

    @FXML
    void cadArtCien(ActionEvent event) {
        MainAplication.mudarTela("telaDoCrudArtigo");
    }

    @FXML
    void remArtCien(ActionEvent event) {
        MainAplication.mudarTela("telaDeRemoverArtigoCientifico");
    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDoAdministrador");
    }

}
