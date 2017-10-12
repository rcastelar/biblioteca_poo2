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
 * @author f32cpd01
 */
public class Exemplar_DAO {

    Exemplar_DAO(){

    }

    public List<Exemplar> GetAllExemplar() throws SQLException, ClassNotFoundException {
        DBHandler Exemplares = new DBHandler();
        ResultSet rs = Exemplares.querry("SELECT * FROM exemplar");

        List<Exemplar> LstExemp = new LinkedList();
        try {
            while (rs.next()) {
                Exemplar ex = new Exemplar(rs.getInt("id"), rs.getInt("id_exemplar"), rs.getInt("status"));
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
                mysql = "SELECT * FROM exemplar WHERE " + campo.get(0) + "='" + valor.get(1) + "'";

                for (int i = 0; i < campo.size(); i++) {
                    if (i == 0)
                        continue;
                    else
                        mysql.concat(" AND " + campo.get(i) + "='" + valor.get(i) + "'");
                }

                ResultSet rs = Exemplares.querry(mysql);

                while (rs.next()) {
                    Exemplar ex = new Exemplar(rs.getInt("id"), rs.getInt("id_exemplar"), rs.getInt("status"));
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
                ResultSet rs = Exemplares.querry("SELECT * FROM exemplar WHERE " + campo + "in:valor");

                while (rs.next()) {
                    Exemplar ex = new Exemplar(rs.getInt("id"), rs.getInt("id_exemplar"), rs.getInt("status"));
                    LstExemp.add(ex);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return LstExemp;
    }

}
