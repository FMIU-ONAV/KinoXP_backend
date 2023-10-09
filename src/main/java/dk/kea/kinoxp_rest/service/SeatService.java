package dk.kea.kinoxp_rest.service;
import dk.kea.kinoxp_rest.dto.SeatConverter;
import dk.kea.kinoxp_rest.dto.SeatDTO;
import dk.kea.kinoxp_rest.dto.TheaterConverter;
import dk.kea.kinoxp_rest.exception.SeatNotFoundException;
import dk.kea.kinoxp_rest.model.Seat;
import dk.kea.kinoxp_rest.repository.SeatRepository;
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

    public SeatService(SeatRepository seatRepository, TheaterRepository theaterRepository, SeatConverter seatConverter, TheaterConverter theaterConverter){
        this.seatRepository = seatRepository;
        this.theaterRepository = theaterRepository;
        this.seatConverter = seatConverter;
        this.theaterConverter = theaterConverter;
    }
    public List<SeatDTO> reserveSeat(List<SeatDTO> seats) {
        List<Seat> saveSeats = new ArrayList<>();

        for (SeatDTO seat : seats) {
          /*  Seat set = new Seat();
            set.setSeat_number(seat.seat_number());
            set.setReserved(true);
            set.setTheater(theaterRepository.findById(set.getTheater_ID()));

           */

          //  SeatDTO reserveseat = seatConverter.toDTO(seat);
            Seat seatToSave = seatConverter.toEntity(seat);
            saveSeats.add(seatToSave);
        }

        System.out.println(saveSeats);
        return saveSeats.stream().map(seatConverter::toDTO).collect(Collectors.toList());
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
