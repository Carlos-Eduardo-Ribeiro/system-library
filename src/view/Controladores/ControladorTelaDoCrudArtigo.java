package view.Controladores;

import business.exceptions.ElementoJaExisteException;
import business.exceptions.ElementoNaoEncontradoException;
import business.service.ObraService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDoCrudArtigo {
    @FXML
    private TextField autor;

    @FXML
    private DatePicker dataDePub;

    @FXML
    private TextField editora;

    @FXML
    private TextField idioma;

    @FXML
    private TextField nDePag;

    @FXML
    private TextField quantidade;

    @FXML
    private TextField referencia;

    @FXML
    private TextField resumo;

    @FXML
    private TextField titulo;

    private ObraService artigo = ObraService.getInstance();

    @FXML
    void addArtigo(ActionEvent event) throws ElementoJaExisteException {
        int qtdInt = Integer.parseInt(this.quantidade.getText());
        int nDePagInt = Integer.parseInt(this.nDePag.getText());
        this.artigo.cadastrarArtigoCientifico(autor.getText(), titulo.getText(), qtdInt, nDePagInt, idioma.getText(),
        dataDePub.getValue(), editora.getText(), referencia.getText(), resumo.getText());
        System.out.println("Artigo cadastrado");
        MainAplication.mudarTela("telaDoCrudObraAutor");
    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDoCrudObraAutor");
    }

}
