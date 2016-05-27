package br.com.eclub.ws;

import br.com.eclub.controller.EventoController;
import br.com.eclub.modelo.Evento;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Gustavo
 */
@Path("/evento")
public class EventoWS {
 
    @GET
    @Path("/listarTodosEventos")
    @Produces("application/json")
    public List<Evento> listarEventos(String local){
        EventoController ec = new EventoController();
        
        
        return ec.ListarEventos(local);
    }
    
}
