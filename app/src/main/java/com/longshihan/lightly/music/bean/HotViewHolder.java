package com.longshihan.lightly.music.bean;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.longshihan.lightly.music.R;

/**
 * @author Administrator
 * @time 2016/6/24 12:23
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class HotViewHolder extends RecyclerView.ViewHolder {
    TextView itemnum;//喜欢人数
    TextView itemdetail;//细节
    ImageView img;//专辑图片

    public HotViewHolder(View view) {
        super(view);
        itemnum = (TextView) view.findViewById(R.id.detail_musichot_num);
        itemdetail = (TextView) view.findViewById(R.id.detail_musichot_detail);
        img = (ImageView) view.findViewById(R.id.detail_musichot_img);
    }
}
