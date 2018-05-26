package slack;

import allbegray.slack.SlackClientFactory;
import allbegray.slack.type.Payload;
import allbegray.slack.webhook.SlackWebhookClient;

import java.io.InputStream;
import java.util.Properties;

public class SlackWebhook {

    private SlackWebhookClient webhookClient;
    private String username;

    public SlackWebhook(String webhookUrl, String username) {
        this.webhookClient = SlackClientFactory.createWebhookClient(webhookUrl);
        this.username = username;
    }

    public SlackWebhook(String username) {
        try {
            Properties props = new Properties();
            InputStream stream = SlackWebhook.class.getClassLoader().getResourceAsStream("slack.properties");
            props.load(stream);
            stream.close();

            this.webhookClient = SlackClientFactory.createWebhookClient(props.getProperty("webhook-url"));
            this.username = username;
        } catch (Throwable ex) {
            System.err.println("Error in retrieving Slack properties");
            ex.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        Payload payload = new Payload();
        payload.setUsername(this.username);
        payload.setText(message);

        this.webhookClient.post(payload);
    }

    public void shutdown() {
        this.webhookClient.shutdown();
    }
}
