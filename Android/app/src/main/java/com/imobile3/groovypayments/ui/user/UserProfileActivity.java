package com.imobile3.groovypayments.ui.user;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.imobile3.groovypayments.R;
import com.imobile3.groovypayments.data.entities.UserEntity;
import com.imobile3.groovypayments.ui.BaseActivity;

public class UserProfileActivity extends BaseActivity {

    @NonNull
    private final UserEntity mUser = new UserEntity();

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
        mUser.setId(122563L);
        mUser.setFirstName("Fred");
        mUser.setLastName("Fredburger");
        mUser.setUsername("fburger");
        mUser.setEmail("fburger@gmail.com");
        mUser.setPassword("aaa1");
    }

    private void setUpViews() {
        TextView lblUsername = findViewById(R.id.label_username);
        lblUsername.setText(mUser.getUsername());

        TextView lblEmail = findViewById(R.id.label_email);
        lblEmail.setText(mUser.getEmail());

        TextView lblHoursWeek = findViewById(R.id.label_hours_week);
        lblHoursWeek.setText(String.valueOf(35.42d));
    }
}
