package dk.kea.kinoxp_rest.dto;

import dk.kea.kinoxp_rest.model.Seat;
import dk.kea.kinoxp_rest.model.Theater;
import org.springframework.stereotype.Component;

@Component
public class TheaterConverter {

    public Theater toEntity(TheaterDTO theaterDTO) {
        Theater theater = new Theater();
        theater.setTheater_ID(theaterDTO.theater_ID());
        theater.setTotal_rows(theaterDTO.total_rows());
        theater.setTotal_Seat_Per_Row(theaterDTO.total_Seat_Per_Row());
        return theater;
    }


    public TheaterDTO toDTO(Theater theater) {
        return new TheaterDTO(
                theater.getTheater_ID(),
                theater.getTotal_rows(),
                theater.getTotal_Seat_Per_Row());
    }
}
