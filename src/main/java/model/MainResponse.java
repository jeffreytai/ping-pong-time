package model;

import com.google.gson.annotations.SerializedName;

public class MainResponse {

    @SerializedName("temp")
    private Double temp;

    @SerializedName("pressure")
    private Double pressure;

    @SerializedName("humidity")
    private Double humidity;

    @SerializedName("temp_min")
    private Double minimumTemp;

    @SerializedName("temp_max")
    private Double maximumTemp;

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getMinimumTemp() {
        return minimumTemp;
    }

    public void setMinimumTemp(Double minimumTemp) {
        this.minimumTemp = minimumTemp;
    }

    public Double getMaximumTemp() {
        return maximumTemp;
    }

    public void setMaximumTemp(Double maximumTemp) {
        this.maximumTemp = maximumTemp;
    }
}
