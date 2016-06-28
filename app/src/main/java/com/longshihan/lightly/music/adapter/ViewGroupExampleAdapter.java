package com.longshihan.lightly.music.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import com.longshihan.lightly.music.R;
import com.longshihan.lightly.music.activity.TypeActivity;
import com.longshihan.lightly.music.view.CustomViewGroup;

import at.technikum.mti.fancycoverflow.FancyCoverFlow;
import at.technikum.mti.fancycoverflow.FancyCoverFlowAdapter;

/**
 *
 * viewpage仿galley的适配器
 * @author Administrator
 * @time 2016/6/23 15:44
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class ViewGroupExampleAdapter extends FancyCoverFlowAdapter {

    private int[] images = {R.mipmap.image1, R.mipmap.image2, R.mipmap.image3, R.mipmap.image4, R.mipmap.image5, R.mipmap.image6,};
    private String[] str={"新歌榜","热歌榜","摇滚榜","爵士榜","流行榜","欧美金曲榜","经典老歌榜","情歌对唱","影视金曲","网络歌曲"};
    private int[] type={1,2,11,12,16,21,22,23,24,25};
    private Context mContext;


    public ViewGroupExampleAdapter(Context context) {
        this.mContext=context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Integer getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getCoverFlowItem(final int i, View reuseableView, ViewGroup viewGroup) {
        CustomViewGroup customViewGroup = null;
        if (reuseableView != null) {
            customViewGroup = (CustomViewGroup) reuseableView;
        } else {
            customViewGroup = new CustomViewGroup(viewGroup.getContext());
            customViewGroup.setLayoutParams(new FancyCoverFlow.LayoutParams(300, 600));
        }

        customViewGroup.getImageView().setImageResource(this.getItem(i));
        customViewGroup.getTextViewname().setText(str[i]);
      //  customViewGroup.getTextViewtilte().setText(String.format("Item %d", i));
        customViewGroup.getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, TypeActivity.class);
                intent.putExtra("type",type[i]);
                mContext.startActivity(intent);
            }
        });

        return customViewGroup;
    }
}
