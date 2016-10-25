package com.example.android.quakereport;

/**
 * Created by pms on 2016. 10. 19..
 */

public class Earthquake {

    private double mMag;
    private String mPlace;
    private long mTimeInMilliseconds;
    private String mUrl;

    public Earthquake(double vMag, String vPlace, long timeInMilliseconds, String vURL) {
        mMag = vMag;
        mPlace = vPlace;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = vURL;
    }

    public double getMag() {
        return mMag;
    }

    public String getPlace() {
        return mPlace;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
    public String getUrl(){
        return mUrl;
    }
}
