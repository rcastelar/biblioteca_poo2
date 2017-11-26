package Controllers;

import biblioteca.Emprestimo;
import biblioteca.Exemplar;
import biblioteca.Usuario;
import biblioteca.Usuario_DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller_Usuario {
    private static Controller_Usuario instanceus;
    private Usuario selectedUser;
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
        ((Usuario) selectedUser).setNome(myUsuario.getNome());
        selectedUser.setEndereco(myUsuario.getEndereco());
        selectedUser.setRg(myUsuario.getRg());
        selectedUser.setId(myUsuario.getId());
        selectedUser.setTelefone(myUsuario.getTelefone());
        myUsuarioDao.InsertUsuario(listaUsuarios);
    }

    public void addEmprestimo(Emprestimo myEmprestimo) {
        Usuario_DAO myUsuarioDao = new Usuario_DAO();
       for (Usuario neededUsuario : listaUsuarios) {
            if (selectedUser.getId() == neededUsuario.get().getId()) {
                neededUsuario.addToListaEmprestimo(myEmprestimo);
                break;
            }
        }
        myUsuarioDao.InsertUsuario(listaUsuarios);
    }

    public void removeEmprestimo(Exemplar myExemplar) {
        selectedUser.removeEmprestimo(myExemplar);
    }
}
