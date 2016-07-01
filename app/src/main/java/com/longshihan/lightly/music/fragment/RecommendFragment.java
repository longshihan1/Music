package com.longshihan.lightly.music.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.jude.rollviewpager.hintview.IconHintView;
import com.longshihan.lightly.music.R;
import com.longshihan.lightly.music.adapter.HotGridViewAdapter;
import com.longshihan.lightly.music.adapter.NormalRecyclerViewAdapter;
import com.longshihan.lightly.music.adapter.NormalRecyclerView_GridAdapter;
import com.longshihan.lightly.music.adapter.TestNormalAdapter;
import com.longshihan.lightly.music.adapter.ViewGroupExampleAdapter;
import com.longshihan.lightly.music.bean.MusicHotBean;
import com.longshihan.lightly.music.bean.MusicLikeBean;
import com.longshihan.lightly.music.bean.SortbangJavabean;
import com.longshihan.lightly.music.bean.TuiJianBean;
import com.longshihan.lightly.music.utils.http.Constant;
import com.longshihan.lightly.music.utils.http.Net;
import com.longshihan.lightly.music.view.FullyGridLayoutManager;
import com.longshihan.lightly.music.view.FullyLinearLayoutManager;
import com.longshihan.lightly.music.view.NewsMusic_View;

import java.util.ArrayList;
import java.util.List;

import at.technikum.mti.fancycoverflow.FancyCoverFlow;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 推荐界面—fragment
 *
 * @author longshihan
 *         created at 2016/6/22 15:39
 */
public class RecommendFragment extends Fragment {


    @InjectView(R.id.roll_view_pager)
    RollPagerView mRollViewPager;
    @InjectView(R.id.homepage_tools_add)
    NewsMusic_View mHomepageToolsAdd;
    @InjectView(R.id.home_fancyCoverFlow)
    FancyCoverFlow mHomeFancyCoverFlow;
    @InjectView(R.id.homepage_tools_like)
    NewsMusic_View mHomepageToolsLike;


    @InjectView(R.id.homepage_setbtn)
    ImageView mHomepageSetbtn;
    @InjectView(R.id.homepage_likerecy)
    RecyclerView mHomepageLikerecy;
    @InjectView(R.id.homepage_tools_hot)
    NewsMusic_View mHomepageToolsHot;
    @InjectView(R.id.homepage_hotgrid)
    GridView mHomepageHotgrid;

    private Context context;

    private NormalRecyclerViewAdapter like_adapter;
    private NormalRecyclerView_GridAdapter hot_adaoter;

    private List<MusicLikeBean> lmusiclike;
    private MusicLikeBean bean;
    private List<MusicHotBean> lmusichot;
    private MusicHotBean bean_hot;

    private FullyLinearLayoutManager mFullyLinearLayoutManager;
    private FullyGridLayoutManager mGridLayoutManager;
    private List<SortbangJavabean.SongListBean> song_bean;
    private List<TuiJianBean.ResultBean.ListBean> tui_bean;
    private HotGridViewAdapter gridViewAdapter;


    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.inject(this, view);
        context = getActivity();
        initView();
        initData();
        return view;
    }

    @Override
    public void onResume() {

        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public RecommendFragment() {
        // Required empty public constructor
    }

    private Handler handler1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (Net.SUCCESS == msg.what) {
                //String lits=msg.obj.toString();
                Gson gson=new Gson();
                SortbangJavabean sort_bean=gson.fromJson(msg.obj.toString(),SortbangJavabean.class);
                song_bean=sort_bean.getSong_list();
                like_adapter = new NormalRecyclerViewAdapter(context, song_bean);//一个javabean
                ViewGroup.LayoutParams mParams = mHomepageLikerecy.getLayoutParams();
                mParams.height = 230 * like_adapter.getItemCount();
                mHomepageLikerecy.setLayoutParams(mParams);
                mHomepageLikerecy.setAdapter(like_adapter);
                mHomepageLikerecy.setNestedScrollingEnabled(false);
            }
        }
    };

    private Handler handler2 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (Net.SUCCESS == msg.what) {
                //String lits=msg.obj.toString();
                Gson gson=new Gson();
                TuiJianBean tuijian_bean=gson.fromJson(msg.obj.toString(),TuiJianBean.class);
                tui_bean=tuijian_bean.getResult().getList();
                gridViewAdapter= new HotGridViewAdapter(tui_bean, context);
                mHomepageHotgrid.setAdapter(gridViewAdapter);


            }
        }
    };



    private void initData() {

        Net.sendHttpGet(context,handler2,"hot", Constant.TUIJIAN,null,null,null);
        Net.sendHttpGet(context,handler1,"like", Constant.BAIDU+Constant.BAIDU_LIST,"1","10","0");
    }

    private void initView() {
        //song_bean=new ArrayList<>();
        tui_bean=new ArrayList<>();

        initlunbo();
        initNewsMusic();
        initLike();
        initHot();


    }

    private void initHot() {
        mHomepageToolsAdd.setAddTestView("热门歌单");
        lmusichot = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            bean_hot = new MusicHotBean();
            bean_hot.setDetail("贵妃醉酒" + i);
            bean_hot.setNum("111111" + i);
            lmusichot.add(bean_hot);
        }


        //添加消息处理
        mHomepageHotgrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
       /* mGridLayoutManager = new FullyGridLayoutManager(context, 4);
        mGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mGridLayoutManager.setSmoothScrollbarEnabled(true);
        mHomepageHotrecy.setLayoutManager(mGridLayoutManager);
        hot_adaoter = new NormalRecyclerView_GridAdapter(context, lmusichot);//一个javabean
        ViewGroup.LayoutParams mParams = mHomepageHotrecy.getLayoutParams();
        mParams.height = 230 * ((hot_adaoter.getItemCount()/4)+1);
        mHomepageHotrecy.setLayoutParams(mParams);
        mHomepageHotrecy.setAdapter(hot_adaoter);
        mHomepageHotrecy.setNestedScrollingEnabled(false);*/

    }

    private void initLike() {
        mHomepageToolsLike.setAddTestView("猜你喜欢");
        lmusiclike = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            bean = new MusicLikeBean();
            bean.setTitle("贵妃醉酒" + i);
            bean.setName("李玉刚" + i);
            lmusiclike.add(bean);
        }
        mFullyLinearLayoutManager = new FullyLinearLayoutManager(context);
        mFullyLinearLayoutManager.setOrientation(FullyLinearLayoutManager.VERTICAL);
        mHomepageLikerecy.setLayoutManager(mFullyLinearLayoutManager);//这里用线性显示 类似于listview

        //        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));//这里用线性宫格显示
        // 类似于grid view
        //        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
        // OrientationHelper.VERTICAL));//这里用线性宫格显示 类似于瀑布流


    }

    /**
     * 最新音乐控件
     */
    private void initNewsMusic() {
        mHomepageToolsAdd.setAddTestView("最新音乐");
        mHomeFancyCoverFlow.setAdapter(new ViewGroupExampleAdapter(context));
        mHomeFancyCoverFlow.setMaxRotation(45);
        mHomeFancyCoverFlow.setUnselectedAlpha(0.3f);
        mHomeFancyCoverFlow.setUnselectedSaturation(0.0f);
        mHomeFancyCoverFlow.setUnselectedScale(0.4f);
        //进入最新音乐界面
        mHomepageToolsAdd.setOnClickListener(new NewsMusic_View.OnMoreClickListener() {
            @Override
            public void onMoreClick() {

            }
        });
    }

    /**
     * 轮播图控件设置
     */
    private void initlunbo() {
        //设置播放时间间隔
        mRollViewPager.setPlayDelay(1000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());
        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        mRollViewPager.setHintView(new IconHintView(context, R.mipmap.point_focus, R.mipmap
                .point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(context, Color.YELLOW, Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);
    }

}
