package com.wangban.yzbbanban.myapplication_achieve_picture.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wangban.yzbbanban.myapplication_achieve_picture.R;
import com.wangban.yzbbanban.myapplication_achieve_picture.entity.Pictures;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by YZBbanban on 16/5/31.
 */
public class PictureAdapter extends BaseAdapter<Pictures> {
    private Pictures picture;
    private URL url;
    ImageView ivImage;
    Handler handler;
    Thread thread;
    private static final String TAG="supergirl";
    public PictureAdapter(Context context, List<Pictures> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        picture=getData().get(position);

        final ViewHolder holder;
        if (convertView == null) {
            convertView=getLayoutInflater().inflate(R.layout.picture_item,null);
            holder=new ViewHolder();
            holder.ivImage= (ImageView) convertView.findViewById(R.id.iv_image);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();

            thread=new ImageThread();
            thread.start();
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case 1:
                            Bitmap bm2 = (Bitmap) msg.obj;
                            holder.ivImage.setImageBitmap(bm2);
                            break;

                    }


                }
            };



        }
        return convertView;
    }
    class ViewHolder{
        ImageView ivImage;
    }


    class ImageThread extends Thread {


        @Override
        public void run() {
            try {
                url = new URL(picture.getPath());

                URLConnection connection = url.openConnection();

                connection.connect();

                InputStream is = connection.getInputStream();

                Bitmap bm = BitmapFactory.decodeStream(is);

                Message msg = Message.obtain();
                msg.obj = bm;
                msg.what = 1;
                handler.sendMessage(msg);


            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

}
