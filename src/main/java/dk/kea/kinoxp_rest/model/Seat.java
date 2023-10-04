package dk.kea.kinoxp_rest.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Seat
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seat_ID;
    private String seat;
    private boolean isReserved;
    private int theater_ID;


    @OneToOne (cascade = CascadeType.ALL, mappedBy = "seat")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "theater_idfk")
    private Theater theater;



}
