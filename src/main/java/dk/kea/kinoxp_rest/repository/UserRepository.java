package dk.kea.kinoxp_rest.repository;

import dk.kea.kinoxp_rest.model.Role;
import dk.kea.kinoxp_rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByUsername(String name);

    //List<User> findUserByPasswordContains(String passwordPart);
}
