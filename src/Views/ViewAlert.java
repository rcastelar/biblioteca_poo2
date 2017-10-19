package Views;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import javax.swing.text.View;
import java.util.Optional;

public class ViewAlert {
    public ViewAlert(String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("iLibrary");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    public ViewAlert(){

    }

    public String getUmDado(String content){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Ilybrary");
        dialog.setHeaderText(null);
        dialog.setContentText("Codigo do exemplar:");
        Optional<String> result = dialog.showAndWait();
// The Java 8 way to get the response value (with lambda expression).
        return result.get();
    }
}
