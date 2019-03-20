/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiensusmanos.model.dao;

import apiensusmanos.model.entity.Ciudadano;
import apiensusmanos.model.entity.Evento;
import apiensusmanos.model.entity.RegistrarEvento;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RegistrarEventoRepositorio {

    //<editor-fold defaultstate="collapsed" desc="Session Factory">
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="Metodos Servicio">
    @Autowired
    private CiudadanoRepositorio ciudadanoRepositorio;
    
    @Autowired
    private EventoRepositorio eventoRepositorio;
    
    public String RegistrarEvento(RegistrarEvento registrarEvento) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(registrarEvento);
        session.getTransaction().commit();
        Integer id = registrarEvento.getIdRegistroEvento();

        Ciudadano getCiudadano = ciudadanoRepositorio.obtenerCiudadanoPorId(registrarEvento.getIdCiudadano());
        Integer puntajeCiudadano = getCiudadano.getPuntajeCiudadano(); //Trae el puntaje del Ciudadano Actual
        
        Evento evento = eventoRepositorio.obtenerEventoPorId(registrarEvento.getIdEvento());
        Integer puntajeEvento = evento.getPuntajeEvento(); //Trae el puntaje del evento actual
        
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setId(registrarEvento.getIdCiudadano());
        ciudadano.setPuntajeCiudadano(puntajeCiudadano + puntajeEvento); //Actualiza puntaje del ciudadano
        
        String mensaje;
        Session sessionCiudadano = sessionFactory.openSession();
        try {
            sessionCiudadano.beginTransaction();
            sessionCiudadano.update(ciudadano); //Guarda el puntaje ciudadano actual
            sessionCiudadano.getTransaction().commit();
            sessionCiudadano.close();
            mensaje = "Puntaje ciudadano actualizado con exito!.";
        } catch (HibernateException ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            mensaje =  "Error al Actualizar Puntaje Ciudadadno. " + ciudadano.getId();
        }
        return "Evento Registrado con el ID: " + id + mensaje;
    }

    public List<RegistrarEvento> obtenerRegistrarEventos() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RegistrarEvento.class);
        return criteria.list();
    }
    //</editor-fold>
}
