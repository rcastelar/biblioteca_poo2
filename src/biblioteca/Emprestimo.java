package biblioteca;

public class Emprestimo {
    String dataDevolucao;
    Exemplar myExemplar;
    Livro myLivro;

    public Exemplar getMyExemplar() {
        return myExemplar;
    }

    public void setMyExemplar(Exemplar myExemplar) {
        this.myExemplar = myExemplar;
    }

    public Livro getMyLivro() {
        return myLivro;
    }

    public void setMyLivro(Livro myLivro) {
        this.myLivro = myLivro;
    }
}
