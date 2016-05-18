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
    
    private Connection conLocal;
    
    public UsuárioDAO(){
       ConnectionFactory con = new ConnectionFactory ();
       conLocal = con.getConnection();
        
    }
    //Método de buscar usuário
    public Usuario BuscarUsuario (String RedeSocial) throws SQLException{
   
        //Query no banco fazendo solicitação de busca da variável
         PreparedStatement stmt = conLocal.prepareStatement("SELECT FROM Usuario WHERE RedeSocial = ?");
         stmt.setString(1, RedeSocial);
         conLocal.close();
         return null; // falta implementar a busca
    }
    //Método de remover usuário
    public void RemoverUsuario (String RedeSocial) throws SQLException{
        Usuario usuario = BuscarUsuario(RedeSocial);
        //Query de validar se o usuário exise para remoção;
        if (usuario != null){
            PreparedStatement stmt = conLocal.prepareStatement("DELETE FROM Usuario WHERE RedeSocial = ?");
            stmt.setString(1, RedeSocial);
            stmt.executeQuery();
        }
        conLocal.close();
    }
    //Método de Cadastrar usuário
    public Usuario CadastrarUsuario (Usuario usuario) throws SQLException{
        Usuario validacao = new Usuario();
        validacao = BuscarUsuario(usuario.getRedeSocial());
        Date data = new Date();
        //Query de cadastrar usuário
        if (validacao == null){
           PreparedStatement stmt = conLocal.prepareStatement("INSERT INTO USUARIO "
                   + "Values ('?', '?', '?', '?', '?', '?', '?')");
           //Terminar o set do query e executá-los
           conLocal.close();
        }
        return usuario;
    }
  
}
    