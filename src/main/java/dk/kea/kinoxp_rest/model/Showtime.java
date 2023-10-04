package dk.kea.kinoxp_rest.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Showtime
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showtime_ID;
    private LocalTime startTime;
//Movie_id is not foreign key
    @ManyToMany
    @JoinTable(
            name = "movie_showtime",
            joinColumns = @JoinColumn(name = "showtime_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movie> movies;
}
