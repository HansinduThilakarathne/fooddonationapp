package com.example.fooddonationapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText email, password, repassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // Ensure the XML file is named correctly

        // Initialize UI Elements
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        Button signup = findViewById(R.id.signup);
        ImageView googleBtn = findViewById(R.id.google_btn);
        ImageView whatsappBtn = findViewById(R.id.imageView7);
        ImageView instagramBtn = findViewById(R.id.imageView9);

        // Sign-Up Button Click Event
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndSignup();
            }
        });

        // Google Button Click (Example: Open Google Sign-in)
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "Facebook Sign-In Coming Soon!", Toast.LENGTH_SHORT).show();
            }
        });

        // WhatsApp Button Click (Example: Open WhatsApp)
        whatsappBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "WhatsApp Feature Coming Soon!", Toast.LENGTH_SHORT).show();
            }
        });

        // Instagram Button Click (Example: Open Instagram)
        instagramBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "Instagram Feature Coming Soon!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Validate Input Fields and Process Sign-Up
    private void validateAndSignup() {
        String emailText = email.getText().toString().trim();
        String passwordText = password.getText().toString().trim();
        String repasswordText = repassword.getText().toString().trim();

        if (TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passwordText) || TextUtils.isEmpty(repasswordText)) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            Toast.makeText(this, "Enter a valid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (passwordText.length() < 6) {
            Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!passwordText.equals(repasswordText)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // After validation, redirect to another activity (e.g., Login Page)
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
