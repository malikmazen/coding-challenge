package com.imobile3.groovypayments.data.dao;

import com.imobile3.groovypayments.data.entities.UserEntity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<UserEntity> getUsers();

    @Query("SELECT EXISTS (SELECT * FROM user where username = :userName AND password= :password)")
    boolean loginUsername(String userName, String password);
    @Query("SELECT EXISTS (SELECT * FROM user where email = :email AND password= :password)")
    boolean loginEmail(String email, String password);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUsers(UserEntity... values);

    @Update
    void updateUsers(UserEntity... values);

    @Delete
    void deleteUsers(UserEntity... values);
}
