package dk.kea.kinoxp_rest.service;

import dk.kea.kinoxp_rest.dto.MovieConverter;
import dk.kea.kinoxp_rest.dto.MovieDTO;
import dk.kea.kinoxp_rest.exception.MovieNotFoundException;
import dk.kea.kinoxp_rest.model.Category;
import dk.kea.kinoxp_rest.model.Movie;
import dk.kea.kinoxp_rest.repository.CategoryRepository;
import dk.kea.kinoxp_rest.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieConverter movieConverter;
    private final CategoryRepository categoryRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, MovieConverter movieConverter, CategoryRepository categoryRepository){
        this.movieRepository = movieRepository;
        this.movieConverter = movieConverter;
        this.categoryRepository = categoryRepository;
    }

    public MovieDTO createMovie(MovieDTO movieDTO){
        Movie movieToSave = movieConverter.toEntity(movieDTO);

        // ensure its a create
        movieToSave.setMovie_ID(0);

        // Set categories to existing entities from the database
        Set<Category> categories = new HashSet<>();
        for (Category category : movieToSave.getCategories()) {
            Optional<Category> categoryOptional = categoryRepository.findById(category.getCategory_ID());
            categoryOptional.ifPresent(categories::add);
        }
        movieToSave.setCategories(categories);

        Movie savedMovie = movieRepository.save(movieToSave);

        return movieConverter.toDTO(savedMovie);
    }


    public List<MovieDTO> getAllMovies(){
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(movieConverter::toDTO).toList();
    }

    public List<MovieDTO> findAllMoviesFrom7DaysForward() {
        List<Movie> movies = movieRepository.findAllMoviesFrom7DaysForward();
        return movies.stream().map(movieConverter::toDTO).toList();
    }

    public List<MovieDTO> findMoviesShowingAfter7Days() {
        List<Movie> movies = movieRepository.findMoviesShowingAfter7Days();
        return movies.stream().map(movieConverter::toDTO).toList();
    }


    public MovieDTO getMovieById(int id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        return optionalMovie.map(movieConverter::toDTO).orElse(null);
    }

    public Movie findById(int id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        return optionalMovie.orElse(null);
    }

    public void deleteMovieById(int id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            movieRepository.deleteById(id);
        } else {
            throw new MovieNotFoundException("Movie not found" + id);
        }
    }
    public MovieDTO updateMovie(int id, MovieDTO movieDTO) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieDTO.movie_ID());
        if (optionalMovie.isPresent()) {
           Movie movieToUpdate = movieConverter.toEntity(movieDTO);
           movieToUpdate.setMovie_ID(id);
           movieRepository.save(movieToUpdate);
           return movieConverter.toDTO(movieToUpdate);
        } else {
            throw new MovieNotFoundException("Movie not found" + movieDTO.movie_ID());
        }
    }

}
