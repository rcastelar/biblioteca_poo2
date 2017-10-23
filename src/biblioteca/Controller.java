package biblioteca;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {
    private static Controller instance;
    private Publicacao selectedPub;
    private Exemplar selectedExemplar;
    private static int qdePublicacao;
    private static ObservableList<Livro> listaLivros = FXCollections.observableArrayList();

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    private Controller() {
        Livro_DAO myLivroDao = new Livro_DAO();
        listaLivros = myLivroDao.getAllLivro();
    }

    public ObservableList getListaLivros() {
        return listaLivros;
    }

    public Publicacao getSelectedPublicacao() {
        return selectedPub;
    }

    public void setSelectedPublicacao(Publicacao gid) {
        selectedPub = gid;
    }

    public Exemplar getSelectedExemplar() {
        return selectedExemplar;
    }

    public void setSelectedExemplar(Exemplar gid) {
        selectedExemplar = gid;
    }

    public void addLivro(Livro myLivro) {
        Livro_DAO myLivroDao = new Livro_DAO();
        listaLivros.add(myLivro);
        myLivroDao.InsertLivro(listaLivros);
    }

    public void addExemplar(Exemplar myExemplar) {
        Livro_DAO myLivroDao = new Livro_DAO();
        for (Livro neededBook : listaLivros) {
            if (selectedPub.getId() == neededBook.get().getId()) {
                neededBook.addToListaExempar(myExemplar);
            }
        }
        myLivroDao.InsertLivro(listaLivros);
    }
}

