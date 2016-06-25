package com.wangban.yzbbanban.myapplication_achieve_picture.app;

import android.app.Application;

import com.wangban.yzbbanban.myapplication_achieve_picture.dal.IDao;
import com.wangban.yzbbanban.myapplication_achieve_picture.dal.PictureDaoFactury;
import com.wangban.yzbbanban.myapplication_achieve_picture.entity.Pictures;

/**
 * Created by YZBbanban on 16/5/31.
 */
import java.util.*;
public class PictureApplication extends Application{
    List<Pictures> pictures=new ArrayList<>();

    @Override
    public void onCreate() {
        IDao<Pictures> iDao= PictureDaoFactury.newInstance();
        pictures=iDao.getData();

    }
        public List<Pictures> getPictures(){
            return  pictures;
        }

}
