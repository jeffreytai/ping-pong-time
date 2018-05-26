package model;

import com.google.gson.annotations.SerializedName;

public class Clouds {

    @SerializedName("all")
    private Double all;

    public Double getAll() {
        return all;
    }

    public void setAll(Double all) {
        this.all = all;
    }
}
