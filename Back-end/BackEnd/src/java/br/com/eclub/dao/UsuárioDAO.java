package br.com.eclub.dao;
import br.com.eclub.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author Thierry Freire
 */
public class UsuárioDAO {
    private Connection con;
    //Método de buscar usuário
    public Usuario BuscarUsuario (String RedeSocial) throws SQLException{
   
        //Query no banco fazendo solicitação de busca da variável
         con = new ConnectionFactory().getConnection();
         PreparedStatement stmt = con.prepareStatement("SELECT FROM Usuario WHERE RedeSocial = ?");
         stmt.setString(1, RedeSocial);
         con.close();
         return null; // falta implementar a busca
    }
    //Método de remover usuário
    public void RemoverUsuario (String RedeSocial) throws SQLException{
        Usuario usuario = BuscarUsuario(RedeSocial);
        //Query de validar se o usuário exise para remoção;
        con = new ConnectionFactory().getConnection();
        if (usuario != null){
            PreparedStatement stmt = con.prepareStatement("DELETE FROM Usuario WHERE RedeSocial = ?");
            stmt.setString(1, RedeSocial);
            stmt.executeQuery();
        }
        con.close();
    }
    //Método de Cadastrar usuário
    public Usuario CadastrarUsuario (Usuario usuario) throws SQLException{
        Usuario validacao = new Usuario();
        validacao = BuscarUsuario(usuario.getRedeSocial());
        Date data = new Date();
        //Query de cadastrar usuário
        con = new ConnectionFactory().getConnection();
        if (validacao == null){
           PreparedStatement stmt = con.prepareStatement("INSERT INTO USUARIO ('dataNascimento', "
           + "'redeSocial', 'sexo', 'nome_User', 'telefone_User', 'foto_User', 'email_User') "
           + "Values ('?', '?', '?', '?', '?', '?', '?')");
           //Terminar o set do query e executá-los
           con.close();
        }
        return usuario;
    }
  
}
    