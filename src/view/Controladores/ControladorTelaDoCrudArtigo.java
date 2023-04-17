package view.Controladores;

import business.exceptions.ElementoJaExisteException;
import business.exceptions.ElementoNaoEncontradoException;
import business.service.ObraService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private void mostrarAlertaElemento() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERRO AO CADASTRAR ARTIGO");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }
    @FXML
    private void mostrarAlertaElemento1() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ALERTA");
        alerta.setHeaderText("CADASTRO REALIZADO");

        // Mostra o alerta e espera pelo fechamento
        alerta.showAndWait();
    }

    @FXML
    void addArtigo(ActionEvent event) throws ElementoJaExisteException {
        if(!autor.getText().isEmpty()&&dataDePub.getValue() != null&&!editora.getText().isEmpty()&&!idioma.getText().isEmpty()&&
        !nDePag.getText().isEmpty()&&!quantidade.getText().isEmpty()&&!referencia.getText().isEmpty()&&!resumo.getText().isEmpty()
        &&!titulo.getText().isEmpty()){
            try{
                int qtdInt = Integer.parseInt(this.quantidade.getText());
                int nDePagInt = Integer.parseInt(this.nDePag.getText());
                this.artigo.cadastrarArtigoCientifico(autor.getText(), titulo.getText(), qtdInt, nDePagInt, idioma.getText(),
                        dataDePub.getValue(), editora.getText(), referencia.getText(), resumo.getText());
                mostrarAlertaElemento1();
                autor.setText("");
                titulo.setText("");
                resumo.setText("");
                referencia.setText("");
                nDePag.setText("");
                idioma.setText("");
                dataDePub.setValue(null);
                editora.setText("");
                quantidade.setText("");
                MainAplication.mudarTela("telaDeAdmObras");
            } catch (Exception e) {
                mostrarAlertaElemento();
                autor.setText("");
                titulo.setText("");
                resumo.setText("");
                referencia.setText("");
                nDePag.setText("");
                idioma.setText("");
                dataDePub.setValue(null);
                editora.setText("");
                quantidade.setText("");
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void voltar(ActionEvent event) {
        autor.setText("");
        titulo.setText("");
        resumo.setText("");
        referencia.setText("");
        nDePag.setText("");
        idioma.setText("");
        dataDePub.setValue(null);
        editora.setText("");
        quantidade.setText("");
        MainAplication.mudarTela("telaDeAdmObras");
    }

}
