package com.jagrut.taskprioritizer.controller;

import com.jagrut.taskprioritizer.entity.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController //Controller + Response Body
//Meaning:
//handles HTTP requests
//returns JSON automatically
@RequestMapping("/tickets")
public class TicketController {

    @PostMapping()
    public boolean addTicket (@RequestBody Ticket ticket)
    {

        return true;
    }

    @PutMapping
    public boolean modifyTicket (@RequestBody Ticket ticket)
    {
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean deleteTicket (@PathVariable Long ticketId){
        return true;
    }


}
