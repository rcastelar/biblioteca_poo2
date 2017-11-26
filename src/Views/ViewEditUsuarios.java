package Views;

import Controllers.Controller_Usuario;
import biblioteca.Emprestimo;
import biblioteca.Usuario;
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
    @FXML
    private TableView<Emprestimo> TableExemplares;
    @FXML
    private TableColumn<Object, Object> ExemplId;
    @FXML
    private TableColumn<Object, Object> DatalimiteId;
    @FXML
    private TableColumn nomeLivro;

    private final Controller_Usuario mainControllerUsuario = Controller_Usuario.getInstance();
    private final Usuario selectedUsuario = (Usuario) mainControllerUsuario.getSelectedUsuario();


    // metodos
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FieldNome.setText(selectedUsuario.getNome());
        FieldTelefone.setText(selectedUsuario.getTelefone());
        FieldRG.setText(selectedUsuario.getRg());
        FieldEndereco.setText(selectedUsuario.getEndereco());
        updateExempTable();
    }

    private void updateExempTable() {
        ObservableList<Emprestimo> listaExemplares = selectedUsuario.getListaEmprestimo();
        ExemplId.setCellValueFactory(new PropertyValueFactory<>("codigo_exemplar"));
        nomeLivro.setCellValueFactory(new PropertyValueFactory("titulo"));
        DatalimiteId.setCellValueFactory(new PropertyValueFactory<>("dataemprestimo"));
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
                Usuario myuser = new Usuario(mainControllerUsuario.getListaUsuarios().size() + 1, FieldNome.getText(), FieldEndereco.getText(), FieldRG.getText(), FieldTelefone.getText());
                mainControllerUsuario.editUsuario(myuser);
            } else {
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
        if (result == 0) {
            new ViewAlert("Exemplar nao cadastrado!");
        } else if (result == 2) {
            new ViewAlert("Efetue a devolucao do exemplar antes de emprestalo novamente.");
        } else {
            updateExempTable();
            new ViewAlert("Exemplar adicionado");
        }
    }

    @FXML
    private void removeSelectedEmprestimo() {
        if (!TableExemplares.getSelectionModel().isEmpty()) {
            new ViewAlert();
            mainControllerUsuario.removeEmprestimo(TableExemplares.getSelectionModel().getSelectedItem());
            updateExempTable();
            new ViewAlert("Exemplar devolvido");
        } else {
            new ViewAlert("Nenhum exemplar selecionado");
        }
    }
}
