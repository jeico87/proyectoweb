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

        Ciudadano getCiudadano = ciudadanoRepositorio.obtenerCiudadanoPorId(registrarEvento.getIdCiudadano());
        registrarEvento.setCiudadano(getCiudadano);
        Evento evento = eventoRepositorio.obtenerEventoPorId(registrarEvento.getIdEvento());
        registrarEvento.setEvento(evento);

        
        Integer puntajeCiudadano = getCiudadano.getPuntajeCiudadano(); //Trae el puntaje del Ciudadano Actual

        Integer puntajeEvento = evento.getPuntajeEvento(); //Trae el puntaje del evento actual
        getCiudadano.setPuntajeCiudadano(puntajeCiudadano + puntajeEvento); //Actualiza puntaje del ciudadano

        String mensaje;
        Session sessionCiudadano = sessionFactory.openSession();
//        try {
            sessionCiudadano.beginTransaction();
            sessionCiudadano.merge(getCiudadano); //Guarda el puntaje ciudadano actual
            sessionCiudadano.getTransaction().commit();
            sessionCiudadano.close();
            mensaje = "Puntaje ciudadano actualizado con exito!.";

            Session sessionRegistrarEvento = sessionFactory.openSession();
            sessionRegistrarEvento.beginTransaction();
            sessionRegistrarEvento.save(registrarEvento);
            sessionRegistrarEvento.getTransaction().commit();
            sessionRegistrarEvento.close();
            Integer id = registrarEvento.getIdRegistroEvento();
////        } catch (HibernateException ex) {
//            ex.printStackTrace();
//            sessionCiudadano.getTransaction().rollback();
//            mensaje = "Error al Actualizar Puntaje Ciudadadno. " + getCiudadano.getId();
//        }
        return "Evento Registrado con el ID: " + id + " " + mensaje;
    }

    public List<RegistrarEvento> obtenerRegistrarEventos() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RegistrarEvento.class);
        return criteria.list();
    }
    //</editor-fold>
}
