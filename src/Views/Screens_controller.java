package Views;

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

public class Screens_controller extends StackPane{

    public String NameViewAtual;

    private static final HashMap<String, Node> screens = new HashMap<>();

    public Screens_controller(){
        super();
    }

    private void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }

    public Node getScreen(String name){
        return screens.get(name);
    }

    public boolean loadScreen(String name, String resource){
        try{
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = myLoader.load();
            ControlledScreen myScreenControler = myLoader.getController();
                myScreenControler.setScreenParent(this);
                addScreen(name, loadScreen);
                return true;
            } catch (Exception e){
                System.out.println(e.getMessage());
                return false;
            }
        }

    public boolean setScreen(String name) {
        if (screens.get(name) != null) {
            final DoubleProperty opacity = opacityProperty();
            if (!getChildren().isEmpty()) {
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(100), t -> {
                            getChildren().remove(0);
                            getChildren().add(0, screens.get(name));
                            Timeline fadeIn = new Timeline(
                                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                    new KeyFrame(new Duration(100), new KeyValue(opacity, 1.0)));
                            fadeIn.play();
                        }, new KeyValue(opacity, 0.0)));
                fade.play();
            } else {
                setOpacity(0.0);
                getChildren().add(screens.get(name));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(100), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }

            NameViewAtual = name;

            return true;
        } else {
            System.out.println("Screen hasn't benn loaded! \n");
            return false;
        }
    }

    boolean unloadScreen(String name) {
            screens.remove(name);
            return false;

    }



}
