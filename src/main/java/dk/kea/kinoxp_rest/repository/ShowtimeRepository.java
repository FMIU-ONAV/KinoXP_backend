package dk.kea.kinoxp_rest.repository;

import dk.kea.kinoxp_rest.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {
}
