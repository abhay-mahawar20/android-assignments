package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment5.R;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    TextView Result;
    Button button;
    CheckBox notificationCheckBox, darkModeCheckBox, locationCheckBox, cloudBackupCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        rg = findViewById(R.id.deviceRadioGroup);
        notificationCheckBox = findViewById(R.id.cbNotification);
        darkModeCheckBox = findViewById(R.id.cbDarkMode);
        locationCheckBox = findViewById(R.id.cbLocation);
        cloudBackupCheckBox = findViewById(R.id.cbCloudBackup);
        button = findViewById(R.id.btnSubmit);
        Result = findViewById(R.id.Result);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedDeviceId = rg.getCheckedRadioButtonId();

                if (selectedDeviceId == -1) {
                    Toast.makeText(MainActivity.this, "Please select a device", Toast.LENGTH_SHORT).show();
                    return;
                }

                rb = findViewById(selectedDeviceId);
                String device = rb.getText().toString();

                String features = "";
                if (notificationCheckBox.isChecked()) {
                    features += "Notification, ";
                }
                if (darkModeCheckBox.isChecked()) {
                    features += "Dark Mode, ";
                }
                if (locationCheckBox.isChecked()) {
                    features += "Location, ";
                }
                if (cloudBackupCheckBox.isChecked()) {
                    features += "Cloud Backup";
                }

                if (features.isEmpty()) {
                    features = "None";
                } else if (features.endsWith(", ")) {
                    features = features.substring(0, features.length() - 2);
                }

                Result.setText("Selected Device: " + device + "\nSelected Features: " + features);
            }
        });
    }
}
