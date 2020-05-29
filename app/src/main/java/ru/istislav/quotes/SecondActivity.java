package ru.istislav.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textView2;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        textView2 = (TextView) findViewById(R.id.textView2);
        backButton = (Button) findViewById(R.id.backButton);

        if (extras != null) {
            String message = extras.getString("messageData1");
            textView2.setText(message);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData", "From SecondActivity");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });


    }
}
