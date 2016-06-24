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
import com.longshihan.lightly.music.bean.MusicHotBean;

import java.util.List;

/**
 * @author Administrator
 * @time 2016/6/23 17:31
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class NormalRecyclerView_GridAdapter extends RecyclerView.Adapter<NormalRecyclerView_GridAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private List<MusicHotBean> mDatas;
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

    public NormalRecyclerView_GridAdapter(Context context, List<MusicHotBean> mDatas) {
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
    public NormalRecyclerView_GridAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.detail_musichot, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    //绑定viewHolder
    @Override
    public void onBindViewHolder(final NormalRecyclerView_GridAdapter.MyViewHolder holder, final int position) {
        MusicHotBean msg=mDatas.get(position);
        holder.itemnum.setText(msg.getNum());
       // imageLoader.DisplayImage(msg.getAuthor().getAvatar(), holder.itemphoto);
        holder.itemdetail.setText(msg.getDetail());

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

        TextView itemnum;//喜欢人数
        TextView itemdetail;//细节
        ImageView img;//专辑图片

        public MyViewHolder(View view) {
            super(view);
            itemnum = (TextView) view.findViewById(R.id.detail_musichot_num);
            itemdetail = (TextView) view.findViewById(R.id.detail_musichot_detail);
            img= (ImageView) view.findViewById(R.id.detail_musichot_img);
        }
    }
}
