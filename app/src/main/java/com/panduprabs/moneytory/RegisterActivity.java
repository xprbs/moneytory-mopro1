package com.panduprabs.moneytory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText fullname, username, password;
    Button signup, signin;

    DBHelper DB;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        fullname = (EditText) findViewById(R.id.inputFullName);
        username = (EditText) findViewById(R.id.InputUsername);
        password = (EditText) findViewById(R.id.InputPassword);

        signup = (Button) findViewById(R.id.buttonRegister);
        signin = (Button) findViewById(R.id.buttonToLogin);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String full = fullname.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (full.equals("") || user.equals("") || pass.equals("")){
                    Toast.makeText(RegisterActivity.this, "Please fill all the form", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuser = DB.checkUsername(user);
                    if (checkuser==false){
                        Boolean insert = DB.insertData(full, user, pass);
                        if (insert == true){
                            Toast.makeText(RegisterActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "User already exists, please sign in", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
