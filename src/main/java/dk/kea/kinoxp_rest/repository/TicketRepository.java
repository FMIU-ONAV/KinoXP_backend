package dk.kea.kinoxp_rest.repository;

import dk.kea.kinoxp_rest.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>
{
    @Query("SELECT t FROM Ticket t WHERE t.showtime.showtime_ID = :showtimeId")
    List<Ticket> findByShowtimeId(int showtimeId);
}
