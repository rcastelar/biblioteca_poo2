/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca;

//import bd.DBHandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author f32cpd02
 */
public class Livro_DAO {
    Path arquivoLivros = Paths.get("./src/bd/arquivoLivros.txt");

    public Livro_DAO() {
    }


    public ObservableList<Livro> getAllLivro() {
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

    public ObservableList<Livro> querry() {
        //mudar para pegar o arquivo inteiro e carregar s dados em uma estrutura de objetos.
        ObservableList<Livro> listResult = FXCollections.observableArrayList();

        try (FileInputStream fis = new FileInputStream("/src/bd/livro/arquivoLivros.txt");
             ObjectInputStream ois = new ObjectInputStream(fis);) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listResult;
    }


    public void InsertLivro(ObservableList<Livro> meusLivros) {
        int i = 0;
        while ((!Files.exists(arquivoLivros) && (i < 2))) {
            try {
                Files.createFile(arquivoLivros);
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    Files.newOutputStream(arquivoLivros));

            //oos.writeObject(new ArrayList<EmployeeEntity>(personsObservable));
            os.writeObject(new ArrayList<Livro>(meusLivros));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void DeleteLivro(Livro Lv) {
        //  DBHandler Livros = DBHandler.getInstance();
        // Livros.querry("DELETE FROM livro WHERE id='" + Lv.getId() + "'");
    }
}

