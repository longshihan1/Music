package com.longshihan.lightly.music.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.longshihan.lightly.music.R;
import com.longshihan.lightly.music.bean.MusicLikeBean;

import java.util.List;

/**
 * @author Administrator
 * @time 2016/6/23 17:31
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private List<MusicLikeBean> mDatas;
    private Context context;
    private ImageLoader imageLoader;

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public NormalRecyclerViewAdapter(Context context, List<MusicLikeBean> mDatas) {
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
    public NormalRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.detile_musiclike, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    //绑定viewHolder
    @Override
    public void onBindViewHolder(final NormalRecyclerViewAdapter.MyViewHolder holder, final int position) {
        MusicLikeBean msg=mDatas.get(position);
        holder.itemname.setText(msg.getName());
       // imageLoader.DisplayImage(msg.getAuthor().getAvatar(), holder.itemphoto);
        holder.itemtitle.setText(msg.getTitle());

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
            itemname = (TextView) view.findViewById(R.id.detail_musiclike_name);
            itemtitle = (TextView) view.findViewById(R.id.detail_musiclike_title);
            img= (ImageView) view.findViewById(R.id.detail_musiclike_img);
        }
    }
}
