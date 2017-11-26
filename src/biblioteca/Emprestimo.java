package biblioteca;

import java.io.Serializable;

public class Emprestimo implements Serializable {
    private String dataemprestimo;
    private Exemplar myexemplar;
    private Livro mybook;

    public Emprestimo(Exemplar gexemplar, Livro glivro, String gdate) {
        this.setMybook(glivro);
        this.setDataemprestimo(gdate);
        this.setMyexemplar(gexemplar);
    }

    public Exemplar getMyexemplar() {
        return myexemplar;
    }

    private void setMyexemplar(Exemplar myexemplar) {
        this.myexemplar = myexemplar;
    }

    private void setMybook(Livro mybook) {
        this.mybook = mybook;
    }

    public String getCodigo_exemplar() {
        return this.myexemplar.getCodigo_exemplar();
    }

    public String getDataemprestimo(){
        return this.dataemprestimo;
    }

    public String getTitulo(){
        return this.mybook.getTitulo();
    }

    private void setDataemprestimo(String gdataemprestimo) {
        dataemprestimo = gdataemprestimo;
    }
}
