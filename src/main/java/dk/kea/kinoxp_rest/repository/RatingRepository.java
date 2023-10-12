package dk.kea.kinoxp_rest.repository;

import dk.kea.kinoxp_rest.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer>
{
}
