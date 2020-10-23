package com.example.HelloWorld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class BlockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block);
        ImageView Ball = findViewById(R.id.ball);
        ImageView Bar = findViewById(R.id.bar);
        ImageView Block1 = findViewById(R.id.block1);
        ImageView Block2 = findViewById(R.id.block2);

        //変数　宣言
        int ball_x = Ball.getMaxWidth();
        int ball_y = Ball.getMaxHeight();
        int bar_x = Bar.getMaxWidth();
        int bar_y = Bar.getMaxHeight();
        int block1_x = Block1.getMaxWidth();
        int block1_y = Block1.getMaxHeight();
        int block2_x = Block2.getMaxWidth();
        int block2_y = Block2.getMaxHeight();

        //ボールの移動変数
        int ballVx = 10;
        int ballVy = 9;
        ball_x += ballVx;
        ball_y += ballVy;

        //ボールの画面端での判定
        if(ball_x - Ball.getMaxWidth() == 0 || ball_x == 1) {
            ballVx = -ballVx;
        }
        if(ball_y - Ball.getMaxHeight() == 0 || ball_y == 1) {
            ballVy = -ballVy;
        }

        //ボールのブロック衝突時の判定
//        if(){
//
//        }
//        if(){
//
//        }
        //バーの画面端での判定
//        if(bar_x - bar_x == 0 || bar_x == ) {
//
//        }
    }



}

/*
    //コンストラクタ
    public Bar( int _x, int _y ){
        //初期座標をセット
        x = (float)_x;
        y = (float)_y;
    }

}
/*








public class MainActivity extends Activity {

 Ball ball;
 Handler handler;
 int width, height;
 int dx = 10, dy = 10, time = 1;
 private Runnable runnable;



 @Override

 protected void onCreate(Bundle savedInstanceState) {

 super.onCreate(savedInstanceState);

 getWindow().addFlags(

 WindowManager.LayoutParams.FLAG_FULLSCREEN);

 requestWindowFeature(Window.FEATURE_NO_TITLE);

 RelativeLayout relativeLayout = new RelativeLayout(this);

 relativeLayout.setBackgroundColor(Color.GREEN);

 setContentView(relativeLayout);



 handler = new Handler();

 //handler.postDelayed(runnable, time);........................1



 WindowManager windowManager =

 (WindowManager) getSystemService(WINDOW_SERVICE);

 Display display = windowManager.getDefaultDisplay();

 Point point = new Point();

 display.getSize(point);

 width = point.x; //画面の幅

 height = point.y; //画面の高さ

 ball = new Ball(this);

 ball.x = width / 2; //ここで

 ball.y = height / 2; //ボールの位置を指定

 relativeLayout.addView(ball);





 runnable = new Runnable() {

 @Override

 public void run() {

 ball.x += dx;

 ball.y -= dy;



 if (ball.x <= ball.radius) {

 ball.x = ball.radius;

 dx = -dx;

 } else if (ball.x >= width - ball.radius) {

 ball.x = width - ball.radius;

 dx = -dx;

 }



 if (ball.y <= ball.radius) {

 ball.y = ball.radius;

 dy = -dy;

 } else if (ball.y >= height - ball.radius) {

 ball.y = height - ball.radius;

 dy = -dy;

 }



 ball.invalidate();

 handler.postDelayed(runnable, time);.............2

 }

 };

 handler.postDelayed(runnable, time);.....................3

 }



 public void onDestroy() {

 super.onDestroy();

 handler.removeCallbacks(runnable);

 }

}
*/


