package com.wangban.yzbbanban.myapplication_achieve_picture.adapter;

import android.content.Context;
import android.view.LayoutInflater;

import java.util.*;

/**
 * Created by YZBbanban on 16/5/31.
 */
public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {
    private Context context;
    private List<T> data;
    private LayoutInflater layoutInflater;

    public BaseAdapter(Context context, List<T> data) {
        setContext(context);
        setData(data);
        setLayoutInflater();

    }

    public Context getContext() {
        return context;
    }

    private final void setContext(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context不为null");
        }
        this.context = context;
    }

    public List<T> getData() {
        return data;
    }

    private final void setData(List<T> data) {
        if (data == null) {
            data = new ArrayList<T>();
        }
        this.data = data;
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    private final void setLayoutInflater() {
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
