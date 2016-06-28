package com.longshihan.lightly.music.bean;

import java.util.List;

/**
 * @author Administrator
 * @time 2016/6/27 15:33
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class TuiJianBean {

    private int error_code;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {

        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String artist_id;
            private String all_artist_id;
            private String all_artist_ting_uid;
            private String language;
            private String publishtime;
            private String album_no;
            private String toneid;
            private String all_rate;
            private String pic_small;
            private String pic_big;
            private String hot;
            private int has_mv_mobile;
            private String versions;
            private String bitrate_fee;
            private String song_id;
            private String title;
            private String ting_uid;
            private String author;
            private String album_id;
            private String album_title;
            private int is_first_publish;
            private int havehigh;
            private int charge;
            private int has_mv;
            private int learn;
            private String song_source;
            private String piao_id;
            private String korean_bb_song;
            private String resource_type_ext;
            private String mv_provider;

            public String getArtist_id() {
                return artist_id;
            }

            public void setArtist_id(String artist_id) {
                this.artist_id = artist_id;
            }

            public String getAll_artist_id() {
                return all_artist_id;
            }

            public void setAll_artist_id(String all_artist_id) {
                this.all_artist_id = all_artist_id;
            }

            public String getAll_artist_ting_uid() {
                return all_artist_ting_uid;
            }

            public void setAll_artist_ting_uid(String all_artist_ting_uid) {
                this.all_artist_ting_uid = all_artist_ting_uid;
            }

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public String getPublishtime() {
                return publishtime;
            }

            public void setPublishtime(String publishtime) {
                this.publishtime = publishtime;
            }

            public String getAlbum_no() {
                return album_no;
            }

            public void setAlbum_no(String album_no) {
                this.album_no = album_no;
            }

            public String getToneid() {
                return toneid;
            }

            public void setToneid(String toneid) {
                this.toneid = toneid;
            }

            public String getAll_rate() {
                return all_rate;
            }

            public void setAll_rate(String all_rate) {
                this.all_rate = all_rate;
            }

            public String getPic_small() {
                return pic_small;
            }

            public void setPic_small(String pic_small) {
                this.pic_small = pic_small;
            }

            public String getPic_big() {
                return pic_big;
            }

            public void setPic_big(String pic_big) {
                this.pic_big = pic_big;
            }

            public String getHot() {
                return hot;
            }

            public void setHot(String hot) {
                this.hot = hot;
            }

            public int getHas_mv_mobile() {
                return has_mv_mobile;
            }

            public void setHas_mv_mobile(int has_mv_mobile) {
                this.has_mv_mobile = has_mv_mobile;
            }

            public String getVersions() {
                return versions;
            }

            public void setVersions(String versions) {
                this.versions = versions;
            }

            public String getBitrate_fee() {
                return bitrate_fee;
            }

            public void setBitrate_fee(String bitrate_fee) {
                this.bitrate_fee = bitrate_fee;
            }

            public String getSong_id() {
                return song_id;
            }

            public void setSong_id(String song_id) {
                this.song_id = song_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTing_uid() {
                return ting_uid;
            }

            public void setTing_uid(String ting_uid) {
                this.ting_uid = ting_uid;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getAlbum_id() {
                return album_id;
            }

            public void setAlbum_id(String album_id) {
                this.album_id = album_id;
            }

            public String getAlbum_title() {
                return album_title;
            }

            public void setAlbum_title(String album_title) {
                this.album_title = album_title;
            }

            public int getIs_first_publish() {
                return is_first_publish;
            }

            public void setIs_first_publish(int is_first_publish) {
                this.is_first_publish = is_first_publish;
            }

            public int getHavehigh() {
                return havehigh;
            }

            public void setHavehigh(int havehigh) {
                this.havehigh = havehigh;
            }

            public int getCharge() {
                return charge;
            }

            public void setCharge(int charge) {
                this.charge = charge;
            }

            public int getHas_mv() {
                return has_mv;
            }

            public void setHas_mv(int has_mv) {
                this.has_mv = has_mv;
            }

            public int getLearn() {
                return learn;
            }

            public void setLearn(int learn) {
                this.learn = learn;
            }

            public String getSong_source() {
                return song_source;
            }

            public void setSong_source(String song_source) {
                this.song_source = song_source;
            }

            public String getPiao_id() {
                return piao_id;
            }

            public void setPiao_id(String piao_id) {
                this.piao_id = piao_id;
            }

            public String getKorean_bb_song() {
                return korean_bb_song;
            }

            public void setKorean_bb_song(String korean_bb_song) {
                this.korean_bb_song = korean_bb_song;
            }

            public String getResource_type_ext() {
                return resource_type_ext;
            }

            public void setResource_type_ext(String resource_type_ext) {
                this.resource_type_ext = resource_type_ext;
            }

            public String getMv_provider() {
                return mv_provider;
            }

            public void setMv_provider(String mv_provider) {
                this.mv_provider = mv_provider;
            }
        }
    }
}
