package ru.istislav.quotes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button quoteButton;
    private Button nextActButton;
    private Button thirdActButton;
    private TextView quoteTextView;
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteText);
        quoteButton = findViewById(R.id.quoteButton);
        nextActButton = findViewById(R.id.buttonNexActiv);
        thirdActButton = findViewById(R.id.thirdActivityButton);

        Toast.makeText(MainActivity.this, "On Create made", Toast.LENGTH_SHORT).show();

        quoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuoteServer quoteServer = new QuoteServer();

                System.out.println("Hello");
                quoteTextView.setText(quoteServer.getRandomQuote());

            }
        });

        nextActButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                 intent.putExtra("messageData1", "It is message data from first activity");
                 //startActivity(intent);
                 startActivityForResult(intent, REQUEST_CODE);
             }
        });

        thirdActButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                 startActivity(intent);
             }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(MainActivity.this, "On Start made", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                String resultStr = data.getStringExtra("returnData");
                Toast.makeText(MainActivity.this, resultStr, Toast.LENGTH_LONG).show();
            }
        }
    }
}
