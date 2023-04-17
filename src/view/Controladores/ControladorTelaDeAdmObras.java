package view.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.MainAplication;

public class ControladorTelaDeAdmObras {

    @FXML
    void atuaObra(ActionEvent event) {
        MainAplication.mudarTela("telaDeAtualizarObra");
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
    void removerArtigo(ActionEvent event) {
        MainAplication.mudarTela("telaDeRemoverArtigoCientifico");
    }

    @FXML
    void cadastrarArtigo(ActionEvent event) {
        MainAplication.mudarTela("telaDoCrudArtigo");
    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDoAdministrador");
    }

}
