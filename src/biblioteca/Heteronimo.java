/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 * @author f32cpd02
 */
public class Heteronimo {
    private int id;
    private String nome;
    private int autor_id;

    public Heteronimo(int bid, int bautor_id, String bnome) {
        this.id = bid;
        this.autor_id = bautor_id;
        this.nome = bnome;
    }

    public Heteronimo() {
    }

    public int getId() {
        return this.id;
    }

    public int getAutor_id() {
        return this.autor_id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setId(int bid) {
        this.id = bid;
    }

    public void setAutor_id(int bautor_id) {
        this.autor_id = bautor_id;
    }

    public void setNome(String bnome) {
        this.nome = bnome;
    }
}
