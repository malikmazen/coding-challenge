package com.imobile3.groovypayments.data.utils;

import androidx.annotation.NonNull;
import com.imobile3.groovypayments.data.entities.UserEntity;


public final class personBuilder {

    private personBuilder() {
    }

    @NonNull
    public static UserEntity build(
            int id,
            String firstName,
            String lastName,
            String userName,
            String email,
            String password) {
        UserEntity result = new UserEntity();
        result.setId(id);
        result.setFirstName(firstName);
        result.setLastName(lastName);
        result.setUsername(userName);
        result.setEmail(email);
        result.setPassword(password);


        return result;
    }
}
