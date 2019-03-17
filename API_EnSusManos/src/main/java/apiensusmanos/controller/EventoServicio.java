/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiensusmanos.controller;

import apiensusmanos.model.dao.EventoRepositorio;
import apiensusmanos.model.entity.Evento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoServicio {
    
    @Autowired
    private EventoRepositorio eventoRepositorio;
    
    public String crearEvento(Evento evento){
        String respuesta = eventoRepositorio.crearEvento(evento);
        return respuesta;
    }
    
    public List<Evento> obtenerEventos(){
        return eventoRepositorio.obtenerEventos();
    }
    
    public Evento obtenerCiudadanoPorId(int id){
        return eventoRepositorio.obtenerEventoPorId(id);
    }
    
    public String eliminarEvento(int id){
        return eventoRepositorio.eliminarEvento(id);
    }
}
