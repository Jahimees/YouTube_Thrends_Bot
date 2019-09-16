package dao;

import entity.Entity;
import entity.IllegalTag;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IllegalTagDAO implements DAO {


    public Entity get(int idIllegalTag, int idUser) {
        PreparedStatement statement = InitStatement.getGetIllegalTag();
        IllegalTag tag = new IllegalTag();

        try {
            statement.setInt(1, idIllegalTag);
            statement.setInt(2, idUser);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                tag.setIdIllegalTag(resultSet.getInt("idIllegalTag"));
                tag.setTag(resultSet.getString("tag"));
                tag.setIdUser(resultSet.getInt("idUser"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

    public boolean create(Entity entity) {
        PreparedStatement statement = InitStatement.getCreateIllegalTag();
        boolean result = false;
        IllegalTag tag = (IllegalTag) entity;

        try {
            statement.setInt(1, tag.getIdIllegalTag());
            statement.setString(2, tag.getTag());
            statement.setInt(3, tag.getIdUser());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(Entity entity) {
        PreparedStatement statement = InitStatement.getDeleteIllegalTag();
        boolean result = false;
        IllegalTag tag = (IllegalTag) entity;
        try {
            statement.setInt(1, tag.getIdIllegalTag());
            statement.setInt(2, tag.getIdUser());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(Entity entity) {
        PreparedStatement statement = InitStatement.getUpdateIllegalTag();
        boolean result = false;
        IllegalTag tag = (IllegalTag) entity;

        try {
            statement.setInt(1, tag.getIdIllegalTag());
            statement.setInt(3, tag.getIdUser());
            statement.setString(2, tag.getTag());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
