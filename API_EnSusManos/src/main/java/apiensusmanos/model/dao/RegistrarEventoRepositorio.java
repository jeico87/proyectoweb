/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiensusmanos.model.dao;

import apiensusmanos.model.entity.RegistrarEvento;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateError;
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
    public String RegistrarEvento(RegistrarEvento registrarEvento) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(registrarEvento);
        session.getTransaction().commit();
        Integer id = registrarEvento.getIdRegistroEvento();
        return  "Evento Registrado con el ID: " + id;
    }
    
    public List<RegistrarEvento> obtenerRegistrarEventos(){
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(RegistrarEvento.class);
        return criteria.list();
        
    }
    
    
    //</editor-fold>
}
