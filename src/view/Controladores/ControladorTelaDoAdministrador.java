package view.Controladores;

import business.entities.Ativo;
import business.entities.Emprestimo;
import business.entities.Pessoa;
import business.service.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import view.MainAplication;

import java.util.List;

public class ControladorTelaDoAdministrador {

    private List<Emprestimo> emprestimos = PessoaService.getInstance().historicoDeEmprestimos();
    private List<Pessoa> listaDeUsuarios = PessoaService.getInstance().listaDeUsuarios();


    @FXML
    void entrou(MouseEvent event) {
        nomeDoAdm.setText(Ativo.getInstance().getUsuarioAtivo().getNome());
    }

    @FXML
    private Label nomeDoAdm;

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

    @FXML
    void telaDaListDeUsuarios(ActionEvent event) {
        MainAplication.mudarTela("telaDaListaDeUsuarios");
    }

    @FXML
    void telaHistDeEmprestimo(ActionEvent event) {
        MainAplication.mudarTela("telaDoHistoricoDeEmprestimo");
    }

    @FXML
    void telaDeLogin(ActionEvent event) {
        MainAplication.mudarTela("telaDeLogin");
    }

    @FXML
    void admUsuario(ActionEvent event) {
        MainAplication.mudarTela("telaAdministrarUsuario");
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