package br.com.eclub.dao;

import br.com.eclub.modelo.Endereco;
import br.com.eclub.modelo.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo, Thierry Freire
 */
public class EventoDAO {

    private Connection conLocal;

    public EventoDAO() {
        ConnectionFactory con = new ConnectionFactory();
        conLocal = con.getConnection();
    }

    public void inserirEvento(Evento evento) {
        Evento e = new Evento();
        e = evento;
        String sql = "INSERT INTO Evento VALUES ('?', '?', '?', '?', '?', '?', '?', '?', '?')";
        //terminar execução do código SQL
    }
    public List<Evento> listarEventos(Endereco endereco) throws SQLException{
        
        //falar com andre para ele criar o codigo sql para o select no banco 
        //para trazer todos os eventos a partir de um  local 
        String sql = "SELECT * FROM Evento E, Endereco D WHERE E.id_Endereco = ? AND D.cidade = ?;";
        //Verificar se o select está realmente correto
        PreparedStatement stmt = conLocal.prepareStatement(sql);
        stmt.setString(1, endereco.getCidade());
        ResultSet rs = stmt.executeQuery();
        
        List<Evento> eventos = new ArrayList<>();
        while (rs.next()){
            Evento ev = new Evento();
            
            ev.setNomeEvento(rs.getString("nome_Evento"));
            ev.setTipoEvento(rs.getString("tipo_Evento"));
            ev.setValorEntrada(rs.getDouble("valorEntrada"));
            ev.setData(rs.getDate("data_Evento"));
            ev.setLotacaoMaxima(rs.getByte("qntMaxPessoas"));
            ev.setHoraEvento(rs.getTime("hora_Evento"));
            ev.setQntHomens(rs.getInt("qntHomem"));
            ev.setQntmulheres(rs.getInt("qntMulher"));
            ev.setDescricaoEvento(rs.getString("descricaoEvento"));
            
            // falta adicionar ao evento o endereco e o divulgador
            
            //apos o evento estar completo deve ser adicionado a lista de eventos
            eventos.add(ev);
                        
            
           
        }
        
        return eventos;
    }
}
