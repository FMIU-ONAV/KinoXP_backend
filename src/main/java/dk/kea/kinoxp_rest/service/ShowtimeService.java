package dk.kea.kinoxp_rest.service;
import dk.kea.kinoxp_rest.model.Movie;
import dk.kea.kinoxp_rest.model.Showtime;
import dk.kea.kinoxp_rest.repository.MovieRepository;
import dk.kea.kinoxp_rest.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        // Save the movie
        movieRepository.save(movie);

        // Add the showtime to the movie
        movie.getShowtimes().add(showtime);

        // Save the showtime
        return showtimeRepository.save(showtime);
    }

}
