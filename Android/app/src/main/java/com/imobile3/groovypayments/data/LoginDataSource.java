package com.imobile3.groovypayments.data;

import com.imobile3.groovypayments.data.dao.UserDao;
import com.imobile3.groovypayments.data.entities.UserEntity;
import com.imobile3.groovypayments.data.model.LoggedInUser;
import com.imobile3.groovypayments.data.model.Product;

import java.io.IOException;
import java.net.UnknownServiceException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    UserDao userDao;
    public Result<LoggedInUser> login(String username, String password) {
        // TODO: handle loggedInUser authentication

       if (DatabaseHelper.getInstance().getDatabase().getUserDao().login(username,password))
        {
            LoggedInUser dummyUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Mazen Malik");
            return  new Result.Success<>(dummyUser);
        } else {
            return new Result.Error(new IOException("error"));
        }
    }
    public Result<List<UserEntity>> getUser() {
        List<UserEntity> results =
                DatabaseHelper.getInstance().getDatabase().getUserDao().getUsers();
        return new Result.Success<>(results);
    }
    public void logout() {
        // TODO: revoke authentication
    }
}
