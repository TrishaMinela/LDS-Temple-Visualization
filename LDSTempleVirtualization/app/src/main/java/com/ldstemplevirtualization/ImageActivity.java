package com.ldstemplevirtualization;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {

    private ImageView imageView;
    int currentIndex;
    private ArrayList<String> allTempleInfo;
    private TextView textView;

    private SingleTempleView stv;

    private static ArrayList<Integer> allImageIds;

    private static ArrayList<Integer> allTempleInfoFileIds;

    private String oneTempleInfo;
    private int howManyLinesInTempleInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);


        allTempleInfo = new ArrayList<>();
        readInfoFile();
        //Toast.makeText(this, " allTempleInfo size is " + allTempleInfo.size() , Toast.LENGTH_SHORT).show();



        //currentIndex = 10;

        Intent lastI = getIntent();
        String data = lastI.getStringExtra("eachIndex");
        final String templeUrl = lastI.getStringExtra("templeUrl");

        currentIndex = Integer.parseInt(data);

        //Toast.makeText(this, data + " currentIndex is " + currentIndex , Toast.LENGTH_SHORT).show();

        allImageIds = ImageCache.getAllImageIds();
        allTempleInfoFileIds = ImageCache.getAllTempleInfoFileIds();



        oneTempleInfo = "";
        readOneInfoFile(allTempleInfoFileIds.get(currentIndex));






        LinearLayout.LayoutParams one = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT, 1);




        /*


        textView = new TextView(this);
        //String websiteString2 ="Website";
        textView.setText(allTempleInfo.get(currentIndex*3));
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        textView.setHeight(250);
        //textView.setLineSpacing(1.5f,0.5f);
        //textView.setBackgroundColor(Color.RED);

        //textView.setLayoutParams(one);




        imageView = new ImageView(this);
        imageView.setImageResource(allImageIds.get(currentIndex));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(one);


        TextView textViewWebsite = new TextView(this);
        String websiteString = "Click here to visit it online";
        textViewWebsite.setText(websiteString);
        //textViewWebsite.setText(Html.fromHtml("<a href='" +  templeUrl + "'> website </a>"));
        //textViewWebsite.setMovementMethod(LinkMovementMethod.getInstance());
        //textViewWebsite.setText(Html.fromHtml("<a href='www.google.com'> website </a>"));
        textViewWebsite.setTextSize(15);
        textViewWebsite.setGravity(Gravity.CENTER);
        textViewWebsite.setHeight(60);
        //textViewWebsite.setBackgroundColor(Color.GREEN);
        textViewWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri web = Uri.parse(templeUrl);
                Intent i = new Intent(Intent.ACTION_VIEW, web);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });



        TextView textViewLocation = new TextView(this);
        String templeLocationString = "Location: " + allTempleInfo.get(currentIndex*3+1);
        textViewLocation.setText(templeLocationString);
        textViewLocation.setTextSize(15);
        textViewLocation.setGravity(Gravity.CENTER);
        textViewLocation.setHeight(120);
        //textView2.setLayoutParams(one);
        //textViewLocation.setBackgroundColor(Color.YELLOW);

        TextView textViewYear= new TextView(this);
        String templeYearString ="Dedicated on: " + allTempleInfo.get(currentIndex*3+2);
        textViewYear.setText(templeYearString);
        textViewYear.setTextSize(15);
        textViewYear.setGravity(Gravity.CENTER);
        textViewYear.setHeight(70);
        //textView2.setLayoutParams(one);
        //textViewYear.setBackgroundColor(Color.BLUE);



        Button b = new Button(this);
        b.setText("OK");
        //b.setLayoutParams(one);
        b.setHeight(100);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                finish();

                //Toast.makeText(getBaseContext(), "Online Access Disabled", Toast.LENGTH_SHORT).show();

                //Intent eachTemplePage= new Intent();
                //eachTemplePage.setAction("android.intent.action.VIEW");
                //Uri eachTemplePage_url = Uri.parse(templeUrl);
                //eachTemplePage.setData(eachTemplePage_url);
                //startActivity(eachTemplePage);


            }
        });





        LinearLayout lnl = new LinearLayout(this);
        lnl.setOrientation(LinearLayout.VERTICAL);



        lnl.addView(textView);



        lnl.addView(imageView);

        //separate image and website
        TextView textViewUseless = new TextView(this);
        textViewUseless.setText(" ");
        textViewUseless.setHeight(50);
        lnl.addView(textViewUseless);
        //textViewUseless.setBackgroundColor(Color.GRAY);


        lnl.addView(textViewWebsite);




        TextView textViewUseless2 = new TextView(this);
        textViewUseless2.setText(" ");
        textViewUseless2.setHeight(50);
        lnl.addView(textViewUseless2);
        //textViewUseless2.setBackgroundColor(Color.BLUE);


        lnl.addView(textViewLocation);
        lnl.addView(textViewYear);



        lnl.addView(b);

        lnl.setBackgroundColor(Color.parseColor("#66ccff"));


        //((ViewGroup)textView.getParent()).removeView(textView);


        //setContentView(lnl);



        */


        //stv = new SingleTempleView(this, allImageIds.get(currentIndex), allTempleInfo.get(currentIndex*3), templeUrl, allTempleInfo.get(currentIndex*3+1), allTempleInfo.get(currentIndex*3+2));

        stv = new SingleTempleView(this, allImageIds.get(currentIndex), allTempleInfo.get(currentIndex*3), templeUrl, oneTempleInfo);



        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // 加入横屏要处理的代码
            //Toast.makeText(this, "landscape now", Toast.LENGTH_SHORT).show();


            WindowManager manager = this.getWindowManager();
            DisplayMetrics outMetrics = new DisplayMetrics();
            manager.getDefaultDisplay().getMetrics(outMetrics);
            int width = outMetrics.widthPixels;
            int height = outMetrics.heightPixels;

            LinearLayout lnl2 = new LinearLayout(this);
            lnl2.setOrientation(LinearLayout.VERTICAL);

            LinearLayout lnl3 = new LinearLayout(this);
            lnl3.setOrientation(LinearLayout.HORIZONTAL);


            final Button b2 = new Button(this);
            b2.setText("OK");
            //b.setLayoutParams(one);
            b2.setHeight(height/10);

            b2.setBackgroundColor(Color.parseColor("#202224"));

            b2.setTextColor(Color.GRAY);

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    finish();

                    //Toast.makeText(getBaseContext(), "Online Access Disabled", Toast.LENGTH_SHORT).show();
                /*
                Intent eachTemplePage= new Intent();
                eachTemplePage.setAction("android.intent.action.VIEW");
                Uri eachTemplePage_url = Uri.parse(templeUrl);
                eachTemplePage.setData(eachTemplePage_url);
                startActivity(eachTemplePage);
                 */

                }
            });

            //Toast.makeText(getBaseContext(), "add button", Toast.LENGTH_SHORT).show();
            //((ViewGroup)b2.getParent()).removeView(b2);





            TextView templeInfo = new TextView(this);
            templeInfo.setText(oneTempleInfo);
            //templeInfo.setHeight(height/5);
            //templeInfo.setBackgroundColor(Color.GREEN);

            templeInfo.setTextColor(Color.GRAY);

            //Toast.makeText(this, "howmanylinesintempleinfo" + howManyLinesInTempleInfo, Toast.LENGTH_SHORT).show();

            if (howManyLinesInTempleInfo <= 2) {
                templeInfo.setTextSize(20);
            } else if (howManyLinesInTempleInfo <= 4) {
                templeInfo.setTextSize(20);
            } else {
                templeInfo.setTextSize(15);
            }
            //templeInfo.setTextSize(height / 5 / (howManyLinesInTempleInfo * 1.8f));
            templeInfo.setGravity(Gravity.CENTER);

            //stv.setLayoutParams(one);

            ImageView im = new ImageView(this);
            im.setImageResource(allImageIds.get(currentIndex));


            im.setClickable(true);
            im.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse(templeUrl);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uri);
                    startActivity(intent);
                }
            });

            LinearLayout.LayoutParams two = new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT, 1);

            LinearLayout.LayoutParams three = new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT, 1);

            TextView title = new TextView(this);
            title.setText(allTempleInfo.get(currentIndex*3));
            title.setHeight(height/10);
            title.setTextSize(30);

            title.setTextColor(Color.GRAY);

            title.setGravity(Gravity.CENTER);
            //title.setLayoutParams(two);

            im.setLayoutParams(two);
            templeInfo.setLayoutParams(two);
            //b2.setLayoutParams(two);

            //im.setBackgroundColor(Color.GREEN);
            //templeInfo.setBackgroundColor(Color.RED);

            //lnl2.addView(stv);
            lnl3.addView((im));
            lnl3.addView(templeInfo);

            lnl3.setLayoutParams(two);

            lnl2.addView(title);
            lnl2.addView(lnl3);
            lnl2.addView(b2);

            //lnl2.addView(b2);




/*
        if (b2 != null) {
            Toast.makeText(getBaseContext(), "button is not null", Toast.LENGTH_SHORT).show();

        }

 */
            //lnl2.setBackgroundColor(Color.parseColor("#66ccff"));
            lnl2.setBackgroundColor(Color.parseColor("#24292b"));

            setContentView(lnl2);


        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            // 加入竖屏要处理的代码
            //Toast.makeText(this, "portrait now", Toast.LENGTH_SHORT).show();

            LinearLayout lnl2 = new LinearLayout(this);
            lnl2.setOrientation(LinearLayout.VERTICAL);




            final Button b2 = new Button(this);
            b2.setText("OK");
            //b.setLayoutParams(one);
            b2.setHeight(100);


            b2.setBackgroundColor(Color.parseColor("#202224"));

            b2.setTextColor(Color.GRAY);

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    finish();

                    //Toast.makeText(getBaseContext(), "Online Access Disabled", Toast.LENGTH_SHORT).show();
                /*
                Intent eachTemplePage= new Intent();
                eachTemplePage.setAction("android.intent.action.VIEW");
                Uri eachTemplePage_url = Uri.parse(templeUrl);
                eachTemplePage.setData(eachTemplePage_url);
                startActivity(eachTemplePage);
                 */

                }
            });

            //Toast.makeText(getBaseContext(), "add button", Toast.LENGTH_SHORT).show();
            //((ViewGroup)b2.getParent()).removeView(b2);



            WindowManager manager = this.getWindowManager();
            DisplayMetrics outMetrics = new DisplayMetrics();
            manager.getDefaultDisplay().getMetrics(outMetrics);
            int width = outMetrics.widthPixels;
            int height = outMetrics.heightPixels;

            TextView templeInfo = new TextView(this);
            templeInfo.setText(oneTempleInfo);
            templeInfo.setHeight(height/5);
            //templeInfo.setBackgroundColor(Color.GREEN);

            templeInfo.setTextColor(Color.GRAY);

            //Toast.makeText(this, "howmanylinesintempleinfo" + howManyLinesInTempleInfo, Toast.LENGTH_SHORT).show();


            if (howManyLinesInTempleInfo <= 2) {
                templeInfo.setTextSize(20);
            } else if (howManyLinesInTempleInfo <= 4) {
                templeInfo.setTextSize(20);
            } else {
                templeInfo.setTextSize(15);
            }
            //templeInfo.setTextSize(height / 5 / (howManyLinesInTempleInfo * 1.8f));
            templeInfo.setGravity(Gravity.CENTER);




            stv.setLayoutParams(one);
            lnl2.addView(stv);
            lnl2.addView(templeInfo);
            lnl2.addView(b2);




/*
        if (b2 != null) {
            Toast.makeText(getBaseContext(), "button is not null", Toast.LENGTH_SHORT).show();

        }

 */
            //lnl2.setBackgroundColor(Color.parseColor("#66ccff"));
            lnl2.setBackgroundColor(Color.parseColor("#24292b"));


            setContentView(lnl2);

        }





    }



    public void readInfoFile() {

        //String s = "temple_info";

        try {
            InputStream allTempleInfoFile =  this.getResources().openRawResource(R.raw.temple_info);
            if (allTempleInfoFile != null)
            {
                InputStreamReader ir = new InputStreamReader(allTempleInfoFile);
                BufferedReader br = new BufferedReader(ir);
                String line;
                //read each line
                while (( line = br.readLine()) != null) {
                    allTempleInfo.add(line+"\n");
                }
                allTempleInfoFile.close();
            }
        }
        catch (java.io.FileNotFoundException e)
        {
            Log.d("TestFile", "The File doesn't not exist.");
        }
        catch (IOException e)
        {
            Log.d("TestFile", e.getMessage());
        }

    }

    public void readOneInfoFile(int id) {

        howManyLinesInTempleInfo = 0;
        //String s = "temple_info";

        try {
            InputStream allTempleInfoFile =  this.getResources().openRawResource(id);
            if (allTempleInfoFile != null)
            {
                InputStreamReader ir = new InputStreamReader(allTempleInfoFile);
                BufferedReader br = new BufferedReader(ir);
                String line;
                //read each line
                while (( line = br.readLine()) != null) {
                    oneTempleInfo = oneTempleInfo + line+"\n";
                    howManyLinesInTempleInfo ++;
                }
                allTempleInfoFile.close();
            }
        }
        catch (java.io.FileNotFoundException e)
        {
            Log.d("TestFile", "The File doesn't not exist.");
        }
        catch (IOException e)
        {
            Log.d("TestFile", e.getMessage());
        }

    }



    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);

        Log.d("orientation changed"," -- onConfigurationChanged");

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // 加入横屏要处理的代码
            Toast.makeText(this, "landscape now", Toast.LENGTH_SHORT).show();
        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            // 加入竖屏要处理的代码
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }


    /*
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("1"," -- onConfigurationChanged");
        if(newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            //切换到竖屏
            //修改布局文件

            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();


            //setContentView(R.layout.activity_main);
            //findViewById ....


            Log.d("1"," -- onConfigurationChanged  可以在竖屏方向 to do something");
        }else{
            //切换到横屏
            //修改布局文件

            Toast.makeText(this, "landscape now", Toast.LENGTH_SHORT).show();


            //setContentView(textView);

            //setContentView(R.layout.activity_main);
            //findViewById ....

            //removeView();

            //setContentView(lnl2);




           //Log.d("1"," -- onConfigurationChanged  可以在横屏方向 to do something");

        }
    }
    */





    @Override
    public boolean onTouchEvent(MotionEvent m) {

        if (m.getAction() == MotionEvent.ACTION_DOWN) {
            float downX = m.getX();
            float downY = m.getY();
            //Toast.makeText(this, "touched at " + downX + " " + downY, Toast.LENGTH_SHORT).show();
            //this.finish();

        }



        return true;
    }



    /*
    @SuppressLint({"NewApi", "ResourceType"})
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.xml.menu, menu);
        //添加标题栏的确定按钮
        MenuItem item=menu.add(0,MENU_CONFIRM,0,"hello");


          //setShowAsAction参数说明   MenuItem接口的一些常量
          //SHOW_AS_ACTION_ALWAYS   总是显示这个项目作为一个操作栏按钮。
          //SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW   此产品的动作视图折叠成一个正常的菜单项。
          //SHOW_AS_ACTION_IF_ROOM   显示此项目作为一个操作栏的按钮,如果系统有空间。
          //SHOW_AS_ACTION_NEVER     从不显示该项目作为一个操作栏按钮。
          //SHOW_AS_ACTION_WITH_TEXT  当这个项目是在操作栏中,始终以一个文本标签显示它,即使它也有指定一个图标。

        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);//主要是这句话

        item.setOnMenuItemClickListener(listener);//添加监听事件
        item.setIcon(R.drawable.ic_menu_confirm);//设置图标
        return true;

    }

    MenuItem.OnMenuItemClickListener listener=new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case MENU_CONFIRM:
                    Toast.makeText(MainActivity.this, "您点击了确定按钮", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            return false;
        }
    };
        */





}
