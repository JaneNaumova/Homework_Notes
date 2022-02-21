package com.example.homework_notes;

import android.os.Parcel;
import android.os.Parcelable;

public class Notes implements Parcelable {
    private int index;

    public Notes(int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }

    public static Creator<Notes> getCREATOR() {
        return CREATOR;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    protected Notes(Parcel in) {
        index = in.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(index);
    }
}


