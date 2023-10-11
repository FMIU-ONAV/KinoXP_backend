package dk.kea.kinoxp_rest.controller;

import dk.kea.kinoxp_rest.model.User;
import dk.kea.kinoxp_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/admin")
    public ResponseEntity<Set<User>> getUsers() {
        Set<User> userDTOs = userService.findAll(); // Make sure this method returns Set<UserDTO>
        if (!userDTOs.isEmpty()) {
            System.out.println("Controller: getUsers: " + userDTOs.size());
            return new ResponseEntity<>(userDTOs, HttpStatus.OK);
        } else {
            System.out.println("Controller: getUsers: NOTHING FOUND");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.findById(id).orElse(null); // Handle the case when user is not found
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
