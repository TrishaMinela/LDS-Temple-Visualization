package edu.byuh.cis.templevis;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class TempleView extends View {

    private Paint bluePaint, redPaint, spiralPaint, yearDisplayPaint;
    private float screenWidth, screenHeight;
    public float theta;
    private Path spiralLine;
    private Boolean loadedImages;
    private  float centerX;
    private float centerY;
    private  float initialR;
    private  float thetaSmall;
    private boolean sliderMoving;
    private static ArrayList<Bitmap> temples;
    private ArrayList<ArrayList<Float>> onScreenTemples;
    private ArrayList<Float> oneOnScreenTemple;
    private ArrayList<ArrayList<Float>> spiralCoordinates;
    private Boolean gotTheFirstSpiralCoordinate = false;
    private ArrayList<Float> sizes;
    private ArrayList<Float> sizes2;
    private Bitmap logo_circle;
    private ArrayList<String> allTempleLinks;
    private ArrayList<String> allTempleInfo;
    private float sliderProgress;
    private float thetaPre;
    private int eachIndex;
    private Matrix currentTempleMatrix;
    private float topCoordinateInSpiralX;
    private float topCoordinateInSpiralY;
    private float largestSizeInSpiral;
    private boolean coordinatesAndSizesUpdated;
    private boolean orientationJustChanged;
    public boolean touchDownOnScreenTempleView;
    private float downX;
    private float downY;
    private ArrayList<Float> movingCoordinatesLastTime;
    private long downTime;
    private float ultimateScreenWidth;
    private float initialRForLocation;
    private boolean firstLaunch;
    private float windowWidth;
    private float windowHeight;
    private static ArrayList<Integer> allSpiralImageIds;
    private String lastSpiralEffectHolder;
    private static ArrayList<Integer> allLargeImageIds;
    private String oneTempleInfo;
    private static ArrayList<Integer> allTempleInfoFileIds;
    private Boolean show_label;


    public TempleView(Context context) {
        super(context);

        bluePaint = new Paint();
        bluePaint.setColor(Color.parseColor("#17252a"));
        bluePaint.setStyle(Paint.Style.FILL);
        bluePaint.setTextSize(35);
        redPaint = new Paint();
        redPaint.setColor(Color.RED);
        redPaint.setStyle(Paint.Style.FILL);
        redPaint.setTextSize(60);
        spiralPaint = new Paint();
        spiralPaint.setColor(Color.RED);
        spiralPaint.setStyle(Paint.Style.STROKE);
        spiralPaint.setStrokeWidth(5);
        spiralLine = new Path();
        loadedImages = false;
        spiralCoordinates = new ArrayList<>();
        sizes = new ArrayList<>();
        sizes2 = new ArrayList<>();
        onScreenTemples = new ArrayList<>();
        oneOnScreenTemple = new ArrayList<>();
        allTempleLinks = new ArrayList<>();
        allTempleInfo = new ArrayList<>();
        theta = 5550;
        thetaPre = 0;
        currentTempleMatrix = new Matrix();
        coordinatesAndSizesUpdated = FALSE;
        orientationJustChanged = FALSE;
        movingCoordinatesLastTime = new ArrayList<>();
        yearDisplayPaint = new Paint();
        firstLaunch = TRUE;
        allSpiralImageIds = new ArrayList<>();

    }

    public void setDegree(int sliderP) {
        sliderProgress = sliderP;
        theta = sliderP;
        //Log.d("theta is ", theta + " ***************************************************************************************");
    }

    public float getLastProgress() {
        //Log.d("theta", " is " + theta + " ");
        return theta;
    }

    public void sliderStart(boolean s) {
        sliderMoving = s;
    }

    public void sliderStop(boolean s) {
        sliderMoving = s;
    }

    public void sliderInProgress(boolean s) {
        sliderMoving = s;
    }

    public void readLinksFile() {
        try {
            InputStream allTempleLinksFile =  getContext().getResources().openRawResource(R.raw.all_temple_links);
            if (allTempleLinksFile != null)
            {
                InputStreamReader ir = new InputStreamReader(allTempleLinksFile);
                BufferedReader br = new BufferedReader(ir);
                String line;
                //read each line
                while (( line = br.readLine()) != null) {
                    allTempleLinks.add(line+"\n");
                }
                allTempleLinksFile.close();
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
        //Log.d("allTempleLinks is ", allTempleLinks.get(1) + "");
    }

    public void readOneInfoFile(int id) {
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

    public void readInfoFile() {
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

    private Bitmap loadAndScale(Resources res, int id, float newWidth) {
        Bitmap original = BitmapFactory.decodeResource(res, id);
        float aspectRatio = (float)original.getHeight()/(float)original.getWidth();
        float newHeight = newWidth * aspectRatio;
        return Bitmap.createScaledBitmap(original, (int)newWidth, (int)newHeight, true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent m) {
        float touchX= m.getX();;
        float touchY= m.getY();;
        //Log.d("TOUCH EVENT",  " touch event happens on screen at ************* " + touchX + " " + touchY );
        if (m.getAction() == MotionEvent.ACTION_DOWN) {
            downX = m.getX();
            downY = m.getY();
            //Toast.makeText(getContext(), "touched DOWN at " + downX + " " + downY, Toast.LENGTH_SHORT).show();
            movingCoordinatesLastTime.clear();
            movingCoordinatesLastTime.add(downX);
            movingCoordinatesLastTime.add(downY);
            //Log.d("DOWN",  " finger down on screen at |||||||||||||||" + downX + " " + downY );
            touchDownOnScreenTempleView = TRUE;
            downTime = System.currentTimeMillis();
        }

        if (m.getAction() == MotionEvent.ACTION_MOVE) {
            //Toast.makeText(getContext(), "finger moving on screen", Toast.LENGTH_SHORT).show();

            float movingX = m.getX();
            float movingY = m.getY();
            //Log.d("MOVING",  " finger moving on screen at " + movingX + " " + movingY );

            float lastX = movingCoordinatesLastTime.get(0);
            float lastY = movingCoordinatesLastTime.get(1);
            float xDisplacementFromLastMove = movingX - lastX;
            float yDisplacementFromLastMove = movingY - lastY;
            //Log.d("movingCoordinates", "movingCoordinatesLastTime is " + movingCoordinatesLastTime);

            movingCoordinatesLastTime.clear();
            movingCoordinatesLastTime.add(movingX);
            movingCoordinatesLastTime.add(movingY);
            //Log.d("xy displacementFLT ", xDisplacementFromLastMove + " " + yDisplacementFromLastMove);

            boolean topLeft = (touchY <= 9 * screenHeight / 20 && touchX <= screenWidth / 2);
            boolean topRight = (touchY <= 9 * screenHeight / 20 && touchX > screenWidth / 2);
            boolean bottomLeft = (touchY < 9 * screenHeight / 10 && touchY > 9 * screenHeight / 20 && touchX <= screenWidth / 2);
            boolean bottomRight = (touchY < 9 * screenHeight / 10 && touchY > 9 * screenHeight / 20 && touchX > screenWidth / 2);

            boolean top = (touchY <= centerY);
            boolean bottom = (touchY < 9 * screenHeight / 10 && touchY > centerY);
            boolean left = (touchX <= centerX);
            boolean right = (touchX > centerX);

            boolean leftThirdVertical = (touchX <= centerX - screenWidth / 6 );
            boolean middleThirdVertical = (touchX > centerX - screenWidth / 6 && touchX < centerX + screenWidth / 6);
            boolean rightThirdVertical = (touchX >= centerX + screenWidth / 6 );

            boolean middleColumnNarrowVertical = (touchX > centerX - screenWidth / 20 && touchX < centerX + screenWidth / 20);

            //Log.d("topLeft? ",  topLeft + " ");

            int moveTheta = 10;

            boolean thetaMaxReached = theta >= 6800;
            boolean thetaMinReached = theta <= 0;

            if (leftThirdVertical) {
                if (yDisplacementFromLastMove > 0) {
                    if (thetaMaxReached) {
                    } else {
                        theta = theta + moveTheta;
                    }
                } else if (yDisplacementFromLastMove < 0) {
                    if (thetaMinReached) {
                    } else {
                        theta = theta - moveTheta;
                    }
                }
            } else if (rightThirdVertical) {
                if (yDisplacementFromLastMove > 0) {
                    if (thetaMinReached) {
                    } else {
                        theta = theta - moveTheta;
                    }
                } else if (yDisplacementFromLastMove < 0) {
                    if (thetaMaxReached) {
                    } else {
                        theta = theta + moveTheta;
                    }
                }
            } else if (middleThirdVertical) {
                if (touchY > centerY - screenWidth / 6 && touchY < centerY + screenWidth / 6) {
                    //do nothing, touch movement in center of spiral is disabled
                } else if (top) {
                    //check xd
                    if (xDisplacementFromLastMove > 0) {
                        if (thetaMinReached) {
                        } else {
                            theta = theta - moveTheta;
                        }
                    } else if (xDisplacementFromLastMove < 0) {
                        if (thetaMaxReached) {
                        } else {
                            theta = theta + moveTheta;
                        }
                    }
                } else if (bottom) {
                    //check xd
                    if (xDisplacementFromLastMove > 0) {
                        if (thetaMaxReached) {
                        } else {
                            theta = theta + moveTheta;
                        }
                    } else if (xDisplacementFromLastMove < 0) {
                        if (thetaMinReached) {
                        } else {
                            theta = theta - moveTheta;
                        }
                    }
                }
            }
        }

        if (m.getAction() == MotionEvent.ACTION_UP) {
            long upTime = System.currentTimeMillis();
            long period = upTime - downTime;
            touchDownOnScreenTempleView = FALSE;
            //helper--time test
            //Long timeLong = System.currentTimeMillis();
            //String time = String.valueOf(timeLong);
            //Toast.makeText(getContext(), "current time is " + time, Toast.LENGTH_SHORT).show();
            float x = m.getX();
            float y = m.getY();
            //Toast.makeText(getContext(), "touched a circle when UP at " + x + " " + y, Toast.LENGTH_SHORT).show();

            float distanceToCenter = (float) (Math.sqrt(Math.pow(Math.abs(x - centerX), 2) + Math.pow(Math.abs(y - centerY), 2)));

            if (y < 9 * screenHeight / 10 && period < 100) {
                boolean singleTempleViewOpened = false;

                Collections.reverse(onScreenTemples);
                for (ArrayList<Float> eachOnScreenTemple : onScreenTemples) {
                    //remember each Float in inner class is a object, when convert it to int you need to use some method.
                    eachIndex = (int)(eachOnScreenTemple.get(0).floatValue());
                    float eachXCoordinate = eachOnScreenTemple.get(1);
                    float eachYCoordinate = eachOnScreenTemple.get(2);
                    float eachSize = eachOnScreenTemple.get(3);
                    float distanceToCurrentCoordinate = (float) (Math.sqrt(Math.pow(Math.abs(x - eachXCoordinate), 2) + Math.pow(Math.abs(y - eachYCoordinate), 2)));

                    if (distanceToCurrentCoordinate < eachSize) {
                        //Toast.makeText(getContext(), "touched a circle at " + x + " " + y + " and eachIndex here is " + eachIndex , Toast.LENGTH_SHORT).show();
                        //Toast.makeText(getContext(), "how many onScreenTemples last time? " + onScreenTemples.size(), Toast.LENGTH_SHORT).show();
                        //Log.d("singleTempleViewOpen? ", singleTempleViewOpened + "");
                        if (singleTempleViewOpened == false) {
                            if (eachIndex <= 226) {
                                singleTempleViewOpened = true;
                                //Log.d("eachIndex is ", eachIndex + " when click on circle");
                                LinearLayout.LayoutParams nice = new LinearLayout.LayoutParams
                                        (LinearLayout.LayoutParams.MATCH_PARENT,
                                                LinearLayout.LayoutParams.MATCH_PARENT, 1);
                                LinearLayout lnl = new LinearLayout(getContext());
                                lnl.setOrientation(LinearLayout.VERTICAL);

                                ImageView singleTempleImageView = new ImageView(getContext());
                                Bitmap b;
                                b = loadAndScale(getResources(), allLargeImageIds.get(eachIndex), 10f*initialR);
                                singleTempleImageView.setImageBitmap(b);
                                singleTempleImageView.setPadding(0,0,0,0);
                                singleTempleImageView.setMaxHeight(singleTempleImageView.getWidth());

                                oneTempleInfo = "";
                                readOneInfoFile(allTempleInfoFileIds.get(eachIndex));

                                TextView singleTempleTextView = new TextView(getContext());
                                singleTempleTextView.setText(oneTempleInfo);
                                //singleTempleTextView.setBackgroundColor(Color.BLUE);
                                singleTempleTextView.setGravity(Gravity.CENTER);

                                ScrollView sv = new ScrollView(getContext());
                                //sv.setPadding(100,100,100,100);
                                sv.addView(singleTempleTextView);


                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                                builder.setTitle(allTempleInfo.get(eachIndex*3));

                                lnl.addView(singleTempleImageView);
                                lnl.addView(sv);

                                singleTempleImageView.setLayoutParams(nice);

                                builder.setView(lnl);

                                builder.setCancelable(true);

                                builder.setPositiveButton(getResources().getString(R.string.return_button), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //do nothing
                                    }
                                });

                                builder.setNegativeButton(getResources().getString(R.string.website_button), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //set onclick method for this button below
                                    }
                                });

                                final AlertDialog dialog = builder.create();

                                dialog.show();

                                // here is where we get templeUrl, to avoid the eachIndex change error
                                final String templeUrl = allTempleLinks.get(eachIndex);

                                Button btnPositive = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                                Button btnNegative = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);

                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btnPositive.getLayoutParams();
                                layoutParams.weight = 10;
                                btnPositive.setLayoutParams(layoutParams);
                                btnNegative.setLayoutParams(layoutParams);

                                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        //dialog.dismiss();
                                        //dialog stays when click on website button

                                        // for some reason, i don't why, but each index is changed in here,
                                        // so we get templeUrl before this, according to the correct eachIndex
                                        //String templeUrl = allTempleLinks.get(eachIndex);
                                        //Log.d("eachIndex is ", eachIndex + " when click on website button");
                                        //Log.d("templeUrl is ", templeUrl + "");

                                        if (templeUrl.equals("" + "\n")) {
                                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                            builder.setTitle("No Link Available");
                                            builder.setMessage("Temple does not have a website yet");
                                            builder.setIcon(R.mipmap.ic_launcher_round);
                                            //点击对话框以外的区域是否让对话框消失
                                            builder.setCancelable(true);
                                            final AlertDialog dialog = builder.create();
                                            dialog.show();

                                        } else {
                                            Intent eachTemplePage= new Intent();
                                            eachTemplePage.setAction("android.intent.action.VIEW");
                                            Uri eachTemplePage_url = Uri.parse(templeUrl);
                                            eachTemplePage.setData(eachTemplePage_url);
                                            getContext().startActivity(eachTemplePage);
                                        }
                                    }
                                });
                            } else {
                                //no link
                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                builder.setTitle("Nothing Here");
                                builder.setMessage("future temples to come!");
                                builder.setIcon(R.mipmap.ic_launcher_round);
                                builder.setCancelable(true);
                                final AlertDialog dialog = builder.create();
                                dialog.show();
                            }
                        }
                    }
                }
                Collections.reverse(onScreenTemples);
            }
        }
        return true;
    }

    public void orientationJustChanged(boolean b) {
        orientationJustChanged = b;
    }

    public void firstLaunchCoordinatesAndSizes() {
        //spiralCoordinates.clear();
        //sizes.clear();
        //getCoordinatesAndSizes();
        firstLaunch = FALSE;
    }

    public void getWindowSize(float w, float h) {
        windowWidth = w;
        windowHeight = h;
    }

    @Override
    public void onDraw(Canvas c) {
        thetaSmall = theta / 4;
        //Toast.makeText(getContext(), "onscreen temples" + onScreenTemples.size(), Toast.LENGTH_SHORT).show();
        //Log.d("onscreen temples ", "" + onScreenTemples.size());
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            screenWidth = c.getWidth() / 2;
            screenHeight = c.getHeight();
            centerX = screenWidth / 2 + 3 * screenWidth / 16;
            centerY = screenHeight / 2;
            yearDisplayPaint.setTextSize((int)(2 * screenHeight / 25));
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            screenWidth = c.getWidth();
            screenHeight = c.getHeight();
            centerX = screenWidth / 2;
            centerY = screenHeight / 2;
            ultimateScreenWidth = screenWidth;
            yearDisplayPaint.setTextSize((int)(screenHeight / 25));
            //Log.d("PORTRAIT ", "|||||||||||||||||||||||||||||" + screenWidth);
        }
        //Log.d("CENTER X ", centerX + " ");
        //Log.d("CENTER Y ", centerY + " ");
        initialR = screenWidth / 10;
        initialRForLocation = ultimateScreenWidth / 10;
        if (orientationJustChanged == TRUE) {
            spiralCoordinates.clear();
            sizes.clear();
            getCoordinates();
            getSizes();
            orientationJustChanged = FALSE;
            //Log.d("coordinates and sizes ", " just reset ");
            //Log.d("orChanged coorSize ", " ++++++++++++++++ "
                    //+ spiralCoordinates.size() + " "
                    //+ sizes.size());
            //Log.d("spiralCoordinates", spiralCoordinates + " ");
            //Log.d("sizes", sizes + " ");
        }
        //when app first launch this got called.
        if (coordinatesAndSizesUpdated == FALSE) {
            getCoordinates();
            getSizes();
            coordinatesAndSizesUpdated = TRUE;
            //Log.d("launch coorSize ", " ++++++++++++++++ "
                    //+ spiralCoordinates.size() + " "
                    //+ sizes.size());
            //Log.d("spiralCoordinates", spiralCoordinates + " ");
            //Log.d("sizes", sizes + " ");
            //Log.d("screenWidth", screenWidth + " ");
            //Log.d("screenHeight", screenHeight + " ");
        }
        String spiral_effect = PrefsActivity.getSpiralEffectPref(getContext());
        show_label = PrefsActivity.getShowLabelPref(getContext());
        //Log.d("spiral effect ", spiral_effect + " ");

        // we need to update the coordinates when switching to static mode from other effect. other wise coordinates for other effect will be kept.
        if (spiral_effect.equalsIgnoreCase("static")) {
            //just turn to static or it was static before?
            if (lastSpiralEffectHolder == null) {
                //first time run, do noting
            } else {
                if (lastSpiralEffectHolder.equalsIgnoreCase(spiral_effect)) {
                    //do nothing, it have been static last time
                } else {
                    //just turn to static, get a new coordinates
                    spiralCoordinates.clear();
                    getCoordinates();
                }
            }
        } else {
            //not static, do nothing
        }
        lastSpiralEffectHolder = spiral_effect;

        if (spiral_effect.equalsIgnoreCase("spin")) {
            spiralCoordinates.clear();
            getCoordinatesRotateRegular();
        } else if (spiral_effect.equalsIgnoreCase("zoom")) {
            spiralCoordinates.clear();
            getCoordinatesRotateZoom();
        } else if (spiral_effect.equalsIgnoreCase("threeD")) {
            spiralCoordinates.clear();
            getCoordinatesThreeD();
        }
        //Log.d("getCoordinatesAndSizes", "again!!!!!!!!!!" + " ");

        //c.drawColor(Color.parseColor("#66ccff"));

        //Temple View Background color
        //c.drawColor(Color.parseColor("#24292b"));
        c.drawColor(Color.parseColor("#17252a"));

        //we just want to load the images once, we don't have to load it every time when we re-draw. otherwise the program is gonna be so slow
        if (loadedImages == false) {
            loadedImages = true;
            //get the temple images in array list

            //when app launches, images are loaded according to screen width
            //when launches landscape, according to window height
            float temp;
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                temp = windowHeight;
            } else {
                temp = screenWidth;
            }
            ImageCache.init(getResources(), temp, screenHeight);

            allLargeImageIds = ImageCache.getAllImageIds();
            allTempleInfoFileIds = ImageCache.getAllTempleInfoFileIds();

            temples = ImageCache.getTemplesList();

            logo_circle = ImageCache.getLogo();

            readLinksFile();
            readInfoFile();

            yearDisplayPaint.setColor(Color.parseColor("#def2f1"));
            yearDisplayPaint.setStyle(Paint.Style.FILL);
            yearDisplayPaint.setTextAlign(Paint.Align.CENTER);
        }

        //helper
        //c.drawText("Screen Width and Height are " + screenWidth + " " + screenHeight, 0, screenHeight - 100, bluePaint);
        //c.drawText("how many temples " + temples.size() + " ", 0, screenHeight - 200, redPaint);
        //c.drawRect(0,3 * screenHeight/4, screenWidth, 3 * screenHeight/4 + 10, bluePaint);
        //the middle circle image is here ==============================================
        //drawMiddleCircle(c);

        placeAllCircles(c);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            yearDisplayLandscape(c);

        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            yearDisplay(c);
        }

//        Matrix logoMatrix = new Matrix();
//        logoMatrix.postScale(2 * 2 * initialR / screenWidth, 2 * 2 * initialR / screenWidth);
//        Bitmap newLogoCircle = Bitmap.createBitmap(logo_circle, 0, 0, logo_circle.getWidth(), logo_circle.getHeight(), logoMatrix, true);
//        c.drawBitmap(newLogoCircle, screenWidth / 6000 * theta, screenHeight / 6000 * theta, null);

        //Log.d("all sizes : ", sizes + " ");
        //Log.d("all sizes : ", spiralCoordinates + " ");
        //Log.d("x y coordinate", "spiralCoordinates are " + spiralCoordinates);

        //drawSpiral(c);

    }

    public void drawTempleLabels(float ts, Bitmap t, Canvas c) {

        float currentTempleSize = sizes.get((int) (ts));
        float currentTempleX = spiralCoordinates.get((int) (ts)).get(0);
        float currentTempleY = spiralCoordinates.get((int) (ts)).get(1);
        float newCurrentTempleRadius = currentTempleSize * screenWidth / 2;

        Paint thisTempleLabelPaint = new Paint();

        thisTempleLabelPaint.setColor(Color.parseColor("#def2f1"));
        thisTempleLabelPaint.setStyle(Paint.Style.FILL);
        thisTempleLabelPaint.setTextSize((int)(newCurrentTempleRadius / 5));
        thisTempleLabelPaint.setTextAlign(Paint.Align.CENTER);
        //thisTempleLabelPaint.setShadowLayer(10,0,-5,Color.GRAY);

        int thisTempleIndex = temples.indexOf(t);

        String thisTempleName = allTempleInfo.get(thisTempleIndex*3);
        String thisTempleLocation = thisTempleName.substring(0, thisTempleName.length() - 7);
        String[] thisTempleLocationWords = thisTempleLocation.split(" ");

        String thisTempleNameOne = "";
        String thisTempleNameTwo = "";
        if (thisTempleLocationWords.length % 2 == 0) { // if there are even number of words in location, then each line has the same number of words
            for (int i = 0; i < thisTempleLocationWords.length / 2; i ++) {
                thisTempleNameOne += thisTempleLocationWords[i] + " ";
            }
            for (int i = thisTempleLocationWords.length / 2; i < thisTempleLocationWords.length ; i ++) {
                thisTempleNameTwo += thisTempleLocationWords[i] + " ";
            }
        } else { // if there are odd number of words in location, then first line has one more line than second line
            for (int i = 0; i < thisTempleLocationWords.length / 2 + 1; i ++) {
                thisTempleNameOne += thisTempleLocationWords[i] + " ";
            }
            for (int i = thisTempleLocationWords.length / 2 + 1; i < thisTempleLocationWords.length ; i ++) {
                thisTempleNameTwo += thisTempleLocationWords[i] + " ";
            }
        }


        if (sliderMoving == false && ts < 200 && thisTempleIndex < 185 && show_label) {
            //c.drawText(thisTempleName, currentTempleX, currentTempleY + newCurrentTempleRadius + thisTempleLabelPaint.getTextSize(), thisTempleLabelPaint);
            c.drawText(thisTempleNameOne, currentTempleX, currentTempleY + newCurrentTempleRadius - thisTempleLabelPaint.getTextSize(), thisTempleLabelPaint);
            c.drawText(thisTempleNameTwo, currentTempleX, currentTempleY + newCurrentTempleRadius, thisTempleLabelPaint);
        }
    }

    public void actuallyDrawing(float ts, Bitmap t, Canvas c) {

        float currentTempleSize = sizes.get((int) (ts));

        //Log.d("ts is: ", "" + ts + " ");
        //Log.d("ts size: ", "" + sizes.get((int) (ts)) + " ");
        //Log.d("spiralcoors: ", " in actuallydrawing " + spiralCoordinates + " ");
        //Log.d("ts coor: ", "" + spiralCoordinates.get((int) (ts)) + " ");

        float currentTempleX = spiralCoordinates.get((int) (ts)).get(0);
        float currentTempleY = spiralCoordinates.get((int) (ts)).get(1);
        float newCurrentTempleRadius = currentTempleSize * screenWidth / 2;

        currentTempleMatrix.setScale(4 * currentTempleSize, 4 * currentTempleSize);
        currentTempleMatrix.postTranslate(currentTempleX - t.getWidth()  *currentTempleSize*2, currentTempleY - t.getHeight() * currentTempleSize*2);

        c.drawBitmap(t, currentTempleMatrix, null);
    }

    //place all circles, and get the index of on screen temples
    //this method also call actualDrawing method to draw
    public void placeAllCircles(Canvas c) {
        //Log.d("spiralcoors: ", " in placeallcircles " + spiralCoordinates + " ");
        //Log.d("spiralcoors: ", " in placeallcircles " + spiralCoordinates + " ");

        onScreenTemples.clear();
        for (Bitmap t : temples) {
            float ts = theta - 30 * temples.indexOf(t);
            if (ts > 0 && ts < spiralCoordinates.size() - 150) {
                actuallyDrawing(ts, t, c);
                drawTempleLabels(ts, t, c);

                //add all on screen temples index to a array list once the slider stopped moving,
                //the following lines of code are copied from method actuallyDrawing(, , );
                float currentTempleIndex = (float)(temples.indexOf(t));
                float currentTempleX = spiralCoordinates.get((int) (ts)).get(0);
                float currentTempleY = spiralCoordinates.get((int) (ts)).get(1);
                float currentTempleSize = sizes.get((int) (ts));
                float currentTempleRadius = currentTempleSize * screenWidth / 2;
                //inner array list: (this onScreenTemple index, x coordinate, y coordinate, temple radius at this position)
                oneOnScreenTemple.add(currentTempleIndex);
                oneOnScreenTemple.add(currentTempleX);
                oneOnScreenTemple.add(currentTempleY);
                oneOnScreenTemple.add(currentTempleRadius);
                //the following lines of code are copied from method getCoordinates();
                //be aware of adding one array list to another array list of array list then clear old one, remember you must copy.
                ArrayList<Float> oneOnScreenTempleCopy = new ArrayList<>();
                oneOnScreenTempleCopy.addAll(oneOnScreenTemple);
                onScreenTemples.add(oneOnScreenTempleCopy);
                //Log.d("onscreentemples", " add one " + onScreenTemples.size() + " ");
                oneOnScreenTemple.clear();
            }
        }
        // we need this line of code, so that in 3 d view, only the front temple opens when user clicks
        Collections.reverse(onScreenTemples);
        //Log.d("onscreen temples ", "" + onScreenTemples.size());
    }

    public void drawMiddleCircle(Canvas c) {
        //draw middle image ********************************
        //float hh = logo_circle.getHeight();
        //c.drawText("hh is " + hh + " ", 0, screenHeight - 200, redPaint);
        //c.drawBitmap(logo_circle, centerX, centerY, null);
        Matrix logoMatrix = new Matrix();
        logoMatrix.postScale(2 * 2 * initialR / screenWidth, 2 * 2 * initialR / screenWidth);
        Bitmap newLogoCircle = Bitmap.createBitmap(logo_circle, 0, 0, logo_circle.getWidth(), logo_circle.getHeight(), logoMatrix, true);
        c.drawBitmap(newLogoCircle, centerX - newLogoCircle.getWidth() / 2, centerY - newLogoCircle.getHeight() / 2, null);
    }


    //improved version of yearDisplay
    public void yearDisplay(Canvas c) {

        //get the index of on screen temples,
        //the first one in on screen temples to the last
        //go to temple info file, the specific line to get years
        //3 lines each temple in the file

        //c.drawRect(0, 9 * screenHeight / 10, screenWidth, screenHeight, bluePaint);
        float firstOnScreenTempleIndex = 0;
        float lastOnScreenTempleIndex = 0;

        // new year display logic
        if (onScreenTemples.size() != 0) {
            lastOnScreenTempleIndex = (onScreenTemples.get(onScreenTemples.size()-1).get(0));
            firstOnScreenTempleIndex = (onScreenTemples.get(0).get(0));
        }

        String endYear = allTempleInfo.get((int)(firstOnScreenTempleIndex) * 3 + 2);
        String startYear = allTempleInfo.get((int)(lastOnScreenTempleIndex) * 3 + 2) ;

        startYear = startYear.substring(startYear.length()-5);
        endYear = endYear.substring(endYear.length()-5);

        if (theta == 0){
            c.drawText( getResources().getString(R.string.welcome_to_view) + " " + getResources().getString(R.string.lds_temples), screenWidth / 2, 39 * screenHeight / 40, yearDisplayPaint);
        } else if (theta > 5550 ) {
            c.drawText( getResources().getString(R.string.future_temples), screenWidth / 2, 39 * screenHeight / 40, yearDisplayPaint);
        } else if (endYear.contains("0000") || endYear.contains("1111")){
            c.drawText( getResources().getString(R.string.years_of_temples) + " "  + startYear + "--- " + 2020, screenWidth / 2, 39 * screenHeight / 40, yearDisplayPaint);
        } else {
            //Log.d("endYeas is ", endYear);
            c.drawText( getResources().getString(R.string.years_of_temples) + " "  + startYear + "--- " + endYear, screenWidth / 2, 39 * screenHeight / 40, yearDisplayPaint);
        }
    }

    public void yearDisplayLandscape(Canvas c) {
        c.drawRect( 5 * screenWidth / 4, 0, 2 * screenWidth, screenHeight, bluePaint);
        float firstOnScreenTempleIndex = 0;
        float lastOnScreenTempleIndex = 0;

        // new year display logic
        if (onScreenTemples.size() != 0) {
            lastOnScreenTempleIndex = (onScreenTemples.get(onScreenTemples.size()-1).get(0));
            firstOnScreenTempleIndex = (onScreenTemples.get(0).get(0));
        }
        String endYear = allTempleInfo.get((int)(firstOnScreenTempleIndex) * 3 + 2);
        String startYear = allTempleInfo.get((int)(lastOnScreenTempleIndex) * 3 + 2) ;

        startYear = startYear.substring(startYear.length()-5);
        endYear = endYear.substring(endYear.length()-5);

        if (theta == 0){
            c.drawText(getResources().getString(R.string.welcome_to_view), 6.5f * screenWidth / 4, 18 * screenHeight / 40, yearDisplayPaint);
            c.drawText(getResources().getString(R.string.lds_temples), 6.5f * screenWidth / 4, 22 * screenHeight / 40, yearDisplayPaint);
        } else if (theta > 5550 ) {
            c.drawText(getResources().getString(R.string.future_temples), 6.5f * screenWidth / 4, 20 * screenHeight / 40, yearDisplayPaint);
        } else if (endYear.contains("0000") || endYear.contains("1111")){
            c.drawText(getResources().getString(R.string.years_of_temples) + " " , 6.5f * screenWidth / 4, 15 * screenHeight / 40, yearDisplayPaint);
            c.drawText(startYear + " --- " + 2020, 6.5f * screenWidth / 4, 25 * screenHeight / 40, yearDisplayPaint);
        } else {
            c.drawText(getResources().getString(R.string.years_of_temples) + " " , 6.5f * screenWidth / 4, 15 * screenHeight / 40, yearDisplayPaint);
            c.drawText(startYear + " --- " + endYear, 6.5f * screenWidth / 4, 25 * screenHeight / 40, yearDisplayPaint);
       }
    }

    public void getCoordinates() {
        //spiral are impacted a lot by initialR.
        //circles locations remain whether landscape or portrait
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //initialRForLocation is 0 when app launches, causing spiral becomes a dot.
            //when first launch, I treat windowHeight as initial R, which is just screen width later
            //(有差距，因为有状态栏，so window height is slightly smaller than screen width)
            if (coordinatesAndSizesUpdated == FALSE) {
                initialR = windowHeight / 10;
            } else {
                initialR = initialRForLocation;
            }
            //Log.d("initialR", " " + initialR);
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            initialR = screenWidth / 10;
        }

        //for (float t = -30; t < 30; t += 0.02f) {
        for (float t = -18; t < 17.5; t += 0.02f) {
            //Equiangular spiral function：
            //x = p * cosA, y = p * sinA, where p = N * e^(B * cotC)
            //When C = PI/2, graph is a circle, when C = 0, graph is a straight line
            float x = centerX + initialR * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.cos(t));
            float y = centerY + initialR * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.sin(t));

            //intendSize is the new size compare to original (original has width of 0.1 * screenWidth)

            ArrayList<Float> oneSpiralCoordinate = new ArrayList<>();
            oneSpiralCoordinate.add(x);
            oneSpiralCoordinate.add(y);

            ArrayList<Float> oneSpiralCoordinateCopy = new ArrayList<>();
            oneSpiralCoordinateCopy.addAll(oneSpiralCoordinate);
            //Log.d("x y coordinate", oneSpiralCoordinate.get(0) + "<- x, y -> " + oneSpiralCoordinate.get(1));
            spiralCoordinates.add(oneSpiralCoordinateCopy);
            //Log.d("x y coordinate", "right after adding, spiralCoordinates are " + spiralCoordinates);
            oneSpiralCoordinate.clear();
        }

        topCoordinateInSpiralX = spiralCoordinates.get(spiralCoordinates.size()-1).get(0);
        topCoordinateInSpiralY = spiralCoordinates.get(spiralCoordinates.size()-1).get(1);

        //when q += 12f, top lines circles next to each other the whole time\
        //must change the same time as getCoordinates()
        for (float q = topCoordinateInSpiralX; q < screenWidth*1.25; q += 48f) {

            ArrayList<Float> oneSpiralCoordinateTop = new ArrayList<>();
            oneSpiralCoordinateTop.add(q);
            oneSpiralCoordinateTop.add(topCoordinateInSpiralY);

            ArrayList<Float> oneSpiralCoordinateTopCopy = new ArrayList<>();
            oneSpiralCoordinateTopCopy.addAll(oneSpiralCoordinateTop);
            spiralCoordinates.add(oneSpiralCoordinateTopCopy);
            oneSpiralCoordinateTop.clear();
        }
        //Toast.makeText(getContext(), spiralCoordinates.size() + " ", Toast.LENGTH_SHORT).show();
        Collections.reverse(spiralCoordinates);
    }

    public void drawSpiral(Canvas c) {
        float e = (float) (Math.E);
        float a = screenWidth / 10;
        //draw spiral
        spiralLine.reset();
        spiralLine.moveTo(centerX, centerY);
        //radius of the circle in the middle
        //c.drawCircle(centerX, centerY, initialR, spiralPaint);
        Log.d("theta ", "is " + theta);
        for (float t = -18; t < 17.5; t += 0.02f) {
            //Equiangular spiral function：
            //x = p * cosA, y = p * sinA, where p = N * e^(B * cotC)
            //When C = PI/2, graph is a circle, when C = 0, graph is a straight line
//            float x = centerX + a * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.cos(t));
//            float y = centerY + a * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.sin(t));
            float x = centerX + a * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.cos(t));
            float y = centerY + a * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.sin(t));

            // rotates about (0, 0)
            //float xNew = x * (float)(Math.cos(theta)) + y * (float)(Math.sin(theta));
            //float yNew = y * (float)(Math.cos(theta)) - x * (float)(Math.sin(theta));

            float angle = theta / 500;
            float xNew = (x - centerX) * (float) (Math.cos(angle)) - (y - centerY) * (float) (Math.sin(angle)) + centerX;
            float yNew = (y - centerY) * (float) (Math.cos(angle)) + (x - centerX) * (float) (Math.sin(angle)) + centerY;

            //spiral doesn't rotates
            //spiralLine.lineTo(x, y);

            //spiral rotates
            spiralLine.lineTo(xNew, yNew);
        }
        //draw the spiral ****************************************
        c.drawPath(spiralLine, spiralPaint);
        //Toast.makeText(getContext(), count + " ", Toast.LENGTH_SHORT).show();
    }

    public void getCoordinatesRotateRegular() {
        //spiral are impacted a lot by initialR.
        //circles locations remain whether landscape or portrait
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //initialRForLocation is 0 when app launches, causing spiral becomes a dot.
            //when first launch, I treat windowHeight as initial R, which is just screen width later
            //(有差距，因为有状态栏，so window height is slightly smaller than screen width)
            if (coordinatesAndSizesUpdated == FALSE) {
                initialR = windowHeight / 10;
            } else {
                initialR = initialRForLocation;
            }
            //Log.d("initialR", " " + initialR);
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            initialR = screenWidth / 10;
        }
        //for (float t = -30; t < 30; t += 0.02f) {
        for (float t = -18; t < 17.5; t += 0.02f) {
            //Equiangular spiral function：
            //x = p * cosA, y = p * sinA, where p = N * e^(B * cotC)
            //When C = PI/2, graph is a circle, when C = 0, graph is a straight line
            float x = centerX + initialR * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.cos(t));
            float y = centerY + initialR * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.sin(t));

            //intendSize is the new size compare to original (original has width of 0.1 * screenWidth)

            float angle = theta / 100;
            float xNew = (x - centerX) * (float) (Math.cos(angle)) - (y - centerY) * (float) (Math.sin(angle)) + centerX;
            float yNew = (y - centerY) * (float) (Math.cos(angle)) + (x - centerX) * (float) (Math.sin(angle)) + centerY;

            ArrayList<Float> oneSpiralCoordinate = new ArrayList<>();
            oneSpiralCoordinate.add(xNew);
            oneSpiralCoordinate.add(yNew);

            ArrayList<Float> oneSpiralCoordinateCopy = new ArrayList<>();
            oneSpiralCoordinateCopy.addAll(oneSpiralCoordinate);
            //Log.d("x y coordinate", oneSpiralCoordinate.get(0) + "<- x, y -> " + oneSpiralCoordinate.get(1));
            spiralCoordinates.add(oneSpiralCoordinateCopy);
            //Log.d("x y coordinate", "right after adding, spiralCoordinates are " + spiralCoordinates);
            oneSpiralCoordinate.clear();
        }

        topCoordinateInSpiralX = spiralCoordinates.get(spiralCoordinates.size()-1).get(0);
        topCoordinateInSpiralY = spiralCoordinates.get(spiralCoordinates.size()-1).get(1);

        float secondTopCoordinateInSpiralX = spiralCoordinates.get(spiralCoordinates.size()-2).get(0);
        float secondTopCoordinateInSpiralY = spiralCoordinates.get(spiralCoordinates.size()-2).get(1);

        //when q += 12f, top lines circles next to each other the whole time\
        //must change the same time as getCoordinates()
        for (float q = 0; q < 20; q += 1) {

            ArrayList<Float> oneSpiralCoordinateTop = new ArrayList<>();

            float xDirection = topCoordinateInSpiralX - secondTopCoordinateInSpiralX;
            float yDirection = topCoordinateInSpiralY - secondTopCoordinateInSpiralY;

            float step = q * 30;
            oneSpiralCoordinateTop.add(xDirection / Math.abs(xDirection) * step + secondTopCoordinateInSpiralX);
            oneSpiralCoordinateTop.add(yDirection / Math.abs(yDirection) * step + secondTopCoordinateInSpiralY);

            ArrayList<Float> oneSpiralCoordinateTopCopy = new ArrayList<>();
            oneSpiralCoordinateTopCopy.addAll(oneSpiralCoordinateTop);
            spiralCoordinates.add(oneSpiralCoordinateTopCopy);
            oneSpiralCoordinateTop.clear();
        }
        //Toast.makeText(getContext(), spiralCoordinates.size() + " ", Toast.LENGTH_SHORT).show();
        Collections.reverse(spiralCoordinates);
    }

    public void getCoordinatesRotateZoom() {
        //spiral are impacted a lot by initialR.
        //circles locations remain whether landscape or portrait
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //initialRForLocation is 0 when app launches, causing spiral becomes a dot.
            //when first launch, I treat windowHeight as initial R, which is just screen width later
            //(有差距，因为有状态栏，so window height is slightly smaller than screen width)
            if (coordinatesAndSizesUpdated == FALSE) {
                initialR = windowHeight / 10;
            } else {
                initialR = initialRForLocation;
            }
            //Log.d("initialR", " " + initialR);
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            initialR = screenWidth / 10;
        }
        //for (float t = -30; t < 30; t += 0.02f) {
        for (float t = -18; t < 17.5; t += 0.02f) {
            //Equiangular spiral function：
            //x = p * cosA, y = p * sinA, where p = N * e^(B * cotC)
            //When C = PI/2, graph is a circle, when C = 0, graph is a straight line
            float x = centerX + initialR * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.cos(t));
            float y = centerY + initialR * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.sin(t));

            //intendSize is the new size compare to original (original has width of 0.1 * screenWidth)

            float angle = theta / 50;
            float xNew = (x - centerX) * (float) (Math.cos(angle)) - (y - centerY) * (float) (Math.sin(angle)) + centerX;
            float yNew = (y - centerY) * (float) (Math.cos(angle)) + (x - centerX) * (float) (Math.sin(angle)) + centerY;

            ArrayList<Float> oneSpiralCoordinate = new ArrayList<>();
            oneSpiralCoordinate.add(xNew);
            oneSpiralCoordinate.add(yNew);

            ArrayList<Float> oneSpiralCoordinateCopy = new ArrayList<>();
            oneSpiralCoordinateCopy.addAll(oneSpiralCoordinate);
            //Log.d("x y coordinate", oneSpiralCoordinate.get(0) + "<- x, y -> " + oneSpiralCoordinate.get(1));
            spiralCoordinates.add(oneSpiralCoordinateCopy);
            //Log.d("x y coordinate", "right after adding, spiralCoordinates are " + spiralCoordinates);
            oneSpiralCoordinate.clear();
        }

        topCoordinateInSpiralX = spiralCoordinates.get(spiralCoordinates.size()-1).get(0);
        topCoordinateInSpiralY = spiralCoordinates.get(spiralCoordinates.size()-1).get(1);

        //when q += 12f, top lines circles next to each other the whole time\
        //must change the same time as getCoordinates()
        for (float q = 0; q < 20; q += 1) {

            ArrayList<Float> oneSpiralCoordinateTop = new ArrayList<>();

            float xDirection = topCoordinateInSpiralX - centerX;
            float yDirection = topCoordinateInSpiralY - centerY;

            float step = q * 10;
            oneSpiralCoordinateTop.add((xDirection) / Math.abs(xDirection) * step + topCoordinateInSpiralX);
            oneSpiralCoordinateTop.add((yDirection) / Math.abs(yDirection) * step + topCoordinateInSpiralY);

            ArrayList<Float> oneSpiralCoordinateTopCopy = new ArrayList<>();
            oneSpiralCoordinateTopCopy.addAll(oneSpiralCoordinateTop);
            spiralCoordinates.add(oneSpiralCoordinateTopCopy);
            oneSpiralCoordinateTop.clear();
        }
        //Toast.makeText(getContext(), spiralCoordinates.size() + " ", Toast.LENGTH_SHORT).show();
        Collections.reverse(spiralCoordinates);
    }

    public void getCoordinatesThreeD() {
        //spiral are impacted a lot by initialR.
        //circles locations remain whether landscape or portrait
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //initialRForLocation is 0 when app launches, causing spiral becomes a dot.
            //when first launch, I treat windowHeight as initial R, which is just screen width later
            //(有差距，因为有状态栏，so window height is slightly smaller than screen width)
            if (coordinatesAndSizesUpdated == FALSE) {
                initialR = windowHeight / 10;
            } else {
                initialR = initialRForLocation;
            }
            //Log.d("initialR", " " + initialR);
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            initialR = screenWidth / 10;
        }
        //for (float t = -30; t < 30; t += 0.02f) {
        for (float t = -18; t < 17.5; t += 0.02f) {
            //Equiangular spiral function：
            //x = p * cosA, y = p * sinA, where p = N * e^(B * cotC)
            //When C = PI/2, graph is a circle, when C = 0, graph is a straight line
            float x = centerX + initialR * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.cos(t));
            float y = centerY + initialR * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.sin(t));

            //intendSize is the new size compare to original (original has width of 0.1 * screenWidth)

            float angle = theta / 500;
            x = (x - centerX) * (float) (Math.cos(angle)) - (y - centerY) * (float) (Math.sin(angle)) + centerX;
            y = (y - centerY) * (float) (Math.cos(angle)) + (x - centerX) * (float) (Math.sin(angle)) + centerY;

            ArrayList<Float> oneSpiralCoordinate = new ArrayList<>();
            oneSpiralCoordinate.add(x);
            oneSpiralCoordinate.add(y);

            ArrayList<Float> oneSpiralCoordinateCopy = new ArrayList<>();
            oneSpiralCoordinateCopy.addAll(oneSpiralCoordinate);
            //Log.d("x y coordinate", oneSpiralCoordinate.get(0) + "<- x, y -> " + oneSpiralCoordinate.get(1));
            spiralCoordinates.add(oneSpiralCoordinateCopy);
            //Log.d("x y coordinate", "right after adding, spiralCoordinates are " + spiralCoordinates);
            oneSpiralCoordinate.clear();
        }

        topCoordinateInSpiralX = spiralCoordinates.get(spiralCoordinates.size()-1).get(0);
        topCoordinateInSpiralY = spiralCoordinates.get(spiralCoordinates.size()-1).get(1);

        //when q += 12f, top lines circles next to each other the whole time\
        //must change the same time as getCoordinates()
        for (float q = topCoordinateInSpiralX; q < screenWidth*1.25; q += 48f) {

            ArrayList<Float> oneSpiralCoordinateTop = new ArrayList<>();
            oneSpiralCoordinateTop.add(q);
            oneSpiralCoordinateTop.add(topCoordinateInSpiralY);

            ArrayList<Float> oneSpiralCoordinateTopCopy = new ArrayList<>();
            oneSpiralCoordinateTopCopy.addAll(oneSpiralCoordinateTop);
            spiralCoordinates.add(oneSpiralCoordinateTopCopy);
            oneSpiralCoordinateTop.clear();
        }
        //Toast.makeText(getContext(), spiralCoordinates.size() + " ", Toast.LENGTH_SHORT).show();
        Collections.reverse(spiralCoordinates);
    }

    public void getSizes() {
        float pi = (float) Math.PI;

        //circles sizes remain whether landscape or portrait
        initialR = screenWidth / 10;
        //Toast.makeText(getContext(), "getSizes called, sizes.length is " + sizes.size(), Toast.LENGTH_SHORT).show();

        //for (float t = -30; t < 30; t += 0.02f) {
        for (float t = -18; t < 17.5; t += 0.02f) {
            float x = centerX + initialR * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.cos(t));
            float y = centerY + initialR * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.sin(t));
            float newSize;

            if (t <= 2 * pi) {
                newSize = (float) (Math.sqrt(Math.pow(Math.abs(x - centerX), 2) + Math.pow(Math.abs(y - centerY), 2)) - initialR);
                //newSize = ((newSize / (screenWidth)) * screenWidth / 818); //1.32f
                newSize = ((newSize / (screenWidth)) * 1.32f); //1.32f

                if (newSize < 0.03) {
                    newSize = 0.03f;
                }
                sizes.add(newSize);

            } else if (2 * pi < t) {
                float t2 = t - 2 * pi;
                float x2 = centerX + initialR * (float) (Math.exp(t2 * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.cos(t2));
                float y2 = centerY + initialR * (float) (Math.exp(t2 * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.sin(t2));
                newSize = (float) (Math.sqrt(Math.pow(Math.abs(x - x2), 2) + Math.pow(Math.abs(y - y2), 2)));
                //newSize = (newSize / screenWidth * 1.32f);
                //newSize = (newSize / screenWidth) * screenWidth / 818; //1.32f
                //newSize = (newSize / screenWidth * 1.32f); //

                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    //newSize = (newSize / screenWidth * 1.12f);
                    //newSize = (newSize / screenWidth * initialR / 60.6f);
                    newSize = (newSize / screenWidth * 1.3f);

                } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    //newSize = (newSize / screenWidth * 1.32f);
                    //newSize = (newSize / screenWidth * initialR / 60.6f);
                    newSize = (newSize / screenWidth * 1.3f);
                }
                sizes.add(newSize);
            }
        }
        //Log.d("sizes 1400 are ", " " + sizes.get(1400));
        //Log.d("sizes size is ", " " + sizes.size());
        //Log.d("initialR is ", " " + initialR);

        int sizesSizeInSpiralPart = sizes.size();
        largestSizeInSpiral = sizes.get(sizesSizeInSpiralPart - 1);

        //when q += 12f, top lines circles next to each other the whole time
        //must change the same time as getCoordinates()
        for (float q = topCoordinateInSpiralX; q < screenWidth*1.25; q += 48f) {
            sizes.add(largestSizeInSpiral);
        }
        Collections.reverse(sizes);
    }
}
