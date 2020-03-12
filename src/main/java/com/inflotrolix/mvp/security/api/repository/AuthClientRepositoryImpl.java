package com.inflotrolix.mvp.security.api.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.inflotrolix.mvp.security.domain.AuthClientDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthClientRepositoryImpl implements AuthClientRepository {

    private final DynamoDBMapper dynamoDBMapper;

    @Override
    public Optional<AuthClientDetails> findByClientId(String clientId) {
        return Optional.ofNullable(dynamoDBMapper.load(AuthClientDetails.class, ""));
    }
}
