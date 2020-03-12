package com.inflotrolix.mvp.security.api.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.inflotrolix.mvp.security.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final DynamoDBMapper dynamoDBMapper;

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(dynamoDBMapper.load(User.class, "user"));
    }

    @Override
    public User save(User user) {
        dynamoDBMapper.save(user);
        return user;
    }
}
