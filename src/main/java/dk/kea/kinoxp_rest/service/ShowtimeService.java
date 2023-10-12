package dk.kea.kinoxp_rest.service;
import dk.kea.kinoxp_rest.dto.TheaterConverter;
import dk.kea.kinoxp_rest.dto.TheaterDTO;
import dk.kea.kinoxp_rest.exception.ShowtimesNotFoundException;
import dk.kea.kinoxp_rest.model.Movie;
import dk.kea.kinoxp_rest.model.Showtime;
import dk.kea.kinoxp_rest.model.Theater;
import dk.kea.kinoxp_rest.repository.MovieRepository;
import dk.kea.kinoxp_rest.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShowtimeService {
    private final ShowtimeRepository showtimeRepository;
    private final MovieRepository movieRepository;
    private final TheaterConverter theaterConverter;

    @Autowired
    public ShowtimeService(ShowtimeRepository showtimeRepository, MovieRepository movieRepository, TheaterConverter theaterConverter){
        this.showtimeRepository = showtimeRepository;
        this.movieRepository = movieRepository;
        this.theaterConverter = theaterConverter;
    }

    public Showtime createShowtime(Showtime showtime, Movie movie, TheaterDTO theater){
        // Add the showtime to the movie
        Optional<Showtime> optionalShowtime = showtimeRepository.findDateAndTime(showtime.getDate(), showtime.getTime(), theater.theater_ID());
        Showtime showtimeToSave = optionalShowtime.orElse(null);

        if (optionalShowtime.isPresent()){
            movie.getShowtimes().add(showtimeToSave);
        } else {
            showtime.setMovie(movie);
            showtime.setTheater(theaterConverter.toEntity(theater));
            movie.getShowtimes().add(showtime);
            showtimeRepository.save(showtime);
        }

        // Save the movie after establishing the association
        movieRepository.save(movie);

        return showtime;
    }


    public List<Showtime> findAllByMovieID(int movieId) {
        return showtimeRepository.findShowtimesByMovieId(movieId);
    }
    public Showtime findByMovieIDAndDateAndTime(int movieId, LocalDate date, LocalTime time) {
        Optional<Showtime> optionalShowtime = Optional.ofNullable(showtimeRepository.findByMovieIDAndDateAndTime(movieId, date, time));
        return optionalShowtime.orElseThrow(() -> new ShowtimesNotFoundException("Showtime not found with id " + movieId + " and date " + date + " and time " + time));
    }



}
