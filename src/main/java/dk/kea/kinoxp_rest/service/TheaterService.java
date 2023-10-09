package dk.kea.kinoxp_rest.service;

import dk.kea.kinoxp_rest.dto.TheaterConverter;
import dk.kea.kinoxp_rest.dto.TheaterDTO;
import dk.kea.kinoxp_rest.exception.TheaterNotFoundException;
import dk.kea.kinoxp_rest.model.Theater;
import dk.kea.kinoxp_rest.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TheaterService {


    private final TheaterRepository theaterRepository;


    private final TheaterConverter theaterConverter;

    public TheaterService(TheaterRepository theaterRepository, TheaterConverter theaterConverter) {
        this.theaterRepository = theaterRepository;
        this.theaterConverter = theaterConverter;
    }

    public List<TheaterDTO> getAllTheaters() {
        System.out.println("det virker");
        List<Theater> theaters = theaterRepository.findAll();
        return theaters.stream().map(theaterConverter::toDTO).collect(Collectors.toList());
    }

    public TheaterDTO getTheater(int id) {
        Optional<Theater> theaterDTO = theaterRepository.findById(id);
        if (theaterDTO.isPresent()) {
            return theaterConverter.toDTO(theaterDTO.get());
        } else {
            throw new TheaterNotFoundException("Theater does not exsist" + id);

        }

    }
}
