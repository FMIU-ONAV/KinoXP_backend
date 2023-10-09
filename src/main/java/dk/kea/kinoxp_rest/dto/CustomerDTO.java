package dk.kea.kinoxp_rest.dto;

import java.time.LocalDate;

public record CustomerDTO(int customer_ID, String first_Name, String last_Name, LocalDate birthday, String email) {

}
/*
  private int customer_ID;
    private String first_Name;
    private String last_Name;
    private LocalDate birthday;
    private String email;
 */