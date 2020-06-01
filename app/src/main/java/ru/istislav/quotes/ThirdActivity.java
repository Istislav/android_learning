package ru.istislav.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ussrView;
    private ImageView tsoyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ussrView = (ImageView) findViewById(R.id.ussrImageView);
        ussrView.setOnClickListener(this);
        tsoyView = (ImageView) findViewById(R.id.tsoyImageView);
        tsoyView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent openingIntent = new Intent(ThirdActivity.this, BioActivity.class);

        switch (v.getId()) {
            case R.id.tsoyImageView:
                Toast.makeText(ThirdActivity.this, "Tsoy", Toast.LENGTH_SHORT).show();

                openingIntent.putExtra("name", "Victor Tsoy");
                openingIntent.putExtra("bio", "Greatest rock-musiciant all over the world");

                break;
            case R.id.ussrImageView:
                Toast.makeText(ThirdActivity.this, "Ussr", Toast.LENGTH_SHORT).show();

                openingIntent.putExtra("name", "USSR");
                openingIntent.putExtra("bio", "United States of Soviet Republics");
                break;
        }

        startActivity(openingIntent);
    }
}
