package view.Controladores;

import business.entities.Ativo;
import business.enums.Status;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import view.MainAplication;

public class ControladorTelaDoCliente{

    @FXML
    void Sair(ActionEvent event){
        MainAplication.mudarTela("telaDeLogin");
    }

    @FXML
    private Label nDeCadastro;

    @FXML
    private Label nomeDoUsuario;

    @FXML
    private Label status;

    @FXML
    void iniciar(MouseEvent event) {
        nomeDoUsuario.setText(Ativo.getInstance().getUsuarioAtivo().getNome());
        nDeCadastro.setText(Ativo.getInstance().getUsuarioAtivo().getNumeroDeCadastro());
        Status UserStatus = Ativo.getInstance().getUsuarioAtivo().getStatus();
        String statusDoUsuario = UserStatus.name();
        status.setText(statusDoUsuario);
    }

    @FXML
    void magicButton(ActionEvent event) {
        MainAplication.mudarTela("telaDoHistoricoDeEmprestimoUsuario");
    }

    @FXML
    void telaDeConfigurarUsuario(ActionEvent event) {
        MainAplication.mudarTela("telaDeConfigurarUsuario");
    }

    @FXML
    void telaDePesquisaDoCliente(ActionEvent event) {
        MainAplication.mudarTela("telaDeProcurarObraAutorUsuario");
    }
}