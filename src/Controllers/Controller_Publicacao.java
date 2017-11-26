package Controllers;

import biblioteca.Exemplar;
import biblioteca.Livro;
import biblioteca.Livro_DAO;
import biblioteca.Publicacao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller_Publicacao {
    private static Controller_Publicacao instancepu;
    private static ObservableList<Livro> listaLivros = FXCollections.observableArrayList();
    private Publicacao selectedPub;

    private Controller_Publicacao() {
        Livro_DAO myLivroDao = new Livro_DAO();
        listaLivros = myLivroDao.getAllLivro();
    }

    public static Controller_Publicacao getInstance() {
        if (instancepu == null) {
            instancepu = new Controller_Publicacao();
        }
        return instancepu;
    }

    public ObservableList<Livro> getListaLivros() {
        return listaLivros;
    }

    public Publicacao getSelectedPublicacao() {
        return selectedPub;
    }

    public void setSelectedPublicacao(Publicacao gid) {
        selectedPub = gid;
    }

    public void addLivro(Livro myLivro) {
        Livro_DAO myLivroDao = new Livro_DAO();
        listaLivros.add(myLivro);
        myLivroDao.InsertLivro(listaLivros);
    }

    public void editLivro(Livro myLivro) {
        Livro_DAO myLivroDao = new Livro_DAO();
        ((Livro) selectedPub).setAutor(myLivro.getAutor());
        selectedPub.setEditora(myLivro.getEditora());
        selectedPub.setGenero(myLivro.getGenero());
        selectedPub.setPosicao(myLivro.getPosicao());
        selectedPub.setTitulo(myLivro.getTitulo());
        myLivroDao.InsertLivro(listaLivros);
    }

    public void addExemplar(Exemplar myExemplar) {
        Livro_DAO myLivroDao = new Livro_DAO();
        String cod = selectedPub.getId() + ";" + myExemplar.getCodigo_exemplar();
        myExemplar.setCodigo_exemplar(cod);
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

