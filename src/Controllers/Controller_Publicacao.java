package Controllers;

import biblioteca.Exemplar;
import biblioteca.Livro;
import biblioteca.Livro_DAO;
import biblioteca.Publicacao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller_Publicacao {
    private static Controller_Publicacao instance;
    private Publicacao selectedPub;
    private Exemplar selectedExemplar;
    private static int qdePublicacao;
    private static ObservableList<Livro> listaLivros = FXCollections.observableArrayList();

    private Controller_Publicacao() {
        Livro_DAO myLivroDao = new Livro_DAO();
        listaLivros = myLivroDao.getAllLivro();
    }

    public static Controller_Publicacao getInstance() {
        if (instance == null) {
            instance = new Controller_Publicacao();
        }
        return instance;
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

    public void editLivro(Livro myLivro) {
        Livro_DAO myLivroDao = new Livro_DAO();
        for (Livro neededBook : listaLivros) {
            if (selectedPub.getId() == neededBook.get().getId()) {
                neededBook.setAutor(myLivro.getAutor());
                neededBook.setEditora(myLivro.getEditora());
                neededBook.setGenero(myLivro.getGenero());
                neededBook.setPosicao(myLivro.getPosicao());
                neededBook.setTitulo(myLivro.getTitulo());
                break;
            }
        }
        myLivroDao.InsertLivro(listaLivros);
    }

    public void addExemplar(Exemplar myExemplar) {
        Livro_DAO myLivroDao = new Livro_DAO();
        for (Livro neededBook : listaLivros) {
            if (selectedPub.getId() == neededBook.get().getId()) {
                neededBook.addToListaExempar(myExemplar);
                break;
            }
        }
        myLivroDao.InsertLivro(listaLivros);
    }

    public void removeExemplar(Exemplar myExemplar) {
        Livro_DAO myLivroDao = new Livro_DAO();
        selectedPub.removeExemplar(myExemplar);
    }
}

