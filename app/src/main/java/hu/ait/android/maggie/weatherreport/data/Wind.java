package hu.ait.android.maggie.weatherreport.data;

import com.google.gson.annotations.Expose;

/**
 * Created by Magisus on 4/22/2015.
 */
public class Wind {

    @Expose
    private Double speed;
    @Expose
    private Double deg;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDeg() {
        return deg;
    }

    public void setDeg(Double deg) {
        this.deg = deg;
    }
}
