package Controllers;

import biblioteca.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller_Usuario {
    private static Controller_Usuario instanceus;
    private static ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    private final Controller_Publicacao myController_Publicacao = Controller_Publicacao.getInstance();
    private Usuario selectedUser;

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


    public int addUsuario(Usuario myUsuario) {
        Usuario_DAO myUsuarioDao = new Usuario_DAO();
        for (Usuario neededuser : listaUsuarios) {
            if ((neededuser).getRg().equals(myUsuario.getRg())) {
                return 1;
            }
        }
        listaUsuarios.add(myUsuario);
        myUsuarioDao.InsertUsuario(listaUsuarios);
        return 0;
    }

    public void editUsuario(Usuario myUsuario) {
        Usuario_DAO myUsuarioDao = new Usuario_DAO();
        selectedUser.setNome(myUsuario.getNome());
        selectedUser.setEndereco(myUsuario.getEndereco());
        selectedUser.setRg(myUsuario.getRg());
        selectedUser.setId(myUsuario.getId());
        selectedUser.setTelefone(myUsuario.getTelefone());
        myUsuarioDao.InsertUsuario(listaUsuarios);
    }

    public int addEmprestimo(String myExemplarCod) {
        Livro_DAO myLivroDao = new Livro_DAO();
        Usuario_DAO myUsuarioDao = new Usuario_DAO();
        //o simbolo ; separa a parte do codigo do exemplar que se refere ao livro da parte que se refere ao proprio exemplar
        if (myExemplarCod.contains("/")){
        String[] codigos = myExemplarCod.split("/");
        String livroid = codigos[0];
        String mydate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        for (Livro neededlivro : myController_Publicacao.getListaLivros()) {
            if ((neededlivro).getId() == Integer.parseInt(livroid)) {
                for (Exemplar neededexemplar : (neededlivro).getListaExemplar()) {
                    if ((neededexemplar).getCodigo_exemplar().equals(myExemplarCod)) {
                        if (neededexemplar.getStatus().equals("Disponível")) {
                            Emprestimo myEmprestimo = new Emprestimo(neededexemplar, neededlivro, mydate);
                            selectedUser.addToListaEmprestimo(myEmprestimo);
                            neededexemplar.setStatus("Emprestado");
                            myUsuarioDao.InsertUsuario(listaUsuarios);
                            myLivroDao.InsertLivro(myController_Publicacao.getListaLivros());
                            return 1;
                        } else {
                            return 2;
                        }
                    }
                }
            }
        }
        }else{
                return 3;
                }

        return 0;
    }

    public void removeEmprestimo(Emprestimo myExemplar) {
        String[] codigos = myExemplar.getCodigo_exemplar().split("/");
        String livroid = codigos[0];
        Livro_DAO myLivroDao = new Livro_DAO();
        Usuario_DAO myUsuarioDao = new Usuario_DAO();
        for (Livro neededlivro : myController_Publicacao.getListaLivros()) {
            if ((neededlivro).getId() == Integer.parseInt(livroid)) {
                for (Exemplar neededexemplar : (neededlivro).getListaExemplar()) {
                    if ((neededexemplar).getCodigo_exemplar().equals(myExemplar.getCodigo_exemplar())) {
                        neededexemplar.setStatus("Disponível");
                        selectedUser.removeEmprestimo(myExemplar);
                        myUsuarioDao.InsertUsuario(listaUsuarios);
                        myLivroDao.InsertLivro(myController_Publicacao.getListaLivros());
                    }

                }
            }
        }
    }
}
