package com.melancholia.educationplatform.util;

import com.melancholia.educationplatform.product.ProductRepository;
import com.melancholia.educationplatform.user.permissions.Privilege;
import com.melancholia.educationplatform.user.permissions.PrivilegeRepository;
import com.melancholia.educationplatform.user.User;
import com.melancholia.educationplatform.user.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
public class SetupData {

    /*@Autowired
    private UserRepository userRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        initUsers();
    }


    private void initUsers() {
        final Privilege admin = new Privilege("ROLE_ADMIN");
        final Privilege user = new Privilege("ROLE_USER");

        privilegeRepository.save(admin);
        privilegeRepository.save(user);

        final User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword(passwordEncoder.encode("123"));
        user1.setEmail("admin@mail.ru");
        user1.setPrivileges(new HashSet<>(List.of(admin)));
        userRepository.save(user1);

        final User user2 = new User();
        user2.setUsername("user");
        user2.setPassword(passwordEncoder.encode("123"));
        user2.setEmail("user@mail.ru");
        user2.setPrivileges(new HashSet<>(List.of(user)));
        userRepository.save(user2);
    }
*/
}