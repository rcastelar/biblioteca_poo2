package bd;

import java.sql.*;
import bd.DBCreator;

public class DBHandler {
    public static Connection con;
    private static boolean hasData = false;

    public ResultSet querry(String sql) throws SQLException, ClassNotFoundException {
        if (con == null) {
            getConnection();
        }
        Statement state = con.createStatement();
        ResultSet res = state.executeQuery(sql);
        return res;
    }

    public boolean execute(String sql) throws SQLException, ClassNotFoundException {
        if (con == null) {
            getConnection();
        }
        Statement state = con.createStatement();
        boolean res = state.execute(sql);
        return res;
    }

    public int update(String sql) throws SQLException, ClassNotFoundException {
        if (con == null) {
            getConnection();
        }
        Statement state = con.createStatement();
        int res = state.executeUpdate(sql);
        return res;
    }


    public void getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:SQLiteTest1.db");
        initialise();
    }

    private void initialise() {
        int tablenumber = 2; //nmero de tabelas no banco. Utilizado para checagem de integridade e criacao do banco
        if (!hasData) {
            hasData = true;
            String checkdb = ("SELECT COUNT(*) FROM sqlite_master WHERE type='table'");
            Statement stest = null;
            try {
                stest = con.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ResultSet tnumber = stest.executeQuery(checkdb);
                if (tnumber.getInt(1) != tablenumber) {
                    createDb();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void createDb() {
        String livro = ("CREATE TABLE IF NOT EXISTS livro(\n" +
                "id integer PRIMARY KEY,\n" +
                "titulo varchar(60),\n" +
                "posicao varchar(60),\n" +
                "autor varchar(60),\n" +
                "genero varchar(60),\n" +
                "editora varchar(60))\n");

        String exemplar = ("CREATE TABLE IF NOT EXISTS exemplar(\n" +
                "id integer PRIMARY KEY,\n" +
                "id_exemplar integer,\n" +
                "status integer)\n");


        try {
            execute(livro);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            execute(exemplar);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
