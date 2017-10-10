/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 * @author f32cpd02
 */
public class Subdivisao {
    private int id;
    private int local_id;
    private String descricao;

    public Subdivisao(int bid, int blocal_id, String bdescricao) {
        this.id = bid;
        this.local_id = blocal_id;
        this.descricao = bdescricao;
    }

    public Subdivisao() {
    }

    public int getId() {
        return this.id;
    }

    public int getLocal_id() {
        return this.local_id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setId(int bid) {
        this.id = bid;
    }

    public void setLocal_id(int blocal_id) {
        this.local_id = blocal_id;
    }

    public void setDescricao(String bdescricao) {
        this.descricao = bdescricao;
    }
}
