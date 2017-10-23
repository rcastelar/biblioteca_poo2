/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**package biblioteca;

 //import bd.DBHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

 import java.io.EOFException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author f32cpd01

public class Exemplar_DAO {

    private String IdLivro;
    public Exemplar_DAO(){
    }

public ObservableList<Exemplar> GetAllExemplar(int idLivro) throws EOFException {
//DBHandler Exemplares = DBHandler.getInstance();
ResultSet rs = (ResultSet) Exemplares.querry("arquivoLivros.txt");
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





    public void InsertExemplar (String cod_exemplar, int id_livro, String status){
DBHandler Exemplares = DBHandler.getInstance();
Exemplares.insert("src/bd//arquivoLivros.txt","INSERT INTO exemplar(cod_exemplar, id_livro, status) VALUES ('"+cod_exemplar+"', "+id_livro+", '"+status+"');");
    }

    public void DeleteExemplar(Exemplar Ex){
DBHandler Exemplares = DBHandler.getInstance();
Exemplares.insert("src/bd/arquivoLivros.txt","DELETE FROM exemplar WHERE id ='" + Ex.getId() + "'");
    }

public void UpdateExemplar(Exemplar Ex) throws EOFException {
DBHandler Exemplares = DBHandler.getInstance();
Exemplares.querry("UPDATE exemplar SET id_livro='"+Ex.getLivro_id()+"',status='"+Ex.getStatus()+"' WHERE id_exemplar='"+Ex.getId()+"'");
    }

}
 */