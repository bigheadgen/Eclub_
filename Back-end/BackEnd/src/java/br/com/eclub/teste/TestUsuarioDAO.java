package br.com.eclub.teste;

import br.com.eclub.dao.UsuarioDAO;
import br.com.eclub.modelo.Usuario;
import java.sql.SQLException;
//@author Thierry Freire
public class TestUsuarioDAO {

    public static void main(String[] Args) throws SQLException {
        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        usuario = dao.BuscarUsuario("face");

        usuario.toString();
    }
}
