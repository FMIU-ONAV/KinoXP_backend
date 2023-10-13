package dk.kea.kinoxp_rest.controller;

import dk.kea.kinoxp_rest.model.Showtime;
import dk.kea.kinoxp_rest.model.Ticket;
import dk.kea.kinoxp_rest.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/ticket")
    public ResponseEntity createTicket(@RequestBody Ticket ticket){
        Ticket createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.ok(createdTicket);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") int id){
        Ticket ticket = ticketService.findById(id);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/ticket")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> tickets = ticketService.findAll();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/ticket/showtime/{id}")
    public ResponseEntity<List<Ticket>> getTicketsByShowtimeId(@PathVariable("id") int id){
        List<Ticket> tickets = ticketService.findByShowtimeId(id);
        return ResponseEntity.ok(tickets);
    }
}
