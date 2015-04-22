package hu.ait.android.maggie.weatherreport.data;

import com.google.gson.annotations.Expose;

/**
 * Created by Magisus on 4/22/2015.
 */
public class Weather {

    @Expose
    private Integer id;
    @Expose
    private String main;
    @Expose
    private String description;
    @Expose
    private String icon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
