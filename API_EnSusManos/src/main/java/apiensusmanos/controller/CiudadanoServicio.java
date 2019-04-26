/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiensusmanos.controller;
 
import apiensusmanos.model.dao.CiudadanoRepositorio;
import apiensusmanos.model.entity.Ciudadano;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
@Component
public class CiudadanoServicio {
    @Autowired
    private CiudadanoRepositorio ciudadanoRepositorio;
 
    public CiudadanoServicio() {
    }
 
    public CiudadanoRepositorio getCiudadanoRepositorio() {
        return ciudadanoRepositorio;
    }
 
    public void setCiudadanoRepositorio(CiudadanoRepositorio ciudadanoRepositorio) {
        this.ciudadanoRepositorio = ciudadanoRepositorio;
    }
     
    public String crearCiudadano(Ciudadano ciudadano){
        String respuesta = ciudadanoRepositorio.crearCiudadano(ciudadano);
        return respuesta;
    }
     
    public List<Ciudadano> obtenerCiudadanos(){
        return ciudadanoRepositorio.obtenerCiudadanos();
    }
     
    public Ciudadano obtenerCiudadanoPorId(int id){
        return ciudadanoRepositorio.obtenerCiudadanoPorId(id);
    }
     
    public String eliminarCiudadano(int id){
        return ciudadanoRepositorio.eliminarCiudadano(id);
    }
     
    public String loginCiudadano(Ciudadano ciudadano){
        return ciudadanoRepositorio.LoginCiudadano(ciudadano);
    }
}