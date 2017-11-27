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
        if (!FieldRG.getText().isEmpty()) {
            Usuario myuser = new Usuario(mainControllerUsuario.getListaUsuarios().size() + 1, FieldNome.getText(), FieldEndereco.getText(), FieldRG.getText(), FieldTelefone.getText());
            int result =mainControllerUsuario.addUsuario(myuser);
            if (result == 1){
                new ViewAlert("Usuario ja cadastrado");
            }else {

            FieldNome.setText("");
            FieldRG.setText("");
            FieldEndereco.setText("");
            FieldTelefone.setText("");
            new ViewAlert("Usu'ario salvo");
            }
        }else {
            new ViewAlert("Usuario não pode ser salvo. Preencha o campo RG!");
            FieldRG.setStyle("-fx-border-style:solid; -fx-border-color: red; -fx-border-radius: 5px; -fx-effect: dropshadow(three-pass-box, red, 10, 0, 0, 0);");
        }
    }
}


