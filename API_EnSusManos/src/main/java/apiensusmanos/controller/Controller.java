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
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private CiudadanoServicio ciudadanoServicio;

    @RequestMapping(value = "/ciudadanos/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearCiudadano(@RequestBody Ciudadano ciudadano) {
        String resultado = ciudadanoServicio.crearCiudadano(ciudadano);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);

//        if ((ciudadanoServicio.crearCiudadano(ciudadano)) != 1) {
//            String resultado = "Ciudadano creado con id: " + String.valueOf(ciudadanoServicio.crearCiudadano(ciudadano));
//            return new ResponseEntity<String>(resultado, HttpStatus.OK);
//        } else {
//            String resultado = "Ciudadano actualizado ";
//            return new ResponseEntity<String>(resultado, HttpStatus.OK);
//        }
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
        String respuesta = ciudadanoServicio.eliminarCiudadano(id);
        return new ResponseEntity<String>(respuesta, HttpStatus.OK);
    }
}
