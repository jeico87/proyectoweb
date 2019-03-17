/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiensusmanos.controller;

import apiensusmanos.model.dao.RegistrarEventoRepositorio;
import apiensusmanos.model.entity.RegistrarEvento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrarEventoServicio {
    @Autowired
    private RegistrarEventoRepositorio registrarEventoRepositorio;

    public RegistrarEventoServicio() {
    }

    public RegistrarEventoRepositorio getRegistrarEventoRepositorio() {
        return registrarEventoRepositorio;
    }

    public void setRegistrarEventoRepositorio(RegistrarEventoRepositorio registrarEventoRepositorio) {
        this.registrarEventoRepositorio = registrarEventoRepositorio;
    }
    
    public String RegistrarEvento(RegistrarEvento registrarEvento){
        return registrarEventoRepositorio.RegistrarEvento(registrarEvento);
    }
    
    public List<RegistrarEvento> obtenerRegistrarEvento(){
      return registrarEventoRepositorio.obtenerRegistrarEventos();
    }
}
