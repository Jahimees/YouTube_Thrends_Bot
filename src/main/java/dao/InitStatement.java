package dao;

import connection.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InitStatement {
    private static PreparedStatement getUser;
    private static PreparedStatement createUser;
    private static PreparedStatement deleteUser;
    private static PreparedStatement updateUser;

    private static PreparedStatement getIllegalTag;
    private static PreparedStatement createIllegalTag;
    private static PreparedStatement deleteIllegalTag;
    private static PreparedStatement updateIllegalTag;

    private static PreparedStatement getBannedChannel;
    private static PreparedStatement createBannedChannel;
    private static PreparedStatement deleteBannedChannel;
    private static PreparedStatement updateBannedChannel;

    public static void initStatements() throws SQLException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.retrieve();
        getUser = connection.prepareStatement("SELECT * FROM user WHERE idUser=?");
        createUser = connection.prepareStatement("INSERT INTO user(idUser, firstname) VALUES (?, ?)");
        deleteUser = connection.prepareStatement("DELETE FROM user WHERE idUser=?");
        updateUser = connection.prepareStatement("UPDATE user SET idUser=?, firstname=? WHERE idUser=?");

        getIllegalTag = connection.prepareStatement("SELECT * FROM illegal_tag WHERE idIllegalTag=? AND idUser=?");
        createIllegalTag = connection.prepareStatement("INSERT INTO illegal_tag(idIllegalTag, tag, idUser) VALUES (?,?,?)");
        deleteIllegalTag = connection.prepareStatement("DELETE FROM illegal_tag WHERE idIllegalTag=? AND idUser=?");
        updateIllegalTag = connection.prepareStatement("UPDATE illegal_tag SET idIllegalTag=?, tag=?, idUser=?");

        getBannedChannel = connection.prepareStatement("SELECT * FROM banchannel WHERE idChannel=? AND idUser=?");
        createBannedChannel = connection.prepareStatement("INSERT INTO banchannel(idChannel, channel, idUser) VALUES (?,?,?)");
        deleteBannedChannel = connection.prepareStatement("DELETE FROM banchannel WHERE idChannel=? AND idUser=?");
        updateBannedChannel = connection.prepareStatement("UPDATE banchannel SET idChannel=?, channel=?, idUser=?");

        connectionPool.putback(connection);
    }

    public static PreparedStatement getCreateUser() {
        return createUser;
    }

    public static PreparedStatement getDeleteUser() {
        return deleteUser;
    }

    public static PreparedStatement getUpdateUser() {
        return updateUser;
    }

    public static PreparedStatement getGetUser() {
        return getUser;
    }

    public static PreparedStatement getGetIllegalTag() {
        return getIllegalTag;
    }

    public static PreparedStatement getCreateIllegalTag() {
        return createIllegalTag;
    }

    public static PreparedStatement getDeleteIllegalTag() {
        return deleteIllegalTag;
    }

    public static PreparedStatement getUpdateIllegalTag() {
        return updateIllegalTag;
    }

    public static PreparedStatement getGetBannedChannel() {
        return getBannedChannel;
    }

    public static PreparedStatement getCreateBannedChannel() {
        return createBannedChannel;
    }

    public static PreparedStatement getDeleteBannedChannel() {
        return deleteBannedChannel;
    }

    public static PreparedStatement getUpdateBannedChannel() {
        return updateBannedChannel;
    }
}
