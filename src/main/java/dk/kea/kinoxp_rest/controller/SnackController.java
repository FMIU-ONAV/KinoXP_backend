package dk.kea.kinoxp_rest.controller;

import dk.kea.kinoxp_rest.dto.SeatDTO;
import dk.kea.kinoxp_rest.dto.SnackDTO;
import dk.kea.kinoxp_rest.service.SnackService;
import dk.kea.kinoxp_rest.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SnackController {

    @Autowired
    SnackService snackService;

    @PostMapping("/snacks")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<SnackDTO>> reserveSeats(@RequestBody List<SnackDTO> snackDTOS) {
        List<SnackDTO> snackmenu = snackService.saveSnack(snackDTOS);
        System.out.println(snackDTOS);
        System.out.println(snackmenu);
        return new ResponseEntity<>(snackmenu, HttpStatus.OK);
    }

}
