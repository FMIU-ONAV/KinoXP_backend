package dk.kea.kinoxp_rest.repository;

import dk.kea.kinoxp_rest.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT DISTINCT m FROM Movie m " +
            "INNER JOIN m.showtimes s " +
            "WHERE s.date BETWEEN CURRENT_DATE AND CURRENT_DATE + 7")
    List<Movie> findAllMoviesFrom7DaysForward();

    @Query("SELECT DISTINCT m FROM Movie m " +
            "LEFT JOIN m.showtimes s " +
            "WHERE s.date >= CURRENT_DATE + 8 AND s.date <= CURRENT_DATE + 90")
    List<Movie> findMoviesShowingAfter7Days();
}
