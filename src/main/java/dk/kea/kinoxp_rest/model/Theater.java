package dk.kea.kinoxp_rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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
    private int theaterID;
    private int totalRows;
    private int totalSeatsPerRow;

}
