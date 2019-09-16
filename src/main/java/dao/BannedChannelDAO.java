package dao;

import entity.BannedChannel;
import entity.Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BannedChannelDAO implements DAO {
    /**
     * @deprecated
     * @param id
     * @return
     */
    public Entity get(int id) {
        return null;
    }

    public Entity get(int idChannel, int idUser) {
        PreparedStatement statement = InitStatement.getGetBannedChannel();
        BannedChannel channel = new BannedChannel();

        try {
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
        }

        return channel;

    }

    public boolean create(Entity entity) {
        PreparedStatement statement = InitStatement.getCreateBannedChannel();
        BannedChannel channel = (BannedChannel) entity;
        boolean result = false;

        try {
            statement.setInt(1, channel.getIdChannel());
            statement.setString(2, channel.getChannelName());
            statement.setInt(3, channel.getIdUser());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(Entity entity) {
        PreparedStatement statement = InitStatement.getDeleteBannedChannel();
        BannedChannel channel = (BannedChannel) entity;
        boolean result = false;

        try {
            statement.setInt(1, channel.getIdChannel());
            statement.setInt(2, channel.getIdUser());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(Entity entity) {
        PreparedStatement statement = InitStatement.getUpdateBannedChannel();
        BannedChannel channel = (BannedChannel) entity;
        boolean result = false;

        try {
            statement.setInt(1, channel.getIdChannel());
            statement.setInt(3, channel.getIdUser());
            statement.setString(2, channel.getChannelName());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
