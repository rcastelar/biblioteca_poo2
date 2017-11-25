/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 * @author f32cpd02
 */
public class Usuario {
    private int id;
    private int rg;
    private String nome;
    private String endereco;

    private int telefone;

    private Livro[] livros_emprestados;

    public Usuario(int bid, int brg, String bnome, String brua, String bnumero_moradia, int bcep, int btelefone, String bcidade, String bestado, Livro[] blivros_emprestados) {
        this.id = bid;
        this.rg = brg;
        this.nome = bnome;
        this.endereco = brua;
        this.telefone = btelefone;
        this.livros_emprestados = blivros_emprestados;
    }

    public Usuario() {
    }

    public int getId() {
        return this.id;
    }

    public int getRg() {
        return this.rg;
    }

    public String getNome() {
        return this.nome;
    }

    public String getRua() {
        return this.endereco;
    }

    public int getTelefone() {
        return this.telefone;
    }

    public Livro[] getLivro() {
        return this.livros_emprestados;
    }

    public void setId(int bid) {
        this.id = bid;
    }

    public void setRg(int brg) {
        this.rg = brg;
    }

    public void setNome(String bnome) {
        this.nome = bnome;
    }

    public void setRua(String brua) {
        this.endereco = brua;
    }


    public void setTelefone(int btelefone) {
        this.telefone = btelefone;
    }



    public void setLivro(Livro[] blivro) {
        this.livros_emprestados = blivro;
    }
}
