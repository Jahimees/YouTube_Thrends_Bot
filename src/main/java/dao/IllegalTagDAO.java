package dao;

import connection.ConnectionPool;
import entity.Entity;
import entity.IllegalTag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IllegalTagDAO implements DAO {


    public Entity get(String tagStr, int idUser) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.retrieve();
        IllegalTag tag = new IllegalTag();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM illegal_tag WHERE tag=? AND idUser=?");
            statement.setString(1, tagStr);
            statement.setInt(2, idUser);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                tag.setIdIllegalTag(resultSet.getInt("idIllegalTag"));
                tag.setTag(resultSet.getString("tag"));
                tag.setIdUser(resultSet.getInt("idUser"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.putback(connection);
        }
        return tag;
    }

    /**
     * @deprecated
     * @param id
     * @return
     */
    public Entity get(int id) {
        return null;
    }

    public ArrayList<IllegalTag> getAllIllegalTags(int idUser) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.retrieve();
        ArrayList<IllegalTag> list = new ArrayList<>();
        IllegalTag illegalTag;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM illegal_tag WHERE idUser=?");
            statement.setInt(1, idUser);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                illegalTag = new IllegalTag();
                illegalTag.setIdIllegalTag(resultSet.getInt("idIllegalTag"));
                illegalTag.setTag(resultSet.getString("tag"));
                illegalTag.setIdUser(resultSet.getInt("idUser"));
                list.add(illegalTag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.putback(connection);
        }
        return list;
    }

    public boolean create(Entity entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.retrieve();
        boolean result = false;
        IllegalTag tag = (IllegalTag) entity;

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO illegal_tag(tag, idUser) VALUES (?,?)");
            statement.setString(1, tag.getTag());
            statement.setInt(2, tag.getIdUser());
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
        boolean result = false;
        IllegalTag tag = (IllegalTag) entity;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM illegal_tag WHERE tag=? AND idUser=?");
            statement.setString(1, tag.getTag());
            statement.setInt(2, tag.getIdUser());
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
        IllegalTag tag = (IllegalTag) entity;

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE illegal_tag SET tag=?, idUser=?");
            statement.setInt(2, tag.getIdUser());
            statement.setString(1, tag.getTag());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.putback(connection);
        }
        return result;
    }
}
