/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca;

import bd.DBHandler;

import java.sql.*;
import java.util.*;

/**
 * @author f32cpd02
 */
public class Livro_DAO {

    private String IdLivro;

    Livro_DAO(String IdLivro){
        this.IdLivro = IdLivro;
    }

    public List<Livro> GetAllLivro() throws SQLException, ClassNotFoundException {
        DBHandler Livros = new DBHandler();
        ResultSet rs = Livros.querry("SELECT * FROM livro");

        List<Livro> LstLivros = new LinkedList<>();
        try{
            while(rs.next()){
                Livro lv = new Livro(rs.getInt("id"),rs.getString("titulo"),rs.getString("posicao"),
                        rs.getString("autor"),rs.getString("genero"),rs.getString("editora"));
                LstLivros.add(lv);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return LstLivros;
    }

    public Livro GetLivro() throws SQLException, ClassNotFoundException {
        DBHandler Livros = new DBHandler();
        ResultSet rs = Livros.querry("SELECT * FROM livro WHERE id="+this.IdLivro);
        Livro LivroReturn = null;
        try{
             LivroReturn = new Livro(rs.getInt("id"),rs.getString("titulo"),rs.getString("posicao"),
                        rs.getString("autor"),rs.getString("genero"),rs.getString("editora"));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return LivroReturn;
    }
}

