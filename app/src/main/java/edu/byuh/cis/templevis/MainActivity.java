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

import java.util.Locale;

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
    private int stop;
    private boolean sliderTouchedByHuman;
    private boolean justStartSlider;
    private float startPoint;
    private float stopPoint;
    private LinearLayout lnl;
    private LinearLayout lnl2;

    public class MyTimer extends Handler {

        public MyTimer() {
            sendMessageDelayed(obtainMessage(0), 1);
        }

        @Override
        public void handleMessage(Message m) {
            //Log.d("My Timer here ", "My Timer ****************" + " ");

            if (tv.touchDownOnScreenTempleView == TRUE) {
                progress = lastProgress;
            }

            float lastProgressF = tv.getLastProgress();
            lastProgress = (int)lastProgressF;
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
        mContext = MainActivity.this;

        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
        //Log.d("window Width", width + " ");
        //Log.d("window Height", height + " ");

        LinearLayout.LayoutParams nice = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT, 1);

        tv = new TempleView(this);
        tv.getWindowSize(width, height);
        tv.setLayoutParams(nice);
        slider = findViewById(R.id.seekBar3);
        //slider.setBackgroundColor(Color.parseColor("#669cff"));
        //slider.setBackgroundColor(Color.parseColor("#202224"));
        slider.setBackgroundColor(Color.parseColor("#287a78"));
        slider.setProgress(5550);

        timA = new MyTimer();

        progress = 5550;

        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (sliderTouchedByHuman) {
                    int disableClickLastProgress = (int)(tv.getLastProgress());
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
                //Log.d("progress", "IN oProgressChanged is " + i + " ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                tv.sliderStart(TRUE);
                tv.invalidate();
                sliderTouchedByHuman = TRUE;
                slider.setProgress(lastProgress);
                justStartSlider = TRUE;

                //Toast.makeText(mContext, "touch SeekBar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv.sliderStop(FALSE);
                tv.invalidate();

                sliderTouchedByHuman = FALSE;
                stopPoint = slider.getProgress();

                //Toast.makeText(mContext, "stop point is " + stopPoint, Toast.LENGTH_SHORT).show();
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


        if (getResources().getConfiguration().orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setContentView(lnl);
        } else {
            setContentView(lnl);
            //finish();
        }

        //setContentView(lnl);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("1"," -- onConfigurationChanged");
        if(newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            //切换到竖屏
            //修改布局文件
            tv.orientationJustChanged(TRUE);

            //Log.d("1"," -- onConfigurationChanged  可以在竖屏方向 to do something");
        }else{
            //切换到横屏
            //修改布局文件
            tv.orientationJustChanged(TRUE);
            //Log.d("1"," -- onConfigurationChanged  可以在横屏方向 to do something");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(1,RED,1,R.string.settings);
        menu.add(1,GREEN,2,R.string.about);
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
                //Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();

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

        String html = getResources().getString(R.string.about_content_one) + "<br><br>";
        html += "<a href='https://litianzhang.com/latter-day-temples-visualization-android-app/'>" + getResources().getString(R.string.about_content_two)+ "</a> <br>";
        html += "<br>" +
                 getResources().getString(R.string.about_content_three)+ "<br>" +
                "<br>" +
                getResources().getString(R.string.about_content_four);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.app_name));

        TextView aboutTv = new TextView(this);
        aboutTv.setText(Html.fromHtml(html));
        aboutTv.setMovementMethod(LinkMovementMethod.getInstance());
        aboutTv.setGravity(Gravity.LEFT);
        aboutTv.setTextSize(20);
        aboutTv.setPadding(50,50,50,50);
        aboutTv.setBackgroundColor(Color.parseColor("#ffffee"));

        builder.setView(aboutTv);
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setCancelable(true);
        builder.setNeutralButton(getResources().getString(R.string.return_button), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
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

}
