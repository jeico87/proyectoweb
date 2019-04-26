/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiensusmanos.model.dao;

import apiensusmanos.model.entity.Ciudadano;
import apiensusmanos.model.entity.Evento;
import apiensusmanos.model.entity.RegistrarEvento;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
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

    public List<RegistrarEvento> eventosPorCiudadano(Integer id) {
//        //Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RegistrarEvento.class);
//        List<RegistrarEvento> rg = new ArrayList<RegistrarEvento>();
//        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RegistrarEvento.class);
//        criteria.add(Restrictions.eq("IdCiudadano", id));
//        //List<RegistrarEvento> results = criteria.list();
//        Criteria RegistrarCriteria = getSessionFactory().getCurrentSession().createCriteria(RegistrarEvento.class);
//        Criteria CiudadanoCriteria = RegistrarCriteria.createCriteria("ciudadano", "ciudadano");
//        Criteria EventoCriteria = CiudadanoCriteria.createCriteria("evento", "evento");
        //CiudadanoCriteria.add(Restrictions.eq("Id", id));

//        ProjectionList properties = Projections.projectionList();
//        properties.add(Projections.property("name"));
//        properties.add(Projections.property("id"));
//        return sessionFactory.getCurrentSession().createCriteria(RegistrarEvento.class)
//                .createAlias("book", "book")
//                .createAlias("book.organization", "organization")
//                .add(Restrictions.eq("organization.name", name))
//                .list();
//        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RegistrarEvento.class);
//        criteria.setFetchMode("Ciudadano", FetchMode.JOIN);

        
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RegistrarEvento.class,"rg" )
                .createAlias("ciudadano", "Ciudadano")
                .add(Restrictions.eq("Ciudadano.Id", id));
                //.setProjection( Projections.projectionList()
                //.add( Property.forName("rg.Ciudadano.nombreCiudadano")));
                //.add( Property.forName("nombreEvento")));
        
        return criteria.list();
    }
    //</editor-fold>
}
