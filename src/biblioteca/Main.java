package biblioteca;

import Views.Screens_controller;
import bd.DBHandler;
import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.SQLException;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        Screens_controller mainContainer = new Screens_controller();
        mainContainer.loadScreen("ViewLivros", "ViewLivros.fxml");
        mainContainer.loadScreen("ViewEditLivros", "ViewEditLivros.fxml");
        mainContainer.setScreen("ViewLivros");
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Livros");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        DBHandler mysqlite = new DBHandler();
        try {
            mysqlite.querry("SELECT * FROM sqlite_master");
       //    mysqlite.execute("INSERT INTO livro VALUES "+"(" + "1"+", " + "livro1"+", "+" 1a"+", " +"autor1"+", " + "gen1"+", "+ "edito1"+")");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        launch(args);
    }
}
