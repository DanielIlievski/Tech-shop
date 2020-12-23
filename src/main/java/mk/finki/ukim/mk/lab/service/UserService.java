package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.User;

import java.util.Optional;

public interface UserService {
    User save(User user);
    Optional <User> findByUsername(String username);
}
