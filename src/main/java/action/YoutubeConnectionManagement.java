package action;

import dao.DAOExecutor;
import entity.MyUser;
import org.telegram.telegrambots.api.objects.User;

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

    public abstract static class UserRegistration {

        public static MyUser checkUserForExists(User user) {
            DAOExecutor daoExecutor = new DAOExecutor();

            MyUser myUser = new MyUser();
            if (!daoExecutor.checkUserInBase(user.getId())) {
                daoExecutor.createNewUser(user.getId(), user.getFirstName());
                myUser.setIdUser(user.getId());
                myUser.setFirstname(user.getFirstName());
                System.out.println("Создан новый пользователь");
            } else {

                myUser.setIdUser(user.getId());
                myUser.setFirstname(user.getFirstName());
                System.out.println("Такой у меня есть");
            }
            return myUser;
        }

    }
}
