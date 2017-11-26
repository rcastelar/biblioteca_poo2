package Views;

import Controllers.Controller_Usuario;
import biblioteca.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewNewUsuario extends MasterView implements Initializable, ControlledScreen {

    private final Controller_Usuario mainControllerUsuario = Controller_Usuario.getInstance();
    @FXML
    private TextField FieldNome;
    @FXML
    private TextField FieldRG;
    @FXML
    private TextField FieldTelefone;
    @FXML
    private TextField FieldEndereco;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void newUser(ActionEvent event) {
        if (!FieldNome.getText().isEmpty()) {
            int id = 1;
            Usuario myuser = new Usuario(mainControllerUsuario.getListaUsuarios().size() + 1, FieldNome.getText(), FieldEndereco.getText(), FieldRG.getText(), FieldTelefone.getText());
            mainControllerUsuario.addUsuario(myuser);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("iLibrary");
            alert.setHeaderText(null);
            alert.setContentText("Usuario salvo.");
            FieldNome.setText("");
            FieldRG.setText("");
            FieldEndereco.setText("");
            FieldTelefone.setText("");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("iLibrary");
            alert.setHeaderText(null);
            alert.setContentText("Usuario não pode ser salvo. Preencha o campo Nome!");
            alert.showAndWait();
            FieldNome.setStyle("-fx-border-style:solid; -fx-border-color: red; -fx-border-radius: 5px; -fx-effect: dropshadow(three-pass-box, red, 10, 0, 0, 0);");
        }
    }
}

