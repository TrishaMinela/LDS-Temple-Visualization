package com.ldstemplevirtualization;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class TempleView extends View {

    private Paint bluePaint, redPaint, spiralPaint, yearDisplayPaint;
    private float screenWidth, screenHeight;
    public float theta;
    private Path spiralLine;
    private Boolean loadedImages;
    float centerX;
    float centerY;
    float initialR;
    float thetaSmall;

    private boolean sliderTouched;
    private boolean sliderIsMoving;
    private boolean sliderMoving;


    private static ArrayList<Bitmap> temples;
    private ArrayList<ArrayList<Float>> onScreenTemples;
    private ArrayList<Float> oneOnScreenTemple;

    private static ArrayList<Bitmap> tempTemples = new ArrayList<>();

    private ArrayList<ArrayList<Float>> spiralCoordinates;

    private Boolean gotTheFirstSpiralCoordinate = false;

    private ArrayList<Float> sizes;
    private ArrayList<Float> sizes2;

    private Bitmap logo_circle;

    private ArrayList<String> allTempleLinks;
    private ArrayList<String> allTempleInfo;


    //private MyTimer tim;

    private float sliderProgress;

    private float thetaPre;

    private Bitmap screen;

    private int eachIndex;

    Matrix currentTempleMatrix;


    float topCoordinateInSpiralX;
    float topCoordinateInSpiralY;
    float largestSizeInSpiral;

    private boolean coordinatesAndSizesUpdated;

    private boolean orientationJustChanged;

    public boolean touchDownOnScreenTempleView;

    float downX;
    float downY;

    private ArrayList<Float> movingCoordinatesLastTime;

    long downTime;

    float ultimateScreenWidth;
    float initialRForLocation;

    public TempleView(Context context) {
        super(context);

        bluePaint = new Paint();
        //bluePaint.setColor(Color.parseColor("#669cff"));
        bluePaint.setColor(Color.parseColor("#202224"));
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


        //theta = 0;
        theta = 5550;
        thetaPre = 0;

        currentTempleMatrix = new Matrix();

        coordinatesAndSizesUpdated = FALSE;
        orientationJustChanged = FALSE;

        movingCoordinatesLastTime = new ArrayList<>();


    }

    public void smoothy(SeekBar s) {

    }

    /*
    public class MyTimer extends Handler {

        public MyTimer() {
            sendMessageDelayed(obtainMessage(0), 100);
        }

        @Override
        public void handleMessage(Message m) {


            //

            if (theta/thetaPre != 60 && thetaPre != theta && theta < 6000) {
                if (thetaPre * 60 > theta) {

                    theta ++;
                    invalidate();

                } else {
                    theta --;
                    invalidate();
                }


            }

             //


//
            float difference = Math.abs(sliderProgress - theta);

            if (difference > 0) {
                if (sliderProgress > theta) {
                    theta ++;
                } else if (sliderProgress < theta){
                    theta --;
                }
                difference --;
                invalidate();

                Log.d("invalidate ", "invalidate------------------------" + " ");

            }


            Log.d("My Timer here ", "My Timer ****************" + " ");

//
            //invalidate();
            //theta ++;
            sendMessageDelayed(obtainMessage(0), 100);a
        }
    }
    */




    public void setDegree(int sliderP) {

        sliderProgress = sliderP;

        //not using Timer to make slider smooth anymore
        //thetaPre = sliderP * 60;
        //theta = sliderP;
        theta = sliderP;

        //Log.d("theta is ", theta + " ***************************************************************************************");
        //theta = sliderP * 60;
        //theta = sliderP;

/*
        if (theta > sliderP) {
            while (theta > sliderP) {
                theta --;
                invalidate();
            }
        } else {
            while (theta < sliderP) {
                theta ++;
                invalidate();
            }
        }






 */


    }

    public float getLastProgress() {

        //Log.d("theta", " is " + theta + " ");
        return theta;

    }


    //not using Timer to make slider smooth anymore
    //commented three methods here
    /*

    public void sliderStart(boolean s) {
        sliderTouched = s;
    }

    public void sliderStop(boolean s) {
        sliderTouched = s;
    }

    public void sliderInProgress(boolean s) {
        sliderIsMoving = s;
    }

     */

    public void sliderStart(boolean s) {
        sliderMoving = s;
    }

    public void sliderStop(boolean s) {
        sliderMoving = s;
    }

    public void sliderInProgress(boolean s) {
        sliderMoving = s;
    }


    /*
    public List<String> Sort(String s) {

        String vowels = "vowels: ";
        String consonants = "consonants: ";
        for (int i = 0; i < s.length(); i ++) {


            String t = String.valueOf(s.charAt(i));

            if (t.equals("a") || t.equals("e") || t.equals("i") || t.equals("o") || t.equals("u") || t.equals("A") || t.equals("E") ||t.equals("I") ||t.equals("O") ||t.equals("U")) {
                vowels = vowels + t;
            } else {
                consonants = consonants + t;
            }

        }

        List<String> result = new ArrayList<>();
        result.add(vowels);
        result.add(consonants);

        return result;

    }
*/


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

            //theta = 1000;

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


            float xDisplacementFromDown = movingX - downX;
            float yDisplacementFromDown  = movingX - downY;

            float xDisplacementFromLastMove = movingX - lastX;
            float yDisplacementFromLastMove = movingY - lastY;

            //Log.d("movingCoordinates", "movingCoordinatesLastTime is " + movingCoordinatesLastTime);

            movingCoordinatesLastTime.clear();
            movingCoordinatesLastTime.add(movingX);
            movingCoordinatesLastTime.add(movingY);


            Log.d("xy displacementFLT ", xDisplacementFromLastMove + " " + yDisplacementFromLastMove);

            //theta = theta - 10;


            /*
            float direction = (centerX-0) * (movingY-0) - (centerY-0) *(movingX-0);

            if(direction > 0) {
                Log.d("direction is ",  "clockwise");
            } else if (direction < 0) {
                Log.d("direction is ",  "anti-clockwise");
            }
             */

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

            boolean thetaMaxReached = theta >= 6770;
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

            /*
            if (topLeft) {
                if (xDisplacementFromLastMove > 0 && yDisplacementFromLastMove < 0) { //diagonal move in forth quadrant - this and next else if
                    theta = theta - 10;
                } else if (xDisplacementFromLastMove < 0 && yDisplacementFromLastMove > 0) {
                    theta = theta + 10;
                } else if (yDisplacementFromLastMove > 1) {
                    theta = theta + 10;
                } else if (yDisplacementFromLastMove < -1) {
                    theta = theta - 10;
                } else if (xDisplacementFromLastMove > 0) {
                    theta = theta - 10;
                } else if (xDisplacementFromLastMove < 0) {
                    theta = theta + 10;
                }
            } else if (topRight) {
                if (xDisplacementFromLastMove > 0 && yDisplacementFromLastMove > 0) { //diagonal move in first quadrant - this and next else if
                    theta = theta - 10;
                } else if (xDisplacementFromLastMove < 0 && yDisplacementFromLastMove < 0) {
                    theta = theta + 10;
                } else if (yDisplacementFromLastMove > 1) {
                    theta = theta - 10;
                } else if (yDisplacementFromLastMove < -1) {
                    theta = theta + 10;
                }
            } else if (bottomLeft) {
                if (xDisplacementFromLastMove > 0 && yDisplacementFromLastMove > 0) { //diagonal move in second quadrant - this and next else if
                    theta = theta + 10;
                } else if (xDisplacementFromLastMove < 0 && yDisplacementFromLastMove < 0) {
                    theta = theta - 10;
                } else if (yDisplacementFromLastMove > 1) {
                    theta = theta + 10;
                } else if (yDisplacementFromLastMove < -1) {
                    theta = theta - 10;
                }
            } else if (bottomRight) {
                if (xDisplacementFromLastMove > 0 && yDisplacementFromLastMove < 0) { //diagonal move in third quadrant - this and next else if
                    theta = theta + 10;
                } else if (xDisplacementFromLastMove < 0 && yDisplacementFromLastMove > 0) {
                    theta = theta - 10;
                } else if (yDisplacementFromLastMove > 1) {
                    theta = theta - 10;
                } else if (yDisplacementFromLastMove < -1) {
                    theta = theta + 10;
                }
            }

             */



            /*
            if (touchY < 9 * screenHeight / 20) {
                //Log.d("UPPER",  "UPPER");
                if (xDisplacementFromLastMove > 0) {
                    theta = theta - 10;
                } else {
                    theta = theta + 10;
                }
            } else if (touchY < 9 * screenHeight / 10){
                //Log.d("LOWER",  "LOWER");
                if (xDisplacementFromLastMove > 0) {
                    theta = theta + 10;
                } else {
                    theta = theta - 10;
                }
            }

            if (touchX < screenWidth / 2) {
                //Log.d("LEFT",  "LEFT");
            } else if (touchX > screenWidth / 2) {
                //Log.d("RIGHT",  "RIGHT");
            }

            */



        }



        if (m.getAction() == MotionEvent.ACTION_UP) {

            //theta = theta - 10;

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

            if (distanceToCenter < initialR) {
                //Toast.makeText(getContext(), "touched center circle", Toast.LENGTH_SHORT).show();
                //Toast.makeText(getContext(), "allTempleLinks size is " + allTempleLinks.size(), Toast.LENGTH_SHORT).show();


                /*
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Temple Name");
                //builder.setMessage("Welcome! Nothing Here Yet!");
                builder.setIcon(R.mipmap.ic_launcher_round);


                ImageView imageView = findViewById(R.id.imageView);
                builder.setView(imageView);

                //点击对话框以外的区域是否让对话框消失
                builder.setCancelable(true);

                final AlertDialog dialog = builder.create();

                dialog.show();

                 */


                /*
                Uri homepage_url = Uri.parse("https://www.churchofjesuschrist.org/?lang=eng");
                Intent homePage= new Intent(Intent.ACTION_VIEW, homepage_url);
                getContext().startActivity(homePage);
                 */


                /*
                Intent homePage= new Intent();
                homePage.setAction("android.intent.action.VIEW");
                Uri homepage_url = Uri.parse("https://www.churchofjesuschrist.org/?lang=eng");
                homePage.setData(homepage_url);
                getContext().startActivity(homePage);
                */


                /*
                Intent test = new Intent(getContext(), ImageActivity.class);
                getContext().startActivity(test);


                 */

                /*
                WebView homePage = findViewById(R.id.myWebView);

                homePage.loadUrl("https://www.churchofjesuschrist.org/?lang=eng");

                //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
                homePage.setWebViewClient(new WebViewClient(){
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {

                        //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                        view.loadUrl(url);
                        return true;
                    }
                });
                */
            }


            if (y < 9 * screenHeight / 10 && period < 100) {

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

                        if (eachIndex <= 226) {


                            Intent thisTemple = new Intent(getContext(), ImageActivity.class);

                            //传值给下一个Activity
                            String data = String.valueOf(eachIndex);
                            thisTemple.putExtra("eachIndex", data);

                            String templeUrl = allTempleLinks.get(eachIndex);
                            thisTemple.putExtra("templeUrl", templeUrl);

                            getContext().startActivity(thisTemple);

/*
                            Intent eachTemplePage= new Intent();
                            eachTemplePage.setAction("android.intent.action.VIEW");
                            Uri eachTemplePage_url = Uri.parse(allTempleLinks.get(eachIndex));
                            eachTemplePage.setData(eachTemplePage_url);
                            getContext().startActivity(eachTemplePage);
*/


                        } else {



                                //no link
                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                builder.setTitle("Nothing Here");
                                builder.setMessage("future temples to come!");
                                builder.setIcon(R.mipmap.ic_launcher_round);

                                //点击对话框以外的区域是否让对话框消失
                                builder.setCancelable(true);

                                final AlertDialog dialog = builder.create();

                                dialog.show();

                            /*
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Nothing Here");
                            builder.setMessage("future temples to come!");
                            builder.setIcon(R.mipmap.ic_launcher_round);

                            //点击对话框以外的区域是否让对话框消失
                            builder.setCancelable(true);

                            final AlertDialog dialog = builder.create();

                            dialog.show();

                             */

                            /*
                            Intent eachTemplePage= new Intent();
                            eachTemplePage.setAction("android.intent.action.VIEW");
                            Uri eachTemplePage_url = Uri.parse("https://www.churchofjesuschrist.org/temples/list?lang=eng");
                            eachTemplePage.setData(eachTemplePage_url);
                            getContext().startActivity(eachTemplePage);
                             */

                        }
                    }
                }
            }



        }

        return true;
    }


    public int getCurrentIndex() {
        return eachIndex;
    }


    public void setWidthAndHeight() {
        //screenWidth = c.getWidth();
        //screenHeight = c.getHeight();
    }

    public void orientationJustChanged(boolean b) {
        orientationJustChanged = b;

    }

    @Override
    public void onDraw(Canvas c) {
        thetaSmall = theta / 4;
        //spiralCoordinates.clear();




        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            screenWidth = c.getWidth() / 2;
            screenHeight = c.getHeight();

            centerX = screenWidth / 2 + 3 * screenWidth / 16;
            //centerX = 5 * screenWidth / 4 / 2 + screenWidth / 16;
            centerY = screenHeight / 2;
            //centerY = 3 * screenHeight / 8;

            // screenHeight / 10;
            Log.d("LANDSCAPE ", "-------------------------" + screenHeight);

        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            screenWidth = c.getWidth();
            screenHeight = c.getHeight();
            centerX = screenWidth / 2;
            centerY = screenHeight / 2;
            //centerY = 3 * screenHeight / 8;

            ultimateScreenWidth = screenWidth;
            //initialR = screenWidth / 10;

            Log.d("PORTRAIT ", "|||||||||||||||||||||||||||||" + screenWidth);

        }



        //Log.d("CENTER X ", centerX + " ");
        //Log.d("CENTER Y ", centerY + " ");


        initialR = screenWidth / 10;
        initialRForLocation = ultimateScreenWidth / 10;
        //initialR = 80;



        if (orientationJustChanged == TRUE) {
            spiralCoordinates.clear();
            sizes.clear();
            getCoordinatesAndSizes();
            orientationJustChanged = FALSE;
            //Log.d("coordinates and sizes ", " just reset ");
        }

        if (coordinatesAndSizesUpdated == FALSE) {
            getCoordinatesAndSizes();
            coordinatesAndSizesUpdated = TRUE;
        }

        //tim = new MyTimer();

        //c.drawColor(Color.parseColor("#66ccff"));

        c.drawColor(Color.parseColor("#24292b"));

        //we just want to load the images once, we don't have to load it every time when we re-draw. otherwise the program is gonna be so slow
        if (loadedImages == false) {
            loadedImages = true;
            //get the temple images in arraylist
            ImageCache.init(getResources(), screenWidth, screenHeight);
            temples = ImageCache.getTemplesList();
            //Collections.reverse(temples);

            logo_circle = ImageCache.getLogo();


            readLinksFile();
            readInfoFile();

            yearDisplayPaint = new Paint();
            //yearDisplayPaint.setColor(Color.parseColor("#66ccff"));
            yearDisplayPaint.setColor(Color.parseColor("#3d4245"));

            yearDisplayPaint.setStyle(Paint.Style.FILL);
            yearDisplayPaint.setTextSize((int)(screenHeight / 25));
            yearDisplayPaint.setTextAlign(Paint.Align.CENTER);



            //not drawing anything onscreen, because we don't need spiral to show up.


            //getCoordinatesAndSizes();

        }



        //getCoordinatesAndSizes();

        //Spiral(c);

        //helper
        //c.drawText("Screen Width and Height are " + screenWidth + " " + screenHeight, 0, screenHeight - 100, bluePaint);
        //c.drawText("how many temples " + temples.size() + " ", 0, screenHeight - 200, redPaint);
        //c.drawRect(0,3 * screenHeight/4, screenWidth, 3 * screenHeight/4 + 10, bluePaint);

        //the middle circle image is here ==============================================
        //drawMiddleCircle(c);


        //drawMiddleCircle(c);


        //getCoordinatesAndSizes();



        placeAllCircles(c);


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            yearDisplayLandscape(c);

        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            yearDisplay(c);

        }


        //c.drawText("theta is " + theta + " " + "sliderProgress is " + sliderProgress, 0, 7 * screenHeight / 8, redPaint);


        //c.drawText("Temples", screenWidth / 2, screenHeight / 2, greenPaint);



        Matrix logoMatrix = new Matrix();
        logoMatrix.postScale(2 * 2 * initialR / screenWidth, 2 * 2 * initialR / screenWidth);
        Bitmap newLogoCircle = Bitmap.createBitmap(logo_circle, 0, 0, logo_circle.getWidth(), logo_circle.getHeight(), logoMatrix, true);


        //c.drawBitmap(newLogoCircle, screenWidth / 6000 * theta, screenHeight / 6000 * theta, null);

        /*
        c.save();
        c.scale(theta/60 / 50, theta/60 / 50, logo_circle.getWidth()/2, logo_circle.getHeight()/2);
        c.drawBitmap(logo_circle, 0, 0, null);
        c.restore();

         */






        //Log.d("all sizes : ", sizes + " ");
        //Log.d("all sizes : ", spiralCoordinates + " ");

/*
        Bitmap templeTest = temples.get(0);
        Matrix m = new Matrix();
        m.postScale(0.5f, 0.5f);
        Bitmap newtempleTest = Bitmap.createBitmap(templeTest, 0, 0, templeTest.getWidth(), templeTest.getHeight(), m,true);

        c.drawBitmap(newtempleTest,0,centerY, null);

 */
        //c.drawBitmap(newProvo,100,100, null);

/*
        //test, set an image at this coordinate, it moves long a circle
        float x = centerX +  a * (float)(Math.exp(1 * 1/(Math.tan(47 * Math.PI / 100)))) * (float)(Math.cos(1));
        float y = centerY + a * (float)(Math.exp(1 * 1/(Math.tan(47 *  Math.PI / 100)))) * (float)(Math.sin(1));
        float xNew = (x - centerX) * (float)(Math.cos(theta)) + (y - centerY) * (float)(Math.sin(theta)) + centerX;
        float yNew = (y - centerY) * (float)(Math.cos(theta)) - (x - centerX) * (float)(Math.sin(theta)) + centerY;
*/

        //Log.d("x y coordinate", "spiralCoordinates are " + spiralCoordinates);

/*
        float imageX = centerX + (float)Math.pow(theta, 1.2f);
        float imageY = centerY + (float)Math.pow(theta, 1.2f) ;

        //how fast
        //float t = theta/10;

        //float imageXNew = centerX +  a * (float)(Math.exp(t * 1/(Math.tan(47 * Math.PI / 100)))) * (float)(Math.cos(t));
        //float imageYNew = centerY + a * (float)(Math.exp(t * 1/(Math.tan(47 *  Math.PI / 100)))) * (float)(Math.sin(t));
        //rotate clock wise
        float imageXNew = (imageX - centerX) * (float)(Math.cos(thetaSmall)) - (imageY - centerY) * (float)(Math.sin(thetaSmall)) + centerX;
        float imageYNew = (imageY - centerY) * (float)(Math.cos(thetaSmall)) + (imageX - centerX) * (float)(Math.sin(thetaSmall)) + centerY;
*/

        //test, draw one temple
/*
        //try to tie image coordinate with spiral coordinates
        ArrayList<Float> templeOneCoordinate = new ArrayList<>();
        //int equalPartitionSize = spiralCoordinates.size()/20;
        //int equalPartitionSize = (int)(theta)  ;

        templeOneCoordinate = spiralCoordinates.get((int)(theta));
        float templeOneX = templeOneCoordinate.get(0);
        float templeOneY = templeOneCoordinate.get(1);
        float imageX = templeOneX;
        float imageY = templeOneY;

        //float intendSizeCurrentTemple = 0.1f;
        float intendSizeCurrentTemple = templeOneCoordinate.get(2) * 0.5f;
        Matrix intendSizeM = new Matrix();
        intendSizeM.postScale(intendSizeCurrentTemple, intendSizeCurrentTemple);
        //scaled image
        Bitmap newProvo = Bitmap.createBitmap(provo, 0, 0, provo.getWidth(), provo.getHeight(), intendSizeM,true);
        //c.drawBitmap(newProvo,imageX - newProvo.getWidth() / 2,imageY - newProvo.getHeight() / 2, null);

*/


/*
        if (sliderMoving) {
            c.drawText("slider moving? : YES", 0, screenHeight - 10, redPaint);
        }
        if (sliderMoving == FALSE){

            c.drawText("slider moving? : NO", 0, screenHeight - 10, redPaint);
        }


 */
        //c.drawText("theta is " + theta + " ", 0, 7 * screenHeight / 8, redPaint);
        //tempTemples.clear();

        /*
        float x = spiralCoordinates.get((int)(theta)).get(0);
        float y = spiralCoordinates.get((int)(theta)).get(1);
        float size = spiralCoordinates.get((int)(theta)).get(2);
        Matrix currentTempleMatrix = new Matrix();
        currentTempleMatrix.postScale(size, size);
        Bitmap newt = Bitmap.createBitmap(provo, 0, 0, provo.getWidth(), provo.getHeight(), currentTempleMatrix,true);
        c.drawBitmap(newt,x - newt.getWidth() / 2,y - newt.getHeight() / 2, null);

        Log.d("Hi there", "hahaha");
*/

        /*
        for (int i = 0; i <= temples.size(); i ++) {
            Bitmap currentTemple;

            currentTemple = temples.get(i);

            float currentTempleX = spiralCoordinates.get((int)(theta)).get(0);
            float currentTempleY = spiralCoordinates.get((int)(theta)).get(1);
            float currentTempleSize = spiralCoordinates.get((int)(theta)).get(2);
            Matrix currentTempleMatrix = new Matrix();
            currentTempleMatrix.postScale(currentTempleSize, currentTempleSize);
            Bitmap newCurrentTemple = Bitmap.createBitmap(currentTemple, 0, 0, currentTemple.getWidth(), currentTemple.getHeight(), currentTempleMatrix,true);
            c.drawBitmap(newCurrentTemple,currentTempleX - newCurrentTemple.getWidth() / 2,currentTempleY - newCurrentTemple.getHeight() / 2, null);

        }

         */

/*
        String testString = "abcdeABCDE";
        List result1 = Sort(testString);

        c.drawText(testString + "    " + result1.get(0).toString(), 0, screenHeight/2, redPaint);
        c.drawText(testString + "    " + result1.get(1).toString(), 0, screenHeight/2 + 100, redPaint);

*/
    }


    public void actuallyDrawing(float ts, Bitmap t, Canvas c) {



        //float currentTempleSize = spiralCoordinates.get((int)(ts)).get(2);
        float currentTempleSize = sizes.get((int) (ts));
        //float currentTempleSize = 0.01f;


        float currentTempleX = spiralCoordinates.get((int) (ts)).get(0);
        float currentTempleY = spiralCoordinates.get((int) (ts)).get(1);

        float newCurrentTempleRadius = currentTempleSize * screenWidth / 2;

        currentTempleMatrix.setScale(2 * currentTempleSize, 2 * currentTempleSize);

        currentTempleMatrix.postTranslate(currentTempleX - t.getWidth()  *currentTempleSize, currentTempleY - t.getHeight() * currentTempleSize);

        //currentTempleMatrix.postTranslate(currentTempleX, currentTempleY);

        c.drawBitmap(t, currentTempleMatrix, null);

        if (currentTempleX + newCurrentTempleRadius < screenWidth || currentTempleY + newCurrentTempleRadius < screenHeight) {



        }




        /*
        currentTempleMatrix.postScale(2 * currentTempleSize, 2 * currentTempleSize);
        Bitmap newCurrentTemple = Bitmap.createBitmap(t, 0, 0, t.getWidth(), t.getHeight(), currentTempleMatrix, true);

        float currentTempleX = spiralCoordinates.get((int) (ts)).get(0) - newCurrentTemple.getWidth() / 2;
        float currentTempleY = spiralCoordinates.get((int) (ts)).get(1)- newCurrentTemple.getHeight() / 2;

        float newCurrentTempleRadius = currentTempleSize * screenWidth / 2;

        //only draw circle if part of the circle is on screen
        if (currentTempleX + newCurrentTempleRadius < screenWidth || currentTempleY + newCurrentTempleRadius < screenHeight) {
            c.drawBitmap(newCurrentTemple, currentTempleX, currentTempleY, null);
        }

        //tempTemples.add(newCurrentTemple);

        //do we really need this line?
        newCurrentTemple.recycle();   //回收图片所占的内存

         */




        //***********************************
/*
        float currentTempleX1 = spiralCoordinates.get((int) (ts)).get(0);
        float currentTempleY1 = spiralCoordinates.get((int) (ts)).get(1);
        float lastTempleX1 = spiralCoordinates.get((int) (ts-1)).get(0);
        float lastTempleY1 = spiralCoordinates.get((int) (ts-1)).get(1);
        int dx = (int) (currentTempleX1 - lastTempleX1);
        int dy = (int)(currentTempleY1 -lastTempleY1);

        Bitmap newCurrentTemple1 = Bitmap.createBitmap(t.getWidth() + dx, t.getHeight() + dy, Bitmap.Config.ARGB_8888);
        Matrix matrix = new Matrix();
        // 设置移动的距离
        matrix.setTranslate(dx, dy);
        c.drawBitmap(t, matrix, redPaint);
*/




    }


    //method not working
    public void checkTs(float ts, Bitmap t) {

        while (ts >= 0 && ts < 100) {
            ts = theta - 10 * temples.indexOf(t);
        }
    }


    public void getCoordinatesAndSizes() {

        //this is CODE SECTION 1 FRO FINAL PRODUCTION

        //putting spiral coordinates in a list of lists. we just need to do it once

        //getCoordinatesRotate();

        if (gotTheFirstSpiralCoordinate == false) {
            gotTheFirstSpiralCoordinate = true;

            //getCoordinates();
            //getCoordinatesRotate();

            //getSizes();

        }

        getCoordinates();
        getSizes();

        //getCoordinatesRotate();

            /*
            float intendSizeOne = (0.001f);
            (spiralCoordinates.get(0)).add(intendSizeOne);
            for (int i = 1; i < 1500; i ++) {

                //float intendSize = (0.004f * (float)Math.pow(i, 0.62));

                float intendSize = 0.0f + 0.0005f * (float)Math.pow(i, 0.93);

                //float p1x = spiralCoordinates.get(i).get(0);
                //float p1y = spiralCoordinates.get(i).get(1);
                //float p2x = spiralCoordinates.get(i-1).get(0);
                //float p2y = spiralCoordinates.get(i-1).get(1);

                //float distance = (float)(Math.sqrt(Math.abs(p1x - p2x) * Math.abs(p1x - p2x) + Math.abs(p1y - p2y) * Math.abs(p1y - p2y)));
                //float distanceRatio = distance/screenWidth;
                //float intendSize = distanceRatio - spiralCoordinates.get(i-1).get(2);

                (spiralCoordinates.get(i)).add(intendSize);
                Log.d("this coordinate is ", spiralCoordinates.get(i).get(0) + " " + spiralCoordinates.get(i).get(1) + " " + spiralCoordinates.get(i).get(2));

                Log.d("this coor size is ", spiralCoordinates.get(i).size() + " ");
                Log.d("this intendSize is ", intendSize + "");
                Log.d("new size is ", sizes.get(i) + " ");
            }

             */

    }


    public void drawSpiral(Canvas c) {
        float e = (float) (Math.E);

        float a = screenWidth / 10;

        //draw spiral
        spiralLine.reset();
        spiralLine.moveTo(centerX, centerY);

        //radius of the circle in the middle

        //c.drawCircle(centerX, centerY, initialR, spiralPaint);

        //float pi = (float)Math.PI;
        float pi = 3.14f;

        int count = 0;
        for (float t = 0; t < 17.5; t += 0.02f) {
            count ++;
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

            // rotates about (centerX, centerY)
            float xNew = (x - centerX) * (float) (Math.cos(thetaSmall)) + (y - centerY) * (float) (Math.sin(thetaSmall)) + centerX;
            float yNew = (y - centerY) * (float) (Math.cos(thetaSmall)) - (x - centerX) * (float) (Math.sin(thetaSmall)) + centerY;

            //draw lots of rectangles to make up the spiral
            //c.drawRect(xNew - 2,yNew - 2,xNew + 2,yNew + 2, bluePaint);

            //spiral rotates
            //spiralLine.lineTo(xNew, yNew);

            //spiral doesn't rotates
            spiralLine.lineTo(x, y);


        }
        //draw the spiral ****************************************
        c.drawPath(spiralLine, spiralPaint);
        //Toast.makeText(getContext(), count + " ", Toast.LENGTH_SHORT).show();

        //c.drawText("center circle radius " + initialR + " ", 0, screenHeight - 250, redPaint);
    }

    public void createOnScreenTemples() {
        //method not used
    }


    /**
     * 可以利用android为了提高滚动等各方面的绘制速度，为每一个view创建了一个缓存，使用    View.buildDrawingCache方法可以获取相应view的cache，这个cache就是一个bitmap对象
     * @return Bitmap
     */
/*
    private Bitmap BitmapscreenShotWholeScreen() {

        MainActivity.getWindow().getDecorView().setDrawingCacheEnabled(true);

        Bitmap bmp=MainActivity.getWindow().getDecorView().getDrawingCache();

        return bmp;
    }
    */

    //获取涂鸦板截屏
    public Bitmap getCanvasBitmap(Canvas c) {
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas = c;

        return bitmap;
    }

    //not using Timer to make slider smooth anymore
    //commented out the whole method
    /*
    //place all circles, and get the index of on screen temples
    //this method also call actualDrawing method to draw
    public void placeAllCircles(Canvas c) {
        //float move = 30;






        onScreenTemples.clear();

        for (Bitmap t : temples) {
            float ts = theta - 30 * temples.indexOf(t);
            //checkTs(ts, t);

            if (ts > 0 && ts < 1300) {

                if (sliderIsMoving == FALSE && sliderTouched == FALSE) {

                    // && sliderTouched == FALSE


                    actuallyDrawing(ts, t, c);

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

                    oneOnScreenTemple.clear();


                } else {

                    actuallyDrawing(ts, t, c);
                    //c.save();
                    //c.rotate(theta/10, centerX, centerY);// 旋转弧度，旋转中心点x,旋转中心点y
                    //c.drawBitmap(logo_circle, centerX + 20,centerY, null);
                    //c.restore();

                    //rotates only, not drawing all circles
                    //Bitmap screen = getCanvasBitmap(c);


                    //c.drawBitmap(screen, screenWidth / 2 - screen.getWidth() / 2 , screenHeight / 2 - screen.getHeight() / 2, null);




                }


                //add all on screen temples index to a array list once the slider stopped moving,
                //we do not need to add while slider is moving because people wont click while moving slider
                if (sliderIsMoving == FALSE && sliderTouched == FALSE) {



                    //Toast.makeText(getContext(), "slider stopped", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getContext(), "slider hahaha stop", Toast.LENGTH_SHORT).show();
                } else {
                    //onScreenTemples.clear();
                    //Toast.makeText(getContext(), "slider started", Toast.LENGTH_SHORT).show();
                }


            }
        }

        if (sliderIsMoving == FALSE) {
            //Toast.makeText(getContext(), "how many onScreenTemples now? " + onScreenTemples.size(), Toast.LENGTH_SHORT).show();

        }



        //we put the clear here so that we only clear once in the beginning of slider moving.
        //&& onScreenTemples.size() != 0
        if (sliderTouched) {
            //Toast.makeText(getContext(), "how many onScreenTemples last time? " + onScreenTemples.size(), Toast.LENGTH_SHORT).show();

            //onScreenTemples.clear();
            //Toast.makeText(getContext(), "slider started", Toast.LENGTH_SHORT).show();
            //Toast.makeText(getContext(), "slider hahaha start", Toast.LENGTH_SHORT).show();

        }


    }
    */




    //place all circles, and get the index of on screen temples
    //this method also call actualDrawing method to draw
    public void placeAllCircles(Canvas c) {
        //float move = 30;

        onScreenTemples.clear();

        for (Bitmap t : temples) {
            float ts = theta - 30 * temples.indexOf(t);
            //checkTs(ts, t);
/*
            if (ts > 30 && ts < 200) {
                ts = ts - move;
                move = move - 10;
            }
 */
            if (ts > 0 && ts < spiralCoordinates.size()) {
                actuallyDrawing(ts, t, c);

                //add all on screen temples index to a array list once the slider stopped moving,
                //we do not need to add while slider is moving because people wont click while moving slider
                //if (sliderMoving == FALSE) {
                if (0 == 0) {



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

                    oneOnScreenTemple.clear();




                    //Toast.makeText(getContext(), "slider stopped", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getContext(), "slider hahaha stop", Toast.LENGTH_SHORT).show();
                } else {
                    //onScreenTemples.clear();
                    //Toast.makeText(getContext(), "slider started", Toast.LENGTH_SHORT).show();
                }


            }
        }

        //i hope this will work but it seems it's not working well.
        //we put the clear here so that we only clear once in the beginning of slider moving.
        if (sliderMoving) {
            //&& onScreenTemples.size() != 0
            //Toast.makeText(getContext(), "how many onScreenTemples last time? " + onScreenTemples.size(), Toast.LENGTH_SHORT).show();

            //onScreenTemples.clear();
            //Toast.makeText(getContext(), "slider started", Toast.LENGTH_SHORT).show();
            //Toast.makeText(getContext(), "slider hahaha start", Toast.LENGTH_SHORT).show();

        }


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


    /*
    public void yearDisplay(Canvas c) {
        c.drawRect(0, 9 * screenHeight / 10, screenWidth, screenHeight, bluePaint);

        int startYear;
        int endYear;
        if (theta > 0 && theta <= 1000) {
            startYear = 1884;
            endYear = (int) (theta / 10 + 1884);
        } else if (theta > 1000 && theta <= 5000) {
            if (theta <= 2000) {
                startYear = (int) (theta - 1000) / 10 + 1884;
            } else {
                startYear = (int) (theta - 2000) / 107 + 1984;
            }
            endYear = (int) ((theta - 1000) / 115 + 1984);
        } else if (theta < 5880 && theta >= 5000) {
            startYear = (int) (theta - 5000) / 110 + 2012;
            endYear = 2020;
        } else {
            startYear = 0;
            endYear = 0;
        }
        String startYearS = startYear + " ";
        String endYearS = endYear + " ";
        if (theta > 0 && theta < 5880) {
            c.drawText("Years of Temples: " + startYearS + " --- " + endYearS, screenWidth / 2, 39 * screenHeight / 40, greenPaint);
        } else if (theta >= 5880) {
            c.drawText("Future Temples to Come!", screenWidth / 2, 39 * screenHeight / 40, greenPaint);
        } else {
            c.drawText("Welcome to View LDS Temples!", screenWidth / 2, 39 * screenHeight / 40, greenPaint);
        }
    }

     */



    //improved version of yearDisplay
    public void yearDisplay(Canvas c) {




        //Toast.makeText(getContext(), onScreenTemples.size() + " ", Toast.LENGTH_SHORT).show();


        //get the index of on screen temples,
        //the first one in on screen temples to the last
        //go to temple info file, the specific line to get years
        //3 lines each temple in the file



        //String startYear = "start";
        //String endYear = "end";

        c.drawRect(0, 9 * screenHeight / 10, screenWidth, screenHeight, bluePaint);

        float firstOnScreenTempleIndex;
        float lastOnScreenTempleIndex;

        if (theta > 0 && theta < 4850) {

            //ignore the small temples
            if (onScreenTemples.size() > 25) {
                lastOnScreenTempleIndex = (onScreenTemples.get(onScreenTemples.size()-1).get(0));
                firstOnScreenTempleIndex = (onScreenTemples.get(onScreenTemples.size()-1 - 25).get(0));
            } else {
                lastOnScreenTempleIndex = (onScreenTemples.get(onScreenTemples.size()-1).get(0));
                firstOnScreenTempleIndex = (onScreenTemples.get(0).get(0));
            }

            String startYear = allTempleInfo.get((int)(firstOnScreenTempleIndex) * 3 + 2);
            String endYear = allTempleInfo.get((int)(lastOnScreenTempleIndex) * 3 + 2) ;

            startYear = startYear.substring(startYear.length()-5);
            endYear = endYear.substring(endYear.length()-5);

            //Log.d("years are ", startYear.substring(startYear.length()-5) + " " + endYear.substring(endYear.length()-5));
            //Log.d("years are ", firstOnScreenTempleIndex+" "+lastOnScreenTempleIndex);

            c.drawText("Years of Temples: " + startYear + "--- " + endYear, screenWidth / 2, 39 * screenHeight / 40, yearDisplayPaint);
        } else if (theta >= 4850 && theta <= 5550) {
            firstOnScreenTempleIndex = (onScreenTemples.get(0).get(0));
            String startYear = allTempleInfo.get((int)(firstOnScreenTempleIndex) * 3 + 2);
            startYear = startYear.substring(startYear.length()-5);
            c.drawText("Years of Temples: " + startYear + " --- " + "2020", screenWidth / 2, 39 * screenHeight / 40, yearDisplayPaint);
        } else if (theta > 5550 ) {
            c.drawText("Future Temples", screenWidth / 2, 39 * screenHeight / 40, yearDisplayPaint);
        } else if (theta == 0){
            c.drawText("Welcome to View LDS Temples!", screenWidth / 2, 39 * screenHeight / 40, yearDisplayPaint);
        } else {
            //c.drawText("Future Temples", screenWidth / 2, 39 * screenHeight / 40, yearDisplayPaint);
        }
    }

    public void yearDisplayLandscape(Canvas c) {




        //Toast.makeText(getContext(), onScreenTemples.size() + " ", Toast.LENGTH_SHORT).show();


        //get the index of on screen temples,
        //the first one in on screen temples to the last
        //go to temple info file, the specific line to get years
        //3 lines each temple in the file



        //String startYear = "start";
        //String endYear = "end";

        c.drawRect( 5 * screenWidth / 4, 0, 2 * screenWidth, screenHeight, bluePaint);

        float firstOnScreenTempleIndex;
        float lastOnScreenTempleIndex;

        if (theta > 0 && theta < 4850) {

            //ignore the small temples
            if (onScreenTemples.size() > 25) {
                lastOnScreenTempleIndex = (onScreenTemples.get(onScreenTemples.size()-1).get(0));
                firstOnScreenTempleIndex = (onScreenTemples.get(onScreenTemples.size()-1 - 25).get(0));
            } else {
                lastOnScreenTempleIndex = (onScreenTemples.get(onScreenTemples.size()-1).get(0));
                firstOnScreenTempleIndex = (onScreenTemples.get(0).get(0));
            }

            String startYear = allTempleInfo.get((int)(firstOnScreenTempleIndex) * 3 + 2);
            String endYear = allTempleInfo.get((int)(lastOnScreenTempleIndex) * 3 + 2) ;

            startYear = startYear.substring(startYear.length()-5);
            endYear = endYear.substring(endYear.length()-5);

            //Log.d("years are ", startYear.substring(startYear.length()-5) + " " + endYear.substring(endYear.length()-5));
            //Log.d("years are ", firstOnScreenTempleIndex+" "+lastOnScreenTempleIndex);

            c.drawText("Years of Temples: ", 6.5f * screenWidth / 4, 15 * screenHeight / 40, yearDisplayPaint);

            c.drawText(startYear + "--- " + endYear, 6.5f * screenWidth / 4, 25 * screenHeight / 40, yearDisplayPaint);

        } else if (theta >= 4850  && theta <= 5550) {
            firstOnScreenTempleIndex = (onScreenTemples.get(0).get(0));
            String startYear = allTempleInfo.get((int)(firstOnScreenTempleIndex) * 3 + 2);
            startYear = startYear.substring(startYear.length()-5);

            c.drawText("Years of Temples: ", 6.5f * screenWidth / 4, 15 * screenHeight / 40, yearDisplayPaint);

            c.drawText(startYear + " --- " + "2020", 6.5f * screenWidth / 4, 25 * screenHeight / 40, yearDisplayPaint);

        } else if (theta >= 5550) {
            c.drawText("Future Temples", 6.5f * screenWidth / 4, 20 * screenHeight / 40, yearDisplayPaint);
        } else {

            c.drawText("Welcome to", 6.5f * screenWidth / 4, 18 * screenHeight / 40, yearDisplayPaint);

            c.drawText("LDS Temples!", 6.5f * screenWidth / 4, 22 * screenHeight / 40, yearDisplayPaint);

        }
    }




    public void getCoordinates() {





        //spiral are impacted a lot by initialR.
        //circles locations remain whether landscape or portrait
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            initialR = initialRForLocation;

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


    public void getCoordinatesRotate() {

        Log.d("spiralCoordinates size", "r " + spiralCoordinates.size());
        //if you want to move the images and spin the spiral, you want this
        //meaning if use justDraw(), no need this line, if use getCoordinatesRotate(), need this line, and add getCoordinatesRotate() in getCoordinatesAndSizes method below.
        spiralCoordinates.clear();

        for (float t = 0; t < 30; t += 0.02f) {
            //Equiangular spiral function：
            //x = p * cosA, y = p * sinA, where p = N * e^(B * cotC)
            //When C = PI/2, graph is a circle, when C = 0, graph is a straight line
            float x = centerX + initialR * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.cos(t));
            float y = centerY + initialR * (float) (Math.exp(t * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.sin(t));

            // rotates about (0, 0)
            //float xNew = x * (float)(Math.cos(theta)) + y * (float)(Math.sin(theta));
            //float yNew = y * (float)(Math.cos(theta)) - x * (float)(Math.sin(theta));

            // rotates about (centerX, centerY), angle degrees
            float angle = -theta;
            float xNew = (x - centerX) * (float) (Math.cos(-angle)) + (y - centerY) * (float) (Math.sin(-angle)) + centerX;
            float yNew = (y - centerY) * (float) (Math.cos(-angle)) - (x - centerX) * (float) (Math.sin(-angle)) + centerY;

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


    }


    public void getSizes() {
        float pi = (float) Math.PI;
        //float pi = 3.14f;

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

                /*
                if (newSize < 0.08) {
                    newSize = 0.08f;
                } else if (newSize < 0.08) {
                    newSize = 0.08f;
                } else if (newSize < 0.08) {
                    newSize = 0.08f;
                } else if (newSize < 0.08) {
                    newSize = 0.08f;
                }

                 */


                    /*
                    if (t <= 2 * pi / 4) {
                        newSize = newSize * 1.5f;
                    } else if (t <= 4 * pi / 4) {
                        newSize = newSize * 1.2f;
                    } else if (t < 5 * pi / 4) {
                        newSize = newSize * 1.12f;
                    } else if (t < 6 * pi / 4) {
                        newSize = newSize * 1.08f;
                    } else if (t < 7 * pi / 4){
                        newSize = newSize * 1.05f;
                    }

                     */

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

        Log.d("sizes 1400 are ", " " + sizes.get(1400));
        Log.d("sizes size is ", " " + sizes.size());
        Log.d("initialR is ", " " + initialR);

        float t = 17.5f;
        int sizesSizeInSpiralPart = sizes.size();
        largestSizeInSpiral = sizes.get(sizesSizeInSpiralPart - 1);
        int thisCoordinate = sizesSizeInSpiralPart;
        float temporary = 0.01f;

        //when q += 12f, top lines circles next to each other the whole time
        //must change the same time as getCoordinates()
        for (float q = topCoordinateInSpiralX; q < screenWidth*1.25; q += 48f) {
/*
            float t2 = t - 2 * pi;

            float thisCoordinateX = spiralCoordinates.get(thisCoordinate).get(0);
            float thisCoordinateY = spiralCoordinates.get(thisCoordinate).get(1);

            float x2 = centerX + initialR * (float) (Math.exp(t2 * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.cos(t2));
            float y2 = centerY + initialR * (float) (Math.exp(t2 * 1 / (Math.tan(47 * Math.PI / 100)))) * (float) (Math.sin(t2));


            float newSize = (float) (Math.sqrt(Math.pow(Math.abs(thisCoordinateX - x2), 2) + Math.pow(Math.abs(thisCoordinateY - y2), 2)));
            newSize = (newSize / screenWidth) * 1.32f;

            //sizes.add(largestSize);
            sizes.add(newSize);

            thisCoordinate ++;

            t += 0.02f;

 */

            sizes.add(largestSizeInSpiral);

            //sizes.add(largestSizeInSpiral * (float)Math.exp(temporary));
            //temporary += 0.013f;
        }





        Collections.reverse(sizes);


    }

}
