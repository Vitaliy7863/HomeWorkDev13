package org.example.dao;

import org.example.model.Ticket;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TicketCrudService {

    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(ticket);
            tx.commit();
        }
    }

    public Ticket findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public void update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(ticket);
            tx.commit();
        }
    }

    public void delete(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(ticket);
            tx.commit();
        }
    }

    public List<Ticket> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Ticket");
            List<Ticket> tickets = query.list();
            return tickets;
        }
    }
}
