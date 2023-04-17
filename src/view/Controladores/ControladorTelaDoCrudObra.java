package view.Controladores;

import business.exceptions.ElementoJaExisteException;
import business.service.ObraService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    @FXML
    private void mostrarAlertaElemento() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERRO AO CADASTRAR LIVRO");

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

    private ObraService obra = ObraService.getInstance();

    @FXML
    void addObra(ActionEvent event){
        if(!autor.getText().isEmpty()&&anoDePub.getValue() != null&&!editora.getText().isEmpty()&&!genero.getText().isEmpty()
        &&!idioma.getText().isEmpty()&&!nDePag.getText().isEmpty()&&!qtd.getText().isEmpty()&&!titulo.getText().isEmpty()){
            try {
                int qtdInt = Integer.parseInt(this.qtd.getText());
                int nDePagInt = Integer.parseInt(this.nDePag.getText());
                this.obra.cadastrarLivro(this.titulo.getText(), this.autor.getText(), qtdInt, nDePagInt, this.idioma.getText(), (LocalDate)this.anoDePub.getValue(), this.editora.getText(), this.genero.getText());
                mostrarAlertaElemento1();
                autor.setText("");
                anoDePub.setValue(null);
                editora.setText("");
                genero.setText("");
                idioma.setText("");
                nDePag.setText("");
                qtd.setText("");
                titulo.setText("");
                MainAplication.mudarTela("telaDeAdmObras");
            } catch (Exception var4) {
                mostrarAlertaElemento();
                autor.setText("");
                anoDePub.setValue(null);
                editora.setText("");
                genero.setText("");
                idioma.setText("");
                nDePag.setText("");
                qtd.setText("");
                titulo.setText("");
                System.out.println(var4.getMessage());
            }
        }
    }

    @FXML
    void voltar(ActionEvent event) {
        autor.setText("");
        anoDePub.setValue(null);
        editora.setText("");
        genero.setText("");
        idioma.setText("");
        nDePag.setText("");
        qtd.setText("");
        titulo.setText("");
        MainAplication.mudarTela("telaDeAdmObras");
    }
}