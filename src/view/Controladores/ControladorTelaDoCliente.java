package view.Controladores;

import business.entities.Emprestimo;
import business.exceptions.ElementoNaoEncontradoException;
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

public class ControladorTelaDoCliente {

    @FXML
    void Sair(ActionEvent event){
        MainAplication.mudarTela("telaDeLogin");
    }

//    @FXML
//    void TelaDoHistoricoDeEmprestimo(ActionEvent event) throws ElementoNaoEncontradoException {
//
//        List<Emprestimo> listaDeEmprestimo = PessoaService.getInstance().buscarEmprestimosDoUsuario(PessoaService.getInstance().
//                getuService().getUsuarioAtivo().getNumeroDeCadastro());
//        ObservableList<Emprestimo> items = FXCollections.observableArrayList(listaDeEmprestimo);
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
    void magicButton(ActionEvent event) {
        MainAplication.mudarTela("telaDoHistoricoDeEmprestimoUsuario");
    }

    @FXML
    void telaDeConfigurarUsuario(ActionEvent event) {
        MainAplication.mudarTela("telaDeConfigurarUsuario");
    }

    @FXML
    void TelaDePesquisaDoCliente(ActionEvent event) {
        MainAplication.mudarTela("telaDePesquisaDoCliente");
    }
}