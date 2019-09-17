package action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static entity.Constant.URL_CONNECTION;

public class YoutubeConnectionManagement {
    private HttpURLConnection connection = null;

    public YoutubeConnectionManagement() {
        connection = getConnection();
    }

    public HttpURLConnection getConnection() {
        if (connection == null) {
            try {
                connection = (HttpURLConnection) new URL(URL_CONNECTION).openConnection();
                connection.setRequestMethod("GET");
                connection.setUseCaches(false);
                connection.setConnectTimeout(250);
                connection.setReadTimeout(1250);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }

    public StringBuilder sendRequest(HttpURLConnection connection) {
        StringBuilder builder = new StringBuilder();

        try {
            connection.connect();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                String line;

                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                    builder.append("\n");
                }
                return builder;
            } else {
                System.out.println("Error" + connection.getResponseMessage() + " " + connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return null;
    }

}
