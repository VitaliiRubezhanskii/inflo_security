package com.inflotrolix.mvp.security.api.repository;

import com.inflotrolix.mvp.security.domain.User;

import java.util.Optional;


public interface UserRepository {

    Optional<User> findByUsername(String username);

    User save(User user);

}
