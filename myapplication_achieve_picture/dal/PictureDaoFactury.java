package com.wangban.yzbbanban.myapplication_achieve_picture.dal;

import com.wangban.yzbbanban.myapplication_achieve_picture.entity.Pictures;

/**
 * Created by YZBbanban on 16/5/31.
 */
public class PictureDaoFactury {
    private PictureDaoFactury() {
        super();
    }

    public static IDao<Pictures> newInstance() {
        return new PictureDao();
    }


}
