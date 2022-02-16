package com.example.homework_notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            NoteListFragment noteListFragment = NoteListFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.list,noteListFragment).commit();
            if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
                Notes defaultList = new Notes("Понедельник", R.array.monday);
                NoteFragment noteFragment = NoteFragment.newInstance(defaultList);
                getSupportFragmentManager().beginTransaction().replace(R.id.notes,noteFragment).commit();
            }
        }
    }
}