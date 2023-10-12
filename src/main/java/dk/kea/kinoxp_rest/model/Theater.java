package dk.kea.kinoxp_rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Theater
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int theater_ID;
    private int total_rows;
    private int total_Seat_Per_Row;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @JsonBackReference("theaterShowtime")
    private List<Showtime> showtimes;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @JsonBackReference("theaterSeat")
    private List<Seat> seats;
}


