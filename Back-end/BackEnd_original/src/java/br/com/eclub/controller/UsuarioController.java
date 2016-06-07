package br.com.eclub.controller;
//@author Thierry Freire

import br.com.eclub.dao.UsuarioDAO;
import br.com.eclub.modelo.Usuario;
import java.sql.SQLException;

public class UsuarioController {

    private UsuarioDAO userDAO;

    public UsuarioController() {
        this.userDAO = new UsuarioDAO();
    }

    public void CadastrarUsuario(Usuario usuario) {
        try {
            if (userDAO.BuscarUsuario(usuario) == null) {
                userDAO.CadastrarUsuario(usuario);
            }
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    public void RemoverUsuario (Usuario usuario){
        try{
            if(userDAO.BuscarUsuario(usuario) != null){
                userDAO.RemoverUsuario(usuario);
            } 
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void AlterarUsuario (Usuario usuario) throws SQLException{
        try {
            if (userDAO.BuscarUsuario(usuario) != null){
                userDAO.AlterarUsuario(usuario);
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
