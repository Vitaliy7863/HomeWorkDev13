package org.example;

import org.example.dao.TicketCrudService;
import org.example.model.Ticket;
import org.example.util.HibernateUtil;

public class TestTicket {
    public static void main(String[] args) {
        TicketCrudService ticketCrudService = new TicketCrudService();
        System.out.println(ticketCrudService.findAll());

        Ticket newTicket = new Ticket();
        newTicket.setClientId(1);
        newTicket.setFromPlanetId("MA1");
        newTicket.setToPlanetId("VEN2");
        ticketCrudService.save(newTicket);

        Ticket ticket = ticketCrudService.findById(1);
        System.out.println("Found ticket: " + ticket);

        ticket.setToPlanetId("SA5");
        ticketCrudService.update(ticket);

        ticketCrudService.delete(ticket);


        HibernateUtil.getInstance().close();
    }
}
