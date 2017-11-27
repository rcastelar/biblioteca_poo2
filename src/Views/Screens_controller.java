package Views;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.HashMap;

public class Screens_controller extends StackPane {

    private static final HashMap<String, Node> screens = new HashMap<>();
    public String NameViewAtual;

    public Screens_controller() {
        super();
    }

    private void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }

    public void loadScreen(String name, String resource) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = myLoader.load();
            ControlledScreen myScreenControler = myLoader.getController();
            myScreenControler.setScreenParent(this);
            addScreen(name, loadScreen);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setScreen(String name) {
        if (screens.get(name) != null) {
            final DoubleProperty opacity = opacityProperty();
            if (!getChildren().isEmpty()) {
                            getChildren().remove(0);
                            getChildren().add(0, screens.get(name));
            } else {
                getChildren().add(screens.get(name));
            }
            NameViewAtual = name;
        } else {
            System.out.println("Screen hasn't benn loaded! \n");
        }
    }

    void unloadScreen(String name) {
        screens.remove(name);
    }
}
