package view.Controladores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import view.MainAplication;

public class ControladorTelaDeAtualizarUsuario {

    ObservableList<String> atualizarUsuarioList = FXCollections.observableArrayList("Nome", "Data De Nascimento", "Login",
            "Password", "Status", "Endereço", "Administrador");

    @FXML
    private ChoiceBox updateUsuario;

    @FXML
    private void initialize(){
        updateUsuario.setItems(atualizarUsuarioList);
        updateUsuario.setValue("Nome");
    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDoAdministrador");
    }
}
