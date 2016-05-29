package br.com.eclub.controller;

import br.com.eclub.dao.EventoDAO;
import br.com.eclub.modelo.Endereco;
import br.com.eclub.modelo.Evento;
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
    public EventoController(){
    }
    public List<Evento> ListarEventos(String local) throws SQLException {
        List<Evento> todosEventos;
        EventoDAO evento = new EventoDAO();
        Endereco endereco = new Endereco ();
        
        return evento.listarEventos(endereco);
    }
}

