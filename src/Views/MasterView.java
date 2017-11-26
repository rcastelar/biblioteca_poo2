package Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MasterView {

    Screens_controller myscreen;

    public MasterView(){

    }

    public void setScreenParent(Screens_controller screenParent) {
        myscreen = screenParent;
   }

    @FXML
    public void goToViewLivros(ActionEvent event) {
        myscreen.unloadScreen(myscreen.NameViewAtual);
        myscreen.loadScreen("ViewLivros", "ViewLivros.fxml");
        myscreen.setScreen("ViewLivros");
    }

    @FXML
    public void goToViewUsuarios(ActionEvent event) {
        myscreen.unloadScreen(myscreen.NameViewAtual);
        myscreen.loadScreen("ViewUsuarios", "ViewUsuarios.fxml");
        myscreen.setScreen("ViewUsuarios");
    }

    @FXML
    public void goToViewEditUsuarios(ActionEvent event) {
        myscreen.unloadScreen(myscreen.NameViewAtual);
        myscreen.loadScreen("ViewEditUsuarios", "ViewEditUsuarios.fxml");
        myscreen.setScreen("ViewEditUsuarios");
    }

    @FXML
    public void goToViewEditlivros(ActionEvent event) {
        myscreen.loadScreen("ViewEditLivros", "ViewEditLivros.fxml");
        myscreen.setScreen("ViewEditLivros");
        myscreen.unloadScreen("ViewLivros");
    }

    @FXML
    public void goToViewNewUsuario(ActionEvent event) {
        myscreen.unloadScreen(myscreen.NameViewAtual);
        myscreen.loadScreen("ViewNewUsuario", "ViewNewUsuario.fxml");
        myscreen.setScreen("ViewNewUsuario");
    }

    @FXML
    private void goToViewNewlivro(ActionEvent event) {
        myscreen.unloadScreen("ViewLivros");
        myscreen.loadScreen("ViewNewLivro", "ViewNewLivro.fxml");
        myscreen.setScreen("ViewNewLivro");
    }
}
