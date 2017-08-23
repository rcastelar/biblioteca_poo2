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
public class Livro {
    private int id;
    private String titulo;
    private int codigo;
    private int status;
    private int editora_id;
    private int sub_divisao_id;
    private int autor_id;
    public Livro(int bid, String btitulo, int bcodigo, int bstatus, int beditora_id, int bsub_divisao_id, int bautor_id){
        this.id=bid;
        this.titulo=btitulo;
        this.codigo= bcodigo;
        this.status= bstatus;
        this.editora_id=beditora_id;
        this.sub_divisao_id=bsub_divisao_id;
        this.autor_id=bautor_id;
    }
    public Livro(){
    }
    public int getId(){
        return this.id;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public int getCodigo(){
        return this.codigo;
    }
    public int getStatus(){
        return this.status;
    }
    public int getEditora_id(){
        return this.editora_id;
    }
    public int getSub_divisao_id(){
        return this.sub_divisao_id;
    }
    public int getautor_id(){
        return this.autor_id;
    }
    public void setId(int bid){
        this.id=bid;
    }
    public void setTitulo(String btitulo){
        this.titulo=btitulo;
    }
    public void setCodigo(int bcodigo){
        this.codigo=bcodigo;
    }
    public void setStatus(int bstatus){
        this.status=bstatus;
    }
    public void setEditora_id(int beditora_id){
        this.editora_id=beditora_id;
    }
    public void setSub_divisao_id(int bsub_divisao_id){
        this.sub_divisao_id=bsub_divisao_id;
    }
    public void setAutor_id(int bautor_id){
        this.autor_id=bautor_id;
    }
}
