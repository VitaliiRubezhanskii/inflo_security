package com.inflotrolix.mvp.security.api.service;

import com.inflotrolix.mvp.security.api.repository.UserRepository;
import com.inflotrolix.mvp.security.domain.AuthClientDetails;
import com.inflotrolix.mvp.security.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;

        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
//        throwIfUsernameExists(user.getUsername());
        user.setSortKey(LocalDateTime.now().toString());
        String hash = passwordEncoder.encode(user.getPassword());
        AuthClientDetails details = new AuthClientDetails();
        details.setClientId("clientId");
        user.setClientDetails(details);
        user.setPassword(hash);
//        user.setActivated(Boolean.TRUE); // TODO send sms or email with code for activation
//        user.setAuthorities(new HashSet<>(Collections.singletonList(Authorities.ROLE_USER)));

        // TODO other routines on account creation

        return userRepository.save(user);
    }

    private void throwIfUsernameExists(String username) {
        Optional<User> existingUser = userRepository.findByUsername(username);
        existingUser.ifPresent((user) -> {
            throw new IllegalArgumentException("User not available");
        });
    }

}
