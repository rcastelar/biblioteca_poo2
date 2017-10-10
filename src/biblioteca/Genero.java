/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 * @author f32cpd02
 */
public class Genero {
    private int id;
    private String nome;
    private String descricao;

    public Genero(int bid, String bnome, String bdescricao) {
        this.id = bid;
        this.nome = bnome;
        this.descricao = bdescricao;
    }

    public Genero() {
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setId(int bid) {
        this.id = bid;
    }

    public void setNome(String bnome) {
        this.nome = bnome;
    }

    public void setDescricao(String bdescricao) {
        this.descricao = bdescricao;
    }
}
