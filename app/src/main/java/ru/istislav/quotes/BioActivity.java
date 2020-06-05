package ru.istislav.quotes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BioActivity extends AppCompatActivity {

    private ImageView objImageView;
    private TextView objName;
    private TextView objBio;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

        objImageView = (ImageView) findViewById(R.id.objImageViewID);
        objName = (TextView) findViewById(R.id.nameTextID);
        objBio = (TextView) findViewById(R.id.bioTextID);

        extras = getIntent().getExtras();
        if(extras != null) {
            String name = extras.getString("name");
            String bio = extras.getString("bio");
            setUp(name, bio);
        }

    }

    public void setUp(String name, String bio) {
        Log.d("BioSETUP", "we have runned setUp function - debug"); //debug
        Log.v("BioSETUP", "we have runned setUp function - verbose"); //verbose
        if(name.equals("Victor Tsoy")) {
            objImageView.setImageDrawable(getResources().getDrawable(R.drawable.viktor_tsoi_emblem));
        }else if(name.equals("USSR")) {
            objImageView.setImageDrawable(getResources().getDrawable(R.drawable.emblem_ussr_1));
        }
        objName.setText(name);
        objBio.setText(bio);
    }
}