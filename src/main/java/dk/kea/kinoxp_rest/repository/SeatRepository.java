package dk.kea.kinoxp_rest.repository;

import dk.kea.kinoxp_rest.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SeatRepository  extends JpaRepository<Seat, Integer> {


}
