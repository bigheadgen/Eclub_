package br.com.eclub.dao;
import br.com.eclub.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
//@author Thierry Freire
public class UsuarioDAO {
    
    private Connection conLocal;
    
    public UsuarioDAO(){
    }
    //Método de buscar usuário
    public Usuario BuscarUsuario (Usuario usuario){
        String sql = "SELECT * FROM Usuario WHERE idRedeSocial=?";
        conLocal = new ConnectionFactory().getConnection();
        try {
            Usuario user = new Usuario();
            PreparedStatement stmt = conLocal.prepareStatement(sql);
            stmt.setInt(1, usuario.getRedeSocial());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            user.setNomeUser(rs.getString("nomeUsuario"));
            user.setEmailUser(rs.getString("emailUsuario"));
            user.setSexo(rs.getInt("sexo"));
            user.setTelefoneUser("telefoneUsuario");
            Calendar data = Calendar.getInstance();
            data.setTime(rs.getDate("dataNascimento"));
            user.setDataNascimento(data);
            user.setRedeSocial(rs.getInt("idRedeSocial"));
            }
            stmt.close();
            rs.close();
            return user;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    //Método de remover usuário
    public void RemoverUsuario (Usuario usuario){
       String sql = "DELETE FROM Usuario WHERE idRedeSocial= ?";
       conLocal = new ConnectionFactory().getConnection();
        PreparedStatement stmt ;
        try {
            stmt = conLocal.prepareStatement(sql);
            stmt.setInt(1, usuario.getRedeSocial());
            stmt.execute();
            stmt.close();
            conLocal.close();
        } catch (SQLException ex) {
         throw new RuntimeException(ex);
        }
    }
    //Método de Cadastrar usuário
    public void CadastrarUsuario (Usuario usuario){
        String sql ="INSERT INTO Usuario(nomeUsuario, sexo, dataNascimento, EmailUsuario, telefoneUsuario, idRedeSocial)"
                + "VALUES(?,?,?,?,?,?)";
           conLocal = new ConnectionFactory().getConnection();
        try (PreparedStatement stmt = conLocal.prepareStatement(sql)) {
           stmt.setString(1, usuario.getNomeUser());
           stmt.setInt(2, usuario.getSexo());
           stmt.setDate(3, (java.sql.Date) new Date(usuario.getDataNascimento().getTimeInMillis()));
           stmt.setString(4, usuario.getEmailUser());
           stmt.setString(5, usuario.getTelefoneUser());
           stmt.setInt(6, usuario.getRedeSocial());
           stmt.execute();
           stmt.close();
           conLocal.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    //Método para alterar dados do usuário
    public void AlterarUsuario (Usuario usuario) throws SQLException{
        String sql ="UPDATE TABLE Usuario SET nomeUsuario = ?, emailUsuario = ?, sexo = ?, "
                + "telefoneUsuario = ?, idRedeSocial = ?, dataNascimento=? WHERE idRedeSocial = ?";
        conLocal = new ConnectionFactory().getConnection();
        try (PreparedStatement stmt = conLocal.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNomeUser());
            stmt.setString(2, usuario.getEmailUser());
            stmt.setInt(3, usuario.getSexo());
            stmt.setString(4, usuario.getTelefoneUser());
            stmt.setInt(5, usuario.getRedeSocial());
            stmt.setDate(6, (java.sql.Date) new Date(usuario.getDataNascimento().getTimeInMillis()));
            stmt.setInt(7, usuario.getRedeSocial()); 
            stmt.execute();
            stmt.close();
            conLocal.close();
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
    