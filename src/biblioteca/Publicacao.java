package biblioteca;

/**
 * @author f32cpd02
 */
public class Publicacao {
    protected int id;
    protected String titulo;
    protected String posicao;
    protected String genero;
    protected String editora;

    public Publicacao(int bid, String btitulo, String bposicao, String bgenero, String beditora) {
        this.id = bid;
        this.titulo = btitulo;
        this.posicao = bposicao;
        this.genero = bgenero;
        this.editora = beditora;
    }

    public Publicacao() {
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int bid) {
        this.id = bid;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String btitulo) {
        this.titulo = btitulo;
    }


    public Publicacao get() {
        return this;
    }
}