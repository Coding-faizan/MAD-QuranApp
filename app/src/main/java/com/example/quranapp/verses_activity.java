package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class verses_activity extends AppCompatActivity {

    QDH obj = new QDH();
    QuranArabicText quranArabicText = new QuranArabicText();
    TextView surahName;
    TextView verses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verses);

        Intent intent = getIntent();

        surahName = findViewById(R.id.surahnametextview);
        surahName.setText(intent.getExtras().getString("surah"));

        verses = findViewById(R.id.versesTextView);

        int index=intent.getExtras().getInt("index");

        int start=obj.SSP[index];
        int end=start+obj.surahAyatCount[index];


        verses.setText(quranArabicText.QuranArabicText[0]+"\n");

        for (int i=start;i<end;i++)
        {
            verses.append("  "+quranArabicText.QuranArabicText[i]);
        }
    }

}