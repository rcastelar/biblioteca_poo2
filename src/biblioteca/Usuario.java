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
    private String rua;
    private String numero_moradia;
    private int cep;
    private int telefone;
    private String cidade;
    private String estado;
    private Livro[] livros_emprestados;

    public Usuario(int bid, int brg, String bnome, String brua, String bnumero_moradia, int bcep, int btelefone, String bcidade, String bestado, Livro[] blivros_emprestados) {
        this.id = bid;
        this.rg = brg;
        this.nome = bnome;
        this.rua = brua;
        this.numero_moradia = bnumero_moradia;
        this.cep = bcep;
        this.telefone = btelefone;
        this.cidade = bcidade;
        this.estado = bestado;
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
        return this.rua;
    }

    public String getNumero_moradia() {
        return this.numero_moradia;
    }

    public int getCep() {
        return this.cep;
    }

    public int getTelefone() {
        return this.telefone;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getEstado() {
        return this.estado;
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
        this.rua = brua;
    }

    public void setNumero_moradia(String bnumero_moradia) {
        this.numero_moradia = bnumero_moradia;
    }

    public void setCep(int bcep) {
        this.cep = bcep;
    }

    public void setTelefone(int btelefone) {
        this.telefone = btelefone;
    }

    public void getCidade(String bcidade) {
        this.cidade = bcidade;
    }

    public void getEstado(String bestado) {
        this.estado = bestado;
    }

    public void setLivro(Livro[] blivro) {
        this.livros_emprestados = blivro;
    }
}
