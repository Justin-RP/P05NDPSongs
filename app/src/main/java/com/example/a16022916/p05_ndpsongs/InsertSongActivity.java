package com.example.a16022916.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class InsertSongActivity extends AppCompatActivity {
    public DatabaseHelper db = new DatabaseHelper(this);

    EditText etTitle;
    EditText etSinger;
    EditText etYear;
    RadioGroup rgStars;
    Button btnInsert;
    Button btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_song);

        etTitle = findViewById(R.id.editTextSongTitle);
        etSinger = findViewById(R.id.editTextSinger);
        etYear = findViewById(R.id.editTextYear);
        rgStars = findViewById(R.id.radioGroupStars);

        btnInsert = findViewById(R.id.buttonInsert);
        btnList = findViewById(R.id.buttonShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strTitle = etTitle.getText().toString();
                String strSinger = etSinger.getText().toString();
                int intYear = Integer.valueOf(etYear.getText().toString());

                int starsCheckedId = rgStars.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(starsCheckedId);
                String strRadio = selectedRadioButton.getText().toString();
                int intRadio;

                if(strRadio.equalsIgnoreCase("1")){
                    intRadio = 1;
                } else if (strRadio.equalsIgnoreCase("2")){
                    intRadio = 2;
                } else if (strRadio.equalsIgnoreCase("3")){
                    intRadio = 3;
                } else if (strRadio.equalsIgnoreCase("4")){
                    intRadio = 4;
                } else {
                    intRadio = 5;
                }

//                Toast.makeText(getApplicationContext(),strRadio,Toast.LENGTH_LONG).show();
                Song newSong = new Song(strTitle,strSinger,intYear,intRadio);
                db.insertSong(newSong);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),ShowSongActivity.class);
                startActivity(intent);
        }
        });

    }
}
