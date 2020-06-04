package com.ldstemplevirtualization;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class SingleTempleView extends View {

    private Bitmap singleTemple;
    private int bitmapId;
    private String templeName;
    private String templeUrl;
    private String location;
    private String dedicationDate;
    private Paint titlePaint;
    float sHeight;
    float sWidth;

    float imageX;
    float imageY;

    private String templeInfo;

    public SingleTempleView(Context context, int id, String name, String url, String loc, String date) {
        super(context);
        templeName =name;
        bitmapId = id;
        templeUrl =url;
        location = loc;
        dedicationDate = date;

    }

    public SingleTempleView(Context context, int id, String name, String url, String info) {
        super(context);
        templeName =name;
        bitmapId = id;
        templeUrl =url;
        templeInfo = info;


    }

    @Override
    public void onDraw(Canvas c) {


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            /*
            sHeight = c.getHeight();
            sWidth = c.getWidth();

            singleTemple = loadAndScale(getResources(), bitmapId, sHeight);

            //c.drawBitmap(singleTemple,0 + sWidth / 16, 0, null);
            c.drawBitmap(singleTemple,0 + sWidth / 40, 0, null);

            float imageAreaWidth = sHeight + sWidth/16;
            float textAreaWidth = (sWidth - sHeight + sWidth/16);

            float titleSize = textAreaWidth / templeName.length() * 1.8f;

            titlePaint = new Paint();
            titlePaint.setColor(Color.GRAY);
            titlePaint.setStyle(Paint.Style.FILL);
            titlePaint.setTextSize((int)(titleSize));
            titlePaint.setTextAlign(Paint.Align.CENTER);

            float textAreaCenterX = (sWidth+imageAreaWidth) / 2 - singleTemple.getWidth()/16;

            c.drawText(templeName, textAreaCenterX, sHeight / 6, titlePaint);

            Paint textPaint = new Paint();
            textPaint.setColor(Color.GRAY);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setTextSize(50);
            textPaint.setTextAlign(Paint.Align.CENTER);

            //c.drawRect(0,sHeight/2, sWidth,sHeight,textPaint);

            //c.drawText("Location:", textAreaCenterX, 2 * sHeight / 6, textPaint);
            //c.drawText(location, textAreaCenterX, 3 * sHeight / 6, textPaint);
            //c.drawText("First Dedication Date", textAreaCenterX, 4 * sHeight / 6, textPaint);
            //c.drawText(dedicationDate, textAreaCenterX, 5 * sHeight / 6, textPaint);

            //c.drawText(templeInfo, textAreaCenterX, 4 * sHeight / 6, textPaint);

             */



        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            float sHeight = c.getHeight();
            float sWidth = c.getWidth();
            float centerX = sWidth/2;
            float centerY = sHeight/2;



            float titleSize = sWidth / templeName.length() * 1.6f;

            titlePaint = new Paint();
            titlePaint.setColor(Color.GRAY);
            titlePaint.setColor(Color.GRAY);
            titlePaint.setStyle(Paint.Style.FILL);
            titlePaint.setTextSize((int)(titleSize));
            titlePaint.setTextAlign(Paint.Align.CENTER);

            c.drawText(templeName, sWidth / 2, sHeight / 16 + titleSize / 3, titlePaint);




            //make sure image is now covering texts.
            if (sWidth > sHeight - 50 - 35 - 1.5f * (sHeight / 16 + titleSize / 3)) {
                singleTemple = loadAndScale(getResources(), bitmapId, sHeight-50 - 35 - 1.5f * (sHeight / 16 + titleSize / 3));
            } else {
                singleTemple = loadAndScale(getResources(), bitmapId, sWidth);
            }


            //singleTemple = loadAndScale(getResources(), bitmapId, sWidth);




            imageX = centerX - singleTemple.getWidth()/2;

            //where image's top is, this number is used to calculate image size
            //imageY = (sHeight-250 - 35 + sHeight/8) / 2 - singleTemple.getHeight()/2;
            imageY = 1.5f * sHeight / 16 + titleSize / 3;



            //c.drawBitmap(singleTemple, 0, sHeight / 8, null);
            c.drawBitmap(singleTemple, imageX, imageY, null);


            Paint textPaint = new Paint();
            textPaint.setColor(Color.GRAY);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setTextSize(10);
            textPaint.setTextAlign(Paint.Align.CENTER);


            //c.drawRect(0,sHeight/2, sWidth,sHeight,textPaint);

            //c.drawText(location, sWidth / 2, sHeight -150 , textPaint);
            //c.drawText(dedicationDate, sWidth / 2, sHeight - 70, textPaint);
            //c.drawText(templeInfo, sWidth / 2, sHeight - 70, textPaint);

            /*
            Paint buttonPaint = new Paint();
            buttonPaint.setColor(Color.parseColor("#66ccff"));
            buttonPaint.setStyle(Paint.Style.FILL);
            buttonPaint.setTextAlign(Paint.Align.CENTER);
             */

            /*
            c.drawRect(0,sHeight-25-50-25, sWidth,sHeight,buttonPaint);

            c.drawText("OK", sWidth/2, sHeight - 25, textPaint);

             */

            textPaint.setTextSize(35);
            c.drawText("Click the temple to visit it's website", sWidth/2, sHeight - 50, textPaint);
            //c.drawText("Click the temple to visit it's website", sWidth/2, sHeight - 250, textPaint);



            //c.drawLine(0, sHeight/8, sWidth,sHeight/8, titlePaint);
            //c.drawLine(0, sHeight - 250 - 35, sWidth,sHeight - 250 - 35, titlePaint);
        }


    }


    private static Bitmap loadAndScale(Resources res, int id, float newWidth) {
        Bitmap original = BitmapFactory.decodeResource(res, id);
        float aspectRatio = (float)original.getHeight()/(float)original.getWidth();
        float newHeight = newWidth * aspectRatio;
        return Bitmap.createScaledBitmap(original, (int)newWidth, (int)newHeight, true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent m) {

        if (m.getAction() == MotionEvent.ACTION_UP) {
            float upX = m.getX();
            float upY = m.getY();
            //Toast.makeText(getContext(), "touched at " + upX + " " + upY, Toast.LENGTH_SHORT).show();
            //this.finish();

            float distanceToImageCenter = (float) (Math.sqrt(Math.pow(Math.abs(upX - (imageX + singleTemple.getWidth()/2)), 2) + Math.pow(Math.abs(upY - (imageY + singleTemple.getHeight()/2)), 2)));

            //Toast.makeText(getContext(), "imageX and Y are "+ imageX + " " + imageY, Toast.LENGTH_SHORT).show();

            //Toast.makeText(getContext(), "distance to image center is " + distanceToImageCenter, Toast.LENGTH_SHORT).show();

            //size is good
            //Toast.makeText(getContext(), "singleTemple.getHeight()/2 is " + singleTemple.getHeight()/2, Toast.LENGTH_SHORT).show();

            //Toast.makeText(getContext(), "|" + templeUrl + "|", Toast.LENGTH_SHORT).show();

            if (distanceToImageCenter < singleTemple.getHeight()/2) {

                //Toast.makeText(getContext(), "touched at temple", Toast.LENGTH_SHORT).show();



                if (templeUrl.equals("" + "\n")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("No Link Available");
                    builder.setMessage("Sorry, Temple does not have a website yet");
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


        }





        return true;
    }


}
