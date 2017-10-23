/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 * @author f32cpd01
 */
public class Exemplar_DAO {

    private String IdLivro;
    public Exemplar_DAO(){
    }
/**
 public ObservableList<Exemplar> GetAllExemplar() {
 ObjectInputStream os = null;
 ObservableList<Livro> mylist = FXCollections.observableArrayList();
 try {
 os = new ObjectInputStream(
 Files.newInputStream(arquivoLivros));
 List<Livro> list = (List<Livro>) os.readObject();
 //personsObservable = FXCollections.observableList(list);
 mylist = FXCollections.observableArrayList(list);
 } catch (IOException | ClassNotFoundException e) {
 e.printStackTrace();
 }
 return mylist;
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
 */
}
