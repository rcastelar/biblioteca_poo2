package Views;

import Controllers.Controller_Publicacao;
import biblioteca.Exemplar;
import biblioteca.Exemplar_DAO;
import biblioteca.Livro;
import biblioteca.Livro_DAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewEditLivros implements Initializable, ControlledScreen {
    @FXML
    private TextField FieldTitulo;
    @FXML
    private TextField FieldAutor;
    @FXML
    private TextField FieldGenero;
    @FXML
    private TextField FieldEditora;
    @FXML
    private TextField FieldLocation;
    @FXML
    private Button BtnEditBook;
    private Screens_controller myController;
    @FXML  private TableView TableExemplares;
    @FXML private TableColumn ExemplId;
    @FXML private TableColumn Cod_Exemplar;
    @FXML private TableColumn StatusId;
    @FXML private TableColumn LivroId;
    @FXML private Button BtnRemoveExemplar;
    private Exemplar_DAO bdControl = new Exemplar_DAO();
    private Controller_Publicacao mainControllerPublicacao = Controller_Publicacao.getInstance();
    private Livro selectedlivro = (Livro) mainControllerPublicacao.getSelectedPublicacao();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FieldTitulo.setText(selectedlivro.getTitulo());
        FieldAutor.setText(selectedlivro.getAutor());
        FieldGenero.setText(selectedlivro.getGenero());
        FieldEditora.setText(selectedlivro.getEditora());
        FieldLocation.setText(selectedlivro.getPosicao());
        updateExempTable();
    }

        private void updateExempTable(){
            //   Exemplar_DAO myexempl = new Exemplar_DAO();
            ObservableList<Exemplar> listaExemplares = selectedlivro.getListaExemplar();
            LivroId.setCellValueFactory(new PropertyValueFactory<>("id_livro"));
        ExemplId.setCellValueFactory(new PropertyValueFactory<>("id"));
        Cod_Exemplar.setCellValueFactory(new PropertyValueFactory<>("codigo_exemplar"));
        StatusId.setCellValueFactory(new PropertyValueFactory<>("status"));
        TableExemplares.setItems(listaExemplares);
    }

    public void setScreenParent(Screens_controller screenParent) {
        myController = screenParent;
    }

    @FXML
    private void goToViewLivros(ActionEvent event) {
        myController.loadScreen("ViewLivros", "ViewLivros.fxml");
        myController.setScreen("ViewLivros");
        myController.unloadScreen("VewEditLivros");
    }

    @FXML
    private void editBook(ActionEvent event) {
        if (FieldTitulo.isDisabled()) {
            FieldTitulo.setDisable(false);
            FieldAutor.setDisable(false);
            FieldGenero.setDisable(false);
            FieldEditora.setDisable(false);
            FieldLocation.setDisable(false);
            BtnEditBook.setText("Salvar");

        } else {
            if(!FieldTitulo.getText().isEmpty()) {
                FieldTitulo.setDisable(true);
                FieldAutor.setDisable(true);
                FieldGenero.setDisable(true);
                FieldEditora.setDisable(true);
                FieldLocation.setDisable(true);
                BtnEditBook.setText("Editar livro");
                Livro livroAtualizado = new Livro(selectedlivro.getId(), FieldTitulo.getText(), FieldLocation.getText(), FieldAutor.getText(),
                        FieldGenero.getText(), FieldEditora.getText());
                Livro_DAO bookController = new Livro_DAO();
                //bookController.UpdateLivro(livroAtualizado);
                ///
                Livro mybook = new Livro(mainControllerPublicacao.getListaLivros().size() + 1, FieldTitulo.getText(), FieldLocation.getText(), FieldAutor.getText(), FieldGenero.getText(), FieldEditora.getText());
                mainControllerPublicacao.editLivro(mybook);
                ///
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("iLibrary");
                alert.setHeaderText(null);
                alert.setContentText("Livro não pode ser salvo. Preencha o campo Título! ");
                alert.showAndWait();
                FieldTitulo.setStyle("-fx-border-style:solid; -fx-border-color: red; -fx-border-radius: 5px; -fx-effect: dropshadow(three-pass-box, red, 10, 0, 0, 0);");
            }
        }
    }
    @FXML
    private void newExemplar(ActionEvent event){

        ViewAlert alertGet =new ViewAlert();
        String exempCod = alertGet.getUmDado("Codigo do exemplar:");
        Exemplar myExemplar = new Exemplar(exempCod, selectedlivro.getId(), "Disponível");
        mainControllerPublicacao.addExemplar(myExemplar);
        updateExempTable();
        ViewAlert showAlert= new ViewAlert("Exemplar adicionado");

    }

    @FXML
    private void removeSelectedExemplar(){
        if (!TableExemplares.getSelectionModel().isEmpty()) {
            ViewAlert alertGet = new ViewAlert();
            mainControllerPublicacao.removeExemplar((Exemplar) TableExemplares.getSelectionModel().getSelectedItem());
            updateExempTable();
            ViewAlert showAlert = new ViewAlert("Exemplar removido");
        } else {
            ViewAlert erro = new ViewAlert("Nenhum exemplar selecionado");
        }
    }
}
