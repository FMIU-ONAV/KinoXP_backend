package dk.kea.kinoxp_rest.controller;

import dk.kea.kinoxp_rest.model.Showtime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dk.kea.kinoxp_rest.service.ShowtimeService;

@CrossOrigin
@RestController
public class ShowtimeController {
    @Autowired
    ShowtimeService showtimeService;

    @PostMapping("/showtime")
    public ResponseEntity<Showtime> postShowtime(@RequestBody Showtime showtime){
        Showtime createdShowtime = showtimeService.createShowtime(showtime);
        return new ResponseEntity<>(createdShowtime, HttpStatus.CREATED);
    }

}
