package view.Controladores;

import business.entities.Emprestimo;
import business.entities.ObraImpressa;
import business.entities.Usuario;
import business.exceptions.ElementoNaoEncontradoException;
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

public class ControladorTelaDoHistoricoDeEmprestimoUsuario implements Initializable{

    @FXML
    private TableColumn<Emprestimo, ObraImpressa> autor;

    @FXML
    private TableColumn<Emprestimo, LocalDate> emprestimo;

    @FXML
    private TableColumn<Emprestimo, LocalDate> entrega;

    @FXML
    private TableColumn<Emprestimo, String> titulo;

    @FXML
    private TableView<Emprestimo> tableView;

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDoCliente");
    }

    private Usuario a = PessoaService.getInstance().getuService().getUsuarioAtivo();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        autor.setCellValueFactory(new PropertyValueFactory<Emprestimo, ObraImpressa>("itemEmprestado"));
        emprestimo.setCellValueFactory(new PropertyValueFactory<Emprestimo, LocalDate>("dataDeEmprestimo"));
        entrega.setCellValueFactory(new PropertyValueFactory<Emprestimo, LocalDate>("dataDeEntrega"));
        titulo.setCellValueFactory(new PropertyValueFactory<Emprestimo, String>("itemEmprestadoo"));
    }

    @FXML
    void lista(ActionEvent event) throws ElementoNaoEncontradoException {
        List<Emprestimo> listaDeEmprestimo = PessoaService.getInstance().buscarEmprestimosDoUsuario(
                PessoaService.getInstance().getuService().getUsuarioAtivo().getNumeroDeCadastro());
        ObservableList<Emprestimo> items = FXCollections.observableArrayList(listaDeEmprestimo);
        tableView.setItems(items);
    }
}

