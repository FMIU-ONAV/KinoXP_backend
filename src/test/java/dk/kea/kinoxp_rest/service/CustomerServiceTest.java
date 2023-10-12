package dk.kea.kinoxp_rest.service;

import dk.kea.kinoxp_rest.dto.CustomerConverter;
import dk.kea.kinoxp_rest.dto.CustomerDTO;
import dk.kea.kinoxp_rest.model.Customer;
import dk.kea.kinoxp_rest.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerConverter customerConverter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCustomersTest() {
        Customer customer = new Customer();
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer));

        CustomerDTO customerDTO = new CustomerDTO(1, "John", "Doe", LocalDate.of(2002, 9, 2), "john.doe@example.com");

        when(customerConverter.toDTO(customer)).thenReturn(customerDTO);

        assertEquals(1, customerService.getAllCustomers().size());
        assertEquals(customerDTO, customerService.getAllCustomers().get(0));
    }

    @Test
    void getCustomerByIdTest() {
        Customer customer = new Customer();
        int id = 1;
        when(customerRepository.findById(id)).thenReturn(Optional.of(customer));

        CustomerDTO customerDTO = new CustomerDTO(1, "John", "Doe", LocalDate.of(2002, 9, 2), "john.doe@example.com");
        when(customerConverter.toDTO(customer)).thenReturn(customerDTO);

        assertEquals(customerDTO, customerService.getCustomerById(id));
    }
}
