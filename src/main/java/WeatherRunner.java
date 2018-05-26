import api.OpenWeatherMap;
import org.joda.time.DateTime;
import slack.SlackWebhook;

import java.sql.Timestamp;

public class WeatherRunner {

    /**
     * Interval in milliseconds to run process
     */
    private static final Long TIME_INTERVAL = 60 * 60 * 1000L;

    public WeatherRunner() {}

    /**
     * Primary runner
     */
    public void run() {
        try {
            while (true) {
                DateTime currentDate = new DateTime();
                Integer dayOfWeek = currentDate.getDayOfWeek();
                Integer hourOfDay = currentDate.getHourOfDay();

                /**
                 * Only check if it's after 5pm on Fridays or after 10am on weekends
                 */
                if ((dayOfWeek == 5 && hourOfDay >= 17) || (dayOfWeek >= 6 && hourOfDay >= 9)) {
                    OpenWeatherMap owm = new OpenWeatherMap();
                    Double windSpeed = owm.currentWindSpeed();

                    if (windSpeed < 1d) {
                        String message = String.format("Current wind speed is %s mph, let's play", windSpeed.toString());
                        sendSlackAlert(message);
                    }
                }

                System.out.println(new Timestamp(System.currentTimeMillis()) + " - sleeping...");
                Thread.sleep(TIME_INTERVAL);
            }
        } catch (InterruptedException ex) {
            sendSlackAlert("Error: " + ex.toString());
        }
    }

    /**
     * Send alert to slack channel
     * @param message
     */
    private void sendSlackAlert(String message) {
        SlackWebhook slack = new SlackWebhook("yo let's play some ping pong");

        slack.sendMessage(message);

        slack.shutdown();
    }
}
