package Views;

import biblioteca.Controller;
import biblioteca.Livro;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;


import java.net.URL;

import java.util.ResourceBundle;

public class ViewEditLivros implements Initializable, ControlledScreen{
    @FXML  private TextField FieldTitulo;
    @FXML  private TextField FieldAutor;
    @FXML  private TextField FieldGenero;
    @FXML  private TextField FieldEditora;
    @FXML  private TextField FieldLocation;
    private Screens_controller myController;
    private Controller mainController = Controller.getInstance();

    @Override
        public void initialize(URL url, ResourceBundle rb) {
        Livro selectedlivro = mainController.getSelectedBook();
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
            myController.setScreen("ViewLivros");
            myController.unloadScreen("VewEditLivros");
        }
        @FXML
        private void editBook(ActionEvent event){
            System.out.println("teste");
        }
    }

