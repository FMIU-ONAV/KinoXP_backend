package dk.kea.kinoxp_rest.dto;

import dk.kea.kinoxp_rest.model.Category;

import java.time.LocalTime;
import java.util.Set;

public record MovieDTO(int id, String title, String director, String description, String imgRef, int ageLimit, LocalTime duration, Set<Category> categories) {
}
