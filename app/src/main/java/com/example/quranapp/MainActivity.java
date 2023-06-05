package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView surahNames;
    QDH obj = new QDH();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surahNames = findViewById(R.id.surahList);

        ArrayList<String> surahnames = obj.GetSurahNames();
        ArrayList<String> englishSurahNames = obj.GetEnglishSurahNames();

        ArrayList<String> combinedList = new ArrayList<>();

        int size = Math.min(surahnames.size(), englishSurahNames.size());

        for (int i = 0; i < size; i++) {
            String surahName = surahnames.get(i);
            String englishSurahName = englishSurahNames.get(i);

            // Right justify surah name and left justify English surah name
            String combinedItem = String.format("%-80s %s",englishSurahName,surahName);
            combinedList.add(combinedItem);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, combinedList);
        surahNames.setAdapter(adapter);

    }
}