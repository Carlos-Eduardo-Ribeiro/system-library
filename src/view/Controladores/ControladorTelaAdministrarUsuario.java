package view.Controladores;

import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.MainAplication;

public class ControladorTelaAdministrarUsuario {

    @FXML
    void atualizarUsuario(ActionEvent event) {
        MainAplication.mudarTela("telaDeAtualizarUsuario");
    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaAdministrarUsuario");
    }

}
