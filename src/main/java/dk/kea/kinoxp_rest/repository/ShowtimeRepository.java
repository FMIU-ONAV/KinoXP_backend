package dk.kea.kinoxp_rest.repository;

import dk.kea.kinoxp_rest.model.Movie;
import dk.kea.kinoxp_rest.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {

    @Query("SELECT s FROM Showtime s WHERE s.date = :date AND s.time = :time AND s.theater.theater_ID = :theaterId")
    Optional<Showtime> findDateAndTime(LocalDate date, LocalTime time, int theaterId);


    @Query("SELECT s FROM Showtime s WHERE s.movie.movie_ID = :movieId")
    List<Showtime> findShowtimesByMovieId(@Param("movieId") int movieId);

    @Query("SELECT s FROM Showtime s WHERE s.movie.movie_ID = :movieId AND s.date = :date AND s.time = :time")
    Showtime findByMovieIDAndDateAndTime(int movieId, LocalDate date, LocalTime time);




}
