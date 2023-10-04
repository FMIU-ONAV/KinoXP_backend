package dk.kea.kinoxp_rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Statistic
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statistic_ID;
    private int tickets_Sold;
    private int movie_ID;

    @OneToOne
    @JoinColumn(name = "movie_idfk", referencedColumnName = "movie_id", nullable = false)
//@JsonManagedReference
    private Movie movie;


}
