package view.Controladores;

import business.exceptions.ElementoJaExisteException;
import business.exceptions.ElementoNaoEncontradoException;
import business.service.ObraService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDeRemoverObra {

    @FXML
    private TextField nomeObra;

    private ObraService obra = ObraService.getInstance();

    @FXML
    void remObra(ActionEvent event) throws ElementoNaoEncontradoException {
            obra.excluirObra(nomeObra.getText());
    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDeAdmObras");
    }

}
