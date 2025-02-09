package com.example.fooddonationapp; // Fixed package name

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThankYouActivity extends AppCompatActivity {

    private ImageView thankYouIcon;
    private TextView thankYouMessage;
    private Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou); // Ensure this XML file exists

        // Initialize views
        thankYouIcon = findViewById(R.id.thankYouIcon);
        thankYouMessage = findViewById(R.id.thankYouMessage); // Fixed initialization
        homeButton = findViewById(R.id.homeButton);

        // Click event for Home Button
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(ThankYouActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); // Close ThankYouActivity
        });
    }
}
