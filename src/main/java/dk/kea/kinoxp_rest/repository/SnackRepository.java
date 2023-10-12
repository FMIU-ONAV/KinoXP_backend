package dk.kea.kinoxp_rest.repository;

import dk.kea.kinoxp_rest.model.Movie;
import dk.kea.kinoxp_rest.model.Snack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnackRepository extends JpaRepository<Snack, Integer> {
}
