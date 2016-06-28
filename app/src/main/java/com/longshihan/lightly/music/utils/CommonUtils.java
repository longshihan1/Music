package com.longshihan.lightly.music.utils;

import android.content.Context;

import com.db.entity.Localmusic;
import com.longshihan.lightly.music.db.DaoManager;

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
     * @param music
     * @return
     */
    public boolean insertMusic(Localmusic music){
        boolean flag=false;
        flag=mDaoManager.getDaoSession().insert(music)!=-1?true:false;



        return flag;

    }

}
