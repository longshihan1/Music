package com.longshihan.lightly.music.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.db.entity.Localmusic;
import com.longshihan.lightly.music.R;

import java.util.List;

/**
 * @author Administrator
 * @time 2016/6/23 17:31
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class DANMusicRecyclerViewAdapter extends RecyclerView.Adapter<DANMusicRecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private List<Localmusic> mDatas;
    private Context context;
   // private ImageLoader imageLoader;

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public DANMusicRecyclerViewAdapter(Context context, List<Localmusic> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(context);
       // imageLoader = new ImageLoader(context);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    //创建ViewHolder
    @Override
    public DANMusicRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.detail_danmusic, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    //绑定viewHolder
    @Override
    public void onBindViewHolder(final DANMusicRecyclerViewAdapter.MyViewHolder holder, final int position) {
        Localmusic msg=mDatas.get(position);
        holder.itemname.setText(msg.getArtist());
       // imageLoader.DisplayImage(msg.getPic_big(), holder.img);
       /* ImageLoader.getInstance().loadImage(msg.getPic_small(), new SimpleImageLoadingListener(){

            @Override
            public void onLoadingComplete(String imageUri, View view,
                                          Bitmap loadedImage) {
                super.onLoadingComplete(imageUri, view, loadedImage);
                holder.img.setImageBitmap(loadedImage);
            }
        });*/
        holder.itemtitle.setText(msg.getTitle_name());
        if (mOnItemClickLitener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
            //longClick
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    //removeData(pos);
                    return false;
                }
            });
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemname;//歌手
        TextView itemtitle;//歌曲
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            itemname = (TextView) view.findViewById(R.id.detail_danmusic_author);
            itemtitle = (TextView) view.findViewById(R.id.detail_danmusic_title);
            img= (ImageView) view.findViewById(R.id.detail_danmusic_setting);
        }
    }
}
