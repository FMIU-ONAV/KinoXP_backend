package dk.kea.kinoxp_rest.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Snack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int snack_ID;
    private SnackType snackType;
    private int price;
    private int ticket_ID;



 /*   @OneToOne(cascade = CascadeType.ALL, mappedBy = "snack")
    private Ticket ticket;*/
}

