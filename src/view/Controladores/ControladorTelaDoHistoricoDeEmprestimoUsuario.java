package view.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.MainAplication;

public class ControladorTelaDoHistoricoDeEmprestimoUsuario {

    @FXML
    void button(ActionEvent event){

    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDoCliente");
    }

}
