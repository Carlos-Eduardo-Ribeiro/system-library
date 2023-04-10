package view.Controladores;

import business.entities.Emprestimo;
import business.service.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import view.MainAplication;

import java.util.List;

public class ControladorTelaDoHistoricoDeEmprestimo {

    @FXML
    private TableColumn<?, ?> dataDeDev;
    @FXML
    private TableColumn<?, ?> dataDeDevEfetiva;
    @FXML
    private TableColumn<?, ?> dataDeEmp;
    @FXML
    private TableColumn<?, ?> nDeCad;
    @FXML
    private TableColumn<?, ?> nome;
    @FXML
    private TableColumn<?, ?> obraEmprestada;

    private List<Emprestimo> emprestimos = PessoaService.getInstance().historicoDeEmprestimos();

    @FXML
    void tabela(ActionEvent event) {
    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDoAdministrador");
    }

    public void start(Stage primaryStage) {
    }
}