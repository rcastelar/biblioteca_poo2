package Views;

import Controllers.Controller_Publicacao;
import biblioteca.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewNewLivro implements Initializable, ControlledScreen {

    Screens_controller myController;
    Controller_Publicacao mainControllerPublicacao = Controller_Publicacao.getInstance();
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
        Livro mybook = new Livro(mainControllerPublicacao.getListaLivros().size() + 1, FieldTitulo.getText(), FieldLocation.getText(), FieldAutor.getText(), FieldGenero.getText(), FieldEditora.getText());
        mainControllerPublicacao.addLivro(mybook);
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

