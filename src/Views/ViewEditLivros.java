package Views;

import biblioteca.Controller;
import biblioteca.Livro;
import biblioteca.Livro_DAO;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Array;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class ViewEditLivros implements Initializable, ControlledScreen{
    @FXML  private TextField FieldTitulo;
    @FXML  private TextField FieldAutor;
    @FXML  private TextField FieldGenero;
    @FXML  private TextField FieldEditora;
    @FXML  private TextField FieldLocation;
    Livro selectedlivro;
        Screens_controller myController;
        Controller mainController = Controller.getInstance();

    @Override
        public void initialize(URL url, ResourceBundle rb) {
            selectedlivro =mainController.getSelectedBook();

            FieldTitulo.setText(selectedlivro.getTitulo());
            FieldAutor.setText(selectedlivro.getAutor());
            FieldGenero.setText(selectedlivro.getGenero());
            FieldEditora.setText(selectedlivro.getEditora());


        }

        public void setScreenParent(Screens_controller screenParent) {
            myController = screenParent;
        }

        @FXML
        private void goToViewLivros(ActionEvent event) {
            myController.setScreen("ViewLivros");
            myController.unloadScreen("VewEditLivros");
        }
    }

