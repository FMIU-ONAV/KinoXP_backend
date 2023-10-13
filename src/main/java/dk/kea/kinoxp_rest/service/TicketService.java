package dk.kea.kinoxp_rest.service;

import dk.kea.kinoxp_rest.model.Movie;
import dk.kea.kinoxp_rest.model.Showtime;
import dk.kea.kinoxp_rest.model.Ticket;
import dk.kea.kinoxp_rest.repository.MovieRepository;
import dk.kea.kinoxp_rest.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService
{
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowtimeService showtimeService;

    @Autowired
    MovieRepository movieRepository;

    public Ticket findById(int id){
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        return optionalTicket.orElse(null);
    }

    public Ticket createTicket(Ticket ticket) {
        System.out.println("Movie ID: " + ticket.getMovie().getMovie_ID());
        Optional<Movie> movieOptional = movieRepository.findById(ticket.getMovie().getMovie_ID());
        if (movieOptional.isPresent()) {
            ticket.setMovie(movieOptional.get());
            return ticketRepository.save(ticket);
        } else {
            throw new IllegalArgumentException("Movie not found with id: " + ticket.getMovie().getMovie_ID());
        }
    }

    public List<Ticket> findByShowtimeId(int showtimeId){
        return ticketRepository.findByShowtimeId(showtimeId);
    }


    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }
}
