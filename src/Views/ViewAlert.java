package Views;

import javafx.scene.control.Alert;

public class ViewAlert {
    public ViewAlert(String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("iLibrary");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
