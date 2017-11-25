package biblioteca;

import Controllers.*;
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
        primaryStage.setMaximized(false);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Controller_Publicacao mainControllerPublicacao = Controller_Publicacao.getInstance();
        Controller_Usuario mainControllerUsuario = Controller_Usuario.getInstance();

        launch(args);
    }
}
