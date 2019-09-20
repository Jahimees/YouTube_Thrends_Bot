package dao;

import entity.BannedChannel;
import entity.IllegalTag;
import entity.MyUser;

import java.util.ArrayList;

public class DAOExecutor {

    public boolean checkUserInBase(int idUser) {
        UserDAO userDAO = new UserDAO();
        MyUser myUser = (MyUser) userDAO.get(idUser);
        if (myUser.getIdUser() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean createNewUser(int idUser, String firstname) {
        UserDAO userDAO = new UserDAO();
        MyUser myUser = new MyUser();
        myUser.setFirstname(firstname);
        myUser.setIdUser(idUser);
        return userDAO.create(myUser);
    }

    public ArrayList<BannedChannel> getAllBannedChannels(int idUser) {
        BannedChannelDAO bannedChannelDAO = new BannedChannelDAO();
        ArrayList<BannedChannel> list = bannedChannelDAO.getAllUser(idUser);
        return list;
    }

    public ArrayList<IllegalTag> getAllIllegalTags(int idUser) {
        IllegalTagDAO illegalTagDAO = new IllegalTagDAO();
        ArrayList<IllegalTag> list = illegalTagDAO.getAllIllegalTags(idUser);
        return list;
    }

    public boolean addIllegalTag(int idUser, String tag) {
        IllegalTagDAO illegalTagDAO = new IllegalTagDAO();
        IllegalTag illegalTag = new IllegalTag();
        illegalTag.setIdUser(idUser);
        illegalTag.setTag(tag);
        return illegalTagDAO.create(illegalTag);

    }

    public boolean removeIllegalTag(int idUser, String tag){
        IllegalTagDAO illegalTagDAO = new IllegalTagDAO();
        IllegalTag illegalTag = new IllegalTag();
        illegalTag.setIdUser(idUser);
        illegalTag.setTag(tag);
        return illegalTagDAO.delete(illegalTag);
    }

    public boolean banChannel(int idUser, String channel) {
        BannedChannelDAO bannedChannelDAO = new BannedChannelDAO();
        BannedChannel bannedChannel = new BannedChannel();
        bannedChannel.setIdUser(idUser);
        bannedChannel.setChannelName(channel);
        return bannedChannelDAO.create(bannedChannel);
    }

    public boolean unbunChannel(int idUser, String channel) {
        BannedChannelDAO bannedChannelDAO = new BannedChannelDAO();
        BannedChannel bannedChannel = new BannedChannel();
        bannedChannel.setIdUser(idUser);
        bannedChannel.setChannelName(channel);
        return bannedChannelDAO.delete(bannedChannel);
    }
    //THRENDS COMMAND
}
