package br.com.eclub.controller;
//@author Thierry Freire

import br.com.eclub.dao.UsuarioDAO;
import br.com.eclub.modelo.Usuario;

public class UsuarioController {

    private UsuarioDAO userDAO;

    public UsuarioController() {
    }

    public void CadastrarUsuario(Usuario usuario) {
        userDAO = new UsuarioDAO();
        try {
            if (userDAO.BuscarUsuario(usuario) == null) {
                userDAO.CadastrarUsuario(usuario);
            }
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}
