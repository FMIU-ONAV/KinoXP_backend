package dk.kea.kinoxp_rest.model;

import jakarta.persistence.*;
import lombok.*;
import dk.kea.kinoxp_rest.model.Showtime;

import java.time.LocalTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieID;
    private String title;
    private LocalTime duration;
    private String director;
    private String description;
    private String imgRef;
    private int ageLimit;


//    @ManyToMany
//    @JoinTable(name = "Movie_Showtime", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns =
//    @JoinColumn(name = "showtime_id"))

@ManyToMany(mappedBy = "movies")
private Set<Showtime> showtimes;


    @ManyToMany(mappedBy = "movies")
    private Set<Category> categories;

    @ManyToMany(mappedBy = "movies")
    private Set<Employee> employees;
}
