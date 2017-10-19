package bd;

import java.sql.*;

public class DBHandler {
    private static Connection con;
    private static boolean hasData = false;

    public ResultSet querry(String sql) throws SQLException, ClassNotFoundException {
        if (con == null) {
            getConnection();
        }
        Statement state = con.createStatement();
        return state.executeQuery(sql);
    }

    public boolean execute(String sql) throws SQLException, ClassNotFoundException {
        if (con == null) {
            getConnection();
        }
        Statement state = con.createStatement();
        return state.execute(sql);
    }

    public int update(String sql) throws SQLException, ClassNotFoundException {
        if (con == null) {
            getConnection();
        }
        Statement state = con.createStatement();
        return state.executeUpdate(sql);
    }


    public void getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:biblioteca.db");
        initialise();
    }

    private void initialise() {
        int tablenumber = 2; //numero de tabelas no banco. Utilizado para checagem de integridade e criacao do banco
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
                ResultSet tnumber;
                tnumber = stest.executeQuery(checkdb);
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
                "id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "titulo varchar(60),\n" +
                "posicao varchar(60),\n" +
                "autor varchar(60),\n" +
                "genero varchar(60),\n" +
                "editora varchar(60))\n");

        String exemplar = ("CREATE TABLE IF NOT EXISTS exemplar(\n" +
                "id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "cod_exemplar integer,\n" +
                "id_livro,\n"+
                "status varchar(100))\n");

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
