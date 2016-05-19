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
        Usuario aux = new Usuario();
        //Query no banco fazendo solicitação de busca da variável
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
    }
    //Método de remover usuário
    public void RemoverUsuario (Usuario aux) throws SQLException{
        Usuario user = BuscarUsuario(aux.getRedeSocial());
        //Query de validar se o usuário exise para remoção;
        if (user.getRedeSocial()!= null){
           String sql = ("DELETE FROM Usuario WHERE RedeSocial = ?;");
           
         con = new ConnectionFactory().getConnection();
         PreparedStatement stmt;
         stmt = con.prepareStatement(sql);
         stmt.setString(1, aux.getRedeSocial());
         stmt.close();
         con.close();
        }
      
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
    