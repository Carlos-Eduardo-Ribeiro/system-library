package view.Controladores;

import business.service.PessoaService;
import business.service.UsuarioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    @FXML
    private void mostrarAlertaElemento() {
        // Cria o alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText("ERRO AO CADASTRAR AUTOR");

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


    private UsuarioService autor = PessoaService.getInstance().getuService();

    @FXML
    void addAutor(ActionEvent event){
        if(data.getValue() != null&&!endereco.getText().isEmpty()&&!nacionalidade.getText().isEmpty()&&!nome.getText().isEmpty()&&
                !pseudonimo.getText().isEmpty()){
            try{
                this.autor.adicionarAutor(nome.getText(), data.getValue(), endereco.getText(), pseudonimo.getText(),
                        nacionalidade.getText());
                mostrarAlertaElemento1();
                data.setValue(null);
                endereco.setText("");
                nacionalidade.setText("");
                nome.setText("");
                pseudonimo.setText("");
                MainAplication.mudarTela("telaDeAdmAutor");
            } catch (Exception e){
                mostrarAlertaElemento();
            }
        }

    }

    @FXML
    void voltar(ActionEvent event) {
        data.setValue(null);
        endereco.setText("");
        nacionalidade.setText("");
        nome.setText("");
        pseudonimo.setText("");
        MainAplication.mudarTela("telaDeAdmAutor");
    }

}
