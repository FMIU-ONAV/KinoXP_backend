package dk.kea.kinoxp_rest.dto;

import dk.kea.kinoxp_rest.model.SnackType;

public record SnackDTO(int snack_ID, SnackType snackType, int price, int ticket_ID) {
}
