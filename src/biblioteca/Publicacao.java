package biblioteca;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author f32cpd02
 */
public abstract class Publicacao implements Serializable {
    private int id;
    private String titulo;
    private String posicao;
    private String genero;
    private String editora;
    private final ArrayList<Exemplar> listaExemplar = new ArrayList<>();

    Publicacao(int bid, String btitulo, String bposicao, String bgenero, String beditora) {
        this.id = bid;
        this.titulo = btitulo;
        this.posicao = bposicao;
        this.genero = bgenero;
        this.editora = beditora;
    }

    Publicacao() {
    }

    public ObservableList<Exemplar> getListaExemplar() {

        return FXCollections.observableList(listaExemplar);
    }

    public void removeExemplar(Exemplar myexemplar) {
        Livro_DAO myLivroDao = new Livro_DAO();
        for (Exemplar neededExemplar : listaExemplar) {
            if (myexemplar.getCodigo_exemplar() == neededExemplar.getCodigo_exemplar()) {
                listaExemplar.remove(neededExemplar);
                break;
            }
        }
    }

    public void addToListaExempar(Exemplar myExemplar) {
        listaExemplar.add(myExemplar);
    }


    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String btitulo) {
        this.titulo = btitulo;
    }

}