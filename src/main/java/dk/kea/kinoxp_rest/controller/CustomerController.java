package dk.kea.kinoxp_rest.controller;

import dk.kea.kinoxp_rest.dto.CustomerDTO;
import dk.kea.kinoxp_rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomer(){
        List<CustomerDTO> customersDTOList = customerService.getAllCustomers();
        System.out.println(customersDTOList);
        return new ResponseEntity<>(customersDTOList, HttpStatus.OK);
    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println("Attempting to save customer: " + customerDTO);
        CustomerDTO createdCustomer = customerService.createCustomer(customerDTO);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") int id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerDTO);

    }
}
