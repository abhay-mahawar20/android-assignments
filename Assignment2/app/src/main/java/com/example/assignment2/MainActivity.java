package com.example.assignment2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    Button click;
    TextView welcome;
    EditText nameet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        click = findViewById(R.id.btn);
        welcome = findViewById(R.id.wel);
        nameet = findViewById(R.id.nameet);


        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameet.getText().toString().trim();
                if (!name.isEmpty()) {
                    welcome.setText("WELCOME " + name);
                    welcome.setTextSize(24);
                    welcome.setTextColor(Color.BLUE);
                }
            }
        });
    }
}
