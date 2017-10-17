package Views;

        import biblioteca.Livro_DAO;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.event.ActionEvent;
        import java.net.URL;
        import java.util.ResourceBundle;


public class ViewNewLivro implements Initializable, ControlledScreen {
    Screens_controller myController;

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
    private void newBook(ActionEvent event2) {
        String titulo="hue";
        //Livro_DAO myBook = new Livro_DAO();
        //try {
        //    titulo = event.getClass().getField("idFieldAutor").getName();
            System.out.println(titulo);

        //} catch (NoSuchFieldException e) {
        //    e.printStackTrace();
        }
        // myBook.InsertLivro(titulo, posicao, autor, genero, editora);

    //}
}

