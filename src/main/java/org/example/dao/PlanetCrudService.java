package org.example.dao;

import org.example.model.Planet;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PlanetCrudService {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(planet);
            tx.commit();
        }
    }

    public Planet findById(String id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void update(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(planet);
            tx.commit();
        }
    }

    public void delete(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(planet);
            tx.commit();
        }
    }

    public List<Planet> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Planet");
            List<Planet> planets = query.list();
            return planets;
        }
    }
}
