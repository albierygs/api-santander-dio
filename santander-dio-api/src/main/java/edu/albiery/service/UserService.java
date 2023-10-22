package edu.albiery.service;

import edu.albiery.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);

    
}
