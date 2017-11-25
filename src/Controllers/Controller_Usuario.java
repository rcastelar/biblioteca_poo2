package Controllers;

import biblioteca.Usuario;
import biblioteca.Usuario_DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller_Usuario {
    private static Controller_Usuario instanceus;
    private Usuario selectedUser;
    private static int qdeUsuario;
    private static ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();

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
    //    ((Usuario) selectedUser).setAutor(myUsuario.getAutor());
    //    selectedUser.setEditora(myUsuario.getEditora());
     //   selectedUser.setGenero(myUsuario.getGenero());
    //    selectedUser.setPosicao(myUsuario.getPosicao());
    //    selectedUser.setTitulo(myUsuario.getTitulo());
        myUsuarioDao.InsertUsuario(listaUsuarios);
    }


    public void removeUsuario(Usuario myUsuario) {
        Usuario_DAO myUsuarioDao = new Usuario_DAO();
    //    selectedUser.removeUsuario(myUsuario);
    }
}
