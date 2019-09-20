package dao;

import connection.ConnectionPool;
import entity.BannedChannel;
import entity.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BannedChannelDAO implements DAO {
    /**
     * @deprecated
     * @param id
     * @return
     */
    public Entity get(int id) {
        return null;
    }

    //THRENDS
    public ArrayList<BannedChannel> getAllUser(int idUser) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.retrieve();
        ArrayList<BannedChannel> bannedChannels = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM banchannel WHERE idUser=?");
            statement.setInt(1, idUser);
            ResultSet resultSet = statement.executeQuery();
            BannedChannel bannedChannel;
            while (resultSet.next()) {
                bannedChannel = new BannedChannel();
                bannedChannel.setIdUser(resultSet.getInt("idUser"));
                bannedChannel.setChannelName(resultSet.getString("channel"));
                bannedChannel.setIdChannel(resultSet.getInt("idChannel"));
                bannedChannels.add(bannedChannel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.putback(connection);
        }
        return bannedChannels;
    }

    public Entity get(int idChannel, int idUser) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.retrieve();

        BannedChannel channel = new BannedChannel();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM banchannel WHERE idChannel=? AND idUser=?");
            statement.setInt(1, idChannel);
            statement.setInt(2, idUser);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                channel.setIdChannel(resultSet.getInt("idChannel"));
                channel.setChannelName(resultSet.getString("channel"));
                channel.setIdUser(resultSet.getInt("idUser"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.putback(connection);
        }

        return channel;

    }

    public boolean create(Entity entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.retrieve();
        BannedChannel channel = (BannedChannel) entity;
        boolean result = false;

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO banchannel(idChannel, channel, idUser) VALUES (?,?,?)");
            statement.setInt(1, channel.getIdChannel());
            statement.setString(2, channel.getChannelName());
            statement.setInt(3, channel.getIdUser());
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

        BannedChannel channel = (BannedChannel) entity;
        boolean result = false;

        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM banchannel WHERE channel=? AND idUser=?");
            statement.setString(1, channel.getChannelName());
            statement.setInt(2, channel.getIdUser());
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
        BannedChannel channel = (BannedChannel) entity;
        boolean result = false;

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE banchannel SET idChannel=?, channel=?, idUser=?");
            statement.setInt(1, channel.getIdChannel());
            statement.setInt(3, channel.getIdUser());
            statement.setString(2, channel.getChannelName());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.putback(connection);
        }
        return result;
    }
}
