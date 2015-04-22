package hu.ait.android.maggie.weatherreport.data;

import com.google.gson.annotations.Expose;

/**
 * Created by Magisus on 4/22/2015.
 */
public class Coord {

    @Expose
    private Double lon;
    @Expose
    private Double lat;

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
