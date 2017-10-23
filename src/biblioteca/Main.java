package biblioteca;

import Views.Screens_controller;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Screens_controller mainContainer = new Screens_controller();
        mainContainer.loadScreen("ViewLivros", "ViewLivros.fxml");
        mainContainer.setScreen("ViewLivros");
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Livros");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Controller mainController = Controller.getInstance();
        launch(args);
    }
}
