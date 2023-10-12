package dk.kea.kinoxp_rest.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seat_ID;
    private String seat_number;
    private boolean isReserved;
    private double seat_Price;
    //private int theater_ID;

    @ManyToOne
    @JoinColumn(name = "theater_idfk")
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "showtime_idfk")
    @JsonIgnore
    private Showtime showtime;

   /* @ManyToOne
    @JoinColumn(name = "showtime_idfk")
    private Showtime showtime;*/


}
