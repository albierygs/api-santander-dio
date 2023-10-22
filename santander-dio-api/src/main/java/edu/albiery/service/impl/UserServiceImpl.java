package edu.albiery.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import edu.albiery.domain.model.User;
import edu.albiery.domain.repository.UserRepository;
import edu.albiery.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("O número de conta já existe.");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    
}
