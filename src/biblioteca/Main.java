package biblioteca;

import Controllers.Controller_Publicacao;
import Controllers.Controller_Usuario;
import Views.Screens_controller;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
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

    public static void main(String[] args) {
        Controller_Publicacao mainControllerPublicacao = Controller_Publicacao.getInstance();
        Controller_Usuario mainControllerUsuario = Controller_Usuario.getInstance();

        launch(args);
    }
}
