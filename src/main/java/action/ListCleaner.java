package action;

import entity.BannedChannel;
import entity.IllegalTag;
import entity.Video;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class ListCleaner {

    public static ArrayList<Video> clearFromBannedChannels(ArrayList<Video> videos, ArrayList<BannedChannel> bannedChannels) {
        for (int i=0; i<videos.size(); i++) {
            String banned = videos.get(i).getChannelTitle();

            Set<String> bannedStr = new HashSet<>();
            for (BannedChannel bannedChannel : bannedChannels) {
                bannedStr.add(bannedChannel.getChannelName());
            }

            if (bannedStr.contains(banned)) {
                videos.remove(i);
                i--;
            }
        }
        return videos;
    }

    public static ArrayList<Video> clearFromIllegalTags(ArrayList<Video> videos, ArrayList<IllegalTag> illegalTags) {
        for (int i=0; i < videos.size(); i++) {
            Video video = videos.get(i);
            Set<String> videoTags = video.getTags();
            for (IllegalTag illegalTag : illegalTags) {
                if (videoTags.contains(illegalTag.getTag())) {
                    videos.remove(video);
                    i--;
                    break;
                }
            }
        }
        return videos;
    }
}

