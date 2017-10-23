/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.EOFException;
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
        ObjectInputStream os;
        ObservableList<Livro> mylist = FXCollections.observableArrayList();

        if (!Files.exists(arquivoLivros)) {
            try {
                Files.createFile(arquivoLivros);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                os = new ObjectInputStream(
                        Files.newInputStream(arquivoLivros));
                List<Livro> list = (List<Livro>) os.readObject();
                mylist = FXCollections.observableArrayList(list);

            } catch (EOFException e) {
                return mylist;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return mylist;
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
            os.writeObject(new ArrayList<>(meusLivros));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void DeleteLivro(Livro Lv) {
    }
}

