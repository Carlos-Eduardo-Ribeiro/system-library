package view.Controladores;

import business.exceptions.ElementoJaExisteException;
import business.service.ObraService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import view.MainAplication;

import java.time.LocalDate;

public class ControladorTelaDoCrudObra {
    @FXML
    private TextField autor;
    @FXML
    private DatePicker anoDePub;
    @FXML
    private TextField editora;
    @FXML
    private TextField genero;
    @FXML
    private TextField idioma;
    @FXML
    private TextField nDePag;
    @FXML
    private TextField qtd;
    @FXML
    private TextField titulo;

    private ObraService obra = ObraService.getInstance();

    @FXML
    void addObra(ActionEvent event) throws ElementoJaExisteException {
        try {
            int qtdInt = Integer.parseInt(this.qtd.getText());
            int nDePagInt = Integer.parseInt(this.nDePag.getText());
            this.obra.cadastrarLivro(this.titulo.getText(), this.autor.getText(), qtdInt, nDePagInt, this.idioma.getText(), (LocalDate)this.anoDePub.getValue(), this.editora.getText(), this.genero.getText());
            System.out.println("Livro cadastrado");
            MainAplication.mudarTela("telaDeAdmObras");
        } catch (ElementoJaExisteException var4) {
            System.out.println(var4.getMessage());
        }

    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDeAdmObras");
    }
}