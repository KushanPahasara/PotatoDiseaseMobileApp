package com.example.potatodiseasemobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    Button button,detect;
    TextInputLayout u_name, password;
    DatabaseReference reference;
    String username,u_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        u_name = findViewById(R.id.username);
        password = findViewById(R.id.password);
        button = findViewById(R.id.signup_btn);
        detect = findViewById(R.id.signup1_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);

            }
        });

        detect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = u_name.getEditText().getText().toString();
                u_password = password.getEditText().getText().toString();

                if (!username.isEmpty() && !u_password.isEmpty()){
                    reference = FirebaseDatabase.getInstance().getReference("users");
                    reference.child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if (task.isSuccessful()){
                                DataSnapshot dataSnapshot = task.getResult();
                                if (u_password.equals(dataSnapshot.child("password").getValue())){
                                    Toast.makeText(getApplicationContext(),"login successful",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),DetectPage.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(getApplicationContext(),"password incorrect",Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(getApplicationContext(),"User Doesn't Exist",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{

                    Toast.makeText(getApplicationContext(),"Please Enter Username and password",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}