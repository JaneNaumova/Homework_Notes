package com.example.homework_notes;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NoteListFragment extends Fragment {
    public static final String THIS_NOTES = "notes_this";
    private Notes notes_this;

    public static NoteListFragment newInstance() {
        NoteListFragment fragment = new NoteListFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(THIS_NOTES,notes_this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] notes = getResources().getStringArray(R.array.notes);
        for (int i = 0; i < notes.length; i++) {
            String noteName = notes[i];
            TextView textView = new TextView(getContext());
            textView.setTextSize(30f);
            textView.setText(noteName);
            ((LinearLayout) view).addView(textView);
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Notes list = new Notes(finalI);
                    if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
                        NoteFragment noteFragment = NoteFragment.newInstance(list);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.textNotes,noteFragment).commit();
                    }else {
                        NoteFragment noteFragment = NoteFragment.newInstance(list);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.note_list,noteFragment).addToBackStack("").commit();

                    }
                }
            });
        }

        if(savedInstanceState!=null){
            notes_this = savedInstanceState.getParcelable(THIS_NOTES);
        } else {
            notes_this = new Notes(0);
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            showLand();
        }
    }

    private void showLand() {
    }
}