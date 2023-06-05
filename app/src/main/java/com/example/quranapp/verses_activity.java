package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class verses_activity extends AppCompatActivity {

    QDH obj = new QDH();
    QuranArabicText quranArabicText = new QuranArabicText();
    TextView surahName;
    TextView verses;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verses);

        Intent intent = getIntent();

        imageView = findViewById(R.id.backButton);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        surahName = findViewById(R.id.surahnametextview);
        surahName.setText(intent.getExtras().getString("surah"));

        verses = findViewById(R.id.versesTextView);

        int index=intent.getExtras().getInt("index");

        int start=obj.SSP[index];
        int end=start+obj.surahAyatCount[index];

        verses.setMovementMethod(new ScrollingMovementMethod());
        verses.setText(quranArabicText.QuranArabicText[0]+"\n");

        for (int i=start;i<end;i++)
        {
            verses.append("  "+quranArabicText.QuranArabicText[i]);
        }
    }

}