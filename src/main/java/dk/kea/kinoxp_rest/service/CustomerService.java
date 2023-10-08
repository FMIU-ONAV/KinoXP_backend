package dk.kea.kinoxp_rest.service;

import dk.kea.kinoxp_rest.dto.CustomerConverter;
import dk.kea.kinoxp_rest.dto.CustomerDTO;
import dk.kea.kinoxp_rest.model.Customer;
import dk.kea.kinoxp_rest.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
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
        return customerRepository.findById(id)
                .map(customerConverter::toDTO)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO){
        System.out.println("In the service, converting DTO to entity and saving: " + customerDTO);
        Customer customerToSave = customerConverter.toEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customerToSave);
        return customerConverter.toDTO(savedCustomer);
    }

}
