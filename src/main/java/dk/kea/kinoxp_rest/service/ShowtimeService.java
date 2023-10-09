package dk.kea.kinoxp_rest.service;
import dk.kea.kinoxp_rest.model.Movie;
import dk.kea.kinoxp_rest.model.Showtime;
import dk.kea.kinoxp_rest.repository.MovieRepository;
import dk.kea.kinoxp_rest.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowtimeService {
    private final ShowtimeRepository showtimeRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public ShowtimeService(ShowtimeRepository showtimeRepository, MovieRepository movieRepository){
        this.showtimeRepository = showtimeRepository;
        this.movieRepository = movieRepository;
    }

    public Showtime createShowtime(Showtime showtime, Movie movie){
        // Add the showtime to the movie
        Optional optionalShowtime = showtimeRepository.findDateAndTime(showtime.getDate(), showtime.getTime());
        Showtime showtimeToSave = (Showtime) optionalShowtime.orElse(null);

        if (optionalShowtime.isPresent()){
            movie.getShowtimes().add(showtimeToSave);
        } else {
            movie.getShowtimes().add(showtime);
            showtimeRepository.save(showtime);
        }

        // Save the movie after establishing the association
        movieRepository.save(movie);

        return showtime;
    }


}
