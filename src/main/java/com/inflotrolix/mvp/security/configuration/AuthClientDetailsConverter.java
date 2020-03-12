package com.inflotrolix.mvp.security.configuration;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.inflotrolix.mvp.security.domain.AuthClientDetails;

public class AuthClientDetailsConverter implements DynamoDBTypeConverter<String, AuthClientDetails> {

    @Override
    public String convert(AuthClientDetails authClientDetails) {
        return authClientDetails.toString();
    }

    @Override
    public AuthClientDetails unconvert(String s) {
        AuthClientDetails details = new AuthClientDetails();
        details.setClientId("returned");
        return details;
    }
}
