package model;

import com.google.gson.annotations.SerializedName;

public class Coordinate {

    @SerializedName("lon")
    private Double longitude;

    @SerializedName("lat")
    private Double latitude;

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
