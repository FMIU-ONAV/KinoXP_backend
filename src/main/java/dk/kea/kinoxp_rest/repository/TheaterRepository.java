package dk.kea.kinoxp_rest.repository;

import dk.kea.kinoxp_rest.model.Seat;
import dk.kea.kinoxp_rest.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {
}
