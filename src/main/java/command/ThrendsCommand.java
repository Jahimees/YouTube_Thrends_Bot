package command;


import action.BotManagement;
import action.GsonParser;
import action.ListCleaner;
import action.YoutubeConnectionManagement;
import dao.DAOExecutor;
import entity.BannedChannel;
import entity.IllegalTag;
import entity.MyUser;
import entity.Video;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.User;

import java.util.ArrayList;

public class ThrendsCommand implements Command {

    public void execute(BotManagement botManagement) {
        Message message = BotManagement.getMessage();
        YoutubeConnectionManagement connectionManagement = new YoutubeConnectionManagement();
        StringBuilder builder = connectionManagement.sendRequest(connectionManagement.getConnection());
        GsonParser parser = new GsonParser();
        ArrayList<Video> list = parser.parse(builder.toString());

        DAOExecutor daoExecutor = new DAOExecutor();
        User user = message.getFrom();//////
        MyUser myUser = YoutubeConnectionManagement.UserRegistration.checkUserForExists(user);

        ArrayList<BannedChannel> bannedChannels = daoExecutor.getAllBannedChannels(myUser.getIdUser());
        System.out.println("BANNED");
        for (BannedChannel bannedChannel: bannedChannels) {
            System.out.println(bannedChannel.getChannelName());
        }
        ArrayList<IllegalTag> illegalTags = daoExecutor.getAllIllegalTags(myUser.getIdUser());
        list = ListCleaner.clearFromBannedChannels(list, bannedChannels);
        list = ListCleaner.clearFromIllegalTags(list, illegalTags);

        for (Video video : list) {
            botManagement.sendMsg(message, clearMessage(video.toString()));
        }
    }

    private String clearMessage(String dirty) {
        return dirty.replace("_", "\\_")
                .replace("*", "\\*")
                .replace("[", "\\[")
                .replace("`", "\\`");
    }


}
