/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 * @author f32cpd02
 */
public class Livro {
    private int id;
    private String titulo;
    private String posicao;
    private String autor;
    private String genero;
    private String editora;

    public Livro(int bid, String btitulo, String bposicao, String bautor, String bgenero, String beditora) {
        this.id = bid;
        this.titulo = btitulo;
        this.posicao = bposicao;
        this.autor = bautor;
        this.genero = bgenero;
        this.editora = beditora;
    }

    public Livro() {
    }

    public String getPosicao() {
        return posicao;
    }
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
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
    public void setId(int bid) {
        this.id = bid;
    }

    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String btitulo) { this.titulo = btitulo; }
}
