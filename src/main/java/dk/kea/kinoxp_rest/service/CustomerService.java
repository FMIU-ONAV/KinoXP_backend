package dk.kea.kinoxp_rest.service;

import dk.kea.kinoxp_rest.dto.CustomerConverter;
import dk.kea.kinoxp_rest.dto.CustomerDTO;
import dk.kea.kinoxp_rest.model.Customer;
import dk.kea.kinoxp_rest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    @Autowired
    public CustomerService(CustomerRepository customerRepository,
                           CustomerConverter customerConverter){
        this.customerRepository = customerRepository;
        this.customerConverter = customerConverter;
    }

    public List<CustomerDTO> getAllCustomers(){
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerConverter::toDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(int id){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            return customerConverter.toDTO(optionalCustomer.get());
        } else{
            throw new CustomerNotFoundException("Customer not found with id: " + id);
        }
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO){
        Customer customerToSave = customerConverter.toEntity(customerDTO);
        // ensure it's a create
        customerToSave.setCustomer_ID(0);
        Customer savedCustomer = customerRepository.save(customerToSave);
        return customerConverter.toDTO(savedCustomer);
    }

}
