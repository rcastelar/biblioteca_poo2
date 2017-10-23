package Views;

import biblioteca.Controller;
import biblioteca.Livro;
import biblioteca.Livro_DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewNewLivro implements Initializable, ControlledScreen {

    Screens_controller myController;
    Controller mainController = Controller.getInstance();
    @FXML  private TextField FieldTitulo;
    @FXML  private TextField FieldAutor;
    @FXML  private TextField FieldGenero;
    @FXML  private TextField FieldEditora;
    @FXML  private TextField FieldLocation;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setScreenParent(Screens_controller screenParent) {
        myController = screenParent;
    }

    @FXML
    private void goToViewLivros(ActionEvent event) {
        myController.loadScreen("ViewLivros", "ViewLivros.fxml");
        myController.setScreen("ViewLivros");
        myController.unloadScreen("ViewNewLivro");
    }

    @FXML
    private void newBook(ActionEvent event) {
        int id = 1;
        Livro_DAO myBook = new Livro_DAO();
        Livro mybook = new Livro(id, FieldTitulo.getText(), FieldLocation.getText(), FieldAutor.getText(), FieldGenero.getText(), FieldEditora.getText());
        mainController.addLivro(mybook);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("iLibrary");
        alert.setHeaderText(null);
        alert.setContentText("Livro salvo.");
        FieldTitulo.setText("");
        FieldAutor.setText("");
        FieldLocation.setText("");
        FieldGenero.setText("");
        FieldEditora.setText("");
        alert.showAndWait();
//
    }
}

