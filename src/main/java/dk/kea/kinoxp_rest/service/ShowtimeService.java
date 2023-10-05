package dk.kea.kinoxp_rest.service;
import dk.kea.kinoxp_rest.model.Showtime;
import dk.kea.kinoxp_rest.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowtimeService {
    private final ShowtimeRepository showtimeRepository;

    @Autowired
    public ShowtimeService(ShowtimeRepository showtimeRepository){
        this.showtimeRepository = showtimeRepository;
    }

    public Showtime createShowtime(Showtime showtime){
        return showtimeRepository.save(showtime);
    }

}
