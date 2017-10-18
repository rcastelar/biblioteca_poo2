package Views;

import biblioteca.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;

import java.sql.SQLException;
import java.text.FieldPosition;
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
    @FXML  private TableView TableLivros;
    @FXML private TableColumn TituloId;
    @FXML private TableColumn AutorId;
    @FXML private TableColumn GeneroId;
    @FXML private TableColumn PosicaoId;
    @FXML private TableColumn LivroId;
    @FXML private TableColumn EditoraId;
    private Controller mainController = Controller.getInstance();
    private Livro selectedlivro = mainController.getSelectedBook();
    ObservableList<Exemplar> listaExemplares = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        FieldTitulo.setText(selectedlivro.getTitulo());
        FieldAutor.setText(selectedlivro.getAutor());
        FieldGenero.setText(selectedlivro.getGenero());
        FieldEditora.setText(selectedlivro.getEditora());
        FieldLocation.setText(selectedlivro.getPosicao());

        Exemplar_DAO myexempl = new Exemplar_DAO();
        try {
            listaExemplares = myexempl.GetAllExemplar();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
     //   LivroId.setCellValueFactory(new PropertyValueFactory<>("Id"));
     //   TituloId.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
     //   AutorId.setCellValueFactory(new PropertyValueFactory<>("Autor"));
     //   GeneroId.setCellValueFactory(new PropertyValueFactory<>("Genero"));
     //   PosicaoId.setCellValueFactory(new PropertyValueFactory<>("Posicao"));
     //   EditoraId.setCellValueFactory(new PropertyValueFactory<>("Posicao"));
     //   TableLivros.setItems(listaLivros);

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
}

