package com.longshihan.lightly.music.utils;

import android.content.Context;
import android.util.Log;

import com.db.entity.Localmusic;
import com.longshihan.lightly.music.db.DaoManager;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;

/**
 * 完成对某个表的具体操作，ORM操作的是对象
 *
 * @author Administrator
 * @time 2016/6/28 15:04
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class CommonUtils {
    private DaoManager mDaoManager;

    public CommonUtils(Context context) {
        mDaoManager = DaoManager.getInstance();
        mDaoManager.init(context);
    }

    /**
     * 完成对数据库中localmusic的插入
     *
     * @param music
     * @return
     */
    public boolean insertMusic(Localmusic music) {
        boolean flag = false;
        flag = mDaoManager.getDaoSession().insert(music) != -1 ? true : false;
        return flag;
    }

    /**
     * 插入多条数据，开启多线程
     *
     * @param music
     * @return
     */
    public boolean insertMultMusic(final List<Localmusic> music) {
        boolean flag = false;
        Log.e("insert", music.size() + "");
        try {
            mDaoManager.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (Localmusic loccl_music : music) {
                        mDaoManager.getDaoSession().insertOrReplace(loccl_music);
                    }
                }
            });
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * 完成对Music表的某一条记录的修改
     *
     * @param localmusic
     * @return
     */
    public boolean updateMusic(Localmusic localmusic) {
        boolean flag = false;
        try {
            mDaoManager.getDaoSession().update(localmusic);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * 根据ID删除数据库数据
     *
     * @param localmusic
     * @return
     */
    public boolean deleteMusic(Localmusic localmusic) {
        boolean flag = false;
        try {
            //按照指定的id 进行删除，delete from music where _id=?
            mDaoManager.getDaoSession().delete(localmusic);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 返回多行记录
     *
     * @return
     */
    public List<Localmusic> listall() {
        return mDaoManager.getDaoSession().loadAll(Localmusic.class);
    }

    /**
     * 按照主键返回单行记录
     *
     * @param key
     * @return
     */
    public Localmusic listOneMusic(long key) {
        return mDaoManager.getDaoSession().load(Localmusic.class, key);
    }

    public void query1() {
        //使用native sql进行查询操作
        List<Localmusic> list=mDaoManager.getDaoSession().queryRaw(Localmusic.class," where name like ? and _id >?",new String[]{"%李%","1002"});
        Log.e("----->", ""+list);
    }

    /**
     * select * from where name like ? or name =? or
     */
    public void query2(){
        //查询构建器
       QueryBuilder<Localmusic> queryBuilder=mDaoManager.getDaoSession().queryBuilder(Localmusic.class);
       // queryBuilder.where(LocalmusicDao.Properties.Duration.between(0,10000));
      //  queryBuilder.where(LocalmusicDao.Properties.Duration.ge(10000)).where(LocalmusicDao.Properties.Title_name.ge(10000));

    }

    public void close(){
        mDaoManager.closeHelper();
    }





}
