package com.wangban.yzbbanban.myapplication_achieve_picture.dal;

/**
 * Created by YZBbanban on 16/5/31.
 */
import com.wangban.yzbbanban.myapplication_achieve_picture.entity.Pictures;

import java.util.*;
public interface IDao<T> {
    List<T> getData();

}
