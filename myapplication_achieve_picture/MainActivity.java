package com.wangban.yzbbanban.myapplication_achieve_picture;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.*;

import com.wangban.yzbbanban.myapplication_achieve_picture.adapter.PictureAdapter;
import com.wangban.yzbbanban.myapplication_achieve_picture.app.PictureApplication;
import com.wangban.yzbbanban.myapplication_achieve_picture.entity.Pictures;

public class MainActivity extends Activity {
    private ImageView ivImage;
    private TextView tvPath1;
    private TextView tvPath2;
    private static final String TAG = "supergirl";
    private GridView gvLocalImage;
    private PictureApplication app;
    private List<Pictures> pics;
    private PictureAdapter adapter;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivImage = (ImageView) findViewById(R.id.iv_image);
        tvPath1 = (TextView) findViewById(R.id.tv_path1);
        tvPath2 = (TextView) findViewById(R.id.tv_path2);
        gvLocalImage= (GridView) findViewById(R.id.gv_image);

		app = (PictureApplication) getApplication();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

               
                pics = app.getPictures();


                adapter = new PictureAdapter(MainActivity.this, pics);
                gvLocalImage.setAdapter(adapter);


            }
        }, 2000);





    }


}