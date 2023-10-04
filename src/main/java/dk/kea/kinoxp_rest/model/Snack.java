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
public class Snack
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int snackID;
    private Enum snackType;
    private int ticketID;
}
