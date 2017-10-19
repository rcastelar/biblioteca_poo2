/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 * @author f32cpd02
 */
public class Livro extends Publicacao {

    private String autor;

    public Livro(int bid, String btitulo, String bposicao, String bautor, String bgenero, String beditora) {
        super(bid, btitulo, bposicao, bgenero, beditora);
        this.autor = bautor;
    }

    public Livro() {
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Livro get() {
        return this;
    }
}