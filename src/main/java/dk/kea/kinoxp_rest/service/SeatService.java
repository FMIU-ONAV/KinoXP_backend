package dk.kea.kinoxp_rest.service;
import dk.kea.kinoxp_rest.dto.MovieDTO;
import dk.kea.kinoxp_rest.dto.SeatConverter;
import dk.kea.kinoxp_rest.dto.SeatDTO;
import dk.kea.kinoxp_rest.exception.SeatNotFoundException;
import dk.kea.kinoxp_rest.model.Movie;
import dk.kea.kinoxp_rest.model.Seat;
import dk.kea.kinoxp_rest.repository.SeatRepository;
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
    private final SeatConverter seatConverter;


    public SeatService(SeatRepository seatRepository, SeatConverter seatConverter){
        this.seatRepository = seatRepository;
        this.seatConverter = seatConverter;
    }
    public List<SeatDTO> reserveSeat(List<String> seatNumbers) {
        List<SeatDTO> reservedSeats = new ArrayList<>();
        for (String seatNumber : seatNumbers) {
            Seat set = new Seat();
            set.setSeat_number(seatNumber);
            set.setReserved(true);

            SeatDTO reserveseat = seatConverter.toDTO(set);
            reservedSeats.add(reserveseat);
        }
        System.out.println(reservedSeats);
        return reservedSeats;
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


}
