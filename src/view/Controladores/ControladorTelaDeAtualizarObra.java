package view.Controladores;

import business.entities.ObraImpressa;
import business.exceptions.ElementoNaoEncontradoException;
import business.repositories.RepositorioDeObras;
import business.service.ObraService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private void mostrarAlertaElemento1() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ALERTA");
        alerta.setHeaderText("ATUALIZAÇÃO EFETUADA");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }

    @FXML
    private void mostrarAlertaElemento() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERROR AO ATUALIZAR");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }

    @FXML
    void procurarObra() {
        obra = RepositorioDeObras.getInstance().buscarPorNomes(nomeDaObra.getText());
        if(obra==null){
            editora.setText("");
            idioma.setText("");
            numeroDePaginas.setText("");
            quantidade.setText("");
            titulo.setText("");
        } else{
            editora.setText(obra.getEditora());
            idioma.setText(obra.getIdioma());
            numeroDePaginas.setText(String.format("%d", obra.getNumeroDePaginas()));
            quantidade.setText(String.format("%d",obra.getQuantidade()));
            titulo.setText(obra.getTitulo());
        }
    }

    @FXML
    void atuaEditora(ActionEvent event){
        if(obra != null){
            try{
                ObraService.getInstance().atualizarEditoraDaObra(obra.getEditora(), editora.getText());
                mostrarAlertaElemento1();
            }catch(Exception e){
                mostrarAlertaElemento();
            }
        }
    }

    @FXML
    void atuaIdioma(ActionEvent event){
        if(obra != null){
            try{
                ObraService.getInstance().atualizarIdiomaDaObra(obra.getTitulo(), idioma.getText());
                mostrarAlertaElemento1();
            }catch (Exception e){
                mostrarAlertaElemento();
            }
        }

    }

    @FXML
    void atuaPag(ActionEvent event){
        if(obra != null){
            try{
                int nDePagInt = Integer.parseInt(this.numeroDePaginas.getText());
                ObraService.getInstance().atualizarNumeroDePaginasDaObra(obra.getTitulo(),nDePagInt);
                mostrarAlertaElemento1();
            }catch(Exception e){
                mostrarAlertaElemento();
            }
        }

    }

    @FXML
    void atuaQuantidade(ActionEvent event) {
        if(obra != null){
            try{
                int nDePagInt = Integer.parseInt(this.quantidade.getText());
                ObraService.getInstance().atualizarQuantidadeDisponivelDaObra(obra.getTitulo(),nDePagInt);
                mostrarAlertaElemento1();
            } catch(Exception e){
                mostrarAlertaElemento();
            }
        }

    }

    @FXML
    void atuaTitulo(ActionEvent event) throws ElementoNaoEncontradoException {
        if(obra != null){
            try{
                ObraService.getInstance().atualizarTituloDaObra(obra.getTitulo(),titulo.getText());
                mostrarAlertaElemento1();
            }catch(Exception e){
                mostrarAlertaElemento();
            }
        }

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

