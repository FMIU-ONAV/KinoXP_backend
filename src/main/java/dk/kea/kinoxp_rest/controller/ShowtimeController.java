package dk.kea.kinoxp_rest.controller;

import dk.kea.kinoxp_rest.dto.TheaterDTO;
import dk.kea.kinoxp_rest.model.*;
import dk.kea.kinoxp_rest.service.MovieService;
import dk.kea.kinoxp_rest.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dk.kea.kinoxp_rest.service.ShowtimeService;

import java.time.LocalDate;
import java.time.LocalTime;

@CrossOrigin
@RestController
public class ShowtimeController {
    @Autowired
    ShowtimeService showtimeService;
    @Autowired
    MovieService movieService;
    @Autowired
    TheaterService theaterService;

    @PostMapping("/showtime/{movieId}")
    public ResponseEntity<Showtime> postShowtime(@RequestBody Showtime showtime, @PathVariable int movieId, @RequestParam int theaterId){
        // Fetch the movie and theater
        Movie movie = movieService.findById(movieId);
        TheaterDTO theater = theaterService.getTheater(theaterId);

        // Create the showtime
        Showtime createdShowtime = showtimeService.createShowtime(showtime, movie, theater);

        return new ResponseEntity<>(createdShowtime, HttpStatus.CREATED);
    }

    @GetMapping("/showtime/{movieId}")
    public ResponseEntity getAllShowtimesByMovieId(@PathVariable int movieId) {
        return new ResponseEntity<>(showtimeService.findAllByMovieID(movieId), HttpStatus.OK);
    }

    @GetMapping("/showtimes/{movieId}")
    public ResponseEntity getShowtimeByMovieIdAndDateAndTime(@PathVariable int movieId, @RequestParam LocalDate date, @RequestParam LocalTime time) {
        return new ResponseEntity<>(showtimeService.findByMovieIDAndDateAndTime(movieId, date, time), HttpStatus.OK);
    }
}
