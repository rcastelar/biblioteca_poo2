package biblioteca;

import bd.DBHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        DBHandler sql_example = new DBHandler();
        try {
            sql_example.querry("SELECT * FROM sqlite_master");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        launch(args);
    }
}
