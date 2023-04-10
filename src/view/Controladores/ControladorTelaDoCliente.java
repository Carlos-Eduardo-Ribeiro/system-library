package view.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.MainAplication;

public class ControladorTelaDoCliente {

    @FXML
    void Sair(ActionEvent event){
        MainAplication.mudarTela("telaDeLogin");
    }

    @FXML
    void TelaDoHistoricoDeEmprestimo(ActionEvent event) {
        MainAplication.mudarTela("telaDoHistoricoDeEmprestimoUsuario");
    }

    @FXML
    void TelaDePesquisaDoCliente(ActionEvent event) {
        MainAplication.mudarTela("telaDePesquisaDoCliente");
    }
}