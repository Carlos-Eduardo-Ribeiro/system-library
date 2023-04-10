package view.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.MainAplication;

public class ControladorTelaDoCrudObraAutor {
    @FXML
    void CrudAutor(ActionEvent event) {
        MainAplication.mudarTela("telaDoCrudAutor");
    }

    @FXML
    void CrudObra(ActionEvent event) {
        MainAplication.mudarTela("telaDoCrudObra");
    }

    @FXML
    void voltarTelaAdm(ActionEvent event) {
        MainAplication.mudarTela("telaDoAdministrador");
    }

    @FXML
    void CrudArtigo(ActionEvent event) {
    }
}