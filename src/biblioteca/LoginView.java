/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author f32cpd02
 */
public class JavaFXApplication1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      GridPane grid = new GridPane();
      grid.setAlignment(Pos.CENTER);
      grid.setHgap(10);
      grid.setVgap(10);
      grid.setPadding(new Insets(25,25,25,25));
      
      Scene scene = new Scene(grid, 300, 275);
      
      
      Text scenetitle = new Text("Enter your credentials: ");
      scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
      
      Label userName = new Label("User Name:");
      Label pw = new Label("Password: ");
      
      TextField userTextField = new TextField();
      
      PasswordField pwBox = new PasswordField();
      
     // grid.setGridLinesVisible(true);
      
      
      
      //  grid.add(scenetitle,0,0,2,1);
        grid.add(userName,0,1);
        grid.add(userTextField,1,1);
        grid.add(pw,0,2);
        grid.add(pwBox,1,2);
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn,1,4);
        btn.setOnAction(event ->
        {
              //  actiontarget.setFill(Color.FIREBRICK);
               // actiontarget.setText("Sign in button pressed");
        });
        primaryStage.setTitle("BookShare");
        primaryStage.setScene(scene);
        primaryStage.show();
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
