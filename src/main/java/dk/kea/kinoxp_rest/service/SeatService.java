package dk.kea.kinoxp_rest.service;
import dk.kea.kinoxp_rest.dto.SeatConverter;
import dk.kea.kinoxp_rest.dto.SeatDTO;
import dk.kea.kinoxp_rest.dto.TheaterConverter;
import dk.kea.kinoxp_rest.exception.SeatNotFoundException;
import dk.kea.kinoxp_rest.model.Seat;
import dk.kea.kinoxp_rest.repository.SeatRepository;
import dk.kea.kinoxp_rest.repository.ShowtimeRepository;
import dk.kea.kinoxp_rest.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeatService {

    @Autowired
    private final SeatRepository seatRepository;

    @Autowired
    private final TheaterRepository theaterRepository;

    @Autowired
    private final SeatConverter seatConverter;

    @Autowired
    private final TheaterConverter theaterConverter;

    @Autowired
    private final ShowtimeRepository showtimeRepository;

    public SeatService(SeatRepository seatRepository, TheaterRepository theaterRepository, SeatConverter seatConverter, TheaterConverter theaterConverter, ShowtimeRepository showtimeRepository){
        this.seatRepository = seatRepository;
        this.theaterRepository = theaterRepository;
        this.seatConverter = seatConverter;
        this.theaterConverter = theaterConverter;
        this.showtimeRepository = showtimeRepository;
    }
    public SeatDTO reserveSeat(SeatDTO seatDTO) {
        Seat seatToUpdate = seatConverter.toEntity(seatDTO);
        // Ensure it's the id from the path that is updated
        seatToUpdate.setSeat_ID(seatDTO.seat_ID());
        // Update the showtime in the seat
        int showtimeID = seatDTO.showtime().getShowtime_ID();
        seatToUpdate.setShowtime(showtimeRepository.findById(showtimeID).get());
        Seat savedSeat = seatRepository.save(seatToUpdate);
        return seatConverter.toDTO(savedSeat);
    }


  /*  public SeatDTO reserveSeat(SeatDTO seatDTO){
        Seat seatToSave = seatConverter.toEntity(seatDTO);
        // ensure its a create
        seatToSave.setSeat_ID(0);
        Seat savedSeat = seatRepository.save(seatToSave);
        return seatConverter.toDTO(savedSeat);
    }
*/
    public List<SeatDTO> getAllSeatID(){
        List<Seat>seats = seatRepository.findAll();
        return seats.stream()
                .map(seatConverter::toDTO)
                .collect(Collectors.toList());
    }




    public SeatDTO updateSeat(int id, SeatDTO seatDTO) {
        Optional<Seat> existingSeat = seatRepository.findById(id);
        if(existingSeat.isPresent()){
            Seat seatToUpdate = seatConverter.toEntity(seatDTO);
            //Ensure it's the id from the path that is updated
            seatToUpdate.setSeat_ID(id);
            Seat savedSeat = seatRepository.save(seatToUpdate);
            return seatConverter.toDTO(savedSeat);
        } else {
            throw new SeatNotFoundException("Seat not found" + id);
        }
    }

    public SeatDTO updateSeatReservation(int id, SeatDTO seatDTO) {
        Optional<Seat> existingSeat = seatRepository.findById(id);
        if (existingSeat.isPresent()) {
            Seat seatToUpdate = existingSeat.get();

            // Update the isReserved field based on the boolean value received
            if (seatDTO.isReserved()) {
                seatToUpdate.setReserved(true);
            } else {
                seatToUpdate.setReserved(false);
            }

            Seat savedSeat = seatRepository.save(seatToUpdate);
            return seatConverter.toDTO(savedSeat);
        } else {
            throw new SeatNotFoundException("Seat not found" + id);
        }
    }

    public List<SeatDTO> getSeatsByShowtimeId(int showtimeId) {
        List<Seat> seats = seatRepository.findSeatsByShowtimeId(showtimeId);
        return seats.stream()
                .map(seatConverter::toDTO)
                .collect(Collectors.toList());
    }


}
