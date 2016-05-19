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
        Usuario aux = new Usuario();
        //Query no banco fazendo solicitação de busca da variável
<<<<<<< HEAD
         con = new ConnectionFactory().getConnection();
         String s = "SELECT RedeSocial FROM Usuario WHERE RedeSocial = ?;";
         PreparedStatement stmt;
         stmt = con.prepareStatement(s);
         stmt.setString(1, aux.getRedeSocial());
         
         ResultSet rs = stmt.executeQuery();
         
         while(rs.next()) {
         aux.setRedeSocial(rs.getString("redeSocial"));
         aux.setDataNascimento(rs.getTime("dataNascimento"));
         aux.setSexo(rs.getBoolean("sexo"));
         aux.setNomeUser(rs.getString("nome_User"));
         aux.setTelefoneUser(rs.getString("telefone_User"));
         aux.setEmailUser(rs.getString("email_User"));         }
         
         rs.close();
         stmt.close();
         con.close();
         
         return aux; // falta implementar a busca
=======
         PreparedStatement stmt = conLocal.prepareStatement("SELECT FROM Usuario WHERE RedeSocial = ?");
         stmt.setString(1, RedeSocial);
         conLocal.close();
         return null; // falta implementar a busca
>>>>>>> 621f06e054dca3b50ca3f0ddf3bca9d5b7f83500
    }
    //Método de remover usuário
    public void RemoverUsuario (Usuario aux) throws SQLException{
        Usuario user = BuscarUsuario(aux.getRedeSocial());
        //Query de validar se o usuário exise para remoção;
<<<<<<< HEAD
        if (user.getRedeSocial()!= null){
           String sql = ("DELETE FROM Usuario WHERE RedeSocial = ?;");
           
         con = new ConnectionFactory().getConnection();
         PreparedStatement stmt;
         stmt = con.prepareStatement(sql);
         stmt.setString(1, aux.getRedeSocial());
         stmt.close();
         con.close();
        }
      
=======
        if (usuario != null){
            PreparedStatement stmt = conLocal.prepareStatement("DELETE FROM Usuario WHERE RedeSocial = ?");
            stmt.setString(1, RedeSocial);
            stmt.executeQuery();
        }
        conLocal.close();
>>>>>>> 621f06e054dca3b50ca3f0ddf3bca9d5b7f83500
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
    