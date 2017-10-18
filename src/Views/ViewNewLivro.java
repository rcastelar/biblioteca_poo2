package Views;

        import biblioteca.Livro_DAO;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.event.ActionEvent;
        import javafx.scene.control.*;
        import java.net.URL;
        import java.util.ResourceBundle;


public class ViewNewLivro implements Initializable, ControlledScreen {

    Screens_controller myController;

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
        Livro_DAO myBook = new Livro_DAO();
        myBook.InsertLivro(FieldTitulo.getText(), FieldLocation.getText(), FieldAutor.getText(), FieldGenero.getText(), FieldEditora.getText());
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

