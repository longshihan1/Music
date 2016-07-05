package com.longshihan.lightly.music.server;

/**
 * @author Administrator
 * @time 2016/7/5 17:36
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class AudioPlayer {
    public static native int play();
    public static native int stop();

    static {
        System.loadLibrary("AudioPlayer");
    }
}
