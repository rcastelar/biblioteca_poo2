/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author f32cpd02
 */
public class Usuario implements Serializable {
    private int id;
    private String rg;
    private String nome;
    private String endereco;
    private ArrayList<Emprestimo> listaEmprestimo = new ArrayList<>();
    private String telefone;


    public Usuario(int bid, String bnome, String brua, String brg, String btelefone) {
        this.id = bid;
        this.rg = brg;
        this.nome = bnome;
        this.endereco = brua;
        this.telefone = btelefone;
    }

    public Usuario() {
    }

    public ObservableList<Emprestimo> getListaEmprestimo() {

        return FXCollections.observableList(listaEmprestimo);
    }

    public void removeEmprestimo(Emprestimo myexemplar) {
        Livro_DAO myLivroDao = new Livro_DAO();
        for (Emprestimo neededExemplar : listaEmprestimo) {
            if (myexemplar.getMyexemplar().getCodigo_exemplar() == neededExemplar.getMyexemplar().getCodigo_exemplar()) {
                listaEmprestimo.remove(neededExemplar);
                break;
            }
        }
    }

    public void addToListaEmprestimo(Emprestimo myExemplar) {
        listaEmprestimo.add(myExemplar);
    }


    public int getId() {
        return this.id;
    }

    public String getRg() {
        return this.rg;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setRg(String brg) {
        this.rg = brg;
    }



    public void setId(int bid) {
        this.id = bid;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setNome(String bnome) {
        this.nome = bnome;
    }

    public void setEndereco(String brua) {
        this.endereco = brua;
    }

    public void setTelefone(String btelefone) {
        this.telefone = btelefone;
    }

    public Usuario get() {
        return this;
    }
}

