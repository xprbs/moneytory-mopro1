package com.panduprabs.moneytory;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button signup, signin;

    DBHelper DB;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = (EditText) findViewById(R.id.InputUsername);
        password = (EditText) findViewById(R.id.InputPassword);
        signin = (Button) findViewById(R.id.btnLogin);
        signup = (Button) findViewById(R.id.buttonToRegister);

        DB = new DBHelper(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String stats;

                if (user.equals("") || pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Please fill all the form", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuserpass = DB.checkUsernamePassword(user, pass);
                    if (checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "Signin successfull", Toast.LENGTH_SHORT).show();
                        stats = "logged_in";
                        saveUserInfo(stats);
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));

                    }else{
                        Toast.makeText(LoginActivity.this, "Username & Password not Match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

    }

    public void saveUserInfo(String stats){
        SharedPreferences userinfo = this.getSharedPreferences("Status", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = userinfo.edit();
        editor.putString("stats", stats);
        editor.apply();
    }
}
