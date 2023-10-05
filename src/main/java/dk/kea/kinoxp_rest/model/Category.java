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
public class Category
{

    @Id
    private int category_ID;
    private String name;


}
