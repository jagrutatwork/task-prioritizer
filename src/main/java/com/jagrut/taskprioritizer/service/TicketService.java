package com.jagrut.taskprioritizer.service;
import com.jagrut.taskprioritizer.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    private final List<Ticket> tickets = new ArrayList<>();

    public boolean addTicket(Ticket ticket)
    {
        tickets.add(ticket);
        return true;
    }

    public List<Ticket> getAllTickets() {
        return tickets;
    }

    public boolean deleteTicket(Long id){
        tickets.remove(id);
        return true;
    }

    public boolean updateTicket(Long id, Ticket updatedTicket) {
        return true;
    }

}
