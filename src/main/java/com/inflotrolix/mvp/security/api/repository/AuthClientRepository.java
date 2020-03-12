package com.inflotrolix.mvp.security.api.repository;

import com.inflotrolix.mvp.security.domain.AuthClientDetails;

import java.util.Optional;

public interface AuthClientRepository {

    Optional<AuthClientDetails> findByClientId(String clientId);
}
