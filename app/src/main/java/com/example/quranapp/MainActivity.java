package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    QDH obj = new QDH();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.surahList);

        ArrayList<String> surahnames = obj.GetSurahNames();
        ArrayList<String> englishSurahNames = obj.GetEnglishSurahNames();

        ArrayList<String> combinedList = new ArrayList<>();

        int size = Math.min(surahnames.size(), englishSurahNames.size());

        for (int i = 0; i < size; i++) {
            String surahName = surahnames.get(i);
            String englishSurahName = englishSurahNames.get(i);
            String combinedItem = String.format("%-80s %s",englishSurahName,surahName);
            combinedList.add(combinedItem);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, combinedList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listView.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(),verses_activity.class);
                intent.putExtra("surah",str);
                intent.putExtra("index",position);
                startActivity(intent);
            }
        });

    }
}