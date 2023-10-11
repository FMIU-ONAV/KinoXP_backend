package dk.kea.kinoxp_rest.config;

import dk.kea.kinoxp_rest.model.Category;
import dk.kea.kinoxp_rest.model.Role;
import dk.kea.kinoxp_rest.model.User;
import dk.kea.kinoxp_rest.repository.CategoryRepository;
import dk.kea.kinoxp_rest.repository.RoleRepository;
import dk.kea.kinoxp_rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class InitData implements CommandLineRunner
{
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        //create roles
        Role role1 = new Role();
        role1.setId(1);
        role1.setName("ROLE_MOVIE_OPERATOR");
        roleRepository.save(role1);
        Role role2 = new Role();
        role2.setId(2);
        role2.setName("ROLE_INSPECTOR");
        roleRepository.save(role2);
        Role role3 = new Role();
        role3.setId(3);
        role3.setName("ROLE_REGISTRANT");
        roleRepository.save(role3);

        //create users
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("operator");
        user1.setPassword(passwordEncoder.encode("123")); // Hash the password
        user1.setFirst_Name("Erik");
        user1.setLast_Name("Jensen");
        user1.setRole(role1);
        userRepository.save(user1);

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("inspector");
        user2.setPassword(passwordEncoder.encode("123")); // Hash the password
        user2.setFirst_Name("Hardy");
        user2.setLast_Name("Buch");
        user2.setRole(role2);
        userRepository.save(user2);

        User user3 = new User();
        user3.setId(3L);
        user3.setUsername("registrant1");
        user3.setPassword(passwordEncoder.encode("123")); // Hash the password
        user3.setFirst_Name("Clara");
        user3.setLast_Name("Pedersen");
        user3.setRole(role3);
        userRepository.save(user3);

        User user4 = new User();
        user4.setId(4L);
        user4.setUsername("registrant2");
        user4.setPassword(passwordEncoder.encode("123")); // Hash the password
        user4.setFirst_Name("Noah");
        user4.setLast_Name("Nielsen");
        user4.setRole(role3);
        userRepository.save(user4);

        //create categories
        Category category1 = new Category();
        category1.setName("Action");
        category1.setCategory_ID(28);
        categoryRepository.save(category1);
        Category category2 = new Category();
        category2.setName("Adventure");
        category2.setCategory_ID(12);
        categoryRepository.save(category2);
        Category category3 = new Category();
        category3.setName("Animation");
        category3.setCategory_ID(16);
        categoryRepository.save(category3);
        Category category4 = new Category();
        category4.setName("Comedy");
        category4.setCategory_ID(35);
        categoryRepository.save(category4);
        Category category5 = new Category();
        category5.setName("Crime");
        category5.setCategory_ID(80);
        categoryRepository.save(category5);
        Category category6 = new Category();
        category6.setName("Documentary");
        category6.setCategory_ID(99);
        categoryRepository.save(category6);
        Category category7 = new Category();
        category7.setName("Drama");
        category7.setCategory_ID(18);
        categoryRepository.save(category7);
        Category category8 = new Category();
        category8.setName("Family");
        category8.setCategory_ID(10751);
        categoryRepository.save(category8);
        Category category9 = new Category();
        category9.setName("Fantasy");
        category9.setCategory_ID(14);
        categoryRepository.save(category9);
        Category category10 = new Category();
        category10.setName("History");
        category10.setCategory_ID(36);
        categoryRepository.save(category10);
        Category category11 = new Category();
        category11.setName("Horror");
        category11.setCategory_ID(27);
        categoryRepository.save(category11);
        Category category12 = new Category();
        category12.setName("Music");
        category12.setCategory_ID(10402);
        categoryRepository.save(category12);
        Category category13 = new Category();
        category13.setName("Mystery");
        category13.setCategory_ID(9648);
        categoryRepository.save(category13);
        Category category14 = new Category();
        category14.setName("Romance");
        category14.setCategory_ID(10749);
        categoryRepository.save(category14);
        Category category15 = new Category();
        category15.setName("Science Fiction");
        category15.setCategory_ID(878);
        categoryRepository.save(category15);
        Category category16 = new Category();
        category16.setName("TV Movie");
        category16.setCategory_ID(10770);
        categoryRepository.save(category16);
        Category category17 = new Category();
        category17.setName("Thriller");
        category17.setCategory_ID(53);
        categoryRepository.save(category17);
        Category category18 = new Category();
        category18.setName("War");
        category18.setCategory_ID(10752);
        categoryRepository.save(category18);
        Category category19 = new Category();
        category19.setName("Western");
        category19.setCategory_ID(37);
        categoryRepository.save(category19);
    }
}
