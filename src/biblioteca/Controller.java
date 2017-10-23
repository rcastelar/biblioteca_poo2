package biblioteca;

//import bd.DBHandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {
    private static Controller instance;
    private Publicacao selectedPub;
    private Exemplar selectedExemplar;
    //  private DBHandler myDB = DBHandler.getInstance();
    private static ObservableList<Object> listaLivros = FXCollections.observableArrayList();

    private static int livrosQde;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    private Controller() {
        //  DBHandler myDb = DBHandler.getInstance();
        //  listaLivros = myDb.querry("./src/bd/livros/arquivolivros.txt");
    }

    public int getLivrosQde() {
        return livrosQde;
    }

    public void setLivrosQde(int myqde) {
        livrosQde = myqde;
    }
    public Publicacao getSelectedBook() {
        return selectedPub;
    }

    public void setSelectedBook(Livro gid) {
        selectedPub = gid;
    }

    public Exemplar getSelectedExemplar() {
        return selectedExemplar;
    }

    public void setSelectedExemplar(Exemplar gid) {
        selectedExemplar = gid;
    }

    public void addLivro(Livro myLivro) {
        listaLivros.add(myLivro);
    }

}

