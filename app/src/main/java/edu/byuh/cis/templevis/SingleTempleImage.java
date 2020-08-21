package edu.byuh.cis.templevis;

import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import java.util.ArrayList;


public class SingleTempleImage extends View {

    private float x;
    private float y;
    private boolean firstTimeDraw = true;
    private float canvasCenterX;
    private float canvasCenterY;
    private float imageSize;
    private int id;
    private int idLast;
    private int idNext;
    private int idStore;
    private int idLastStore;
    private int idNextStore;

    private Temple currentTemple;
    private Temple lastTemple;
    private Temple nextTemple;

    private ArrayList<Temple> threeTemples;

    private Paint textPaint;
    private float canvasWidth;
    private float canvasHeight;

    public SingleTempleImage(Context context, int id, int idLast, int idNext) {
        super(context);
        this.id = id;
        this.idLast = idLast;
        this.idNext = idNext;

        threeTemples = new ArrayList<>();

        textPaint = new Paint();
        textPaint.setTextSize(50);


    }

    private Bitmap loadAndScale(Resources res, int id, float newWidth) {
        Bitmap original = BitmapFactory.decodeResource(res, id);
        float aspectRatio = (float)original.getHeight()/(float)original.getWidth();
        float newHeight = newWidth * aspectRatio;
        return Bitmap.createScaledBitmap(original, (int)newWidth, (int)newHeight, true);
    }

    public void updateThreeTemplesBitmapIds(int id, int idLast, int idNext) {
        this.idStore = id;
        this.idLastStore = idLast;
        this.idNextStore = idNext;
    }


    @Override
    public void onDraw(Canvas c) {

        canvasWidth = c.getWidth();
        canvasHeight = c.getHeight();
        canvasCenterX = canvasWidth / 2;
        canvasCenterY = canvasHeight / 2;

        imageSize = Math.min(canvasWidth, canvasHeight) * 1f;

        if (firstTimeDraw) {
            x = canvasCenterX - imageSize / 2;
            y = canvasCenterY - imageSize / 2;

            Bitmap b = loadAndScale(getResources(), id, imageSize);
            Bitmap bLast = loadAndScale(getResources(), idLast, imageSize);
            Bitmap bNext = loadAndScale(getResources(), idNext, imageSize);
            currentTemple = new Temple(b, 0f, 0f, 0f);
            lastTemple = new Temple(bLast, 0f, 0f, 0f);
            nextTemple = new Temple(bNext, 0f, 0f, 0f);
            threeTemples.add(currentTemple);
            threeTemples.add(lastTemple);
            threeTemples.add(nextTemple);
            currentTemple.setRole("current");
            lastTemple.setRole("last");
            nextTemple.setRole("next");

            firstTimeDraw = false;
        }

        //c.drawText(currentTemple.link + "hi", 100, 100, textPaint);

        for (Temple t: threeTemples) {
            if (t.role.equals("current")) {
                c.drawBitmap(t.image, x, y, null);
            } else if (t.role.equals("last")) {
                c.drawBitmap(t.image, x - canvasWidth, y, null);
            } else if (t.role.equals("next")) {
                c.drawBitmap(t.image, x + canvasWidth, y, null);
            }
        }

    }

    public void moveImage(String direction) {

        float sign = 1;

        if (direction.equals("left")) {
            sign = -1;
        } else if (direction.equals("right")) {
            sign = 1;
        }

        ValueAnimator valueAnimator;
        valueAnimator = ValueAnimator.ofObject(new FloatEvaluator(), x, sign * canvasWidth + (canvasCenterX - imageSize / 2));
        valueAnimator.setDuration(1500);
        valueAnimator.setInterpolator(new LinearInterpolator());
        final float finalSign = sign;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                x = (float) animation.getAnimatedValue();
                invalidate();
                if(x == finalSign * canvasWidth + (canvasCenterX - imageSize / 2)) {
                    x = canvasCenterX - imageSize / 2;
                    for (Temple t: threeTemples) {
                        if (t.role.equals("current")) {
                            t.setRole("last");
                        } else if (t.role.equals("last")) {
                            t.setRole("next");
                        } else if (t.role.equals("next")) {
                            t.setRole("current");
                        }
                    }
                    id = idStore;
                    idLast = idLastStore;
                    idNext = idNextStore;
                    Bitmap b = loadAndScale(getResources(), id, imageSize);
                    Bitmap bLast = loadAndScale(getResources(), idLast, imageSize);
                    Bitmap bNext = loadAndScale(getResources(), idNext, imageSize);

                    for (Temple t: threeTemples) {
                        if (t.role.equals("current")) {
                            t.changeImage(b);
                        } else if (t.role.equals("last")) {
                            t.changeImage(bLast);
                        } else if (t.role.equals("next")) {
                            t.changeImage(bNext);
                        }
                    }
                }

            }
        });
        valueAnimator.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent m) {
        float touchX= m.getX();;
        float touchY= m.getY();;
        if (m.getAction() == MotionEvent.ACTION_DOWN) {

        }

        if (m.getAction() == MotionEvent.ACTION_MOVE) {


        }

        if (m.getAction() == MotionEvent.ACTION_UP) {

        }
        return true;
    }
}
