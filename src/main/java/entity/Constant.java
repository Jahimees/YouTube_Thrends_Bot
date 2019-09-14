package entity;

public abstract class Constant {
    public static final String MAX_RESULT = "maxResults=10";
    public static final String YOUTUBE_KEY = "key=AIzaSyDCJh3y0HNKissvtz06kG3gEEQvYPF-r98";
    public static final String URL_CONNECTION =
            "https://www.googleapis.com/youtube/v3/videos?part=snippet%2CcontentDetails%2Cstatistics&"
                    +MAX_RESULT
                    +"&chart=mostPopular&regionCode=BY&order=viewCount&"
                    +YOUTUBE_KEY;

}
