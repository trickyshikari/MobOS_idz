package com.tolstenkov.idz.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;


public class Theory implements Parcelable {

    private String mTitle;
    private String mContent;
    private int mMark;

    public Theory(){
    }

    protected Theory(Parcel in) {
        mTitle = in.readString();
        mContent = in.readString();
        mMark = in.readInt();
    }

    public Theory(String s, String s1, int i) {
        mTitle = s;
        mContent = s1;
        mMark = i;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mContent);
        dest.writeInt(mMark);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Theory> CREATOR = new Creator<Theory>() {
        @Override
        public Theory createFromParcel(Parcel in) {
            return new Theory(in);
        }

        @Override
        public Theory[] newArray(int size) {
            return new Theory[size];
        }
    };

    public String getmTitle(){return mTitle;}
    public String getmContent(){return mContent;}
    public int getmMark(){return mMark;}
    public void setmTitle(String mTitle){this.mTitle = mTitle;}
    public void setmContent(String mContent){this.mContent = mContent;}
    public void setmMark(int mMark){this.mMark = mMark;}

    public static ArrayList<Theory> get(){
        ArrayList<Theory> ret = new ArrayList<Theory>();
        ret.add(new Theory("R.string.start", "R.string.start_content", 0));
        ret.add(new Theory("1R.string.start1", "1R.string.start_content1", 0));
        return ret;
    }
}
