package dk.kea.kinoxp_rest.dto;

import java.time.LocalDate;

public record CustomerDTO(int customer_ID, String first_Name, String last_Name, LocalDate birthday, String email) {

}
