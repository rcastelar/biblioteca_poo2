package Views;

import biblioteca.Livro;
import biblioteca.Livro_DAO;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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



        TituloId.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
        AutorId.setCellValueFactory(new PropertyValueFactory<>("Autor"));
        GeneroId.setCellValueFactory(new PropertyValueFactory<>("Genero"));
        PosicaoId.setCellValueFactory(new PropertyValueFactory<>("Posicao"));
        TableLivros.setItems(listaLivros);

    }

    public void setScreenParent(Screens_controller screenParent) {
        myscreen = screenParent;
    }

    @FXML
    private void goToViewEditlivros(ActionEvent event) {
        myscreen.loadScreen("ViewEditLivros", "ViewEditLivros.fxml");
        myscreen.setScreen("ViewEditLivros");

    }
    @FXML
    private void goToViewNewlivro(ActionEvent event) {
        myscreen.loadScreen("ViewNewLivro", "ViewNewLivro.fxml");
        myscreen.setScreen("ViewNewLivro");

    }
}