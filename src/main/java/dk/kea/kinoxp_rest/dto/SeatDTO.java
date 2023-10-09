package dk.kea.kinoxp_rest.dto;

import dk.kea.kinoxp_rest.model.Theater;

public record SeatDTO(int seat_ID, String seat_number, boolean isReserved, Theater theater, double seat_Price) {

}
