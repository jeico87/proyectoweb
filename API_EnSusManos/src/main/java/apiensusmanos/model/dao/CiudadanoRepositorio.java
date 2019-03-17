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
                return "Error al Crear Ciudadadno. " + ciudadano.getId();
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
        Ciudadano ciudadano = (Ciudadano) session.get(Ciudadano.class, id);
        boolean eliminado = false;
        if (ciudadano != null) {
            String cadena = "Id: " + ciudadano.getId() + "  Nombre: " + ciudadano.getNombreCiudadano() + " " + ciudadano.getApellidoCiudadano();
            try {
                Transaction tn = session.beginTransaction();
                tn
                tn.
                tn.delete(ciudadano);
                tn.commit();
                session.close();
                eliminado = true;
            } catch (HibernateException ex) {
                ex.printStackTrace();
                tn.getTransaction().rollback();
            }
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
}
