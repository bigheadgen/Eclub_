package br.com.eclub.controller;

import br.com.eclub.dao.EventoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustavo
 */
public class EventoController {

    public List<Evento> ListarEventos(String local) {
        List<Evento> todosEventos;
        EventoDAO evento = new EventoDAO();

        //aqui deve entrar as validacoes 
        //e tratamentos 
        //para fazer a busca no banco
        //reponsavel fazer
        try {
            
            return evento.listarEventos(local);

        } catch (SQLException ex) {

        }

        return null;
    }

}
