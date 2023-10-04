package dk.kea.kinoxp_rest.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_ID;
    private String first_Name;
    private String last_Name;
    private String user_name;
    private String password;
    private int role;///




    @ManyToMany
    @JoinTable(
            name = "movie_Employee",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private Set<Movie> movies;

}
