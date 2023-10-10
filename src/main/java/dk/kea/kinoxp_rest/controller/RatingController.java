package dk.kea.kinoxp_rest.controller;

import dk.kea.kinoxp_rest.model.Rating;
import dk.kea.kinoxp_rest.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RatingController
{
    @Autowired
    RatingService ratingService;

    @PostMapping("/rating")
    public ResponseEntity<Rating> postRating(@RequestBody Rating rating) {

        Rating createdRating = ratingService.saveRating(rating);

        return new ResponseEntity<>(createdRating, HttpStatus.CREATED);

    }




}
