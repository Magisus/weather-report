package hu.ait.android.maggie.weatherreport.data;

import com.google.gson.annotations.Expose;

/**
 * Created by Magisus on 4/22/2015.
 */
public class Clouds {

    @Expose
    private Integer all;

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }
}
