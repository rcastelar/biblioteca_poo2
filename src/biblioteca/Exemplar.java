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
    private int livro_id;
    private int codigo_exemplar;
    private int status;

    Exemplar(int blivro_id, int bcodigo_exemplar, int bstatus) {
        this.livro_id = blivro_id;
        this.codigo_exemplar = bcodigo_exemplar;
        this.status = bstatus;
    }

    Exemplar() {
    }

    public int getLivro_id() {
        return this.livro_id;
    }

    public int getCodigo_exemplar() {
        return this.codigo_exemplar;
    }

    public int getStatus() {
        return this.status;
    }

    public void setLivro_id(int blivro_id) {
        this.livro_id = blivro_id;
    }

    public void setcodigo_exemplar(int bcodigo_exemplar) {
        this.codigo_exemplar = bcodigo_exemplar;
    }

    public void setStatus(int bstatus) {
        this.status = bstatus;
    }
}
