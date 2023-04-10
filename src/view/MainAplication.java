package view;

import business.exceptions.ElementoJaExisteException;
import business.service.PessoaService;
import business.service.UsuarioService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class MainAplication extends Application {
    private static Stage stage;
    private static Scene mainScene;
    private static Scene telaDeLogin;
    private static Scene telaDoCliente;
    private static Scene telaDeCadastro;
    private static Scene telaDoAdministrador;
    private static Scene telaDeDevolverLivro;
    private static Scene telaDeEmprestimo;
    private static Scene telaDoHistoricoDeEmprestimo;
    private static Scene telaDeProcurarObraAutor;
    private static Scene telaDaListaDeUsuarios;
    private static Scene telaDoCrudObraAutor;
    private static Scene telaAdministrarUsuario;
    private static Scene telaDeAtualizarUsuario;
    private static Scene telaDoHistoricoDeEmprestimoUsuario;
    private static Scene telaDeProcurarObraAutorUsuario;
    private static Scene telaDoCrudObra;
    private static Scene telaDoCrudAutor;

    public void start(Stage stagePrimary) throws IOException {
        stage = stagePrimary;

        Parent fxmlPrincipal = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//Main.fxml")));
        telaDeLogin = new Scene(fxmlPrincipal, 600.0, 400.0);

        Parent fxmlTelaDoCliente = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//TelaDoCliente.fxml")));
        telaDoCliente = new Scene(fxmlTelaDoCliente, 600.0, 400.0);

        Parent fxmlTelaDeCadastro = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//TelaDeCadastro.fxml")));
        telaDeCadastro = new Scene(fxmlTelaDeCadastro, 600.0, 400.0);

        Parent fxmlTelaDoAdministrador = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//TelaDoAdministrador.fxml")));
        telaDoAdministrador = new Scene(fxmlTelaDoAdministrador, 600.0, 400.0);

        Parent fxmlTelaDeDevolverLivro = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//TelaDeDevolverLivro.fxml")));
        telaDeDevolverLivro = new Scene(fxmlTelaDeDevolverLivro, 600.0, 400.0);

        Parent fxmlTelaDeEmprestimo = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//TelaDeEmprestimo.fxml")));
        telaDeEmprestimo = new Scene(fxmlTelaDeEmprestimo, 600.0, 400.0);

        Parent fxmlTelaDoHistoricoDeEmprestimo = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//TelaDoHistoricoDeEmprestimo.fxml")));
        telaDoHistoricoDeEmprestimo = new Scene(fxmlTelaDoHistoricoDeEmprestimo, 600.0, 400.0);

        Parent fxmlTelaDeProcurarObraAutor = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//TelaDeProcurarObraAutor.fxml")));
        telaDeProcurarObraAutor = new Scene(fxmlTelaDeProcurarObraAutor, 600.0, 400.0);

        Parent fxmlTelaDaListaDeUsuarios = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//TelaDaListaDeUsuarios.fxml")));
        telaDaListaDeUsuarios = new Scene(fxmlTelaDaListaDeUsuarios, 600.0, 400.0);

        Parent fxmlTelaDoCrudObraAutor = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//TelaDoCrudObraAutor.fxml")));
        telaDoCrudObraAutor = new Scene(fxmlTelaDoCrudObraAutor, 600.0, 400.0);

        Parent fxmlTelaAdministrarUsuario = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//TelaAdministrarUsuario.fxml")));
        telaAdministrarUsuario = new Scene(fxmlTelaAdministrarUsuario, 600.0, 400.0);

        Parent fxmlTelaDeAtualizarUsuario = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//TelaDeAtualizarUsuario.fxml")));
        telaDeAtualizarUsuario = new Scene(fxmlTelaDeAtualizarUsuario, 600.0, 400.0);

        Parent fxmlTelaDoHistoricoDeEmprestimoUsuario = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//TelaDoHistoricoDeEmprestimoUsuario.fxml")));
        telaDoHistoricoDeEmprestimoUsuario = new Scene(fxmlTelaDoHistoricoDeEmprestimoUsuario, 600.0, 400.0);

        Parent fxmlTelaDeProcurarObraAutorUsuario = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//TelaDeProcurarObraAutorUsuario.fxml")));
        telaDeProcurarObraAutorUsuario = new Scene(fxmlTelaDeProcurarObraAutorUsuario, 600.0, 400.0);

        Parent fxmlTelaDoCrudObra = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//TelaDoCrudObra.fxml")));
        telaDoCrudObra = new Scene(fxmlTelaDoCrudObra, 600.0, 400.0);

        Parent fxmlTelaDoCrudAutor = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml//TelaDoCrudAutor.fxml")));
        telaDoCrudAutor = new Scene(fxmlTelaDoCrudAutor, 600.0, 400.0);

        stage.setScene(telaDeLogin);
        stage.show();
    }

    public static void mudarTela(String tela) {
        switch (tela) {
            case "telaDoCliente" -> stage.setScene(telaDoCliente);
            case "telaDeLogin" -> stage.setScene(telaDeLogin);
            case "telaDeCadastro" -> stage.setScene(telaDeCadastro);
            case "telaDoAdministrador" -> stage.setScene(telaDoAdministrador);
            case "telaDeDevolverLivro" -> stage.setScene(telaDeDevolverLivro);
            case "telaDeEmprestimo" -> stage.setScene(telaDeEmprestimo);
            case "telaDoHistoricoDeEmprestimo" -> stage.setScene(telaDoHistoricoDeEmprestimo);
            case "telaDeProcurarObraAutor" -> stage.setScene(telaDeProcurarObraAutor);
            case "telaDaListaDeUsuarios" -> stage.setScene(telaDaListaDeUsuarios);
            case "telaDoCrudObraAutor" -> stage.setScene(telaDoCrudObraAutor);
            case "telaAdministrarUsuario" -> stage.setScene(telaAdministrarUsuario);
            case "telaDeAtualizarUsuario" -> stage.setScene(telaDeAtualizarUsuario);
            case "telaDoHistoricoDeEmprestimoUsuario" -> stage.setScene(telaDoHistoricoDeEmprestimoUsuario);
            case "telaDeProcurarObraAutorUsuario" -> stage.setScene(telaDeProcurarObraAutorUsuario);
            case "telaDoCrudObra" -> stage.setScene(telaDoCrudObra);
            case "telaDoCrudAutor" -> stage.setScene(telaDoCrudAutor);
        }
    }

    public static void fecharTela(){
        stage.close();
    }

    public static void main(String[] args) throws ElementoJaExisteException {
        UsuarioService a = PessoaService.getInstance().getuService();
        a.adicionarUsuario("Administrador", "", LocalDate.parse("2000-01-01"), "", "admin", "admin", true);
        launch();
    }
}