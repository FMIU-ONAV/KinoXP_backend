package dk.kea.kinoxp_rest.model;

import jakarta.persistence.*;
import lombok.*;
import dk.kea.kinoxp_rest.model.Showtime;

import java.time.LocalTime;
import java.util.List;
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
    private int movie_ID;
    private String title;
    private int duration;
    private String director;
    @Column(length = 1000)
    private String description;
    @Column(name="img_ref")
    private String imgRef;
    private int ageLimit;


//    @ManyToMany
//    @JoinTable(name = "Movie_Showtime", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns =
//    @JoinColumn(name = "showtime_id"))

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Movie_Category",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @ManyToMany(mappedBy = "movies")
    private Set<Employee> employees;


    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
    private Statistic statistic;

    public Movie(int id, String title, String director, String description, String imgRef, int ageLimit, int duration, Set<Category> categories) {
        this.movie_ID = id;
        this.title = title;
        this.director = director;
        this.description = description;
        this.imgRef = imgRef;
        this.ageLimit = ageLimit;
        this.duration = duration;
        this.categories = categories;
    }
}
