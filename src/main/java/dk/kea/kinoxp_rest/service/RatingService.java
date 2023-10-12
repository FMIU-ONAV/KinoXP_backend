package dk.kea.kinoxp_rest.service;

import dk.kea.kinoxp_rest.model.Rating;
import dk.kea.kinoxp_rest.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService
{
    @Autowired
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository)
    {
        this.ratingRepository = ratingRepository;
    }

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }
}
