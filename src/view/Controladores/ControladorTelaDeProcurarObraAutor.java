package view.Controladores;

import business.entities.Emprestimo;
import business.entities.ObraImpressa;
import business.repositories.RepositorioDeObras;
import business.service.ObraService;
import com.sun.tools.javac.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import view.MainAplication;

import java.time.LocalDate;
import java.util.List;

public class ControladorTelaDeProcurarObraAutor {

    @FXML
    private TableColumn<ObraImpressa, LocalDate> anoDePublicacao;

    @FXML
    private TableColumn<ObraImpressa, String> autor;

    @FXML
    private TableColumn<ObraImpressa, String> editora;

    @FXML
    private TableColumn<ObraImpressa, String> genero;

    @FXML
    private TableColumn<ObraImpressa, String> idioma;

    @FXML
    private TableColumn<ObraImpressa, Integer> nDePag;

    @FXML
    private TableColumn<ObraImpressa, String> refBibliografica;

    @FXML
    private TableColumn<ObraImpressa, String> resumo;

    @FXML
    private TableColumn<ObraImpressa, String> titulo;

    @FXML
    private TableColumn<ObraImpressa, Integer> quantidade;

    @FXML
    private TextField nomeObraAutor;

    @FXML
    private TableView<ObraImpressa> tableView;

    private ObraImpressa listaDeObraPorNome;
    private ObraImpressa listaDeObraPorAutor;
    private List<ObraImpressa> listaDeObras = ObraService.getInstance().pesquisarObras();


    @FXML
    void pesquisar(ActionEvent event) {
        listaDeObraPorNome = RepositorioDeObras.getInstance().buscarPorNomes(nomeObraAutor.getText());
        listaDeObraPorAutor = RepositorioDeObras.getInstance().buscObraPorAutor(nomeObraAutor.getText());
        if(listaDeObraPorNome==null){
            if(listaDeObraPorAutor==null){
                autor.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("autor"));
                titulo.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("titulo"));
                nDePag.setCellValueFactory(new PropertyValueFactory<ObraImpressa, Integer>("numeroDePaginas"));
                resumo.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String >("resumo"));
                refBibliografica.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("referenciaBibliografica"));
                anoDePublicacao.setCellValueFactory(new PropertyValueFactory<ObraImpressa, LocalDate>("anoDePublicacao"));
                genero.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("generoLiterario"));
                editora.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("editora"));
                idioma.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("idioma"));
                autor.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("autor"));
                quantidade.setCellValueFactory(new PropertyValueFactory<ObraImpressa, Integer>("quantidade"));
                ObservableList<ObraImpressa> items = FXCollections.observableArrayList(listaDeObras);
                tableView.setItems(items);
            }else{
                autor.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("autor"));
                titulo.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("titulo"));
                nDePag.setCellValueFactory(new PropertyValueFactory<ObraImpressa, Integer>("numeroDePaginas"));
                resumo.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String >("resumo"));
                refBibliografica.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("referenciaBibliografica"));
                anoDePublicacao.setCellValueFactory(new PropertyValueFactory<ObraImpressa, LocalDate>("anoDePublicacao"));
                genero.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("generoLiterario"));
                editora.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("editora"));
                idioma.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("idioma"));
                autor.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("autor"));
                quantidade.setCellValueFactory(new PropertyValueFactory<ObraImpressa, Integer>("quantidade"));
                ObservableList<ObraImpressa> items = FXCollections.observableArrayList(listaDeObraPorNome);
                tableView.setItems(items);
            }
       }else{
            autor.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("autor"));
            titulo.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("titulo"));
            nDePag.setCellValueFactory(new PropertyValueFactory<ObraImpressa, Integer>("numeroDePaginas"));
            resumo.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String >("resumo"));
            refBibliografica.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("referenciaBibliografica"));
            anoDePublicacao.setCellValueFactory(new PropertyValueFactory<ObraImpressa, LocalDate>("anoDePublicacao"));
            genero.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("generoLiterario"));
            editora.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("editora"));
            idioma.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("idioma"));
            autor.setCellValueFactory(new PropertyValueFactory<ObraImpressa, String>("autor"));
            quantidade.setCellValueFactory(new PropertyValueFactory<ObraImpressa, Integer>("quantidade"));
            ObservableList<ObraImpressa> items = FXCollections.observableArrayList(listaDeObraPorAutor);
            tableView.setItems(items);
       }
    }

    @FXML
    void voltar(ActionEvent event) {
        tableView.setItems(null);
        MainAplication.mudarTela("telaDoAdministrador");
    }

}
