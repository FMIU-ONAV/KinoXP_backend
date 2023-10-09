package dk.kea.kinoxp_rest.dto;

import dk.kea.kinoxp_rest.model.Category;
import dk.kea.kinoxp_rest.model.Movie;
import dk.kea.kinoxp_rest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MovieConverter {
    @Autowired
    CategoryRepository categoryRepository;
    public Movie toEntity(MovieDTO movieDTO){
        Movie movie = new Movie();
        movie.setTitle(movieDTO.title());
        movie.setDirector(movieDTO.director());
        movie.setDescription(movieDTO.description());
        movie.setImgRef(movieDTO.imgRef());
        movie.setBackdropRef(movieDTO.backdropRef());
        movie.setAgeLimit(movieDTO.ageLimit());
        movie.setDuration(movieDTO.duration());
        Set<Category> categories = movieDTO.categories().stream()
                .map(categoryDTO -> categoryRepository.findById(categoryDTO.getCategory_ID())
                        .orElseThrow(() -> new IllegalArgumentException("Category with id " + categoryDTO.getCategory_ID() + " not found")))
                .collect(Collectors.toSet());
        System.out.println(categories);
        movie.setCategories(categories);

        return movie;
    }

    public MovieDTO toDTO(Movie movie){
        return new MovieDTO(
                movie.getMovie_ID(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getDescription(),
                movie.getImgRef(),
                movie.getBackdropRef(),
                movie.getAgeLimit(),
                movie.getDuration(),
                movie.getCategories()
        );
    }
}
