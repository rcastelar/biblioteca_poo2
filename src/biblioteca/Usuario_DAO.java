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
public class Usuario_DAO {
    Path arquivoUsuarios = Paths.get("./src/bd/arquivoUsuarios.txt");


    public Usuario_DAO() {
    }


    public ObservableList<Usuario> getAllUsuario() {
        ObjectInputStream os;
        ObservableList<Usuario> mylist = FXCollections.observableArrayList();

        if (!Files.exists(arquivoUsuarios)) {
            try {
                Files.createFile(arquivoUsuarios);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                os = new ObjectInputStream(
                        Files.newInputStream(arquivoUsuarios));
                List<Usuario> list = (List<Usuario>) os.readObject();
                mylist = FXCollections.observableArrayList(list);

            } catch (EOFException e) {
                return mylist;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return mylist;
    }


    public void InsertUsuario(ObservableList<Usuario> meusUsuarios) {
        int i = 0;
        while ((!Files.exists(arquivoUsuarios) && (i < 2))) {
            try {
                Files.createFile(arquivoUsuarios);
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    Files.newOutputStream(arquivoUsuarios));
            os.writeObject(new ArrayList<>(meusUsuarios));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void DeleteUsuario(Usuario Us) {
    }
}
