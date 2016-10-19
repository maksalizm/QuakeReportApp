package com.example.android.quakereport;

/**
 * Created by pms on 2016. 10. 19..
 */

public class Earthquake {

    private double mMag;
    private String mPlace;
    private String mDate;

    public Earthquake(double vMag, String vPlace, String vDate) {
        mMag = vMag;
        mPlace = vPlace;
        mDate = vDate;
    }

    public double getMag() {
        return mMag;
    }

    public String getPlace() {
        return mPlace;
    }

    public String getDate() {
        return mDate;
    }
}
