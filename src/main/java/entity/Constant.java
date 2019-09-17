package entity;

import java.sql.PreparedStatement;

public abstract class Constant {
    public static final String MAX_RESULT = "maxResults=10";
    public static final String YOUTUBE_KEY = "key=AIzaSyDCJh3y0HNKissvtz06kG3gEEQvYPF-r98";
    public static final String URL_CONNECTION =
            "https://www.googleapis.com/youtube/v3/videos?part=snippet%2CcontentDetails%2Cstatistics&maxResults=10&"
                    +MAX_RESULT
                    +"&chart=mostPopular&regionCode=BY&order=viewCount&"
                    +YOUTUBE_KEY;


    //////////////////DB CONFIGURATION///////////////
    public static final String URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
    public static final int INIT_CONNECTION_COUNT = 5;
    public static final String USER = "root";
    public static final String PASSWORD = "123";
    public static final String DRIVER = "com.mysql.jdbc.Driver";

}
