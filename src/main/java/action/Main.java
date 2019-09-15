package action;

import connection.ConnectionPool;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
       BotManagement.initBot();
       YoutubeConnectionManagement connectionManagment = null;
       connectionManagment = new YoutubeConnectionManagement();
       StringBuilder builder = connectionManagment.sendRequest(connectionManagment.getConnection());

//        try {
//            Connection connection = ConnectionPool.getInstance().retrieve();
//            Statement state = connection.createStatement();
//            state.execute("INSERT INTO user (idUser, firstname) VALUES (1, 'hello')");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }
}
