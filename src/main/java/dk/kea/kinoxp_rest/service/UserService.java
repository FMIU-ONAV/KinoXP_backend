package dk.kea.kinoxp_rest.service;

import dk.kea.kinoxp_rest.config.SecurityConfiguration;
import dk.kea.kinoxp_rest.model.Role;
import dk.kea.kinoxp_rest.model.User;
import dk.kea.kinoxp_rest.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Set<User> findAll() {
        return new HashSet<>(userRepository.findAll());
    }

    @Override
    public User save(User user) {
//        if(user.getPassword() == null) {
            PasswordEncoder pw = SecurityConfiguration.passwordEncoder();
            user.setPassword(pw.encode(user.getPassword()));
//        }
        return userRepository.save(user);
    }

    @Override
    public void delete(User object) {
            userRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<User> findById(Long aLong) {
        return userRepository.findById(aLong);
    }

    @Override
    public List<User> findByName(String name) {
        System.out.println("Userservice called findByName with argument: " + name);
        return userRepository.findByUsername(name);
    }
}
