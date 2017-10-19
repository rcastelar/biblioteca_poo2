package Views;

import biblioteca.*;
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

import java.net.URL;
import java.sql.SQLException;
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
    private Controller mainController = Controller.getInstance();
    private Livro selectedlivro = (Livro) mainController.getSelectedBook();
    private ObservableList<Exemplar> listaExemplares = FXCollections.observableArrayList();

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
        Exemplar_DAO myexempl = new Exemplar_DAO();
        try {
            listaExemplares = myexempl.GetAllExemplar(selectedlivro.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
            FieldTitulo.setDisable(true);
            FieldAutor.setDisable(true);
            FieldGenero.setDisable(true);
            FieldEditora.setDisable(true);
            FieldLocation.setDisable(true);
            BtnEditBook.setText("Editar livro");
            Livro livroAtualizado = new Livro (selectedlivro.getId(), FieldTitulo.getText(), FieldLocation.getText(), FieldAutor.getText(),
                    FieldGenero.getText(), FieldEditora.getText());
            Livro_DAO bookController = new Livro_DAO();
            bookController.UpdateLivro(livroAtualizado);

        }
    }
    @FXML
    private void newExemplar(ActionEvent event){

        ViewAlert alertGet =new ViewAlert();
        String exempCod = alertGet.getUmDado("Codigo do exemplar:");
        bdControl.InsertExemplar(exempCod, selectedlivro.getId(), "Disponível");
        updateExempTable();
        ViewAlert showAlert= new ViewAlert("Exemplar adicionado");
    }
    @FXML
    private void removeSelectedExemplar(){
        if (!TableExemplares.getSelectionModel().isEmpty()) {
            bdControl.DeleteExemplar((Exemplar) TableExemplares.getSelectionModel().getSelectedItem());
            updateExempTable();
            ViewAlert ok = new ViewAlert("Exemplar excluido");
        }
        else{
           ViewAlert erro = new ViewAlert("Nenhum exemplar selecionado");
        }
    }
}

