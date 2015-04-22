package hu.ait.android.maggie.weatherreport.data;

import com.google.gson.annotations.Expose;

/**
 * Created by Magisus on 4/22/2015.
 */
public class Sys {

    @Expose
    private Double message;
    @Expose
    private String country;
    @Expose
    private Integer sunrise;
    @Expose
    private Integer sunset;

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    public Integer getSunset() {
        return sunset;
    }

    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }

}
