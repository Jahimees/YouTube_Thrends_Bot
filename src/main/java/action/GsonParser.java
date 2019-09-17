package action;

import entity.Video;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;

public class GsonParser {
    private String title;
    private String channelId;
    private String channelTitle;
    private String idVideo;
    private ArrayList<String> tags;

    private String imageUrl;
    private long viewCount;
    private long likeCount;
    private long dislikeCount;
    public ArrayList<Video> parse(String json) {
        ArrayList<Video> videoList = new ArrayList<Video>();
        try {
            JSONObject o = (JSONObject) new JSONParser().parse(json);
            JSONArray jsonItems = (JSONArray) o.get("items");
            Iterator iterator = jsonItems.iterator();
            Video video;

            while (iterator.hasNext()) {
                video = new Video();
                JSONObject nextItem =  (JSONObject) iterator.next();
                idVideo = nextItem.get("id").toString();

                JSONObject statistics = (JSONObject) nextItem.get("statistics");
                statisticParser(statistics);

                JSONObject snippet = (JSONObject) nextItem.get("snippet");
                snippetParser(snippet);

                video.setChannelId(channelId);
                video.setChannelTitle(channelTitle);
                video.setIdVideo(idVideo);
                video.setTitle(title);
                video.setTags(tags);
                video.setImgUrl(imageUrl);
                video.setViewCount(viewCount);
                video.setLikeCount(likeCount);
                video.setDislikeCount(dislikeCount);

                videoList.add(video);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return videoList;
    }

    private void snippetParser(JSONObject snippet) {
        title = snippet.get("title").toString();
        channelId = snippet.get("channelId").toString();
        channelTitle = snippet.get("channelTitle").toString();
        tags = (JSONArray) snippet.get("tags");
        imageUrl = ((JSONObject)
                ((JSONObject) snippet.get("thumbnails")).
                                        get("standard")).
                                            get("url").toString();
    }

    private void statisticParser(JSONObject statistics) {
        viewCount = Long.parseLong(statistics.get("viewCount").toString());
        likeCount = Long.parseLong(statistics.get("likeCount").toString());
        dislikeCount = Long.parseLong(statistics.get("dislikeCount").toString());

    }
}
