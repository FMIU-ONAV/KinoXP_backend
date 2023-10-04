package dk.kea.kinoxp_rest.dto;

import dk.kea.kinoxp_rest.model.Category;
import dk.kea.kinoxp_rest.model.Movie;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MovieConverter {
    public Movie toEntity(MovieDTO movieDTO){
        Movie movie = new Movie();
        movie.setTitle(movieDTO.title());
        movie.setDirector(movieDTO.director());
        movie.setDescription(movieDTO.description());
        movie.setImgRef(movieDTO.imgRef());
        movie.setAgeLimit(movieDTO.ageLimit());
        movie.setDuration(movieDTO.duration());
        movie.setCategories(movieDTO.categories());

        return movie;
    }

    public MovieDTO toDTO(Movie movie){
        return new MovieDTO(
                movie.getMovie_ID(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getDescription(),
                movie.getImgRef(),
                movie.getAgeLimit(),
                movie.getDuration(),
                movie.getCategories()
        );
    }
}
