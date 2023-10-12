package dk.kea.kinoxp_rest.controller;

import dk.kea.kinoxp_rest.dto.SeatDTO;
import dk.kea.kinoxp_rest.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
public class SeatController {

    @Autowired
    SeatService seatService;


    @GetMapping("/seat")
    public ResponseEntity<List<SeatDTO> > getAllSeatsByID(){
        List<SeatDTO> allSeatID = seatService.getAllSeatID();
        System.out.println(allSeatID);
        System.out.println(seatService.getAllSeatID());
        return new ResponseEntity<>(allSeatID, HttpStatus.OK);
    }


    @PostMapping("/seats")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<SeatDTO>> reserveSeats(@RequestBody List<SeatDTO> seatNumbers) {
        List<SeatDTO> reservedSeats = new ArrayList<>();
        for (SeatDTO seatDTO : seatNumbers) {
            SeatDTO updatedSeatDTO = seatService.reserveSeat(seatDTO);
            reservedSeats.add(updatedSeatDTO);
        }
        System.out.println(seatNumbers);
        System.out.println(reservedSeats);
        return new ResponseEntity<>(reservedSeats, HttpStatus.OK);
    }
    /*@PostMapping("/seats")
    public ResponseEntity<SeatDTO> postMovie(@RequestBody SeatDTO seatDTO){
        SeatDTO reserveseat = seatService.reserveSeat(seatDTO);
        return new ResponseEntity<>(reserveseat, HttpStatus.CREATED);
    }
*/

   @PutMapping("/seat/{id}")
    public ResponseEntity<SeatDTO> putSeat(@PathVariable("id") int id, @RequestBody SeatDTO seatDTO){
        SeatDTO updatedSeatDTO = seatService.updateSeat(id, seatDTO);
        return ResponseEntity.ok( updatedSeatDTO);

    }

   /* @PutMapping("/{id}")
    public ResponseEntity<SeatDTO> updateSeatReservation(
            @PathVariable("id") int id,
            @RequestBody SeatDTO seatDTO
    ) {
        SeatDTO updatedSeatDTO = seatService.updateSeatReservation(id, seatDTO);
        return ResponseEntity.ok(updatedSeatDTO);
    }*/

    @GetMapping("/seats/{showtimeId}")
    public ResponseEntity<List<SeatDTO>> getSeatsByShowtimeId(@PathVariable int showtimeId) {
        List<SeatDTO> seats = seatService.getSeatsByShowtimeId(showtimeId);
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    @GetMapping("/seat/{seatNumber}")
    public ResponseEntity<SeatDTO> getSeatBySeatNumber(@PathVariable String seatNumber, @RequestParam int showtimeId){
        SeatDTO seatDTO = seatService.getSeatBySeatNumber(seatNumber, showtimeId);
        return ResponseEntity.ok(seatDTO);
    }

}





