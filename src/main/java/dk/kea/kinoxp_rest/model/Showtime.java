package dk.kea.kinoxp_rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalTime;

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
    private int showtimeID;
    private LocalTime startTime;
}
