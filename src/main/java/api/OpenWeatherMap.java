package api;

import com.google.gson.Gson;
import model.WeatherResponse;
import utils.ApiHelper;

import java.io.IOException;

public class OpenWeatherMap {

    /**
     * Base open weather map url to query by zip code
     */
    private static final String BASE_WEATHER_ZIP_URL = "http://api.openweathermap.org/data/2.5/weather?zip=%s,us&appid=%s";

    /**
     * App specific id
     */
    private static final String APP_ID = "6c0124bf86dde3ec8153151663db3e5f";

    /**
     * Local zip code
     */
    private static final String ZIPCODE = "90016";

    /**
     * Google JSON unit
     */
    private static Gson gson;

    public OpenWeatherMap() {
        gson = new Gson();
    }

    /**
     * Retrieve the current wind speed
     * @return
     */
    public Double currentWindSpeed() {
        try {
            String url = String.format(BASE_WEATHER_ZIP_URL, ZIPCODE, APP_ID);
            String weatherJson = ApiHelper.readUrl(url);
            WeatherResponse response = gson.fromJson(weatherJson, WeatherResponse.class);

            Double windSpeed = response.getWind().getSpeed();
            return windSpeed;
        } catch (IOException ex) {
            System.out.println("Error in finding wind speed");
            ex.printStackTrace();
        }

        return null;
    }
}
