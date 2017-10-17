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

        myController.setScreen("ViewLivros");
        myController.unloadScreen("ViewNewLivro");
    }

    @FXML
    private void newBook(ActionEvent event) {
        Livro_DAO myBook = new Livro_DAO();
        myBook.InsertLivro(FieldTitulo.getText() ,FieldAutor.getText(), FieldLocation.getText(), FieldGenero.getText(), FieldEditora.getText());
        String titulo;
    titulo =   FieldAutor.getText();

         System.out.println(titulo);
//
    }
}

