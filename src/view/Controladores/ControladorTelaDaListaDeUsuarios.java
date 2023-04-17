package view.Controladores;

import business.entities.Pessoa;
import business.enums.Status;
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

public class ControladorTelaDaListaDeUsuarios implements Initializable {

    @FXML
    private TableColumn<Pessoa, String> cpf;

    @FXML
    private TableColumn<Pessoa, String> endereco;

    @FXML
    private TableColumn<Pessoa, LocalDate> idade;

    @FXML
    private TableColumn<Pessoa, String> login;

    @FXML
    private TableColumn<Pessoa, String> nDeCadastro;

    @FXML
    private TableColumn<Pessoa, String> nome;

    @FXML
    private TableColumn<Pessoa, String> senha;

    @FXML
    private TableColumn<Pessoa, Status> status;

    @FXML
    private TableColumn<Pessoa, Boolean> administrador;

    @FXML
    private TableView<Pessoa> tableView;

    private List<Pessoa> listaDeUsuarios = PessoaService.getInstance().listaDeUsuarios();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nome.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("nome"));
        cpf.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("cpf"));
        endereco.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("endereco"));
        idade.setCellValueFactory(new PropertyValueFactory<Pessoa, LocalDate>("idade"));
        login.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("login"));
        senha.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("password"));
        nDeCadastro.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("numeroDeCadastro"));
        administrador.setCellValueFactory(new PropertyValueFactory<Pessoa, Boolean>("Admin"));
        status.setCellValueFactory(new PropertyValueFactory<Pessoa, Status>("status"));
    }

    @FXML
    void visualizarLista(ActionEvent event) {
        ObservableList<Pessoa> items = FXCollections.observableArrayList(listaDeUsuarios);
        tableView.setItems(items);
    }

    @FXML
    void voltar(ActionEvent event) {
        tableView.setItems(null);
        MainAplication.mudarTela("telaDoAdministrador");
    }
}
