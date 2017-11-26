package Views;

import Controllers.Controller_Usuario;
import biblioteca.Exemplar;
import biblioteca.Exemplar_DAO;
import biblioteca.Usuario;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewEditUsuarios implements Initializable, ControlledScreen {

    //Botoes
    @FXML
    private Button BtnEditUser;
    @FXML
    private Button BtnAddExemplar;
    @FXML
    private Button BtnRemoveExemplar;

    //Colunas
    @FXML
    private TableColumn nome_livro;
    @FXML
    private TableColumn LivroId;

    //TextFields
    @FXML
    private TextField FieldNome;
    @FXML
    private TextField FieldTelefone;
    @FXML
    private TextField FieldRG;
    @FXML
    private TextField FieldEndereco;

    //tabela e colunas
    @FXML  private TableView TableExemplares;
    @FXML private TableColumn ExemplId;
    @FXML
    private TableColumn DatalimiteId;
    @FXML
    private TableColumn nomeLivro;

    //controlers e entidades
    private Screens_controller myController;
    private Exemplar_DAO bdControl = new Exemplar_DAO();
    private Controller_Usuario mainControllerUsuario = Controller_Usuario.getInstance();
    private Usuario selectedUsuario = (Usuario) mainControllerUsuario.getSelectedUsuario();


    // metodos
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FieldNome.setText(selectedUsuario.getNome());
        FieldTelefone.setText(selectedUsuario.getTelefone());
        FieldRG.setText(selectedUsuario.getRg());
        FieldEndereco.setText(selectedUsuario.getEndereco());
        updateExempTable();
    }

        private void updateExempTable(){
            //   Exemplar_DAO myexempl = new Exemplar_DAO();
            ObservableList<Exemplar> listaExemplares = selectedUsuario.getListaEmprestimo();
        ExemplId.setCellValueFactory(new PropertyValueFactory<>("id"));
            nomeLivro.setCellValueFactory(new PropertyValueFactory<>("codigo_exemplar"));
            DatalimiteId.setCellValueFactory(new PropertyValueFactory<>("status"));
        TableExemplares.setItems(listaExemplares);
    }

    public void setScreenParent(Screens_controller screenParent) {
        myController = screenParent;
    }

    @FXML
    private void goToViewUsuarios(ActionEvent event) {
        myController.loadScreen("ViewUsuarios", "ViewUsuarios.fxml");
        myController.setScreen("ViewUsuarios");
        myController.unloadScreen("VewEditUsuarios");
    }
    @FXML
    private void goToViewLivros(ActionEvent event) {
        myController.loadScreen("ViewLivros", "ViewLivros.fxml");
        myController.setScreen("ViewLivros");
        myController.unloadScreen("VewEditUsuarios");
    }
    @FXML
    private void editUser(ActionEvent event) {
        if (FieldNome.isDisabled()) {
            FieldNome.setDisable(false);
            FieldTelefone.setDisable(false);
            FieldRG.setDisable(false);
            FieldEndereco.setDisable(false);
            BtnEditUser.setText("Salvar");

        } else {
            if (!FieldNome.getText().isEmpty()) {
                FieldNome.setDisable(true);
                FieldTelefone.setDisable(true);
                FieldRG.setDisable(true);
                FieldEndereco.setDisable(true);
                BtnEditUser.setText("Editar Usuario");
                Usuario UsuarioAtualizado = new Usuario(selectedUsuario.getId(), FieldNome.getText(), FieldEndereco.getText(),
                        FieldRG.getText(), FieldTelefone.getText());
                Usuario myuser = new Usuario(mainControllerUsuario.getListaUsuarios().size() + 1, FieldNome.getText(), FieldEndereco.getText(), FieldRG.getText(), FieldTelefone.getText());
                mainControllerUsuario.editUsuario(myuser);
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("iLibrary");
                alert.setHeaderText(null);
                alert.setContentText("Usuario não pode ser salvo. Preencha o campo Título! ");
                alert.showAndWait();
                FieldNome.setStyle("-fx-border-style:solid; -fx-border-color: red; -fx-border-radius: 5px; -fx-effect: dropshadow(three-pass-box, red, 10, 0, 0, 0);");
            }
        }
    }
    @FXML
    private void newEmprestimo(ActionEvent event) {

        ViewAlert alertGet =new ViewAlert();
        String exempCod = alertGet.getUmDado("Codigo do exemplar:");
        Exemplar myExemplar = new Exemplar(exempCod, selectedUsuario.getId(), "Disponível");
        mainControllerUsuario.addEmprestimo(myExemplar);
        updateExempTable();
        ViewAlert showAlert= new ViewAlert("Exemplar adicionado");

    }

    @FXML
    private void removeSelectedEmprestimo() {
        if (!TableExemplares.getSelectionModel().isEmpty()) {
            ViewAlert alertGet = new ViewAlert();
            mainControllerUsuario.removeEmprestimo((Exemplar) TableExemplares.getSelectionModel().getSelectedItem());
            updateExempTable();
            ViewAlert showAlert = new ViewAlert("Exemplar removido");
        } else {
            ViewAlert erro = new ViewAlert("Nenhum exemplar selecionado");
        }
    }
}
