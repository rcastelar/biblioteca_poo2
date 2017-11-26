package biblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Emprestimo implements Serializable{
    private String Dataemprestimo;
    private Exemplar myexemplar;
    private Livro mybook;

    public Emprestimo(Exemplar gexemplar, Livro glivro, String gdate){
        this.setMybook(glivro);
        this.setDataemprestimo(gdate);
        this.setMyexemplar(gexemplar);
    }

    public Exemplar getMyexemplar() {
        return myexemplar;
    }

    public Livro getMybook() {
        return mybook;
    }

    public String getTitulo(){
        return this.mybook.getTitulo();
    }

 public String getcodigo_exemplar(){
        return this.myexemplar.getCodigo_exemplar();
 }

    public String getDataemprestimo() {
        return Dataemprestimo;
    }

    public void setDataemprestimo(String dataemprestimo) {
        Dataemprestimo = dataemprestimo;
    }

    public void setMybook(Livro mybook) {
        this.mybook = mybook;
    }

    public void setMyexemplar(Exemplar myexemplar) {
        this.myexemplar = myexemplar;
    }
}
