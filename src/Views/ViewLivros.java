package Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;




public class ViewLivros implements Initializable, ControlledScreen {

    Screens_controller myscreen;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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