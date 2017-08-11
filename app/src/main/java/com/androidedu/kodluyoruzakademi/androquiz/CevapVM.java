package com.androidedu.kodluyoruzakademi.androquiz;


import android.os.Parcel;
import android.os.Parcelable;

public class CevapVM implements Parcelable {

    public static final Creator<CevapVM> CREATOR = new Creator<CevapVM>() {
        @Override
        public CevapVM createFromParcel(Parcel in) {
            return new CevapVM(in);
        }

        @Override
        public CevapVM[] newArray(int size) {
            return new CevapVM[size];
        }
    };
    public String[] soru;
    public boolean[] cevap;

    public CevapVM() {
        soru = new String[10];
        cevap = new boolean[10];
    }

    protected CevapVM(Parcel in) {
        soru = in.createStringArray();
        cevap = in.createBooleanArray();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeStringArray(soru);
        parcel.writeBooleanArray(cevap);
    }
}
