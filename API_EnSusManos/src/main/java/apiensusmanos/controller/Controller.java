/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiensusmanos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import apiensusmanos.model.entity.Ciudadano;
import apiensusmanos.model.entity.Evento;
<<<<<<< HEAD
import apiensusmanos.model.entity.RegistrarEvento;
import org.omg.CORBA.PUBLIC_MEMBER;
=======
>>>>>>> 18d4e7acbf51e68459cab81570d660c72cb8aaa1
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api")
public class Controller {

    //<editor-fold defaultstate="collapsed" desc="Servicio Ciudadano">
    @Autowired
    private CiudadanoServicio ciudadanoServicio;

    @RequestMapping(value = "/ciudadanos/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearActualizarCiudadano(@RequestBody Ciudadano ciudadano) {
        String resultado = ciudadanoServicio.crearCiudadano(ciudadano);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }

    @RequestMapping(value = "/ciudadanos/", method = RequestMethod.GET)
    public ResponseEntity<List<Ciudadano>> obtenerCiudadanos() {
        List<Ciudadano> listaCiudadanos = ciudadanoServicio.obtenerCiudadanos();
        return new ResponseEntity<List<Ciudadano>>(listaCiudadanos, HttpStatus.OK);
    }

    @RequestMapping(value = "/ciudadanos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ciudadano> obtenerCiudadanoporId(@PathVariable("id") int id) {
        Ciudadano resultadoCiudadano = ciudadanoServicio.obtenerCiudadanoPorId(id);
        return new ResponseEntity<Ciudadano>(resultadoCiudadano, HttpStatus.OK);
    }

    @RequestMapping(value = "/ciudadanos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarCiudadano(@PathVariable int id) {
        String eliminarCiudadanoRespuesta = ciudadanoServicio.eliminarCiudadano(id);
        return new ResponseEntity<String>(eliminarCiudadanoRespuesta, HttpStatus.OK);
    }
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Servicio Evento">
    @Autowired
    private EventoServicio eventoServicio;

    @RequestMapping(value = "/eventos/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearActualizarEvento(@RequestBody Evento evento) {
        String resultado = eventoServicio.crearEvento(evento);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
<<<<<<< HEAD
    }

    @RequestMapping(value = "/eventos/", method = RequestMethod.GET)
    public ResponseEntity<List<Evento>> obtenerEventos() {
        List<Evento> listaEventos = eventoServicio.obtenerEventos();
        return new ResponseEntity<List<Evento>>(listaEventos, HttpStatus.OK);
    }

    @RequestMapping(value = "/eventos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Evento> obtenerEventosporId(@PathVariable("id") int id) {
        Evento resultadoEvento = eventoServicio.obtenerCiudadanoPorId(id);
        return new ResponseEntity<Evento>(resultadoEvento, HttpStatus.OK);
    }

    @RequestMapping(value = "/eventos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarEvento(@PathVariable int id) {
        String eliminarEventoRespuesta = eventoServicio.eliminarEvento(id);
        return new ResponseEntity<String>(eliminarEventoRespuesta, HttpStatus.OK);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Servicio Registro Evento">
    @Autowired
    private RegistrarEventoServicio registrarEventoServicio;

    @RequestMapping(value = "/registrarEvento/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registrarEvento(@RequestBody RegistrarEvento registrarEvento) {
        String resultRegistroEvento = registrarEventoServicio.RegistrarEvento(registrarEvento);
        return new ResponseEntity<String>(resultRegistroEvento, HttpStatus.OK);
    }

    @RequestMapping(value = "/registrarEvento/", method = RequestMethod.GET)
    public ResponseEntity<List<RegistrarEvento>> obtenerRegistrarEvento() {
        List<RegistrarEvento> listaEventos = registrarEventoServicio.obtenerRegistrarEvento();
        return new ResponseEntity<List<RegistrarEvento>>(listaEventos, HttpStatus.OK);
    }
    
    
=======
    }

    @RequestMapping(value = "/eventos/", method = RequestMethod.GET)
    public ResponseEntity<List<Evento>> obtenerEventos() {
        List<Evento> listaEventos = eventoServicio.obtenerEventos();
        return new ResponseEntity<List<Evento>>(listaEventos, HttpStatus.OK);
    }

    @RequestMapping(value = "/eventos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Evento> obtenerEventosporId(@PathVariable("id") int id) {
        Evento resultadoEvento = eventoServicio.obtenerCiudadanoPorId(id);
        return new ResponseEntity<Evento>(resultadoEvento, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/eventos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarEvento(@PathVariable int id) {
        String eliminarEventoRespuesta = eventoServicio.eliminarEvento(id);
        return new ResponseEntity<String>(eliminarEventoRespuesta, HttpStatus.OK);
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Servicio Registro Evento">
>>>>>>> 18d4e7acbf51e68459cab81570d660c72cb8aaa1
    //</editor-fold>
}
