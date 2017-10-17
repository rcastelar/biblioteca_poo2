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






    public Livro_DAO(){
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

    public Livro GetLivro(int idLivro) throws SQLException, ClassNotFoundException {

        DBHandler Livros = new DBHandler();
        ResultSet rs = Livros.querry("SELECT * FROM livro WHERE id="+idLivro);
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

    public void InsertLivro(String titulo, String autor, String posicao, String genero, String editora){
        try {
            DBHandler Livros = new DBHandler();
            Livros.execute("INSERT INTO livro(titulo,posicao,autor,genero,editora) VALUES ('"
                    +titulo+"','"+autor+"','"+posicao+"','"+genero+"','"+editora+"')");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void DeleteLivro(Livro Lv){
        try{
            DBHandler Livros = new DBHandler();
            Livros.querry("DELETE FROM livro WHERE id='"+Lv.getId()+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void UpdateLivro(Livro Lv){
        try{
            DBHandler Livros = new DBHandler();
            Livros.querry("UPDATE livro SET titulo='"+Lv.getTitulo()+"',posicao'"+Lv.getPosicao()+
                    "',autor='"+Lv.getAutor()+"',genero='"+Lv.getGenero()+"',editora='"+Lv.getEditora()+"' WHERE id='"+Lv.getId()+"'");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

