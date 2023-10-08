package dk.kea.kinoxp_rest.dto;

public record SeatDTO(int seat_ID, String seat_number, boolean isReserved, int theater_ID) {
}
