package com.jagrut.taskprioritizer.controller;

import com.jagrut.taskprioritizer.entity.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @PostMapping
    public ResponseEntity<String> addTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok("Ticket added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modifyTicket(
            @PathVariable Long id,
            @RequestBody Ticket ticket) {

        return ResponseEntity.ok("Ticket updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable Long id) {

        return ResponseEntity.ok("Ticket deleted successfully");
    }
}