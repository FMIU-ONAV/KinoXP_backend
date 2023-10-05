package dk.kea.kinoxp_rest.service;

import dk.kea.kinoxp_rest.dto.MovieConverter;
import dk.kea.kinoxp_rest.dto.MovieDTO;
import dk.kea.kinoxp_rest.model.Movie;
import dk.kea.kinoxp_rest.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieConverter movieConverter;

    @Autowired
    public MovieService(MovieRepository movieRepository, MovieConverter movieConverter){
        this.movieRepository = movieRepository;
        this.movieConverter = movieConverter;
    }

    public MovieDTO createMovie(MovieDTO movieDTO){
        Movie movieToSave = movieConverter.toEntity(movieDTO);

        // ensure its a create
        movieToSave.setMovie_ID(0);
        Movie savedMovie = movieRepository.save(movieToSave);

        return movieConverter.toDTO(savedMovie);
    }

    public List<MovieDTO> getAllMovies(){
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(movieConverter::toDTO).toList();
    }
}
