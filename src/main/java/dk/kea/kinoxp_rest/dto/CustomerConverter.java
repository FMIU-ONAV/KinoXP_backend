package dk.kea.kinoxp_rest.dto;

import dk.kea.kinoxp_rest.model.Customer;
import dk.kea.kinoxp_rest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public Customer toEntity(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setCustomer_ID(customerDTO.customer_ID());
        customer.setFirst_Name(customerDTO.first_Name());
        customer.setLast_Name(customerDTO.last_name());
        customer.setBirthday(customerDTO.birthday());
        customer.setEmail(customerDTO.email());

        return customer;

    }
    /*
        movie.setTitle(movieDTO.title());
        movie.setDirector(movieDTO.director());
        movie.setDescription(movieDTO.description());
        movie.setImgRef(movieDTO.imgRef());
        movie.setAgeLimit(movieDTO.ageLimit());
        movie.setDuration(movieDTO.duration());
        Set<Category> categories = movieDTO.categories().stream()
                .map(categoryDTO -> categoryRepository.findById(categoryDTO.getCategory_ID())
                        .orElseThrow(() -> new IllegalArgumentException("Category with id " + categoryDTO.getCategory_ID() + " not found")))
                .collect(Collectors.toSet());
        System.out.println(categories);
        movie.setCategories(categories);

        return movie;
    }
     */

    public CustomerDTO toDTO(Customer customer){ //Student til StudentDTO
        return new CustomerDTO(
                customer.getCustomer_ID(),
                customer.getFirst_Name(),
                customer.getLast_Name(),
                customer.getBirthday(),
                customer.getEmail()
        );
    }
}

/*

@Component
public class StudentConverter { //StudentDTO til entity
    public Student toEntity(StudentDTO studentDTO){
        return new Student(
                studentDTO.id(),
                studentDTO.name(),
                studentDTO.bornDate(),
                studentDTO.bornTime()
        );
    }

    public StudentDTO toDTO(Student student){ //Student til StudentDTO
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getBornDate(),
                student.getBornTime()
        );
    }
}

 */