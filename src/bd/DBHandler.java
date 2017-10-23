/**package bd;


 import javafx.collections.FXCollections;
 import javafx.collections.ObservableList;
 import javafx.scene.Node;
 import java.io.*;
import java.sql.*;
 import java.util.*;

 public class DBHandler implements Serializable{
 private static DBHandler instance;
 private static Connection con;
 private static boolean hasData = false;
 private static final HashMap<String, Node> arquivos= new HashMap<>();

 private DBHandler() {
 //nome dos arquivos de dados
 // arquivos.add(0, "livros.txt");
 }

 public static DBHandler getInstance() {
 if (instance == null) {
 instance = new DBHandler();
 }
 return instance;
 }


 private void addFile(String name, Node arquivo) {
 //arquivos.put(name);
 }


 public ObservableList<Object> querry() {
 //mudar para pegar o arquivo inteiro e carregar s dados em uma estrutura de objetos.
 ObservableList<Object> listResult = FXCollections.observableArrayList();
 try (FileInputStream fis = new FileInputStream(pathArquivo);
 ObjectInputStream ois = new ObjectInputStream(fis);) {
 listResult.add(ois.readObject());
 return listResult;
 } catch (IOException | ClassNotFoundException e) {
 e.printStackTrace();
 }
 return listResult;
 }

 public void insert(String pathArquivo, Entity obj) {
 FileOutputStream file= null;
 try {
 file = new FileOutputStream(pathArquivo);
 } catch (FileNotFoundException e) {
 e.printStackTrace();
 }
 try {
 ObjectOutputStream fos = new ObjectOutputStream(file);
 } catch (IOException e) {
 e.printStackTrace();
 }

 }


 public int update(String sql) throws SQLException, ClassNotFoundException {
 //nao sera permitido em arquivos
 if (con == null) {
 getConnection();
 }
 Statement state = con.createStatement();
 return state.executeUpdate(sql);
 }


 public void getConnection() throws ClassNotFoundException, SQLException {
 //mudar para verificar existencia dos arquivos, criar se nao existe (atraves do initialise), retornar erro se nome incorreto.
 Class.forName("org.sqlite.JDBC");
 con = DriverManager.getConnection("jdbc:sqlite:biblioteca.db");
 initialise();
 }

 private void initialise() {
 File f = new File("fileLivro");
 if(!f.exists())
 try {
 f.createNewFile();
 } catch (IOException e) {
 e.printStackTrace();
 }



 /**
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


 private void createDb() {

 //mudar para criar arquivos com dados de liros e exemplares



 /**     String livro = ("CREATE TABLE IF NOT EXISTS livro(\n" +
 "id integer PRIMARY KEY AUTOINCREMENT,\n" +
 "titulo varchar(60),\n" +
 "posicao varchar(60),\n" +
 "autor varchar(60),\n" +
 "genero varchar(60),\n" +
 "editora varchar(60))\n");

 String exemplar = ("CREATE TABLE IF NOT EXISTS exemplar(\n" +
 "id integer PRIMARY KEY AUTOINCREMENT,\n" +
 "cod_exemplar varchar(100),\n" +
 "id_livro,\n"+
 "status varchar(100))\n");

 try {
 execute(livro);
 } catch (SQLException | ClassNotFoundException e) {
 e.printStackTrace();
 }

 try {
 execute(exemplar);
 } catch (SQLException | ClassNotFoundException e) {
 e.printStackTrace();
 }

 }
}
 */