package dk.kea.kinoxp_rest.service;

import dk.kea.kinoxp_rest.model.Movie;
import dk.kea.kinoxp_rest.model.Ticket;
import dk.kea.kinoxp_rest.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService
{
    @Autowired
    TicketRepository ticketRepository;

    public Ticket findById(int id){
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        return optionalTicket.orElse(null);
    }
}
