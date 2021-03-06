package kr.co.woobi.imyeon.loaddataexam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class LineActivity extends AppCompatActivity {
List<Point> points=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.parseColor("#99cc00"));
            Paint paint=new Paint();
            paint.setColor(Color.parseColor("#000000"));
            for (int i = 0; i <points.size() ; i++) {
                Point now=points.get(i);
                if(now.isDraw){
                    Point before=points.get(i-1);
                    canvas.drawLine(before.x, before.y, now.x, now.y,paint);
                }

            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                points.add(new Point(event.getX(), event.getY(),false));
                return  true;
            }
            //터치 후 드래그 상태
            if(event.getAction()==MotionEvent.ACTION_MOVE){
                points.add(new Point(event.getX(), event.getY(), true));
                invalidate();
                return true;
            }
            return false;
        }
    }
}
