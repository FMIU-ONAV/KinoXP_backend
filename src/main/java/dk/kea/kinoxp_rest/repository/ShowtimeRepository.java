package dk.kea.kinoxp_rest.repository;

import dk.kea.kinoxp_rest.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {

    @Query("SELECT s FROM Showtime s WHERE s.date = :date AND s.time = :time")
    Optional<Showtime> findDateAndTime(LocalDate date, LocalTime time);
}
