package com.example.assignment1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText nameEt,cityEt,emailEt,mobileEt;
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            nameEt=FindViewById(R.id.name);
            cityEt=FindViewById(R.id.city);
            nameEt=FindViewById(R.id.email);
            cityEt=FindViewById(R.id.mobile);
            click=findViewById(R.id.submit);
            click.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View view){
                  String name,city,email,mobile;
                  name=nameEt.getText().toString();
                  city=cityEt.getText().toString();
                  email=emailEt.getText().toString();
                 mobile=mobileEt.getText().toString();
                String output = "i Am"+name+
                        "i live in " +city+
                        "my email and my mobile number is "+ email+ mobile;
                Toast.makeText(getApplicationContext(),name, Toast.LENGTH_SHORT).show();

            }
            });
            return insets;
        });
    }

    private EditText FindViewById(int name) {
    }


}

