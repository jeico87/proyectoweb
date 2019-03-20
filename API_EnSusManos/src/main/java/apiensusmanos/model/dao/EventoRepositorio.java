/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiensusmanos.model.dao;

import apiensusmanos.model.entity.Ciudadano;
import apiensusmanos.model.entity.Evento;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class EventoRepositorio {

    //<editor-fold defaultstate="collapsed" desc="Session Factory">
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public EventoRepositorio() {
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos Servicio">
    public String crearEvento(Evento evento) {
       Session session = sessionFactory.openSession();
        if (evento.getIdEvento() != null) {
            try {
                session.beginTransaction();
                session.saveOrUpdate(evento);
                session.getTransaction().commit();
                Integer id = evento.getIdEvento();
                session.close();
                return "Evento Actualizado Id: " + id;
            } catch (HibernateException ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
                return "Error al Actualizar Evento. " + evento.getIdEvento();
            }
        } else {
            try {
                session.beginTransaction();
                session.saveOrUpdate(evento);
                session.getTransaction().commit();
                Integer id = evento.getIdEvento();
                session.close();
                return "Evento Creado con Id: " + id;
            } catch (HibernateException ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
                return "Error al Crear Evento. ";
            }
        }
    }
    
    public List<Evento> obtenerEventos() {
         Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Evento.class);
        return criteria.list();
    }
    
    public Evento obtenerEventoPorId(int id) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Evento.class);
        criteria.add(Restrictions.eq("IdEvento", id));
        return (Evento) criteria.uniqueResult();
    }
    
    public String eliminarEvento(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tn = session.beginTransaction();
        Evento evento = (Evento) session.get(Evento.class, id);
        boolean eliminado = false;
        if (evento != null) {
            String cadena = "IdEvento: " + evento.getIdEvento() + "  Nombre Evento : " + evento.getNombreEvento() + " " ;
            try {
                session.delete(evento);
                tn.commit();
                eliminado = true;
            } catch (HibernateException ex) {
                ex.printStackTrace();
                //tn.rollback();
            }
             session.close();
            if (eliminado) {
                return "Evento Eliminado: " + cadena;
            }
            else{
                return "Error al Eliminar Evento: " + cadena;
            }
        } else {
            return "Evento no existe: " + id;
        }
    }
    //</editor-fold>     
}
