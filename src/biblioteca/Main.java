package biblioteca;

import Views.Screens_controller;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Screens_controller mainContainer = new Screens_controller();
        mainContainer.loadScreen("ViewUsuarios", "ViewUsuarios.fxml");
        mainContainer.setScreen("ViewUsuarios");
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setTitle("iLibrary");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(false);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
