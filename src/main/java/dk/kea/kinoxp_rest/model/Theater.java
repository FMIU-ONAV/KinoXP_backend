package dk.kea.kinoxp_rest.model;

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


    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "theater")
  //  private List<Seat> seats;


   /* @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    private List<Showtime> showtime;*/



}
