package org.example.dao;

import org.example.model.Client;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClientCrudService {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(client);
            tx.commit();
        }
    }

    public Client findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }

    public void update(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(client);
            tx.commit();
        }
    }

    public void delete(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(client);
            tx.commit();
        }
    }

    public List<Client> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Client");
            List<Client> clients = query.list();
            return clients;
        }
    }
}
