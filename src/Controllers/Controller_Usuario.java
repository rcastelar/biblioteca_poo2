package Controllers;

import biblioteca.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller_Usuario {
    private static Controller_Usuario instanceus;
    private Usuario selectedUser;
    private static ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    Controller_Publicacao myController_Publicacao = Controller_Publicacao.getInstance();
    private Controller_Usuario() {
        Usuario_DAO myUsuarioDao = new Usuario_DAO();
        listaUsuarios = myUsuarioDao.getAllUsuario();
    }

    public static Controller_Usuario getInstance() {
        if (instanceus == null) {
            instanceus = new Controller_Usuario();
        }
        return instanceus;
    }

    public ObservableList getListaUsuarios() {
        return listaUsuarios;
    }

    public Usuario getSelectedUsuario() {
        return selectedUser;
    }

    public void setSelectedUsuario(Usuario gid) {
        selectedUser = gid;
    }


    public void addUsuario(Usuario myUsuario) {
        Usuario_DAO myUsuarioDao = new Usuario_DAO();
        listaUsuarios.add(myUsuario);
        myUsuarioDao.InsertUsuario(listaUsuarios);
    }

    public void editUsuario(Usuario myUsuario) {
        Usuario_DAO myUsuarioDao = new Usuario_DAO();
        ((Usuario) selectedUser).setNome(myUsuario.getNome());
        selectedUser.setEndereco(myUsuario.getEndereco());
        selectedUser.setRg(myUsuario.getRg());
        selectedUser.setId(myUsuario.getId());
        selectedUser.setTelefone(myUsuario.getTelefone());
        myUsuarioDao.InsertUsuario(listaUsuarios);
    }

    public int addEmprestimo(String myExemplarCod) {

        Usuario_DAO myUsuarioDao = new Usuario_DAO();
        String[] codigos = myExemplarCod.split(";");
        String livroid = codigos[0];
        String mydate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
       for (Object neededlivro : myController_Publicacao.getListaLivros()) {
            if (((Livro)neededlivro).getId() == Integer.parseInt(livroid)) {
                for (Object neededexemplar : ((Livro)neededlivro).getListaExemplar()) {
                    if (((Exemplar)neededexemplar).getCodigo_exemplar().equals(myExemplarCod)) {
                        Emprestimo myEmprestimo = new Emprestimo((Exemplar)neededexemplar, (Livro)neededlivro, mydate);
                        selectedUser.addToListaEmprestimo(myEmprestimo);
                    }else {
                        return 0;
                    }
                }
            }
        }
        myUsuarioDao.InsertUsuario(listaUsuarios);
       return 1;
    }

    public void removeEmprestimo(Emprestimo myExemplar) {
        selectedUser.removeEmprestimo(myExemplar);
    }
}
