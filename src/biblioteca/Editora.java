/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author f32cpd02
 */
public class Editora {
      private int id;
    private String nome;
    public Editora(int bid, String bnome){
        this.id=bid;
        this.nome=bnome;
}
    public int getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public void setId(int bid){
        this.id=bid;
    }
    public void setNome(String bnome){
        this.nome=bnome;
    }
}
