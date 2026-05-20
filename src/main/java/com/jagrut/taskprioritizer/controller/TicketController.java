package com.jagrut.taskprioritizer.controller;

import com.jagrut.taskprioritizer.entity.Ticket;
import com.jagrut.taskprioritizer.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService ;
    }

    @PostMapping
    public ResponseEntity<String> addTicket(@RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
        return ResponseEntity.ok("Ticket added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modifyTicket(
            @PathVariable Long id,
            @RequestBody Ticket ticket) {

        ticketService.addTicket(ticket);
        return ResponseEntity.ok("Ticket updated successfully");
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {

        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable Long id) {

        ticketService.deleteTicket(id);
        return ResponseEntity.ok("Ticket deleted successfully");
    }
}