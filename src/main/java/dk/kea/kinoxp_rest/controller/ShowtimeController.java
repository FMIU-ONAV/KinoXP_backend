package dk.kea.kinoxp_rest.controller;

import dk.kea.kinoxp_rest.model.Movie;
import dk.kea.kinoxp_rest.model.Showtime;
import dk.kea.kinoxp_rest.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dk.kea.kinoxp_rest.service.ShowtimeService;

@CrossOrigin
@RestController
public class ShowtimeController {
    @Autowired
    ShowtimeService showtimeService;
    @Autowired
    MovieService movieService;

    @PostMapping("/showtime/{movieId}")
    public ResponseEntity<Showtime> postShowtime(@RequestBody Showtime showtime, @PathVariable int movieId){
        // Fetch the movie
        Movie movie = movieService.findById(movieId);

        // Create the showtime
        Showtime createdShowtime = showtimeService.createShowtime(showtime, movie);

        return new ResponseEntity<>(createdShowtime, HttpStatus.CREATED);
    }
}
