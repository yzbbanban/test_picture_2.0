package com.wangban.yzbbanban.myapplication_achieve_picture.dal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.wangban.yzbbanban.myapplication_achieve_picture.entity.Pictures;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * Created by YZBbanban on 16/5/31.
 */

public class PictureDao implements IDao {
    private static final String TAG = "supergirl";
    private String path2;
    private int width;
    private int height;
    private Thread thread;
    private List<Pictures> pictures= new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            pictures = (List<Pictures>) msg.obj;
        }
    };


    @Override
    public List<Pictures> getData() {

        thread = new InnerThread();
        thread.start();
        Log.i(TAG, "getData: path" + pictures.get(0).getPath());
        Log.i(TAG, "getData: path" + pictures.get(2).getPath());
        Log.i(TAG, "getData: path" + pictures.get(4).getPath());
        Log.i(TAG, "getData: path" + pictures.get(6).getPath());
        Log.i(TAG, "getData: path" + pictures.get(8).getPath());
        return pictures;
    }

    class InnerThread extends Thread {

        @Override
        public void run() {
            try {
                thread.sleep(4000);
                String webPath = "http://m.xxxiao.com";

                Document doc = Jsoup.connect(webPath).get();
                Elements e = doc.getElementsByClass("post-thumb");
                for (int i = 0; i < 18; i++) {
                    //String path1 = e1.get(0).getElementsByTag("a").attr("href");
                    //<img width="760" height="500"
                    Elements a = e.get(i).getElementsByTag("a");
                    String width2 = a.first().getElementsByTag("img").attr("width");
                    String height2 = a.first().getElementsByTag("img").attr("height");
                    path2 = a.first().getElementsByTag("img").attr("src");


                    width = Integer.parseInt(width2);
                    height = Integer.parseInt(height2);
                    Pictures pic = new Pictures();
                    pic.setPath(path2);
                    pic.setHeight(height);
                    pic.setWidth(width);
                    pictures.add(pic);
                     Log.i(TAG, "getData: path" + pic.getPath());
                    Message m = new Message();
                    m.obj = pictures;
                    handler.sendMessage(m);

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



