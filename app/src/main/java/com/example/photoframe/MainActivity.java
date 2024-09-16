package com.example.photoframe;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int currentphoto = 3;
    int arr[] = {0, 1, 2, 3, 4};

    public void gallery(View v) {
        TextView Name = findViewById(R.id.nameOfPhoto);
        Name.setText("Hiccup \u0026 Astrid");
        ((ImageView) findViewById(R.id.pic1)).setImageResource(R.drawable.photo1);

        switch (arr[currentphoto]) {
            case 1:
                ((ImageView) findViewById(R.id.pic1)).setImageResource(R.drawable.photo1);
                Name.setText("Car");
                break;

            case 2:
                ((ImageView) findViewById(R.id.pic1)).setImageResource(R.drawable.photo2);
                Name.setText("SpiderMan");
                break;

            case 3:
                ((ImageView) findViewById(R.id.pic1)).setImageResource(R.drawable.photo3);
                Name.setText("Hiccup & Astrid");
                break;

            case 4:
                ((ImageView) findViewById(R.id.pic1)).setImageResource(R.drawable.photo4);
                Name.setText("Tigers");
                break;

            case 0:
                ((ImageView) findViewById(R.id.pic1)).setImageResource(R.drawable.photo5);
                Name.setText("Baby Hanuman Ji");
                break;
        }

    }

    public void prevPhoto(View v) {
        if(currentphoto > -1) {
            if(currentphoto == 0) {
                currentphoto = 4;
                gallery(v);
                return;
            }
            currentphoto--;
            gallery(v);
        } else {
            currentphoto = 4;
            gallery(v);
        }

    }
    public void nextPhoto(View v) {
        currentphoto++;
        if(currentphoto < 5) {
            gallery(v);
       } else {
            currentphoto = 0;
            gallery(v);
        }
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

}