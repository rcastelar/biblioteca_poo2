package Views;

import Controllers.Controller_Publicacao;
import biblioteca.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewLivros extends MasterView implements Initializable, ControlledScreen {
    Controller_Publicacao mainControllerPublicacao = Controller_Publicacao.getInstance();

    @FXML
    private TextField Pesquisar;
    @FXML
    private TableView<Livro> TableLivros;
    @FXML
    private TableColumn<Object, Object> TituloId;
    @FXML
    private TableColumn<Object, Object> AutorId;
    @FXML
    private TableColumn<Object, Object> GeneroId;
    @FXML
    private TableColumn<Object, Object> PosicaoId;
    @FXML
    private TableColumn<Object, Object> LivroId;
    @FXML
    private TableColumn<Object, Object> EditoraId;

    ObservableList<Livro> listaLivros = FXCollections.observableArrayList();
    ObservableList<Livro> listaPesquisa = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaLivros = mainControllerPublicacao.getListaLivros();
        LivroId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        TituloId.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
        AutorId.setCellValueFactory(new PropertyValueFactory<>("Autor"));
        GeneroId.setCellValueFactory(new PropertyValueFactory<>("Genero"));
        PosicaoId.setCellValueFactory(new PropertyValueFactory<>("Posicao"));
        EditoraId.setCellValueFactory(new PropertyValueFactory<>("Posicao"));
        TableLivros.setItems(listaLivros);
    }

    @FXML
    private void ToViewEditlivros(ActionEvent event) {
        if (!TableLivros.getSelectionModel().isEmpty()) {
            goToViewEditlivros(event);
        } else {
            ViewAlert alert = new ViewAlert("Nenhum livro selecionado");
        }
    }

    @FXML
    private void mySelectedBook(){
        mainControllerPublicacao.setSelectedPublicacao(TableLivros.getSelectionModel().getSelectedItem());
    }
    @FXML
    private void pesquisaLivros(KeyEvent e) {
        String palavraChave = Pesquisar.getText();

        if (!palavraChave.isEmpty()) {
            listaPesquisa.clear();

            for (Livro l : listaLivros) {
                if ((l.getPosicao().contains(palavraChave) || l.getEditora().contains(palavraChave) || l.getGenero().contains(palavraChave) ||
                        l.getAutor().contains(palavraChave) || l.getTitulo().contains(palavraChave)) && !listaPesquisa.contains(l))
                    listaPesquisa.add(l);
            }

            if (!listaPesquisa.isEmpty()) {
                TableLivros.setItems(listaPesquisa);
            }
        } else if (palavraChave.length() == 0 ) {
            TableLivros.setItems(listaLivros);

        }
    }
}