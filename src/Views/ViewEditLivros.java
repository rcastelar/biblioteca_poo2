package Views;

import biblioteca.Controller;
import biblioteca.Livro;
import biblioteca.Livro_DAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.net.URL;

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
    private Controller mainController = Controller.getInstance();
    private Livro selectedlivro = mainController.getSelectedBook();
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        FieldTitulo.setText(selectedlivro.getTitulo());
        FieldAutor.setText(selectedlivro.getAutor());
        FieldGenero.setText(selectedlivro.getGenero());
        FieldEditora.setText(selectedlivro.getEditora());
        FieldLocation.setText(selectedlivro.getPosicao());

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

