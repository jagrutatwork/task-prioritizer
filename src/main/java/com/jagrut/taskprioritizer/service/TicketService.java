package com.jagrut.taskprioritizer.service;
import com.jagrut.taskprioritizer.entity.Ticket;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TicketService {

    private final Map<Long, Ticket> tickets = new HashMap<>();

    public boolean addTicket(Ticket ticket)
    {
        tickets.put(ticket.getId(),ticket);
        return true;
    }

    public List<Ticket> getAllTickets() {
        return tickets.values().stream().toList();
    }

    public boolean deleteTicket(Long id){
        tickets.remove(id);
        return true;
    }

    public boolean updateTicket(Long id, Ticket updatedTicket) {
        tickets.put(id, updatedTicket);
        return true;
    }

}
