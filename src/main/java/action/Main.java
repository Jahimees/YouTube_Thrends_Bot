package action;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
       BotManagement.initBot();
        YoutubeConnectionManagement connectionManagment = null;
        connectionManagment = new YoutubeConnectionManagement();
        StringBuilder builder = connectionManagment.sendRequest(connectionManagment.getConnection());


    }
}
