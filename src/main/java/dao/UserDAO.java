package dao;

import entity.Entity;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements DAO {
    public Entity get(int id) {
        PreparedStatement statement = InitStatement.getGetUser();

        User user = new User();
        try {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setIdUser(resultSet.getInt("idUser"));
                user.setFirstname(resultSet.getString("firstname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean create(Entity entity) {
        PreparedStatement statement = InitStatement.getCreateUser();
        User user = (User) entity;
        boolean result = false;

        try {
            statement.setInt(1, user.getIdUser());
            statement.setString(2, user.getFirstname());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean delete(Entity entity) {
        PreparedStatement statement = InitStatement.getDeleteUser();
        User user = (User) entity;
        boolean result = false;

        try {
            statement.setInt(1, user.getIdUser());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(Entity entity) {
        PreparedStatement statement = InitStatement.getUpdateUser();
        boolean result = false;
        User user = (User) entity;

        try {
            statement.setString(2, user.getFirstname());
            statement.setInt(1, user.getIdUser());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
