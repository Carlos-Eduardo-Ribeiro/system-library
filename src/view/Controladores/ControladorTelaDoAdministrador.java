package view.Controladores;

import business.entities.Emprestimo;
import business.entities.Pessoa;
import business.service.PessoaService;
import com.sun.tools.javac.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.MainAplication;

import java.util.List;

public class ControladorTelaDoAdministrador {

    private List<Emprestimo> emprestimos = PessoaService.getInstance().historicoDeEmprestimos();
    private List<Pessoa> listaDeUsuarios = PessoaService.getInstance().listaDeUsuarios();

//    @FXML
//    void telaDaListaDeUsuarios(ActionEvent event) {
//        ObservableList<Pessoa> items = FXCollections.observableArrayList(listaDeUsuarios);
//
//        // Cria o ListView e configura com a lista de itens
//        ListView<Pessoa> listView = new ListView<Pessoa>(items);
//
//        // Cria o layout e adiciona o ListView
//        VBox root = new VBox();
//        root.getChildren().add(listView);
//
//        // Cria a cena e adiciona o layout
//        Scene scene = new Scene(root, 200, 200);
//
//        // Cria a janela e define a cena
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
//    }

    @FXML
    void telaDeDevolverLivro(ActionEvent event) {
        MainAplication.mudarTela("telaDeDevolverLivro");
    }

    @FXML
    void telaDeProcurarObraAutor(ActionEvent event) {
        MainAplication.mudarTela("telaDeProcurarObraAutor");
    }

    @FXML
    void telaDeEmprestimo(ActionEvent event) {
        MainAplication.mudarTela("telaDeEmprestimo");
    }

//    @FXML
//    void telaDoCrudObraAutor(ActionEvent event) {
//        MainAplication.mudarTela("telaDeAtualizarUsuario");
//    }

    @FXML
    void telaDaListDeUsuarios(ActionEvent event) {
        MainAplication.mudarTela("telaDaListaDeUsuarios");
    }

    @FXML
    void telaHistDeEmprestimo(ActionEvent event) {
        MainAplication.mudarTela("telaDoHistoricoDeEmprestimo");
    }

//    @FXML
//    void telaDoHistoricoDeEmprestimos(ActionEvent event) {
//
//        ObservableList<Emprestimo> items = FXCollections.observableArrayList(emprestimos);
//
//        // Cria o ListView e configura com a lista de itens
//        ListView<Emprestimo> listView = new ListView<Emprestimo>(items);
//
//        // Cria o layout e adiciona o ListView
//        VBox root = new VBox();
//        root.getChildren().add(listView);
//
//        // Cria a cena e adiciona o layout
//        Scene scene = new Scene(root, 200, 200);
//
//        // Cria a janela e define a cena
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
//    }

    @FXML
    void telaDeLogin(ActionEvent event) {
        MainAplication.mudarTela("telaDeLogin");
    }

    @FXML
    void admUsuario(ActionEvent event) {
        MainAplication.mudarTela("telaAdministrarUsuario");
    }

    @FXML
    void admArtCien(ActionEvent event) {
        MainAplication.mudarTela("telaDeAdmArtCien");
    }

    @FXML
    void admAutor(ActionEvent event) {
        MainAplication.mudarTela("telaDeAdmAutor");
    }

    @FXML
    void admObra(ActionEvent event) {
        MainAplication.mudarTela("telaDeAdmObras");
    }
}