package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.exception.InavlidUserCredentialsExceptions;
import mk.finki.ukim.mk.lab.model.exception.InvalidArgumentException;
import mk.finki.ukim.mk.lab.model.exception.PasswordsDoNotMatchException;
import mk.finki.ukim.mk.lab.model.exception.UsernameExistsException;
import mk.finki.ukim.mk.lab.repository.UserRepository;
import mk.finki.ukim.mk.lab.service.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty())
            throw new InvalidArgumentException();
        return this.userRepository.
                findByUsernameAndPassword(username, password).
                orElseThrow(InavlidUserCredentialsExceptions::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty()) {
            throw new InvalidArgumentException();
        }
        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }
        if (this.userRepository.findByUsername(username).isPresent() || !this.userRepository.findByUsername(username).isEmpty())
            throw new UsernameExistsException(username);
        User user = new User(username,password, name, surname);
        return this.userRepository.save(user);
    }
}
