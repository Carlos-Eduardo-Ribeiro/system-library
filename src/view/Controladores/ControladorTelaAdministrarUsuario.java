package view.Controladores;

import business.entities.Usuario;
import business.enums.Status;
import business.service.PessoaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import view.MainAplication;
import javafx.scene.control.ChoiceBox;

public class ControladorTelaAdministrarUsuario {

    ObservableList<String> status = FXCollections.observableArrayList("Released", "Warned", "Blocked");

    @FXML
    private TextField idDoUsuario;

    @FXML
    private CheckBox myCheckBox;

    private Usuario usuario;

    @FXML
    private ChoiceBox statusDoUsuario;

    @FXML
    void administrador(ActionEvent event) {
        if(myCheckBox.isSelected()){
            usuario.setAdmin(true);
        } else{
            usuario.setAdmin(false);
        }
    }

    @FXML
    void procurarUsuario() {
        try{
            usuario = PessoaService.getInstance().buscarUsuario(idDoUsuario.getText());
            statusDoUsuario.setItems(status);
            if(usuario==null){
                idDoUsuario.setText("");
                statusDoUsuario.setItems(status);
                statusDoUsuario.setValue("Released");
            }else{
                if(usuario.isAdmin()==true){
                    myCheckBox.setSelected(true);
                } else {
                    myCheckBox.setSelected(false);
                }
            }
            if (usuario.getStatus() == Status.RELEASED){
                statusDoUsuario.setValue("Released");
            } else if(usuario.getStatus() == Status.WARNED){
                statusDoUsuario.setValue("Warned");
            } else{
                statusDoUsuario.setValue("Blocked");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void initialize(){
        statusDoUsuario.setItems(status);
        statusDoUsuario.setOnAction(event -> {
            if(statusDoUsuario.getValue() == "Released"){
                usuario.setStatus(Status.RELEASED);
            }
            else if(statusDoUsuario.getValue() == "Warned"){
                usuario.setStatus(Status.WARNED);
            }
            else{
                usuario.setStatus(Status.BLOCKED);
            }
        });
    }


    @FXML
    void voltar(ActionEvent event) {
        idDoUsuario.setText("");
        myCheckBox.setSelected(false);
        MainAplication.mudarTela("telaDoAdministrador");
    }

}
