package dk.kea.kinoxp_rest.dto;

import dk.kea.kinoxp_rest.model.Seat;
import org.springframework.stereotype.Component;
@Component
public class SeatConverter {

    public Seat toEntity(SeatDTO seatDTO) {
        Seat seat = new Seat();
        seat.setSeat_ID(seatDTO.seat_ID());
        seat.setSeat_number(seatDTO.seat_number());
        seat.setReserved(seatDTO.isReserved());
        seat.setTheater(seatDTO.theater());
        seat.setSeat_Price(seatDTO.seat_Price());

        return seat;
    }



    public SeatDTO toDTO(Seat seat) {
        return new SeatDTO(
                seat.getSeat_ID(),
                seat.getSeat_number(),
                        seat.isReserved(),
                        seat.getTheater(),
                seat.getSeat_Price());
    }
}
