package com.endava.BookClub.service;

import com.endava.BookClub.entity.UserEntity;
import com.endava.BookClub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void save(UserEntity user) {
        userRepository.save(user);
    }
}
