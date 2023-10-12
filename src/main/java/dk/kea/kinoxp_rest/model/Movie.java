package dk.kea.kinoxp_rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

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
    private String backdropRef;
    private int ageLimit;

    @ManyToMany
    @JoinTable(
            name = "Movie_Category",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @ManyToMany(mappedBy = "movies")
    private Set<User> users;


    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonBackReference("movieTicket")
    private List<Ticket> tickets;

    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
    private Statistic statistic;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonBackReference("movieShowtime")
    private Set<Showtime> showtimes;

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
