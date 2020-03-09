package io.eduardogarcia.ppmtool.services;

import io.eduardogarcia.ppmtool.domain.User;
import io.eduardogarcia.ppmtool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser (User newUser) {
       newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

       //Username has not be unique( expection

        //Make sure password and confirmPassword match

        //We dont persist or show password

       return userRepository.save(newUser);


    }

}
