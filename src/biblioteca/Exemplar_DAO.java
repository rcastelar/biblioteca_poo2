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

    public ResultSet GetAllExemplar() throws SQLException, ClassNotFoundException {
        DBHandler Exemplares = new DBHandler();
        return Exemplares.querry("SELECT * FROM exemplar");
    }

    public ResultSet GetExemplarCampos(List<String> campo, List<String> valor) throws SQLException, ClassNotFoundException {
        DBHandler Exemplares = new DBHandler();
        if(!campo.isEmpty() && !valor.isEmpty())
        {
            String mysql = new String();
            mysql = "SELECT * FROM exemplar WHERE "+campo.get(0)+"='"+valor.get(1)+"'";

            for(int i=0; i<campo.size(); i++)
            {
                if(i==0)
                    continue;
                else
                    mysql.concat(" AND "+campo.get(i)+"='"+valor.get(i)+"'");
            }

            return Exemplares.querry(mysql);
        }
        else
            return null;
    }

    public ResultSet GetExemplarInList(String campo, List<String> valor) throws SQLException, ClassNotFoundException {
        DBHandler Exemplares = new DBHandler();
        if(!valor.isEmpty())
        {
            return Exemplares.querry("SELECT * FROM exemplar WHERE "+campo+"in:valor");
            //Precisamos testar para ver se será possivel fazer essa in: valor
        }
        else
            return null;
    }

}
