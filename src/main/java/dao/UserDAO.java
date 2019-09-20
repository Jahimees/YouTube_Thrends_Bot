package dao;

import connection.ConnectionPool;
import entity.Entity;
import entity.MyUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements DAO {
    public Entity get(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.retrieve();
        MyUser user = new MyUser();
        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE idUser=?");


            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setIdUser(resultSet.getInt("idUser"));
                user.setFirstname(resultSet.getString("firstname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.putback(connection);
        }
        return user;
    }

    public boolean create(Entity entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.retrieve();
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user(idUser, firstname) VALUES (?, ?)");
            MyUser user = (MyUser) entity;
            statement.setInt(1, user.getIdUser());
            statement.setString(2, user.getFirstname());
            result = statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.putback(connection);
        }
        return result;
    }

    public boolean delete(Entity entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.retrieve();
        MyUser user = (MyUser) entity;
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM user WHERE idUser=?");
            statement.setInt(1, user.getIdUser());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.putback(connection);
        }
        return result;
    }

    public boolean update(Entity entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.retrieve();
        boolean result = false;
        MyUser user = (MyUser) entity;

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE user SET idUser=?, firstname=? WHERE idUser=?");
            statement.setString(2, user.getFirstname());
            statement.setInt(1, user.getIdUser());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.putback(connection);
        }
        return result;
    }
}
