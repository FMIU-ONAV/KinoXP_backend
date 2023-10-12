package dk.kea.kinoxp_rest.repository;

import dk.kea.kinoxp_rest.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>
{
}
