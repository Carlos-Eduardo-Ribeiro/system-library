package view.Controladores;

import business.exceptions.ElementoNaoEncontradoException;
import business.service.ObraService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDeRemoverArtigoCientifico {

    @FXML
    private TextField nomeArtCien;

    private ObraService obra = ObraService.getInstance();

    @FXML
    void remArtCien(ActionEvent event) throws ElementoNaoEncontradoException {
        obra.excluirObra(nomeArtCien.getText());
    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDeAdmObras");
    }

}
