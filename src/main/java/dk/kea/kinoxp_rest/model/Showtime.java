package dk.kea.kinoxp_rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showtime_ID;

    @Column(name="show_date")
    private LocalDate date;

    @Column(name="show_time")
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "movie_idfk")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theater_idfk")
    @JsonBackReference
    private Theater theater;
}

