package com.imobile3.groovypayments.ui.user;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Query;

import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.imobile3.groovypayments.R;
import com.imobile3.groovypayments.data.DatabaseHelper;
import com.imobile3.groovypayments.data.entities.UserEntity;
import com.imobile3.groovypayments.ui.BaseActivity;
import com.imobile3.groovypayments.ui.login.LoginActivity;

import org.w3c.dom.Entity;

import java.util.ArrayList;
import java.util.List;

public class UserProfileActivity extends BaseActivity {

    @NonNull
    private final UserEntity mUser = new UserEntity();
    String firstName, lastName, email, value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_activity);

        setUpMainNavBar();
        setUpViews();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void setUpMainNavBar() {
        super.setUpMainNavBar();
        mMainNavBar.showBackButton();
        mMainNavBar.showLogo();
    }

    @Override
    protected void initViewModel() {
        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
         value = sharedPreferences.getString("value","");
         firstName = DatabaseHelper.getInstance().getDatabase().getUserDao().loadFirstName(value);
         lastName = DatabaseHelper.getInstance().getDatabase().getUserDao().loadLastName(value);
         email = DatabaseHelper.getInstance().getDatabase().getUserDao().loadEmail(value);


    }

    private void setUpViews() {
        TextView labelUsername = findViewById(R.id.label_username);
        labelUsername.setText(value);
        TextView labelName = findViewById(R.id.label_name);
        labelName.setText(firstName+ " " + lastName);
        TextView labelEmail = findViewById(R.id.label_email);
        labelEmail.setText(email);


    }
}
