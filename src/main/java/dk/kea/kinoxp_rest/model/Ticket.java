package dk.kea.kinoxp_rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticket_ID;
    private int customer_ID;
    private int movie_ID;
    private int seat_ID;

    @ManyToOne
    @JoinColumn(name = "customer_idfk")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "movie_idfk")
    private Movie movie;

    @OneToOne
    @JoinColumn(name = "seat_idfk", referencedColumnName = "seat_ID", nullable = false)
   // @JsonBackReference
    private Seat seat;

    @OneToOne(mappedBy = "ticket")
    private Rating rating;


}
