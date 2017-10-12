package Controllers;

import biblioteca.Exemplar;
import biblioteca.Exemplar_DAO;
import biblioteca.Livro;
import biblioteca.Livro_DAO;

import java.sql.SQLException;
import java.util.List;

public class ControllerEditLivros {

    public List<Exemplar> LstExemp;
    public Livro LivroSelecionado;

    public ControllerEditLivros(String IdLivro) throws SQLException, ClassNotFoundException {
        Exemplar_DAO exe = new Exemplar_DAO(IdLivro);
        this.LstExemp = exe.GetAllExemplar();

        Livro_DAO lv = new Livro_DAO(IdLivro);
        this.LivroSelecionado = lv.GetLivro();
    }
}
