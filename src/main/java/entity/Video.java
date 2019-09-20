package entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Video {
    private String idVideo;
    private String title;
    private String imgUrl;
    private String channelId;
    private String channelTitle;
    private Set<String> tags = new HashSet<>();
    private long viewCount;
    private long likeCount;
    private long dislikeCount;


    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(long likeCount) {
        this.likeCount = likeCount;
    }

    public long getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(long dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    @Override
    public String toString(){
        String tagsStr = "";
        for (String tag1 : tags) {
            tagsStr+=tag1 + ", ";
        }
        String result = "Title: " + title + "\n" +
                        "Url video: " + idVideo + "\n" +
                        "Channel Title: " + channelTitle + "\n" +
                        "Tags: " + tagsStr + "\n" +
                        "View count: " + viewCount + "\n" +
                        "Like count: " + likeCount + "\n" +
                        "Dislike count: " + dislikeCount + "\n" +
                        "Image url: " + imgUrl + "\n";

        return result;
    }

}
