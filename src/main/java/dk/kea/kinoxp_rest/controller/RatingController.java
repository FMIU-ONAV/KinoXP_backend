package dk.kea.kinoxp_rest.controller;

import dk.kea.kinoxp_rest.model.Rating;
import dk.kea.kinoxp_rest.model.Ticket;
import dk.kea.kinoxp_rest.service.RatingService;
import dk.kea.kinoxp_rest.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RatingController
{
    @Autowired
    RatingService ratingService;
    @Autowired
    TicketService ticketService;

    @PostMapping("/rating")
    public ResponseEntity<?> postRating(@RequestBody Rating rating) {
        // Check if the ticket with the given ID exists
        Ticket ticket = ticketService.findById(rating.getTicket().getTicket_ID());

        if (ticket != null) {
            // Ticket exists, proceed with rating submission
            Rating createdRating = ratingService.saveRating(rating);
            return new ResponseEntity<>(createdRating, HttpStatus.CREATED);
        } else {
            // Ticket doesn't exist, return an error response
            return new ResponseEntity<>("Ticket not found", HttpStatus.NOT_FOUND);
        }

    }




}
