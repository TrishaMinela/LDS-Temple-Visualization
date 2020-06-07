package edu.byuh.cis.templevis;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import edu.byuh.cis.templevis.R;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity {

    private TempleView tv;
    public SeekBar slider;
    public Context mContext;
    private int oldProgress;

    //not using Timer to make slider smooth anymore
    private MyTimer timA;

    public int progress;
    public int lastProgress;


    int stop;

    private boolean sliderTouchedByHuman;
    //GestureDetector mDetector;

    private boolean justStartSlider;

    private float startPoint;
    private float stopPoint;

    private LinearLayout lnl;
    private LinearLayout lnl2;




    //not using Timer to make slider smooth anymore
    public class MyTimer extends Handler {

        public MyTimer() {
            sendMessageDelayed(obtainMessage(0), 1);
        }

        @Override
        public void handleMessage(Message m) {
            //Log.d("My Timer here ", "My Timer ****************" + " ");

            //slider.setProgress(3000);

            if (tv.touchDownOnScreenTempleView == TRUE) {

                /*
                progress = (int)tv.theta;
                lastProgress = (int)tv.theta;
                slider.setProgress(progress);
                tv.invalidate();
                 */

                progress = lastProgress;

            }




            float lastProgressF = tv.getLastProgress();
            lastProgress = (int)lastProgressF;

            /*
            if (Math.abs(lastProgressF - progress) > 200) {
                //slider.setProgress((int)(lastProgressF));
                tv.setDegree(progress);
                tv.invalidate();

            } else {
                tv.setDegree(progress);
                tv.invalidate();
            }
             */

            float difference = Math.abs(lastProgress - progress);


            if (difference > 8) {
                tv.sliderInProgress(TRUE);
                if (lastProgress > progress) {
                    lastProgress = lastProgress - 8;
                    slider.setProgress((int)(lastProgress));
                    tv.setDegree((int)(lastProgress));
                } else if (lastProgress < progress) {
                    lastProgress = lastProgress + 8;
                    slider.setProgress((int)(lastProgress));
                    tv.setDegree((int) (lastProgress));

                }
                tv.invalidate();
                difference --;
                stop = 0;
            } else {

                if (stop == 0) {
                    tv.sliderInProgress(FALSE);
                    tv.invalidate();

                }
                stop ++;


            }

            /*
            if (progress == 0 || progress == 100) {
                slider.setProgress(progress);
            }

             */


            //very helper log here, display current slider progress and it's target progress
            //Log.d("progress is ", progress + " ");
            //Log.d("last progress is ", lastProgress + " ");

            sendMessageDelayed(obtainMessage(0), 1);
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        //tv = new TempleView(this);
        //setContentView(tv);
        mContext = MainActivity.this;

        //not using Timer to make slider smooth anymore
        //timA = new MyTimer();

        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
        Log.d("window Width", width + " ");
        Log.d("window Height", height + " ");


        LinearLayout.LayoutParams nice = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT, 1);

        tv = new TempleView(this);

        tv.getWindowSize(width, height);

        tv.setLayoutParams(nice);

        slider = findViewById(R.id.seekBar3);

        //slider.setBackgroundColor(Color.parseColor("#669cff"));
//        slider.setBackgroundColor(Color.parseColor("#202224"));
        slider.setBackgroundColor(Color.parseColor("#287a78"));




        slider.setProgress(5550);

        timA = new MyTimer();

        progress = 5550;


        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


                /*
                if (timA != null) {
                    slider.setProgress(lastProgress);
                }

                 */

                /*
                if (justStartSlider) {
                    startPoint = slider.getProgress();

                    //Toast.makeText(mContext, "start point is " + startPoint, Toast.LENGTH_SHORT).show();

                }

                justStartSlider = FALSE;


                 */




                if (sliderTouchedByHuman) {

                    int disableClickLastProgress = (int)(tv.getLastProgress());
                    //lastProgress = (int)(tv.getLastProgress());

                    //Log.d("slider changing", "last progress and i are " + disableClickLastProgress + " ||| " + i + " ");





                    if (Math.abs(disableClickLastProgress - i) > 200) {

                        slider.setProgress(disableClickLastProgress);


                    } else {
                        tv.setDegree(i);
                        tv.invalidate();
                    }


                    progress = i;


                } else {
                    slider.setProgress(lastProgress);

                }



                /*
                if (timA != null && Math.abs(lastProgress - progress) <= 10) {
                    timA.removeCallbacksAndMessages(null);
                }

                if (Math.abs(lastProgress - progress) > 10) {
                    if (sliderTouchedByHuman) {
                        progress = i;
                    }
                }

                 */




                //tv.setDegree(i);
                //tv.invalidate();

                //Log.d("progress", "IN oProgressChanged is " + i + " ");

                //not using Timer to make slider smooth anymore
             /*
                //you need this line. otherwise the slider thumb will move to where your figure is then come back instantly
                slider.setProgress(lastProgress);



                //you have to check if onProgressChanged is being called because of a human touch
                //when we call setProgress in MyTimer, this is being called too,
                //so the intent progress reset to the "last progress"
                if (sliderTouchedByHuman) {
                    progress = i;
                }




              */

                /*
                final Timer timer = new Timer();
                timer.schedule(new TimerTask(){
                    public void run(){
                        float lastProgress = tv.getLastProgress();

                        float difference = Math.abs(lastProgress - i);

                        if (difference > 0) {
                            if (lastProgress > i) {
                                lastProgress = lastProgress - 1;
                                slider.setProgress((int)(lastProgress));
                                tv.setDegree((int)(lastProgress));
                                tv.invalidate();
                            } else if (lastProgress < i) {
                                lastProgress = lastProgress + 1;
                                slider.setProgress((int)(lastProgress));
                                tv.setDegree((int) (lastProgress));
                                tv.invalidate();
                            }
                            difference --;
                        }
                        timer.cancel();
                    }
                }, 1, 1);
                */


                /*
                float lastProgressF = tv.getLastProgress();
                lastProgress = (int)lastProgressF;

                if (Math.abs(lastProgressF - i) > 200) {
                    //slider.setProgress((int)(lastProgressF));
                    tv.setDegree(i);
                    tv.invalidate();

                } else {
                    tv.setDegree(i);
                    tv.invalidate();
                }

                 */



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                tv.sliderStart(TRUE);
                tv.invalidate();

                sliderTouchedByHuman = TRUE;

                slider.setProgress(lastProgress);



                justStartSlider = TRUE;


                //not using Timer to make slider smooth anymore
                /*
                tv.sliderStart(TRUE);
                //tv.invalidate();

                tv.sliderInProgress(TRUE);



                //you need this line. otherwise the slider thumb will move to where your figure is then come back instantly
                slider.setProgress(lastProgress);
 */
                //Toast.makeText(mContext, "touch SeekBar", Toast.LENGTH_SHORT).show();

                /*
                if (timA != null) {
                    timA.removeCallbacksAndMessages(null);
                }


                 */

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                tv.sliderStop(FALSE);
                tv.invalidate();

                //not using Timer to make slider smooth anymore
                /*
                tv.sliderStop(FALSE);
                 */

                sliderTouchedByHuman = FALSE;

                stopPoint = slider.getProgress();
                //Toast.makeText(mContext, "stop point is " + stopPoint, Toast.LENGTH_SHORT).show();




                //timA = new MyTimer();


                /*
                if (Math.abs(lastProgress - stopPoint) > 500) {

                    timA = new MyTimer();

                }

                Toast.makeText(mContext, "lastProgress is " + lastProgress, Toast.LENGTH_SHORT).show();


                 */

                //Toast.makeText(mContext, "release SeekBar", Toast.LENGTH_SHORT).show();

            }
        });

        LinearLayout sliderLabel = findViewById(R.id.sliderLabel);
        //sliderLabel.setBackgroundColor(Color.parseColor("#669cff"));
        //sliderLabel.setBackgroundColor(Color.parseColor("#202224"));
        sliderLabel.setBackgroundColor(Color.parseColor("#287a78"));

        LinearLayout sliderLabelNoText = findViewById(R.id.sliderLabelNoText);
        sliderLabelNoText.setBackgroundColor(Color.parseColor("#287a78"));



        lnl = new LinearLayout(this);

        lnl.setOrientation(LinearLayout.VERTICAL);

        lnl.addView(tv);

        ((ViewGroup)sliderLabelNoText.getParent()).removeView(sliderLabelNoText);
        lnl.addView(sliderLabelNoText);

        ((ViewGroup)slider.getParent()).removeView(slider);
        lnl.addView(slider);



        ((ViewGroup)sliderLabel.getParent()).removeView(sliderLabel);
        lnl.addView(sliderLabel);



        /*
        LinearLayout lnl2_1 = new LinearLayout(this);
        lnl2_1.setOrientation(LinearLayout.HORIZONTAL);

        lnl2_1.addView(tv);
        lnl2_1.addView(slider);

        lnl2 = new LinearLayout(this);
        lnl2.setOrientation(LinearLayout.VERTICAL);
        lnl2.addView(lnl2_1);
        lnl2.addView(sliderLabel);


         */


        //LinearLayout lnlOne = findViewById(R.id.lnlOne);
        //((ViewGroup)lnlOne.getParent()).removeView(lnlOne);
        //lnl.addView(lnlOne);

        //TextView text1 = findViewById(R.id.text1);
        //((ViewGroup)text1.getParent()).removeView(text1);
        //lnl.addView(text1);

        //setContentView(lnl);

        //tv.firstLaunchCoordinatesAndSizes();

        if(getResources().getConfiguration().orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            setContentView(lnl);
        } else {

            setContentView(lnl);

            /*
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Welcome to Latter-day Temples");
            builder.setMessage("Please Launch the App with Your Device in Portrait Mode");
            builder.setIcon(R.mipmap.ic_launcher_round);

            //点击对话框以外的区域是否让对话框消失
            builder.setCancelable(false);

            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                }
            });

            final AlertDialog dialog = builder.create();

            dialog.show();

             */


        }














        //setContentView(lnl);





    }

    private void removeView() {
        //获取linearlayout子view的个数
        int count = lnl.getChildCount();
        //研究整个LAYOUT布局，第0位的是含add和remove两个button的layout
        //第count-1个是那个文字被置中的textview
        //因此，在remove的时候，只能操作的是0<location<count-1这个范围的
        //在执行每次remove时，我们从count-2的位置即textview上面的那个控件开始删除~
        if (count - 2 > 0) {
            //count-2>0用来判断当前linearlayout子view数多于2个，即还有我们点add增加的button
            lnl.removeViewAt(count - 2);
        }
    }




    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("1"," -- onConfigurationChanged");
        if(newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            //切换到竖屏
            //修改布局文件

            //tv.getCoordinatesAndSizes();

            tv.orientationJustChanged(TRUE);
            //setContentView(R.layout.activity_main);
            //findViewById ....


            Log.d("1"," -- onConfigurationChanged  可以在竖屏方向 to do something");
        }else{
            //切换到横屏
            //修改布局文件

            //tv.getCoordinatesAndSizes();
            tv.orientationJustChanged(TRUE);
            //setContentView(tv);
            //setContentView(R.layout.activity_main);
            //findViewById ....

            //removeView();

            //setContentView(lnl2);




            Log.d("1"," -- onConfigurationChanged  可以在横屏方向 to do something");
        }
    }



    /*
    @Override
    public boolean onTouchEvent(MotionEvent m) {

        if (m.getAction() == MotionEvent.ACTION_UP) {
            float x = m.getX();
            float y = m.getY();
            Toast.makeText(this, "touched a circle at " + x + " " + y, Toast.LENGTH_SHORT).show();


        }
        return true;
    }
     */



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(1,RED,1,"Setting");
        menu.add(1,GREEN,2,"About");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case RED:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();




                Intent setting = new Intent(this, PrefsActivity.class);

                this.startActivity(setting);



                break;
            case GREEN:
                //Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                showAboutDialog();

                break;

        }
        return super.onOptionsItemSelected(item);
    }


    public void showAboutDialog() {

        String about = "Programming by Litian Zhang under the supervision of Dr. Geoffrey Draper at Brigham Young University--Hawaii.\n" +
                "Visit the app's website: " + R.string.app_website + "\n" +
                "\n" +
                "Temple photos are copyrighted by Intellectual Reserve, Inc. Used by permission.\n" +
                "\n" +
                "This app is a research project funded by Brigham Young University--Hawaii, however the contents are the responsibility of its developers. This app is not an \"official\" publication of the Church of Jesus Christ of Latter-day Saints.\n";

        String html = "Programming by Litian Zhang under the supervision of Dr. Geoffrey Draper at Brigham Young University--Hawaii.<br><br>";
        html += "<a href='https://litianzhang.com/latter-day-temples-visualization-android-app/'>Visit the app's website</a> <br>";
        html += "<br>" +
                "Temple photos are copyrighted by Intellectual Reserve, Inc. Used by permission.<br>" +
                "<br>" +
                "This app is a research project funded by Brigham Young University--Hawaii, however the contents are the responsibility of its developers. This app is not an \"official\" publication of the Church of Jesus Christ of Latter-day Saints.<br>";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Latter-day Temples");

        TextView aboutTv = new TextView(this);

        //aboutTv.setText(about + R.string.app_website);

        aboutTv.setText(Html.fromHtml(html));

        //aboutTv.setText(Html.fromHtml(about));

        aboutTv.setMovementMethod(LinkMovementMethod.getInstance());
        aboutTv.setGravity(Gravity.LEFT);
        aboutTv.setTextSize(20);
        aboutTv.setPadding(50,50,50,50);

        aboutTv.setBackgroundColor(Color.parseColor("#ffffee"));

        //builder.setMessage(about);

        builder.setView(aboutTv);

        builder.setIcon(R.mipmap.ic_launcher_round);

        //ImageView im = new ImageView(this);
        //im.setImageResource(R.drawable.aa_imnothing);
        //builder.setView(im);

        //点击对话框以外的区域是否让对话框消失
        builder.setCancelable(true);

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //finish();

                //do nothing

            }
        });

        final AlertDialog dialog = builder.create();

        dialog.show();

        final Button positiveButton=dialog.getButton(AlertDialog.BUTTON_NEUTRAL);
        LinearLayout.LayoutParams positiveButtonLL =(LinearLayout.LayoutParams)positiveButton.getLayoutParams();
        positiveButtonLL.gravity=Gravity.CENTER;
        positiveButtonLL.width=ViewGroup.LayoutParams.MATCH_PARENT;
        positiveButton.setLayoutParams(positiveButtonLL);


    }


/*

//THIS IS THE OLD ABOUT BUTTON

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.action_cart://监听菜单按钮

                String about = "Programming by Litian Zhang under the supervision of Dr. Geoffrey Draper at Brigham Young University--Hawaii.\n" +
                        "Visit the app's website: " + R.string.app_website + "\n" +
                        "\n" +
                        "Temple photos are copyrighted by Intellectual Reserve, Inc. Used by permission.\n" +
                        "\n" +
                        "This app is a research project funded by Brigham Young University--Hawaii, however the contents are the responsibility of its developers. This app is not an \"official\" publication of the Church of Jesus Christ of Latter-day Saints.\n";

                String html = "Programming by Litian Zhang under the supervision of Dr. Geoffrey Draper at Brigham Young University--Hawaii.<br><br>";
                html += "<a href='https://litianzhang.com/latter-day-temples-visualization-android-app/'>Visit the app's website</a> <br>";
                html += "<br>" +
                        "Temple photos are copyrighted by Intellectual Reserve, Inc. Used by permission.<br>" +
                        "<br>" +
                        "This app is a research project funded by Brigham Young University--Hawaii, however the contents are the responsibility of its developers. This app is not an \"official\" publication of the Church of Jesus Christ of Latter-day Saints.<br>";

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Latter-day Temples");

                TextView aboutTv = new TextView(this);

                //aboutTv.setText(about + R.string.app_website);

                aboutTv.setText(Html.fromHtml(html));

                //aboutTv.setText(Html.fromHtml(about));

                aboutTv.setMovementMethod(LinkMovementMethod.getInstance());
                aboutTv.setGravity(Gravity.LEFT);
                aboutTv.setTextSize(20);
                aboutTv.setPadding(50,50,50,50);

                aboutTv.setBackgroundColor(Color.parseColor("#ffffee"));

                //builder.setMessage(about);

                builder.setView(aboutTv);

                builder.setIcon(R.mipmap.ic_launcher_round);

                //ImageView im = new ImageView(this);
                //im.setImageResource(R.drawable.aa_imnothing);
                //builder.setView(im);

                //点击对话框以外的区域是否让对话框消失
                builder.setCancelable(true);

                builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //finish();

                        //do nothing

                    }
                });

                final AlertDialog dialog = builder.create();

                dialog.show();

                final Button positiveButton=dialog.getButton(AlertDialog.BUTTON_NEUTRAL);
                LinearLayout.LayoutParams positiveButtonLL =(LinearLayout.LayoutParams)positiveButton.getLayoutParams();
                positiveButtonLL.gravity=Gravity.CENTER;
                positiveButtonLL.width=ViewGroup.LayoutParams.MATCH_PARENT;
                positiveButton.setLayoutParams(positiveButtonLL);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    */


    /*
    //FAILED DOING POPUP MENU!!!
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.action_cart://监听菜单按钮

                Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();

                PopupMenu menu = new PopupMenu(this,);

                showPopMenu();


                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void showPopMenu(View view){
        PopupMenu menu = new PopupMenu(this,view);
        menu.getMenuInflater().inflate(R.menu.main_for_popupmenu,menu.getMenu());
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.add_item:
                        Toast.makeText(MainActivity.this, "Add selected", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.delete_item:
                        Toast.makeText(MainActivity.this, "Delete Selected", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });
        menu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                Toast.makeText(MainActivity.this, "关闭了", Toast.LENGTH_SHORT).show();
            }
        });
        menu.show();
    }

     */







}
