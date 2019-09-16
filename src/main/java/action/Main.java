package action;

import connection.ConnectionPool;
import dao.InitStatement;
import dao.UserDAO;
import entity.User;

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
//            InitStatement.initStatements();
//            UserDAO userDAO = new UserDAO();
//            User user = new User();
//            user.setIdUser(3);
//            user.setFirstname("hi");
//            userDAO.create(user);
//
//            User newUser = (User) userDAO.get(user.getIdUser());
//            System.out.println(newUser.getFirstname());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }



    }
}
