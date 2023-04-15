package view.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDeRemoverArtigoCientifico {

    @FXML
    private TextField nomeArtCien;

    @FXML
    void remArtCien(ActionEvent event) {
        //Não existe a função ainda
    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDeAdmArtigoCientifico");
    }

}
