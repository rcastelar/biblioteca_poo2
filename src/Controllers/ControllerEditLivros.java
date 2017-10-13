package Controllers;

import biblioteca.Exemplar;
import biblioteca.Exemplar_DAO;
import biblioteca.Livro;
import biblioteca.Livro_DAO;
import javafx.fxml.*;
import javafx.scene.control.TextField;
import javax.print.DocFlavor;
import java.sql.SQLException;
import java.util.*;

public abstract class ControllerEditLivros implements Initializable {

    public List<Exemplar> LstExemp;
    public Livro LivroSelecionado;
    @FXML private TextField FieldLivro;

    public ControllerEditLivros(String IdLivro) throws SQLException, ClassNotFoundException {
        Exemplar_DAO exe = new Exemplar_DAO(IdLivro);
        this.LstExemp = exe.GetAllExemplar();

        Livro_DAO lv = new Livro_DAO(IdLivro);
        this.LivroSelecionado = lv.GetLivro();
    }

    public void initialize(DocFlavor.URL url, ResourceBundle rb) {
        FieldLivro.setText("This is my first Text");
    }
}
