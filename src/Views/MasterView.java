package Views;

import Views.Screens_controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public abstract class MasterView {

    Screens_controller myscreen;

    public MasterView(){

    }

    public void setScreenParent(Screens_controller screenParent) {
        myscreen = screenParent;
   }

    @FXML
    public void goToViewLivros(ActionEvent event) {
        myscreen.unloadScreen("ViewUsuarios");
        myscreen.loadScreen("ViewLivros", "ViewLivros.fxml");
        myscreen.setScreen("ViewLivros");
    }
}
