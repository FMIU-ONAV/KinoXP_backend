package dk.kea.kinoxp_rest.controller;

import dk.kea.kinoxp_rest.dto.CustomerDTO;
import dk.kea.kinoxp_rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerDTO> postCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = customerService.createCustomer(customerDTO);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") int id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerDTO);

    }
}
