package dk.kea.kinoxp_rest.repository;

import dk.kea.kinoxp_rest.dto.SeatDTO;
import dk.kea.kinoxp_rest.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SeatRepository  extends JpaRepository<Seat, Integer> {

    @Query("SELECT s FROM Seat s WHERE s.showtime.showtime_ID = :showtimeId")
    List<Seat> findSeatsByShowtimeId(int showtimeId);

    @Query("SELECT s FROM Seat s WHERE s.seat_number = :SeatNumber AND s.showtime.showtime_ID = :ShowtimeId")
    Seat findBySeat_numberAndShowtimeId(String SeatNumber, int ShowtimeId);

}
