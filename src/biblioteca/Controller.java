package biblioteca;

public class Controller {
    private static Controller instance;
    private Publicacao selectedPub;
    private Exemplar selectedExemplar;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Publicacao getSelectedBook() {
        return selectedPub;
    }

    public void setSelectedBook(Livro gid) {
        selectedPub = gid;
    }

    public Exemplar getSelectedExemplar() {
        return selectedExemplar;
    }

    public void setSelectedExemplar(Exemplar gid) {
        selectedExemplar = gid;
    }

}
