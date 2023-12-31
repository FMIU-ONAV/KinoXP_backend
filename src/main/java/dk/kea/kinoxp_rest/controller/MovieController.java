package dk.kea.kinoxp_rest.controller;

import dk.kea.kinoxp_rest.dto.MovieDTO;
import dk.kea.kinoxp_rest.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/movie")
    public ResponseEntity<MovieDTO> postMovie(@RequestBody MovieDTO movieDTO) {
        MovieDTO createdMovie = movieService.createMovie(movieDTO);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @GetMapping("/movie")
    public ResponseEntity getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable int id) {
        MovieDTO movie = movieService.getMovieById(id);
        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/movie/current")
    public ResponseEntity getCurrentMovies() {
        return new ResponseEntity<>(movieService.findAllMoviesFrom7DaysForward(), HttpStatus.OK);
    }

    @GetMapping("/movie/upcoming")
    public ResponseEntity getUpcomingMovies() {
        return new ResponseEntity<>(movieService.findMoviesShowingAfter7Days(), HttpStatus.OK);
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity <String> deleteMovie(@PathVariable("id") int id) {
        movieService.deleteMovieById(id);
        System.out.println("Movie deleted");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/movie/{id}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable("id") int id, @RequestBody MovieDTO movieDTO) {
        MovieDTO updatedMovie = movieService.updateMovie(id, movieDTO);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }
}
