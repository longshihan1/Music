package com.longshihan.lightly.music.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.longshihan.lightly.music.R;
import com.longshihan.lightly.music.bean.TuiJianBean;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

import java.util.List;

/**
 * @author Administrator
 * @time 2016/6/27 13:36
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class HotGridViewAdapter extends BaseAdapter {
    private List<TuiJianBean.ResultBean.ListBean> mMusicHotBeanList;
    private Context mContext;
    private LayoutInflater inflater;

    public HotGridViewAdapter(List<TuiJianBean.ResultBean.ListBean> musicHotBeanList, Context context) {
        mMusicHotBeanList = musicHotBeanList;
        mContext = context;
        this.inflater = LayoutInflater.from(mContext);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView==null) {
            holder=new ViewHolder();
            convertView= inflater.inflate(R.layout.detail_musichot, null);
            holder.iv=(ImageView) convertView.findViewById(R.id.detail_musichot_img);
            holder.tv_num=(TextView) convertView.findViewById(R.id.detail_musichot_num);
            holder.tv_detaile=(TextView) convertView.findViewById(R.id.detail_musichot_detail);
            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder) convertView.getTag();
        }
       // holder.iv.setImageResource(iconarray[position]);
        TuiJianBean.ResultBean.ListBean musicHotBean=new TuiJianBean.ResultBean.ListBean();
        musicHotBean=mMusicHotBeanList.get(position);
        holder.tv_num.setText(musicHotBean.getHot());
        holder.tv_detaile.setText(musicHotBean.getAlbum_title());
        ImageLoader.getInstance().loadImage(musicHotBean.getPic_big(), new SimpleImageLoadingListener(){

            @Override
            public void onLoadingComplete(String imageUri, View view,
                                          Bitmap loadedImage) {
                super.onLoadingComplete(imageUri, view, loadedImage);
                holder.iv.setImageBitmap(loadedImage);
            }
        });
        return convertView;
    }

    private class ViewHolder{
        ImageView iv;
        TextView tv_num;
        TextView tv_detaile;
    }

    /*
     * 功能：获得当前选项的ID
     *
     * @see android.widget.Adapter#getItemId(int)
     */
    @Override
    public long getItemId(int position) {
        //System.out.println("getItemId = " + position);
        return position;
    }

    /*
     * 功能：获得当前选项
     *
     * @see android.widget.Adapter#getItem(int)
     */
    @Override
    public Object getItem(int position) {
        return position;
    }

    /*
     * 获得数量
     *
     * @see android.widget.Adapter#getCount()
     */
    @Override
    public int getCount() {
        return mMusicHotBeanList.size();
    }
}
