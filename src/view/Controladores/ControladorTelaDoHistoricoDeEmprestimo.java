package view.Controladores;

import business.entities.Emprestimo;
import business.entities.ObraImpressa;
import business.service.PessoaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.MainAplication;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ControladorTelaDoHistoricoDeEmprestimo implements Initializable {

    @FXML
    private TableColumn<Emprestimo, ObraImpressa> autor;

    @FXML
    private TableColumn<Emprestimo, LocalDate> dataDeEmprestimo;

    @FXML
    private TableColumn<Emprestimo, LocalDate> dataDeEntrega;

    @FXML
    private TableColumn<Emprestimo, LocalDate> detaDeDevolucao;

    @FXML
    private TableColumn<Emprestimo, String> nDeCadastro;

    @FXML
    private TableColumn<Emprestimo, String> nome;

    @FXML
    private TableColumn<Emprestimo, String> nomeDaObra;

    @FXML
    private TableColumn<Emprestimo, Integer> quantidade;

    @FXML
    private TableView<Emprestimo> tableView;

    private List<Emprestimo> emprestimos = PessoaService.getInstance().historicoDeEmprestimos();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        autor.setCellValueFactory(new PropertyValueFactory<Emprestimo, ObraImpressa>("itemEmprestado"));
        dataDeEmprestimo.setCellValueFactory(new PropertyValueFactory<Emprestimo, LocalDate>("dataDeEmprestimo"));
        detaDeDevolucao.setCellValueFactory(new PropertyValueFactory<Emprestimo, LocalDate>("dataDeEntrega"));
        dataDeEntrega.setCellValueFactory(new PropertyValueFactory<Emprestimo, LocalDate>("dataDeDevolucaoEfetiva"));
        nomeDaObra.setCellValueFactory(new PropertyValueFactory<Emprestimo, String>("itemEmprestadoo"));
        quantidade.setCellValueFactory(new PropertyValueFactory<Emprestimo, Integer>("quantidade1"));
        nome.setCellValueFactory(new PropertyValueFactory<Emprestimo, String>("nome123"));
        nDeCadastro.setCellValueFactory(new PropertyValueFactory<Emprestimo, String>("numeroDeCadastro"));
    }

    @FXML
    void vizualisarLista(ActionEvent event) {
        ObservableList<Emprestimo> items = FXCollections.observableArrayList(emprestimos);
        tableView.setItems(items);
    }

    @FXML
    void voltar(ActionEvent event) {
        tableView.setItems(null);
        MainAplication.mudarTela("telaDoAdministrador");
    }


}
