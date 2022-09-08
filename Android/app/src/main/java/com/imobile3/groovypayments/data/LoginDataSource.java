package com.imobile3.groovypayments.data;
import com.imobile3.groovypayments.data.model.LoggedInUser;
import com.imobile3.groovypayments.utils.EncryptDecrypt;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {
        try {
            password = EncryptDecrypt.encrypt(password);
        }catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidAlgorithmParameterException | InvalidKeyException
                | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        // TODO: handle loggedInUser authentication
        //allows users to login with username or email
        //No need to decrypt, it will checks if the encrypted password is in the table
       if (DatabaseHelper.getInstance().getDatabase().getUserDao().loginUsername(username,password) ||
               DatabaseHelper.getInstance().getDatabase().getUserDao().loginEmail(username,password))

        {
            LoggedInUser dummyUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "");
            return  new Result.Success<>(dummyUser);
        } else {
            return new Result.Error(new IOException("ERROR"));
        }
    }


    public void logout() {
        // TODO: revoke authentication
    }


}
