package com.example.homework_notes;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NoteFragment extends Fragment {

    public static final String ARG_NOTES = "notes";

    private Notes notes;
    public static NoteFragment newInstance(Notes notes) {
        NoteFragment fragment = new NoteFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable(ARG_NOTES, notes);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        notes = getArguments().getParcelable(ARG_NOTES);
        TextView textView =  view.findViewById(R.id.textNotes);
        TypedArray noteList = getResources().obtainTypedArray(R.array.list);
        textView.setText(noteList.getResourceId(notes.getIndex(),R.array.monday));
    }
}