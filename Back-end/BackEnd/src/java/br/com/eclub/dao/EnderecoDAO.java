package br.com.eclub.dao;
//@author Thierry,@author Gustavo
import java.sql.Connection;
import br.com.eclub.modelo.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EnderecoDAO {
    private Connection conLocal;
    
    public EnderecoDAO(){} 
   
    public void cadastrarEndereco(Endereco endereco){
        String sql ="INSERT INTO Endereco(cidade, bairro,rua ,estado , numero, latitude, longitude)"
                + "VALUES(?,?,?,?,?,?,?)";
        conLocal = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = conLocal.prepareStatement(sql);
            stmt.setString(1, endereco.getCidade());
            stmt.setString(2, endereco.getBairro());
            stmt.setString(3, endereco.getRua());
            stmt.setString(4, endereco.getEstado());
            stmt.setInt(5, endereco.getNumero());
            stmt.setString(6, endereco.getLatitude());
            stmt.setString(7, endereco.getLongetude());
            
            stmt.executeQuery();
            stmt.close();
            conLocal.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    public void deletarEndereco(Endereco endereco){
        String sql = "DELETE FROM Endereco WHERE latitude= ? AND longitude= ?";
        conLocal = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = conLocal.prepareStatement(sql);
            stmt.setString(1, endereco.getLatitude());
            stmt.setString(2, endereco.getLongetude());
            
            stmt.executeQuery();
            stmt.close();
            conLocal.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    public Endereco buscaEndereco(Endereco endereco){
        Endereco end = new Endereco();
        conLocal = new ConnectionFactory().getConnection();
        String sql= "SELECT * FROM Endereco WHERE latitude=? AND longitude= ?";
        try {
            PreparedStatement stmt = conLocal.prepareStatement(sql);
            stmt.setString(1, endereco.getLatitude());
            stmt.setString(2, endereco.getLongetude());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){

                end.setBairro(rs.getString("bairro"));
                end.setCidade(rs.getString("cidade"));
                end.setEstado(rs.getString("estado"));
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
                end.setLatitude(rs.getString("latitude"));
                end.setLongetude(rs.getString("longetude"));   
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return end;
    }
    public List<Endereco> ListarEnderecosCidade(String cidade){
        List<Endereco> enderecos = new ArrayList<>();
        
        conLocal = new ConnectionFactory().getConnection();
        String sql= "SELECT * FROM Endereco WHERE cidade=?";
        try {
            PreparedStatement stmt = conLocal.prepareStatement(sql);
            stmt.setString(1, cidade);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Endereco end = new Endereco();
                end.setBairro(rs.getString("bairro"));
                end.setCidade(rs.getString("cidade"));
                end.setEstado(rs.getString("estado"));
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
                end.setLatitude(rs.getString("latitude"));
                end.setLongetude(rs.getString("longetude"));   
                enderecos.add(end);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return enderecos;
    }
    public List<Endereco> ListarEnderecosEstado(String estado){
        List<Endereco> enderecos = new ArrayList<>();
        
        conLocal = new ConnectionFactory().getConnection();
        String sql= "SELECT * FROM Endereco WHERE estado=?";
        try {
            PreparedStatement stmt = conLocal.prepareStatement(sql);
            stmt.setString(1, estado);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Endereco end = new Endereco();
                end.setBairro(rs.getString("bairro"));
                end.setCidade(rs.getString("cidade"));
                end.setEstado(rs.getString("estado"));
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
                end.setLatitude(rs.getString("latitude"));
                end.setLongetude(rs.getString("longetude"));   
                enderecos.add(end);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return enderecos;
    }
    public List<Endereco> ListarEnderecosBairro(String bairro){
        List<Endereco> enderecos = new ArrayList<>();
        
        conLocal = new ConnectionFactory().getConnection();
        String sql= "SELECT * FROM Endereco WHERE bairro=?";
        try {
            PreparedStatement stmt = conLocal.prepareStatement(sql);
            stmt.setString(1, bairro);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Endereco end = new Endereco();
                end.setBairro(rs.getString("bairro"));
                end.setCidade(rs.getString("cidade"));
                end.setEstado(rs.getString("estado"));
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
                end.setLatitude(rs.getString("latitude"));
                end.setLongetude(rs.getString("longetude"));   
                enderecos.add(end);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return enderecos;
    }
}