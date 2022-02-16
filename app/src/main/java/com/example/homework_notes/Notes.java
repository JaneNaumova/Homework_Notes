package com.example.homework_notes;

import android.os.Parcel;
import android.os.Parcelable;

public class Notes implements Parcelable {
    private int noteIndex;
    private String noteName;

    protected Notes(Parcel in) {
        noteIndex = in.readInt();
        noteName = in.readString();
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    public Notes(String noteName, int noteIndex) {
       this.noteName = noteName;
       this.noteIndex = noteIndex;

    }

    public int getNoteIndex() {
        return noteIndex;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteIndex(int noteIndex) {
        this.noteIndex = noteIndex;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(noteIndex);
        parcel.writeString(noteName);
    }
}
