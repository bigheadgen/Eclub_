package br.com.eclub.dao;
//@author Thierry,@author Gustavo
import java.sql.Connection;
import br.com.eclub.modelo.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class EnderecoDAO {
    private Connection conLocal;

    public EnderecoDAO() {
    }
    public void cadastrarEndereco(Endereco endereco) {
        String sql = "INSERT INTO Endereco(cidade, bairro,rua ,estado , numero, latitude, longitude)"
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
            stmt.setString(7, endereco.getLongitude());

            stmt.execute();
            stmt.close();
            conLocal.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
    public void deletarEndereco(Endereco endereco) {
        String sql = "DELETE FROM Endereco WHERE latitude= ? AND longitude= ?";
        conLocal = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = conLocal.prepareStatement(sql);
            stmt.setString(1, endereco.getLatitude());
            stmt.setString(2, endereco.getLongitude());

            stmt.execute();
            stmt.close();
            conLocal.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public Endereco buscaEndereco(Endereco endereco) {
        Endereco end = new Endereco();
        conLocal = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM Endereco WHERE latitude=? AND longitude= ?";
        try {
            PreparedStatement stmt = conLocal.prepareStatement(sql);
            stmt.setString(1, endereco.getLatitude());
            stmt.setString(2, endereco.getLongitude());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                end.setBairro(rs.getString("bairro"));
                end.setCidade(rs.getString("cidade"));
                end.setEstado(rs.getString("estado"));
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
                end.setLatitude(rs.getString("latitude"));
                end.setLongitude(rs.getString("longetude"));
            }
            stmt.close();
            rs.close();
            conLocal.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return end;
    }
    public List<Endereco> ListarEnderecosCidade(Endereco endereco) {
        List<Endereco> enderecos = new ArrayList<>();

        conLocal = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM Endereco WHERE cidade=?";
        try {
            PreparedStatement stmt = conLocal.prepareStatement(sql);
            stmt.setString(1, endereco.getCidade());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Endereco end = new Endereco();
                end.setBairro(rs.getString("bairro"));
                end.setCidade(rs.getString("cidade"));
                end.setEstado(rs.getString("estado"));
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
                end.setLatitude(rs.getString("latitude"));
                end.setLongitude(rs.getString("longetude"));
                enderecos.add(end);
            }
        rs.close();
        stmt.close();
        conLocal.close();
        } catch (SQLException ex) {
          throw new RuntimeException(ex);
        }
        return enderecos;
    }
    public List<Endereco> ListarEnderecosEstado(Endereco endereco) {
        List<Endereco> enderecos = new ArrayList<>();

        conLocal = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM Endereco WHERE estado=?";
        try (PreparedStatement stmt = conLocal.prepareStatement(sql)) {
            stmt.setString(1, endereco.getEstado());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Endereco end = new Endereco();
                end.setBairro(rs.getString("bairro"));
                end.setCidade(rs.getString("cidade"));
                end.setEstado(rs.getString("estado"));
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
                end.setLatitude(rs.getString("latitude"));
                end.setLongitude(rs.getString("longetude"));
                enderecos.add(end);
            }
        rs.close();
        conLocal.close();
        } catch (SQLException ex) {
           throw new RuntimeException(ex);
        }
        return enderecos;
    }
    public List<Endereco> ListarEnderecosBairro(Endereco endereco) throws SQLException {
        List<Endereco> enderecos = new ArrayList<>();
        conLocal = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM Endereco WHERE bairro=?";
        ResultSet rs;
        try (PreparedStatement stmt = conLocal.prepareStatement(sql)) {
            stmt.setString(1, endereco.getBairro());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Endereco end = new Endereco();
                end.setBairro(rs.getString("bairro"));
                end.setCidade(rs.getString("cidade"));
                end.setEstado(rs.getString("estado"));
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
                end.setLatitude(rs.getString("latitude"));
                end.setLongitude(rs.getString("longetude"));
                enderecos.add(end);
            }
        }
        rs.close();
        conLocal.close();
        return enderecos;
    }
    public void AlterarEndereco(Endereco endereco) throws SQLException {
        //a validaçã0o dos campos de endereco para saber o que mudou deve ficar no controller
        conLocal = new ConnectionFactory().getConnection();
        String sql = "UPDATE TABLE endereco SET cidade = ?, rua = ?, estado = ?, numero = ?, latitude = ?,"
                + "longitude = ?, bairro = ? WHERE latitude = ? AND longitude = ?;";
        try (PreparedStatement stmt = conLocal.prepareStatement(sql)) {
            stmt.setString(1, endereco.getCidade());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getEstado());
            stmt.setInt(4, endereco.getNumero());
            stmt.setString(5, endereco.getLatitude());
            stmt.setString(6, endereco.getLongitude());
            stmt.setString(7, endereco.getBairro());
            stmt.setString(8, endereco.getLatitude());
            stmt.setString(9, endereco.getLongitude());
            stmt.execute();
            stmt.close();
            conLocal.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}