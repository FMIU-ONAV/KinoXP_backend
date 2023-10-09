package dk.kea.kinoxp_rest.controller;

import dk.kea.kinoxp_rest.dto.SeatDTO;
import dk.kea.kinoxp_rest.dto.TheaterDTO;
import dk.kea.kinoxp_rest.service.SeatService;
import dk.kea.kinoxp_rest.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@CrossOrigin
@RestController
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @GetMapping("/theater")
    public ResponseEntity<List<TheaterDTO>> getAllBySeatsID(){
        System.out.println("con");
        List<TheaterDTO> allTheaters = theaterService.getAllTheaters();
        System.out.println(allTheaters);
        System.out.println(theaterService.getAllTheaters());
        return new ResponseEntity<>(allTheaters, HttpStatus.OK);
    }


    @GetMapping("/theater/{id}")
    public ResponseEntity<TheaterDTO> getTheaterByID(@PathVariable("id") int id){
        TheaterDTO theaterDTO = theaterService.getTheater(id);
        System.out.println(theaterDTO);
        System.out.println(theaterService.getTheater(id));
        return ResponseEntity.ok(theaterDTO);
    }
}
