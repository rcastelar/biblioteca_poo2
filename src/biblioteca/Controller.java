package biblioteca;

public class Controller {
    private static Controller instance;
    private Livro selectedBook;
    private Exemplar selectedExemplar;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Livro getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(Livro gid) {
        selectedBook = gid;
    }

    public Exemplar getSelectedExemplar() {
        return selectedExemplar;
    }

    public void setSelectedExemplar(Exemplar gid) {
        selectedExemplar = gid;
    }

}
