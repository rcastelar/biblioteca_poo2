package Views;

        import biblioteca.Livro_DAO;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.event.ActionEvent;
        import java.net.URL;
        import java.util.ResourceBundle;


public class ViewNewLivro implements Initializable, ControlledScreen{
    Screens_controller myController;

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
        myController.unloadScreen("VewNewLivro");
    }
    @FXML
    private void newBook(ActionEvent event, String titulo, String posicao, String autor, String genero, String editora){
        Livro_DAO myBook = new Livro_DAO();
        myBook.InsertLivro(titulo, posicao, autor, genero, editora);
    }
}

