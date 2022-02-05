package com.panduprabs.moneytory;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void registerNow(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void loginClicked(View view){
        Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//        startActivity(intent);
    }

}
