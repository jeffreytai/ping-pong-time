import api.OpenWeatherMap;
import slack.SlackWebhook;

public class WeatherRunner {

    public WeatherRunner() {}

    /**
     * Primary runner
     */
    public void run() {
        OpenWeatherMap owm = new OpenWeatherMap();
        Double windSpeed = owm.currentWindSpeed();

        if (windSpeed < 1d) {
            sendSlackAlert(windSpeed);
        }
    }

    /**
     * Send alert to slack channel
     * @param windSpeed
     */
    private void sendSlackAlert(Double windSpeed) {
        SlackWebhook slack = new SlackWebhook("yo let's play some ping pong");

        String message = String.format("Current wind speed is %s mph, let's play", windSpeed.toString());
        slack.sendMessage(message);

        slack.shutdown();
    }
}
