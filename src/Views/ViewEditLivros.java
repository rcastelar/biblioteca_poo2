package Views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewEditLivros implements Initializable, ControlledScreen{


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
        }
    }

