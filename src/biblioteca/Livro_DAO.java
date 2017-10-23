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

/**
 * @author f32cpd02
 */
public class Livro_DAO {
    Controller mainController = Controller.getInstance();
    Path arquivoLivros = Paths.get("./src/bd/arquivoLivros.txt");

    public Livro_DAO() {
    }


    public void getAllLivro() {
        ObjectInputStream os = null;
        try {
            os = new ObjectInputStream(
                    Files.newInputStream(arquivoLivros));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mainController.addLivro((Livro) os.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Livro> querry() {
        //mudar para pegar o arquivo inteiro e carregar s dados em uma estrutura de objetos.
        ObservableList<Livro> listResult = FXCollections.observableArrayList();

        try (FileInputStream fis = new FileInputStream("/src/bd/livro/arquivoLivros.txt");
             ObjectInputStream ois = new ObjectInputStream(fis);) {
            listResult.add((Livro) ois.readObject());
            return listResult;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listResult;
    }


    public void InsertLivro(Livro meuLivro) {
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
            os.writeObject(meuLivro);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void DeleteLivro(Livro Lv) {
        //  DBHandler Livros = DBHandler.getInstance();
        // Livros.querry("DELETE FROM livro WHERE id='" + Lv.getId() + "'");
    }
}

