package com.example.fooddonationapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class DonationformActivity extends AppCompatActivity {

    private EditText donatorName, idNumber, address, contactNumber, foodName, foodQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donationform);

        // Initializing UI Components
        donatorName = findViewById(R.id.donatorName);
        idNumber = findViewById(R.id.idNumber);
        address = findViewById(R.id.address);
        contactNumber = findViewById(R.id.contactNumber);
        foodName = findViewById(R.id.foodName);
        foodQuantity = findViewById(R.id.foodQuantity);
        Button submitButton = findViewById(R.id.homeButton);

        // Submit Button Click Listener
            submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DonationformActivity.this, UserDetailsActivity.class));
            }
        });
    }

    private void submitDonation() {
        String name = donatorName.getText().toString().trim();
        String id = idNumber.getText().toString().trim();
        String addr = address.getText().toString().trim();
        String contact = contactNumber.getText().toString().trim();
        String food = foodName.getText().toString().trim();
        String quantity = foodQuantity.getText().toString().trim();

        // Input Validation
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(id) || TextUtils.isEmpty(addr) ||
                TextUtils.isEmpty(contact) || TextUtils.isEmpty(food) || TextUtils.isEmpty(quantity)) {
            Toast.makeText(this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!id.matches("\\d{6,12}")) { // ID should be between 6-12 digits
            Toast.makeText(this, "Enter a valid ID number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!contact.matches("\\d{10}")) { // Phone number should be exactly 10 digits
            Toast.makeText(this, "Enter a valid 10-digit phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        // Successful submission message
        Toast.makeText(this, "Donation Submitted Successfully!", Toast.LENGTH_LONG).show();

        // Optionally: Clear fields after submission
        clearFields();
    }

    private void clearFields() {
        donatorName.setText("");
        idNumber.setText("");
        address.setText("");
        contactNumber.setText("");
        foodName.setText("");
        foodQuantity.setText("");
    }
}
