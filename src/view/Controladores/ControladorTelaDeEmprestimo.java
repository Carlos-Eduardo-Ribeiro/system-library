package view.Controladores;

import business.exceptions.ElementoNaoEncontradoException;
import business.service.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDeEmprestimo {
    @FXML
    private TextField itemEmprestado;
    @FXML
    private TextField nDeCadastro;

    private PessoaService usuario = PessoaService.getInstance();

    @FXML
    void addEmprestimo(ActionEvent event) {
        try {
            this.usuario.emprestrarObra(this.nDeCadastro.getText(), this.itemEmprestado.getText());
            MainAplication.mudarTela("telaDoAdministrador");
            itemEmprestado.setText("");
            nDeCadastro.setText("");
            System.out.println("Livro Emprestado");
        } catch (ElementoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void voltar(ActionEvent event) {
        itemEmprestado.setText("");
        nDeCadastro.setText("");
        MainAplication.mudarTela("telaDoAdministrador");
    }
}
