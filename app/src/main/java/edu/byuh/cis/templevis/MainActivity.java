package edu.byuh.cis.templevis;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.graphics.Color.BLUE;
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
    private LinearLayout lnlH;
    private Boolean sliderChangedByButton = false;
    private String selectedYear;
    private int selectedYearIndex;
    private String yearPickerString;
    private ArrayList<Integer> templeYearsThetaFriends = new ArrayList<Integer>();

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

            int eachStep = 0;
            if (sliderChangedByButton) {
                eachStep = 1;
            } else {
                eachStep = 8;
            }


            if (difference > eachStep) {
                tv.sliderInProgress(TRUE);
                if (lastProgress > progress) {
                    lastProgress = lastProgress - eachStep;
                    slider.setProgress((int)(lastProgress));
                    tv.setDegree((int)(lastProgress));
                } else if (lastProgress < progress) {
                    lastProgress = lastProgress + eachStep;
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
                    sliderChangedByButton = false;
                }
                stop ++;
            }

            //very helper log here, display current slider progress and it's target progress
            //Log.d("progress is ", progress + " ");
            //Log.d("last progress is ", lastProgress + " ");

            sendMessageDelayed(obtainMessage(0), 1);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        mContext = MainActivity.this;


        //(245, 300, 325, 340, 380, 420, 450, 490, 520, 540, 570, 610, 680, 715, 750, 780, 810, 850, 890, 1070, 1290, 1430, 1520, 1540, 1575, 1630, 1660, 1700, 1710, 1755, 1850, 1890, 2315, 3330, 3540, 3720, 3800, 3850, 3950, 4030, 4110, 4200, 4300, 4400, 4520, 4540, 4650, 4785, 4935, 5100, 5110, 5320, 5330, 5800, 6990)
        List<Integer> temporaryHolder = Arrays.asList(245, 300, 325, 340, 380, 420, 450, 490, 520, 540, 570, 610, 680, 715, 750, 780, 810, 850, 890, 1070, 1290, 1430, 1520, 1540, 1575, 1630, 1660, 1700, 1710, 1755, 1850, 1890, 2315, 3330, 3540, 3720, 3800, 3850, 3950, 4030, 4110, 4200, 4300, 4400, 4520, 4540, 4650, 4785, 4935, 5100, 5110, 5320, 5330, 5800, 6990);
        for (int i : temporaryHolder) {
            templeYearsThetaFriends.add(i);
        }

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

        final Button leftButton = new Button(this);
        //leftButton.setBackgroundResource(R.drawable.left_button_arrow);

        // this following is set the foreground of button, when we press, there is a little press down effect on button which is good, but we can see some edges of button which is not good
        Drawable leftButtonForeground = getResources().getDrawable(R.drawable.left_button_background_svg);
        //ContextCompat.getDrawable(getApplicationContext(),R.drawable.left_button_arrow);
        //ResourcesCompat.getDrawable(getResources(), R.drawable.left_button_arrow, null);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            leftButton.setForeground(leftButtonForeground);
        }




        leftButton.setBackgroundColor(Color.parseColor("#007a66"));

        //leftButton.setBackgroundResource(R.drawable.left_button_background_svg);



        leftButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //Toast.makeText(MainActivity.this,"按下了" ,Toast.LENGTH_SHORT).show();
                    //leftButton.setBackgroundColor(Color.parseColor("#17252a"));
                    //leftButton.setBackgroundResource(R.drawable.left_button_background_pressed);
                    Drawable leftButtonForegroundPressed = getResources().getDrawable(R.drawable.left_button_background_pressed);
                    //ContextCompat.getDrawable(getApplicationContext(),R.drawable.left_button_arrow);
                    //ResourcesCompat.getDrawable(getResources(), R.drawable.left_button_arrow, null);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        leftButton.setForeground(leftButtonForegroundPressed);
                    }
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    //Toast.makeText(MainActivity.this,"松开了" + slider.getProgress() ,Toast.LENGTH_SHORT).show();
                    //leftButton.setBackgroundResource(R.drawable.left_button_arrow);
                    //leftButton.setBackgroundResource(R.drawable.left_button_background_svg);
                    Drawable leftButtonForeground = getResources().getDrawable(R.drawable.left_button_background_svg);
                    //ContextCompat.getDrawable(getApplicationContext(),R.drawable.left_button_arrow);
                    //ResourcesCompat.getDrawable(getResources(), R.drawable.left_button_arrow, null);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        leftButton.setForeground(leftButtonForeground);
                    }
                    //lastProgress = slider.getProgress() - 30;
                    progress = slider.getProgress() - 30;
                    slider.setProgress(lastProgress);
                    tv.setDegree(slider.getProgress());
                    tv.invalidate();
                    sliderChangedByButton = true;
                }
                return false;
            }
        });



        final  Button rightButton = new Button(this);
        //rightButton.setBackgroundResource(R.drawable.right_button_arrow);

        Drawable rightButtonForeground = getResources().getDrawable(R.drawable.right_button_background_svg);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            rightButton.setForeground(rightButtonForeground);
        }




        rightButton.setBackgroundColor(Color.parseColor("#007a66"));

        //rightButton.setBackgroundResource(R.drawable.right_button_background_svg);

        rightButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //Toast.makeText(MainActivity.this,"按下了" ,Toast.LENGTH_SHORT).show();
                    //rightButton.setBackgroundColor(Color.parseColor("#17252a"));
                    //rightButton.setBackgroundResource(R.drawable.right_button_background_pressed);
                    Drawable rightButtonForegroundPressed = getResources().getDrawable(R.drawable.right_button_background_pressed);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        rightButton.setForeground(rightButtonForegroundPressed);
                    }
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    //Toast.makeText(MainActivity.this,"松开了" + slider.getProgress() ,Toast.LENGTH_SHORT).show();
                    //rightButton.setBackgroundResource(R.drawable.right_button_arrow);
                    //rightButton.setBackgroundResource(R.drawable.right_button_background_svg);
                    Drawable rightButtonForeground = getResources().getDrawable(R.drawable.right_button_background_svg);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        rightButton.setForeground(rightButtonForeground);
                    }
                    //lastProgress = slider.getProgress() + 30;
                    progress = slider.getProgress() + 30;
                    slider.setProgress(lastProgress);
                    tv.setDegree(slider.getProgress());
                    tv.invalidate();
                    sliderChangedByButton = true;
                }
                return false;
            }
        });


        LinearLayout.LayoutParams one = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT, 1);
        LinearLayout.LayoutParams two = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT, 4);

        leftButton.setLayoutParams(two);
        rightButton.setLayoutParams(two);
        slider.setLayoutParams(one);

        lnlH = new LinearLayout(this);
        lnlH.setOrientation(LinearLayout.HORIZONTAL);
        lnlH.setBackgroundColor(Color.parseColor("#287a78"));

        //((ViewGroup)leftButton.getParent()).removeView(leftButton);
        lnlH.addView(leftButton);

        //((ViewGroup)rightButton.getParent()).removeView(rightButton);
        //lnlH.addView(rightButton);

        ((ViewGroup)slider.getParent()).removeView(slider);
        lnlH.addView(slider);

        //((ViewGroup)rightButton.getParent()).removeView(rightButton);
        lnlH.addView(rightButton);

        Integer sliderHeight = (int)(height * 0.1);
        lnlH.setMinimumHeight(sliderHeight);

        // any setting button size is not working, because it's match parent linear layout already.
        //leftButton.setWidth((int)(width*0.2));
        //leftButton.setWidth(lnlH.getHeight());

//        if (leftButton.getWidth() > leftButton.getHeight()) {
//            leftButton.setWidth(leftButton.getHeight());
//        } else {
//            leftButton.setHeight(leftButton.getWidth());
//        }

//        leftButton.setWidth(leftButton.getHeight());
//        rightButton.setWidth(rightButton.getHeight());

        LinearLayout sliderLabel = findViewById(R.id.sliderLabel);
        //sliderLabel.setBackgroundColor(Color.parseColor("#669cff"));
        //sliderLabel.setBackgroundColor(Color.parseColor("#202224"));
        sliderLabel.setBackgroundColor(Color.parseColor("#287a78"));

        LinearLayout sliderLabelNoText = findViewById(R.id.sliderLabelNoText);
        sliderLabelNoText.setBackgroundColor(Color.parseColor("#287a78"));

        lnl = new LinearLayout(this);
        lnl.setOrientation(LinearLayout.VERTICAL);
        lnl.addView(tv);

//        ((ViewGroup)sliderLabelNoText.getParent()).removeView(sliderLabelNoText);
//        lnl.addView(sliderLabelNoText);

//        ((ViewGroup)slider.getParent()).removeView(slider);
//        lnl.addView(slider);

        //((ViewGroup)lnlH.getParent()).removeView(lnlH);
        lnl.addView(lnlH);

//        ((ViewGroup)sliderLabel.getParent()).removeView(sliderLabel);
//        lnl.addView(sliderLabel);


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

        MenuItem item=menu.add(0,BLUE,0,"hi");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);//主要是这句话
        //item.setOnMenuItemClickListener(listener);//添加监听事件
        item.setIcon(R.drawable.calendar);//设置图标

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
            case BLUE:
                showYearPickerDialog();
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

    public void showYearPickerDialog() {

        final NumberPicker picker = new NumberPicker(this);

        //picker.setDisplayedValues(s);
        //picker.setMinValue(0);
        //picker.setMaxValue(10);
        //String[] test = new String[]{"北京","上海","广州","深圳"};

        final ArrayList<String> allYearsWithoutDuplicates = new ArrayList<>();
        for (int i=0; i<tv.allYears.size(); i++) {
            String toBeAdded = tv.allYears.get(i);
            if (toBeAdded.equals("0000")) {
                toBeAdded = "Temples under construction";
            } else if (toBeAdded.equals("1111")) {
                toBeAdded = "Future Temples";
            }
            if(!allYearsWithoutDuplicates.contains(toBeAdded)) {
                allYearsWithoutDuplicates.add(toBeAdded);
            }
        }
        // i have to use this for loop to covert allYears arraylist to String[], I used toArray() on the arraylist, but did work
        //ArrayList<String> temporary = new ArrayList<>();
        final String[] temporary = new String[allYearsWithoutDuplicates.size()];
        for (int i = 0; i < allYearsWithoutDuplicates.size(); i++) {
            temporary[i] = allYearsWithoutDuplicates.get(i);
        }

        //Toast.makeText(mContext, "temporary length is: " + temporary.length + "", Toast.LENGTH_SHORT).show();
        //Toast.makeText(mContext, "allYeas size: " + tv.allYears.size() + "", Toast.LENGTH_SHORT).show();
        //Toast.makeText(mContext, temporary[100] + "", Toast.LENGTH_SHORT).show();

        picker.setDisplayedValues(temporary); //设置文字
        picker.setMaxValue(temporary.length - 1); //设置最大值
        //picker.setValue(0);


        // we can use this text view to pass over want ever year is selected, or we can use a field so that it can be accessed from inner class
        // this text view is the title
        final TextView tx = new TextView(this);
        tx.setGravity(Gravity.CENTER);
        yearPickerString = "View Temple dedicated in " + "1836";
        tx.setText(yearPickerString);
        tx.setTextSize(20);
        tx.setPadding(5,20,5,5);
        tx.setTextColor(Color.BLACK);
        selectedYear = "1836"; // we need this here, other wise, selectedYear is null when first time open year picker dialog and not moving the picker when passed in TempleView through method.
        picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int i, int i1) {
                selectedYear = temporary[i1]; // pass this selected value to dialog button, we can use a field so that it can be accessed from inner class
                selectedYearIndex = i1;
                if (temporary[i1].length() == 4) {
                    yearPickerString = "View Temple dedicated in " + temporary[i1];
                    tx.setText(yearPickerString);
                } else {
                    yearPickerString = "View " + temporary[i1];
                    tx.setText(yearPickerString);
                }
            }
        });




        LinearLayout yearPickerView = new LinearLayout(this);
        yearPickerView.setOrientation(LinearLayout.VERTICAL);
        yearPickerView.addView(tx);
        yearPickerView.addView(picker);



        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setTitle("hi");
        builder.setView(yearPickerView);
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //set onclick method for this button below
                Toast.makeText(mContext, yearPickerString + " theta is " + templeYearsThetaFriends.get(selectedYearIndex), Toast.LENGTH_SHORT).show();
                //we can use this selected year value to update spiral
                progress = templeYearsThetaFriends.get(selectedYearIndex) - 200;
                slider.setProgress(lastProgress);
                tv.setDegree(slider.getProgress());
                tv.invalidate();
                tv.getSelectedYear(selectedYear);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //do nothing
                Toast.makeText(mContext, "Year Picker Dismissed" + templeYearsThetaFriends.size(), Toast.LENGTH_SHORT).show();
            }
        });

        final AlertDialog dialog = builder.create();
        dialog.show();

        Button btnPositive = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button btnNegative = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btnPositive.getLayoutParams();
        layoutParams.weight = 10;
        btnPositive.setLayoutParams(layoutParams);
        btnNegative.setLayoutParams(layoutParams);


        // these will override the onclick above
//        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //do something
//                Toast.makeText(mContext, "click on yes", Toast.LENGTH_SHORT).show();
//            }
//        });
//        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //do something
//                Toast.makeText(mContext, "click on no", Toast.LENGTH_SHORT).show();
//
//            }
//        });



    }

}
