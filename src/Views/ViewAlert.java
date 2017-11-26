package Views;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

class ViewAlert {
    public ViewAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("iLibrary");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public ViewAlert() {
    }

    public String getUmDado(String content) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Ilybrary");
        dialog.setHeaderText(null);
        dialog.setContentText("Codigo do exemplar:");
        Optional<String> result = dialog.showAndWait();
        return result.get();
    }
}
