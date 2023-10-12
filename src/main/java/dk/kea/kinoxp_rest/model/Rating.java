package dk.kea.kinoxp_rest.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rating
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rating_ID;
    private int rating_value;

    @ManyToOne
    @JoinColumn(name = "movie_idfk")
    private Movie movie;
    @OneToOne
    @JoinColumn(name = "ticket_idfk")
    private Ticket ticket;
}
