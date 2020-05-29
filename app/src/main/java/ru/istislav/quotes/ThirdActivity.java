package ru.istislav.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import javax.swing.text.html.ImageView;

public class ThirdActivity extends AppCompatActivity {

    private ImageView ussrView;
    private ImageView tsoyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ussrView = (ImageView) findViewById(R.id.ussrImageView);
        tsoyView = (ImageView) findViewById(R.id.tsoyImageView);
    }
}
