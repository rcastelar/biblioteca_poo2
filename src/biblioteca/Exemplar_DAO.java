/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import bd.DBHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author f32cpd01
 */
public class Exemplar_DAO {

    private String IdLivro;
    public Exemplar_DAO(){
    }

    public ObservableList<Exemplar> GetAllExemplar(int idLivro) throws SQLException, ClassNotFoundException {
        DBHandler Exemplares = new DBHandler();
        ResultSet rs = Exemplares.querry("SELECT * FROM exemplar WHERE id_livro = "+idLivro);

        ObservableList<Exemplar> LstExemp = FXCollections.observableArrayList();
        try {
            while (rs.next()) {
                Exemplar ex = new Exemplar(rs.getInt("id"), rs.getString("cod_exemplar"), rs.getInt("id_livro"), rs.getString("status"));
                LstExemp.add(ex);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return LstExemp;
    }

    public List<Exemplar> GetExemplarCampos(List<String> campo, List<String> valor) throws SQLException, ClassNotFoundException {
        DBHandler Exemplares = new DBHandler();
        List<Exemplar> LstExemp = new LinkedList();
        try {
            if (!campo.isEmpty() && !valor.isEmpty()) {
                String mysql = new String();
                mysql = "SELECT * FROM exemplar WHERE id='"+this.IdLivro+"'";

                for (int i = 0; i < campo.size(); i++)
                        mysql.concat(" AND " + campo.get(i) + "='" + valor.get(i) + "'");

                ResultSet rs = Exemplares.querry(mysql);

                while (rs.next()) {
                    Exemplar ex = new Exemplar(rs.getInt("id"), rs.getString("cod_exemplar"), rs.getInt("id_livro"), rs.getString("status"));
                    LstExemp.add(ex);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return LstExemp;
    }

    public List<Exemplar> GetExemplarInList(String campo, List<String> valor) throws SQLException, ClassNotFoundException {
        DBHandler Exemplares = new DBHandler();
        List<Exemplar> LstExemp = new LinkedList();
        try {
            if (!valor.isEmpty()) {
                //Precisamos testar para ver se será possivel fazer essa in: valor
                ResultSet rs = Exemplares.querry("SELECT * FROM exemplar WHERE id='"+this.IdLivro+"' AND " + campo + "in:valor");

                while (rs.next()) {
                    Exemplar ex = new Exemplar(rs.getInt("id"), rs.getString("cod_exemplar"),rs.getInt("id_livro") , rs.getString("status"));
                    LstExemp.add(ex);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return LstExemp;
    }

    public void InsertExemplar (String cod_exemplar, int id_livro, String status){
        try{
            DBHandler Exemplares = new DBHandler();
            Exemplares.execute("INSERT INTO exemplar(cod_exemplar, id_livro, status) VALUES ('"+cod_exemplar+"', "+id_livro+", '"+status+"');");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void DeleteExemplar(Exemplar Ex){
        try {
            DBHandler Exemplares = new DBHandler();
            Exemplares.execute("DELETE FROM exemplar WHERE id ='" + Ex.getId() + "'");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void UpdateExemplar(Exemplar Ex){
        try{
            DBHandler Exemplares = new DBHandler();
            Exemplares.querry("UPDATE exemplar SET id_livro='"+Ex.getLivro_id()+"',status='"+Ex.getStatus()+"' WHERE id_exemplar='"+Ex.getId()+"'");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
