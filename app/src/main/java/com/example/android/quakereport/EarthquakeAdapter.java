package com.example.android.quakereport;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by pms on 2016. 10. 19..
 */

public class EarthquakeAdapter extends ArrayAdapter <Earthquake> {


    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magTextView = (TextView) listItemView.findViewById(R.id.mag);

        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        String formattedMag = formatMag(currentEarthquake.getMag());

        int magnitudeColor = getMagColor(currentEarthquake.getMag());

        magTextView.setText(formattedMag);

        magnitudeCircle.setColor(magnitudeColor);

        TextView ofPlaceTextView = (TextView) listItemView.findViewById(R.id.of_place);

        String formattedOfPlace = formatOfPlace(currentEarthquake.getPlace());

        ofPlaceTextView.setText(formattedOfPlace);

        TextView PlaceView = (TextView) listItemView.findViewById(R.id.place);

        String formattedPlace = formatPlace(currentEarthquake.getPlace());

        PlaceView.setText(formattedPlace);

        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        String formattedDate = formatDate(dateObject);

        dateView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);

        String formattedTime = formatTime(dateObject);

        timeView.setText(formattedTime);

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatOfPlace(String place){
        String [] formattedplace = place.split("of");

        if(!place.contains("of")){
            return "near the";
        } else {
            return formattedplace[0].trim() + " of";
        }
    }

    private String formatPlace(String place){

        String [] formattedplace = place.split("of");
        if(!place.contains("of")){
            return place;

        } else {
            return formattedplace[1].trim();
        }
    }

    private String formatMag(double mag){
        DecimalFormat magFormat = new DecimalFormat("0.0");
        return magFormat.format(mag);
    }

    private int getMagColor(double mag){

        int floorMag = (int) Math.floor(mag);

        switch (floorMag) {
            case 0 : {
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            }
            case 1 : {
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            }
            case 2 : {
                return ContextCompat.getColor(getContext(), R.color.magnitude2);
            }
            case 3 : {
                return ContextCompat.getColor(getContext(), R.color.magnitude3);
            }
            case 4 : {
                return ContextCompat.getColor(getContext(), R.color.magnitude4);
            }
            case 5 : {
                return ContextCompat.getColor(getContext(), R.color.magnitude5);
            }
            case 6 : {
                return ContextCompat.getColor(getContext(), R.color.magnitude6);
            }
            case 7 : {
                return ContextCompat.getColor(getContext(), R.color.magnitude7);
            }
            case 8 : {
                return ContextCompat.getColor(getContext(), R.color.magnitude8);
            }
            case 9 : {
                return ContextCompat.getColor(getContext(), R.color.magnitude9);
            }
            default : {
                return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
            }
        }
    }
}
