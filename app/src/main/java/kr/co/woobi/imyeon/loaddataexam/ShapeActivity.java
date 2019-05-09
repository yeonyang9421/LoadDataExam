package kr.co.woobi.imyeon.loaddataexam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class ShapeActivity extends AppCompatActivity {
    private int x = 50, y = 50;
    private int width, height;
    private int moveX = 5, moveY = 10;
    private int red, green, blue;
    private boolean isRun;
    private Thread th;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    private class MyView extends View implements Runnable {
        public MyView(Context context) {
            super(context);
            th = new Thread(this);
            th.start();
            isRun = true;
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            width = getWidth();
            height = getHeight();
        }

        void setColor() {
            Random random = new Random();
            red = random.nextInt(256);
            green = random.nextInt(256);
            blue = random.nextInt(256);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.parseColor("#dddddd"));
            Paint p = new Paint();
            p.setColor(Color.argb(255, red, green, blue));
            canvas.drawCircle(x, y, 20, p);


//            canvas.drawRect(200, 200, 300, 300, p);
        }

        @Override
        public void run() {
            while (isRun) {
                if (x > (width - 20) || x < 20) {
                    moveX = -moveX;
                    setColor();
                }
                if (y > (height - 20) || y < 20) {
                    moveY = -moveY;
                    setColor();
                }

                x += moveX;
                y += moveY;
                postInvalidate();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isRun = false;
        th = null;
    }
}
