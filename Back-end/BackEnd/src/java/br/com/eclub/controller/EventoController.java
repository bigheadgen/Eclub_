package br.com.eclub.controller;

import br.com.eclub.dao.DivulgadorDAO;
import br.com.eclub.dao.EnderecoDAO;
import br.com.eclub.dao.EventoDAO;
import br.com.eclub.modelo.Endereco;
import br.com.eclub.modelo.Evento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//@author Gustavo

public class EventoController {
    
    private EventoDAO eveDao;
    private EnderecoDAO endDao;
    private DivulgadorDAO divuDao;
    public static Connection comSQL;

    public EventoController() {
        this.eveDao = new EventoDAO();
        this.endDao = new EnderecoDAO();
        this.divuDao = new DivulgadorDAO();
    }

    public boolean inserirEvento(Evento objEvento) {
        try {
            if (this.eveDao.inserirEvento(objEvento)) {
                comSQL.commit();
                return true;
            } else {
                comSQL.rollback();
                return false;
            }
        } catch (SQLException e) {
            e.toString();
            return false;
        }
    }

    public boolean excluirEvento(Evento objEvento) {
        try {
            if (this.eveDao.excluirEvento(objEvento)) {
                comSQL.commit();;
                return true;
            } else {
                comSQL.rollback();
                return false;
            }
        } catch (SQLException e) {
            e.toString();
            return false;
        }
    }
    //falta implementar
    public Evento pesquisarEvento(Evento objEvento) {
        return null;
       
      
    }

    public List<Evento> ListarEventos(String local) throws SQLException {
        List<Evento> todosEventos;
        EventoDAO evento = new EventoDAO();
        Endereco endereco = new Endereco();

        return evento.listarEventos(endereco);
    }
}
