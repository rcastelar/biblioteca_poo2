package Views;

import Controllers.Controller_Usuario;
import biblioteca.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewUsuarios extends MasterView implements Initializable, ControlledScreen {


    @FXML
    public Button btnMainLivros;
    //Screens_controller myscreen;

    @FXML
    private TextField Pesquisar;
    @FXML
    public Button btnNewUser;
    @FXML
    public Button btnMainUsuarios;
    Controller_Usuario mainControllerUsuarios = Controller_Usuario.getInstance();
    ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    ObservableList<Usuario> listaPesquisa = FXCollections.observableArrayList();
    @FXML
    private TableView<Usuario> TableUsuarios;
    @FXML
    private TableColumn<Object, Object> NomeId;
    @FXML
    private TableColumn<Object, Object> EnderecoId;
    @FXML
    private TableColumn<Object, Object> TelefoneId;
    @FXML
    private TableColumn<Object, Object> RGId;
    @FXML
    private Button btnEditUser;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaUsuarios = mainControllerUsuarios.getListaUsuarios();
        NomeId.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        EnderecoId.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
        TelefoneId.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
        RGId.setCellValueFactory(new PropertyValueFactory<>("Rg"));
        TableUsuarios.setItems(listaUsuarios);
    }


    @FXML
    private void goToViewEditUsuarios(ActionEvent event) {
        if (!TableUsuarios.getSelectionModel().isEmpty()) {
            myscreen.loadScreen("ViewEditUsuarios", "ViewEditUsuarios.fxml");
            myscreen.setScreen("ViewEditUsuarios");
            myscreen.unloadScreen("ViewUsuarios");
        } else {
            ViewAlert alert = new ViewAlert("Nenhum usuario selecionado");
        }
    }
    @FXML
    private void goToViewNewUsuario(ActionEvent event) {
        myscreen.unloadScreen("ViewUsuarios");
        myscreen.loadScreen("ViewNewUsuario", "ViewNewUsuario.fxml");
        myscreen.setScreen("ViewNewUsuario");
    }
    @FXML
    private void mySelectedUser() {
        mainControllerUsuarios.setSelectedUsuario(TableUsuarios.getSelectionModel().getSelectedItem());
    }
    @FXML
    private void pesquisaUsuarios(KeyEvent e) {
        String palavraChave = Pesquisar.getText();

        if (!palavraChave.isEmpty()) {
            listaPesquisa.clear();

            for (Usuario l : listaUsuarios) {
                if ((l.getNome().contains(palavraChave) || l.getRg().contains(palavraChave) || l.getTelefone().contains(palavraChave) ||
                        l.getEndereco().contains(palavraChave)) && !listaPesquisa.contains(l))
                    listaPesquisa.add(l);
            }

            if (!listaPesquisa.isEmpty()) {
                TableUsuarios.setItems(listaPesquisa);
            }
        } else if (palavraChave.length() == 0 ) {
            TableUsuarios.setItems(listaUsuarios);

        }
    }
}