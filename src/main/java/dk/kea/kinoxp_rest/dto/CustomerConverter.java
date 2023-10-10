package dk.kea.kinoxp_rest.dto;

import dk.kea.kinoxp_rest.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public Customer toEntity(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setCustomer_ID(customerDTO.customer_ID());
        customer.setFirst_Name(customerDTO.first_Name());
        customer.setLast_Name(customerDTO.last_Name());
        customer.setBirthday(customerDTO.birthday());
        customer.setEmail(customerDTO.email());

        return customer;

    }

    public CustomerDTO toDTO(Customer customer){
        return new CustomerDTO(
                customer.getCustomer_ID(),
                customer.getFirst_Name(),
                customer.getLast_Name(),
                customer.getBirthday(),
                customer.getEmail()
        );
    }
}

