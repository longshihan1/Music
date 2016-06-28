package com.longshihan.lightly.music.utils.http;

/**
 * @author Administrator
 * @time 2016/6/16 11:40
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class Constant {
    public static String BAIDU="http://tingapi.ting.baidu.com/v1/restserver/ting?format=json&calback=&from=webapp_music&";
    public static String BAIDU_LIST="method=baidu.ting.billboard.billList";
    public static String BAIDU_LISTPAGE="&size=";
    public static String BAIDU_LISTPAGE_OFFSET="&offset";
    public static String TUIJIAN="http://tingapi.ting.baidu.com/v1/restserver/ting?format=json&calback=&from=webapp_music&method=baidu.ting.song.getRecommandSongList&song_id=877578&num=12";
}
