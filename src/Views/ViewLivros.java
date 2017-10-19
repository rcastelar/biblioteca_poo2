package Views;

import biblioteca.Controller;
import biblioteca.Livro;
import biblioteca.Livro_DAO;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;




public class ViewLivros implements Initializable, ControlledScreen {

    Screens_controller myscreen;
    @FXML  private TableView TableLivros;
    @FXML private TableColumn TituloId;
    @FXML private TableColumn AutorId;
    @FXML private TableColumn GeneroId;
    @FXML private TableColumn PosicaoId;
    @FXML private TableColumn LivroId;
    @FXML private TableColumn EditoraId;
    ObservableList<Livro> listaLivros = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Livro_DAO mybooks = new Livro_DAO();
        try {
            listaLivros = mybooks.GetAllLivro();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        LivroId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        TituloId.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
        AutorId.setCellValueFactory(new PropertyValueFactory<>("Autor"));
        GeneroId.setCellValueFactory(new PropertyValueFactory<>("Genero"));
        PosicaoId.setCellValueFactory(new PropertyValueFactory<>("Posicao"));
        EditoraId.setCellValueFactory(new PropertyValueFactory<>("Posicao"));
        TableLivros.setItems(listaLivros);

    }

    public void setScreenParent(Screens_controller screenParent) {
        myscreen = screenParent;
    }

    @FXML
    private void goToViewEditlivros(ActionEvent event) {
        if (!TableLivros.getSelectionModel().isEmpty()) {
            myscreen.loadScreen("ViewEditLivros", "ViewEditLivros.fxml");
            myscreen.setScreen("ViewEditLivros");
            myscreen.unloadScreen("ViewLivros");
        } else {
            ViewAlert alert = new ViewAlert("Nenhum livro selecionado");
        }
    }
    @FXML
    private void goToViewNewlivro(ActionEvent event) {
        myscreen.unloadScreen("ViewLivros");
        myscreen.loadScreen("ViewNewLivro", "ViewNewLivro.fxml");
        myscreen.setScreen("ViewNewLivro");
    }
    @FXML
    private void mySelectedBook(){
        Controller mainController = Controller.getInstance();
        mainController.setSelectedBook((Livro)TableLivros.getSelectionModel().getSelectedItem());


    }
}