package com.longshihan.lightly.music.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.longshihan.lightly.music.R;
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
    public View getCoverFlowItem(int i, View reuseableView, ViewGroup viewGroup) {
        CustomViewGroup customViewGroup = null;
        if (reuseableView != null) {
            customViewGroup = (CustomViewGroup) reuseableView;
        } else {
            customViewGroup = new CustomViewGroup(viewGroup.getContext());
            customViewGroup.setLayoutParams(new FancyCoverFlow.LayoutParams(300, 600));
        }

        customViewGroup.getImageView().setImageResource(this.getItem(i));
        customViewGroup.getTextViewname().setText(String.format("Item %d", i));
        customViewGroup.getTextViewtilte().setText(String.format("Item %d", i));
        customViewGroup.getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return customViewGroup;
    }
}
