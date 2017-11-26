package Views;

import Controllers.Controller_Usuario;
import biblioteca.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewEditUsuarios extends MasterView implements Initializable, ControlledScreen {

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
            ObservableList<Emprestimo> listaExemplares = selectedUsuario.getListaEmprestimo();
        ExemplId.setCellValueFactory(new PropertyValueFactory<>("codigo_exemplar"));
            nomeLivro.setCellValueFactory(new PropertyValueFactory("titulo"));
            DatalimiteId.setCellValueFactory(new PropertyValueFactory<>("Dataemprestimo"));
        TableExemplares.setItems(listaExemplares);
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
                alert.setContentText("Usuário não pode ser salvo. Preencha o campo Nome! ");
                alert.showAndWait();
                FieldNome.setStyle("-fx-border-style:solid; -fx-border-color: red; -fx-border-radius: 5px; -fx-effect: dropshadow(three-pass-box, red, 10, 0, 0, 0);");
            }
        }
    }
    @FXML
    private void newEmprestimo(ActionEvent event) {
        ViewAlert alertGet = new ViewAlert();
        String exempCod = alertGet.getUmDado("Codigo do exemplar:");
        int result = mainControllerUsuario.addEmprestimo(exempCod);
        if (result == 0)
        updateExempTable();
        ViewAlert showAlert= new ViewAlert("Exemplar adicionado");

    }

    @FXML
    private void removeSelectedEmprestimo() {
        if (!TableExemplares.getSelectionModel().isEmpty()) {
            ViewAlert alertGet = new ViewAlert();
            mainControllerUsuario.removeEmprestimo((Emprestimo) TableExemplares.getSelectionModel().getSelectedItem());
            updateExempTable();
            ViewAlert showAlert = new ViewAlert("Exemplar removido");
        } else {
            ViewAlert erro = new ViewAlert("Nenhum exemplar selecionado");
        }
    }
}
