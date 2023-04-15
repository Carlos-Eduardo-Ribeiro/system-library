package view.Controladores;

import business.exceptions.ElementoJaExisteException;
import business.service.PessoaService;
import business.service.UsuarioService;
import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDoCrudAutor {

    @FXML
    private DatePicker data;

    @FXML
    private TextField endereco;

    @FXML
    private TextField nacionalidade;

    @FXML
    private TextField nome;

    @FXML
    private TextField pseudonimo;

    private UsuarioService autor = PessoaService.getInstance().getuService();

    @FXML
    void addAutor(ActionEvent event) throws ElementoJaExisteException {
        this.autor.adicionarAutor(nome.getText(), data.getValue(), endereco.getText(), pseudonimo.getText(),
                nacionalidade.getText());
        System.out.println("Autor Cadastrado");
        MainAplication.mudarTela("telaDeAdmAutor");
    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDeAdmAutor");
    }

}
