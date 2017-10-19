/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 * @author f32cpd01
 */
public class Exemplar {
    private int id;
    private int livro_id;
    private int codigo_exemplar;
    private String status;

    Exemplar(int bid, int bcodigo_exemplar, int blivro_id, String bstatus) {
        this.id = bid;
        this.livro_id = blivro_id;
        this.codigo_exemplar = bcodigo_exemplar;
        this.status = bstatus;
    }

    Exemplar() {
    }

    public int getId() {
        return this.id;
    }
    public void setid(int b_id) {
        this.id = b_id;
    }

    public int getLivro_id() {
        return this.livro_id;
    }
    public void setLivro_id(int blivro_id) {
        this.livro_id = blivro_id;
    }

    public int getCodigo_exemplar() {
        return this.codigo_exemplar;
    }
    public void setcodigo_exemplar(int bcodigo_exemplar) {
        this.codigo_exemplar = bcodigo_exemplar;
    }

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String bstatus) {
        this.status = bstatus;
    }
}
