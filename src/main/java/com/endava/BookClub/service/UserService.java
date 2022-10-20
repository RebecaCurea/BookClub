package com.endava.BookClub.service;

import com.endava.BookClub.entity.UserEntity;
import com.endava.BookClub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> save(UserEntity user) {
        Optional<UserEntity> optionalUser = userRepository.findByUsername(user.getUsername());

        if (optionalUser.isPresent()) {
            return new ResponseEntity<>("This username already exist!", HttpStatus.BAD_REQUEST);
        } else {
             user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return new ResponseEntity<>("Your account has been created.", HttpStatus.CREATED);
        }

    }

//    public void save(UserEntity user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }
//
    public ResponseEntity<?> authenticateUser(UserEntity user) {
        Optional<UserEntity>  optionalUser = userRepository.findByUsername(user.getUsername());

        if(optionalUser.isPresent()) {
            if(user.getPassword().equals(optionalUser.get().getPassword())) {
               // return ResponseEntity.ok(optionalUser.get());
                return new ResponseEntity<>("Login successfully", HttpStatus.OK); }
        }
        return new ResponseEntity<>("This username doesn't exist", HttpStatus.NO_CONTENT);
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public UserEntity getUser(Integer id){
        return userRepository.findById(id).get();
    }
    public UserEntity editUser(UserEntity user, Integer id) {
        UserEntity newUser = userRepository.findById(id).orElseThrow();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(newUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
