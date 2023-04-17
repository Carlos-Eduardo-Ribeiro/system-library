package view.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.MainAplication;

public class ControladorTelaDeAdmAutor {

    @FXML
    void cadAutor(ActionEvent event) {
        MainAplication.mudarTela("telaDoCrudAutor");
    }

    @FXML
    void remAutor(ActionEvent event) {
        MainAplication.mudarTela("telaDeRemoverAutor");
    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDoAdministrador");
    }

}
