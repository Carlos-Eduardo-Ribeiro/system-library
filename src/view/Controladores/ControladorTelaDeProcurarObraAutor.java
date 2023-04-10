package view.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ControladorTelaDeProcurarObraAutor {

    @FXML
    private TextField nomeObraAutor;

    @FXML
    void pesquisar(ActionEvent event) {
        String a = nomeObraAutor.getText();
    }

    @FXML
    void voltar(ActionEvent event) {

    }

}
