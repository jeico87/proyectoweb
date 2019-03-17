/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiensusmanos.model.dao;

import apiensusmanos.model.entity.Ciudadano;
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

@Repository
@Transactional
public class CiudadanoRepositorio {

    //<editor-fold defaultstate="collapsed" desc="Session Factory">
     @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public CiudadanoRepositorio() {
    }
    //</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="Metodos Servicio">
    public String crearCiudadano(Ciudadano ciudadano) {
        Session session = sessionFactory.openSession();
        if (ciudadano.getId() != null) {
            try {
                session.beginTransaction();
                session.saveOrUpdate(ciudadano);
                session.getTransaction().commit();
                Integer id = ciudadano.getId();
                session.close();
                return "Ciudadano Actualizado Id: " + id;
            } catch (HibernateException ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
                return "Error al Actualizar Ciudadadno. " + ciudadano.getId();
            }
        } else {
            try {
                session.beginTransaction();
                session.saveOrUpdate(ciudadano);
                session.getTransaction().commit();
                Integer id = ciudadano.getId();
                session.close();
                return "Ciudadano Creado Id: " + id;
            } catch (HibernateException ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();
                return "Error al Crear Ciudadano. " + ciudadano.getId();
            }
        }
    }

    public List<Ciudadano> obtenerCiudadanos() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Ciudadano.class);
        return criteria.list();
    }

    public Ciudadano obtenerCiudadanoPorId(int id) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Ciudadano.class);
        criteria.add(Restrictions.eq("Id", id));
        return (Ciudadano) criteria.uniqueResult();
    }

    public String eliminarCiudadano(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tn = session.beginTransaction();
        Ciudadano ciudadano = (Ciudadano) session.get(Ciudadano.class, id);
        boolean eliminado = false;
        if (ciudadano != null) {
            String cadena = "Id: " + ciudadano.getId() + "  Nombre: " + ciudadano.getNombreCiudadano() + " " + ciudadano.getApellidoCiudadano();
            try {
                session.delete(ciudadano);
                tn.commit();
                eliminado = true;
            } catch (HibernateException ex) {
                ex.printStackTrace();
                tn.rollback();
            }
             session.close();
            if (eliminado) {
                return "Ciudadano Eliminado: " + cadena;
            }
            else{
                return "Error al Eliminar ciudadano: " + cadena;
            }
        } else {
            return "Ciudadano no existe: " + id;
        }
    }
    //</editor-fold>
}
