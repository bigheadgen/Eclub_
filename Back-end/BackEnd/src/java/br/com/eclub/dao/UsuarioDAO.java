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
public class UsuarioDAO {
    
    private Connection conLocal;
    
    public UsuarioDAO(){

    }
    //Método de buscar usuário
    public Usuario BuscarUsuario (String RedeSocial) throws SQLException{
        Usuario aux = new Usuario();
        //Query no banco fazendo solicitação de busca da variável

         conLocal = new ConnectionFactory().getConnection();
         String s = "SELECT RedeSocial FROM Usuario WHERE RedeSocial = ?;";
         PreparedStatement stmt;
         stmt = conLocal.prepareStatement(s);
         stmt.setString(1, aux.getRedeSocial());
         
        try (ResultSet rs = stmt.executeQuery()) {
            while(rs.next()) {
                aux.setRedeSocial(rs.getString("redeSocial"));
                aux.setDataNascimento(rs.getDate("dataNascimento"));
                aux.setSexo(rs.getBoolean("sexo"));
                aux.setNomeUser(rs.getString("nome_User"));
                aux.setTelefoneUser(rs.getString("telefone_User"));
                aux.setEmailUser(rs.getString("email_User"));
            }
        }
        
        
         stmt.close();
         conLocal.close();
         
         return aux; // falta implementar a busca

         
    }
    //Método de remover usuário
    public void RemoverUsuario (Usuario aux) throws SQLException{
        Usuario user = BuscarUsuario(aux.getRedeSocial());
        //Query de validar se o usuário exise para remoção;

        if (user.getRedeSocial()!= null){
           String sql = ("DELETE FROM Usuario WHERE RedeSocial = ?;");
           
         conLocal = new ConnectionFactory().getConnection();
         PreparedStatement stmt;
         stmt = conLocal.prepareStatement(sql);
         stmt.setString(1, aux.getRedeSocial());
         stmt.close();
         conLocal.close();
        }
      
    }
    //Método de Cadastrar usuário
    public Usuario CadastrarUsuario (Usuario aux) throws SQLException{
        Usuario validacao = new Usuario();
        validacao = BuscarUsuario(aux.getRedeSocial());
        Date data = new Date();
        //Query de cadastrar usuário
        if (validacao == null){
           conLocal = new ConnectionFactory().getConnection();
           PreparedStatement stmt = conLocal.prepareStatement("INSERT INTO USUARIO "
                   + "Values ('?', '?', '?', '?', '?', '?', '?')");
           ResultSet rs = stmt.executeQuery();
           while(rs.next()) {
                aux.setRedeSocial(rs.getString("redeSocial"));
                aux.setDataNascimento(rs.getDate("dataNascimento"));
                aux.setSexo(rs.getBoolean("sexo"));
                aux.setNomeUser(rs.getString("nome_User"));
                aux.setTelefoneUser(rs.getString("telefone_User"));
                aux.setEmailUser(rs.getString("email_User"));         
         }         
           conLocal.close();
           return aux;
        } else{
            return null;
            
        }
        
    }
    //Método para alterar dados do usuário
    public Usuario AlterarUsuario (Usuario aux) throws SQLException{
        if (BuscarUsuario(aux.getRedeSocial())!= null){
           conLocal = new ConnectionFactory().getConnection();
           PreparedStatement stmt = conLocal.prepareStatement("UPDATE USUARIO "
                   + "SET dataNascimento =?, redeSocial = ?, sexo = ?, nome_User = ?, telefone_User = ?,"
                   + " email_User WHERE redeSocial = ?");
           ResultSet rs = stmt.executeQuery();
           while(rs.next()) {
                aux.setRedeSocial(rs.getString("redeSocial"));
                aux.setDataNascimento(rs.getDate("dataNascimento"));
                aux.setSexo(rs.getBoolean("sexo"));
                aux.setNomeUser(rs.getString("nome_User"));
                aux.setTelefoneUser(rs.getString("telefone_User"));
                aux.setEmailUser(rs.getString("email_User"));
           }
           conLocal.close();
           return aux; 
        } else {
           return null;
        }
            
    }
  
}
    