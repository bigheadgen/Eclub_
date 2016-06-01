package br.com.eclub.controller;
//@author Thierry Freire

import br.com.eclub.dao.UsuarioDAO;
import br.com.eclub.modelo.Usuario;
import java.sql.Connection;
import java.sql.SQLException;

public class UsuarioController { 
    private UsuarioDAO userDAO;
    private Usuario user;
    public static Connection comSQL;
   
    public UsuarioController (){
        this.userDAO = new UsuarioDAO();
        this.user = new Usuario ();
    }
    public Usuario CadastrarUsuario (Usuario aux) throws SQLException{
        try{
            if (this.userDAO.CadastrarUsuario(user) != null){
                comSQL.commit();
                return user;
            } else {
                comSQL.rollback();
                return null;
            }
        } catch (SQLException e){
            e.toString();
            return  null;
        }
        
    }
}