package view.Controladores;

import business.entities.ObraImpressa;
import business.exceptions.ElementoNaoEncontradoException;
import business.repositories.RepositorioDeObras;
import business.service.ObraService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.MainAplication;

public class ControladorTelaDeAtualizarObra {

    @FXML
    private TextField editora;

    @FXML
    private TextField idioma;

    @FXML
    private TextField numeroDePaginas;

    @FXML
    private TextField quantidade;

    @FXML
    private TextField titulo;

    @FXML
    private TextField nomeDaObra;

    private ObraImpressa obra;

    @FXML
    void procurarObra() {
        obra = RepositorioDeObras.getInstance().buscarPorNomes(nomeDaObra.getText());
        if(obra==null){
            editora.setText("");
            idioma.setText("");
            numeroDePaginas.setText("");
            quantidade.setText("");
            titulo.setText("");
        }

        else{
            editora.setText(obra.getEditora());
            idioma.setText(obra.getIdioma());
            numeroDePaginas.setText(String.format("%d", obra.getNumeroDePaginas()));
            quantidade.setText(String.format("%d",obra.getQuantidade()));
            titulo.setText(obra.getTitulo());
        }
    }

    @FXML
    void atuaEditora(ActionEvent event) throws ElementoNaoEncontradoException {
        ObraService.getInstance().atualizarEditoraDaObra(obra.getEditora(), editora.getText());
    }

    @FXML
    void atuaIdioma(ActionEvent event) throws ElementoNaoEncontradoException {
        ObraService.getInstance().atualizarIdiomaDaObra(obra.getTitulo(), idioma.getText());
    }

    @FXML
    void atuaPag(ActionEvent event) throws ElementoNaoEncontradoException {
        int nDePagInt = Integer.parseInt(this.numeroDePaginas.getText());
        ObraService.getInstance().atualizarNumeroDePaginasDaObra(obra.getTitulo(),nDePagInt);
    }

    @FXML
    void atuaQuantidade(ActionEvent event) throws ElementoNaoEncontradoException {
        int nDePagInt = Integer.parseInt(this.quantidade.getText());
        ObraService.getInstance().atualizarQuantidadeDisponivelDaObra(obra.getTitulo(),nDePagInt);
    }

    @FXML
    void atuaTitulo(ActionEvent event) throws ElementoNaoEncontradoException {
        ObraService.getInstance().atualizarTituloDaObra(obra.getTitulo(),titulo.getText());
    }

    @FXML
    void voltar(ActionEvent event) {
        editora.setText("");
        idioma.setText("");
        numeroDePaginas.setText("");
        quantidade.setText("");
        titulo.setText("");
        nomeDaObra.setText("");
        MainAplication.mudarTela("telaDeAdmObras");
    }
}

