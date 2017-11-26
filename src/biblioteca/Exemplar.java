/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.Serializable;

/**
 * @author f32cpd01
 */
public class Exemplar implements Serializable {
    private int livro_id;
    private String codigo_exemplar;
    private String status;

    public Exemplar(String bcodigo_exemplar, int blivro_id, String bstatus) {
        this.livro_id = blivro_id;
        this.codigo_exemplar = bcodigo_exemplar;
        this.status = bstatus;
    }

    public Exemplar() {
    }



    public int getLivro_id() {
        return this.livro_id;
    }
    public void setLivro_id(int blivro_id) {
        this.livro_id = blivro_id;
    }

    public String getCodigo_exemplar() {
        return this.codigo_exemplar;
    }
    public void setcodigo_exemplar(String bcodigo_exemplar) {
        this.codigo_exemplar = bcodigo_exemplar;
    }

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String bstatus) {
        this.status = bstatus;
    }
}
