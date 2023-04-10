package view.Controladores;

import business.exceptions.ElementoNaoEncontradoException;
import business.service.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDeDevolverLivro {
    @FXML
    private TextField itemEmprestado;
    @FXML
    private TextField nDeCadastro;
    private PessoaService devolverObra = PessoaService.getInstance();

    public ControladorTelaDeDevolverLivro() {
    }

    @FXML
    void devolverLivro(ActionEvent event) {
        try {
            this.devolverObra.devolverLivro(this.nDeCadastro.getText(), this.itemEmprestado.getText());
            MainAplication.mudarTela("telaDoAdministrador");
            System.out.println("Livro Devolvido");
        } catch (ElementoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void voltar(ActionEvent event) {
        MainAplication.mudarTela("telaDoAdministrador");
    }
}