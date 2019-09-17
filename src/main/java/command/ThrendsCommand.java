package command;


import action.GsonParser;
import action.YoutubeConnectionManagement;
import entity.Video;

import java.util.ArrayList;

public class ThrendsCommand implements Command {

    public String execute() {
        YoutubeConnectionManagement connectionManagement = new YoutubeConnectionManagement();
        StringBuilder builder = connectionManagement.sendRequest(connectionManagement.getConnection());
        GsonParser parser = new GsonParser();
        ArrayList<Video> list = parser.parse(builder.toString());
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            if (i<list.size()-1) {
                result += list.get(i).toString() + " ╞ ";
            } else {
                result += list.get(i).toString();
            }
        }
        return result;
    }

}
