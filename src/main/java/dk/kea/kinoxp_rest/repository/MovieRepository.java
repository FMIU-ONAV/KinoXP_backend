package dk.kea.kinoxp_rest.repository;

import dk.kea.kinoxp_rest.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
