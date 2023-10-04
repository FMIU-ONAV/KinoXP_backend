package dk.kea.kinoxp_rest.dto;

import dk.kea.kinoxp_rest.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter {
    public Movie toEntity(MovieDTO movieDTO){
        return new Movie(
                movieDTO.id(),
                movieDTO.title(),
                movieDTO.director(),
                movieDTO.description(),
                movieDTO.imgRef(),
                movieDTO.ageLimit(),
                movieDTO.duration(),
                movieDTO.categories()
        );
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
