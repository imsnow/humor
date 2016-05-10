package com.elegant.humor.model;

import android.os.Parcel;
import android.os.Parcelable;

/***
 * Created by Mike on 06.05.2016.
 */
public class Source implements Parcelable{

    public String site;
    public String name;
    public String desc;

    protected Source(Parcel in) {
        site = in.readString();
        name = in.readString();
        desc = in.readString();
    }

    public static final Creator<Source> CREATOR = new Creator<Source>() {
        @Override
        public Source createFromParcel(Parcel in) {
            return new Source(in);
        }

        @Override
        public Source[] newArray(int size) {
            return new Source[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(site);
        dest.writeString(name);
        dest.writeString(desc);
    }
}
