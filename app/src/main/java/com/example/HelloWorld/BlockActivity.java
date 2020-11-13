package com.example.HelloWorld;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.Button;

public class BlockActivity extends Activity {
    private final int FIELD_WIDTH = 320;
    private final int FIELD_HEIGHT = 200;

    private final int PADDLE_WIDTH = 100;
    private final int PADDLE_HEIGHT = 20;
    private final int PADDLE_VELOCITY = 10;

    private final int BALL_SIZE = 20;
    private final int BALL_VELOCITY = 5;

    private final int BLOCK_WIDTH = 50;
    private final int BLOCK_HEIGHT = 20;
    private final int BLOCK_NUM_X = 6;
    private final int BLOCK_NUM_Y = 3;

    private final int DIR_LB = 0;
    private final int DIR_LT = 1;
    private final int DIR_RT = 2;
    private final int DIR_RB = 3;

    private Button mPaddle;
    private Button mBall;
    private Button[] mBlocks;
    private int mBallDirection;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        final AbsoluteLayout al = new AbsoluteLayout(this);
        setContentView(R.layout.activity_block);

        mPaddle = new Button(this);
        mPaddle.setLayoutParams(new LayoutParams(
                PADDLE_WIDTH, PADDLE_HEIGHT, (FIELD_WIDTH-PADDLE_WIDTH)>>1, 160));
        al.addView(mPaddle);

        mPaddle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                restart();
            }
        });

        mBall = new Button(this);
        mBall.setLayoutParams(new LayoutParams(
                BALL_SIZE, BALL_SIZE, (FIELD_WIDTH-BALL_SIZE)>>1, (FIELD_HEIGHT-BALL_SIZE)>>1));
        al.addView(mBall);
        mBallDirection = DIR_LB;

        mBall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                AlertDialog.show(BlockActivity.this, "Congratulations!", "OMEDETOU !!", "OK", true);
            }
        });

        mBlocks = new Button[BLOCK_NUM_X * BLOCK_NUM_Y];
        for( int i = 0; i < mBlocks.length; ++ i ) {
            final Button bt1 = new Button(this);
            int x = 10 + (i % BLOCK_NUM_X) * BLOCK_WIDTH;
            int y = 10 + (i / BLOCK_NUM_X) * BLOCK_HEIGHT;
            bt1.setLayoutParams(new LayoutParams(BLOCK_WIDTH, BLOCK_HEIGHT, x, y));
            al.addView(bt1);
            bt1.setFocusable(false);
            mBlocks[i] = bt1;
        }

        update();
    }

    private void restart() {
        moveWidget(mPaddle, (FIELD_WIDTH-PADDLE_WIDTH)>>1, 160);
        moveWidget(mBall, (FIELD_WIDTH-BALL_SIZE)>>1, (FIELD_HEIGHT-BALL_SIZE)>>1);
        mBallDirection = DIR_LB;

        for( int i = 0; i < mBlocks.length; ++ i ) {
            mBlocks[i].setVisibility(View.VISIBLE);
        }
    }

    private void moveWidget(View v, int x, int y) {
//        v.layout(0, 0, x, y, x+v.getWidth(), y+v.getHeight());
    }

    private void movePaddle(int vx) {
        int x = mPaddle.getLeft() + vx;
        if( isOverLeft(x) ) x = 0;
        if( isOverRight(x+mPaddle.getWidth()) ) x = FIELD_WIDTH - mPaddle.getWidth();
        moveWidget(mPaddle, x, mPaddle.getTop());
    }

    private void moveBall() {
        int vx = BALL_VELOCITY, vy = BALL_VELOCITY;
        switch( mBallDirection ) {
            case DIR_LB: vx = -vx; break;
            case DIR_LT: vx = -vx; vy = -vy; break;
            case DIR_RT: vy = -vy; break;
            case DIR_RB: break;
        }

        int x = mBall.getLeft() + vx;
        int y = mBall.getTop() + vy;

        if( isOverLeft(x) ) {
            x = 0;
            mBallDirection = vy < 0 ? DIR_RT : DIR_RB;
        }
        if( isOverRight(x+mBall.getWidth()) ) {
            x = FIELD_WIDTH - mBall.getWidth();
            mBallDirection = vy < 0 ? DIR_LT : DIR_LB;
        }
        if( isOverTop(y) ) {
            y = 0;
            mBallDirection = vx < 0 ? DIR_LB : DIR_RB;
        }
        if( isOverBottom(y+mBall.getHeight()) ) {
            //y = FIELD_HEIGHT - mBall.getHeight();
            //mBallDirection = vx < 0 ? DIR_LT : DIR_RT;
            restart();
            return;
        }

        moveWidget(mBall, x, y);
    }

    private boolean isHit(View v1, View v2) {
        Rect r1 = new Rect(v1.getLeft(), v1.getTop(), v1.getRight(), v1.getBottom());
        return r1.intersect(v2.getLeft(), v2.getTop(), v2.getRight(), v2.getBottom());
    }

    private int getNextDirection(View v) {
        int t = v.getTop();
        int b = v.getBottom();
        if( mBall.getTop() < t && mBall.getBottom() > t ) {
            if( mBallDirection == DIR_LB ) return DIR_LT;
            if( mBallDirection == DIR_RB ) return DIR_RT;
        }

        if( mBall.getTop() < b && mBall.getBottom() > b ) {
            if( mBallDirection == DIR_LT ) return DIR_LB;
            if( mBallDirection == DIR_RT ) return DIR_RB;
        }

        return DIR_LB;
    }

    private boolean isOverLeft(int x) { return x < 0; }
    private boolean isOverRight(int x) { return x > FIELD_WIDTH; }
    private boolean isOverTop(int y) { return y < 0; }
    private boolean isOverBottom(int y) { return y > FIELD_HEIGHT; }

    @Override public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                movePaddle(-PADDLE_VELOCITY);
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                movePaddle(PADDLE_VELOCITY);
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void update() {
        moveBall();

        if( isHit(mPaddle, mBall) ) {
            mBallDirection = getNextDirection(mPaddle);
        }

        for( int i = 0; i < mBlocks.length; ++ i ) {
            if( mBlocks[i].getVisibility() == View.INVISIBLE ) continue;
            if( isHit(mBlocks[i], mBall) ) {
                mBlocks[i].setVisibility(View.INVISIBLE);
                mBallDirection = getNextDirection(mBlocks[i]);
            }
        }

        mRedrawHandler.sleep(100);
    }

    private RefreshHandler mRedrawHandler = new RefreshHandler();

    class RefreshHandler extends Handler {
        @Override public void handleMessage(Message msg) {
            update();
        }

        public void sleep(long delayMills) {
            this.removeMessages(0);
            sendMessageDelayed(obtainMessage(0), delayMills);
        }
    }
}

//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.MotionEvent;
//import android.widget.ImageView;
//import android.app.Activity;
//import android.graphics.Color;
//import android.graphics.Point;
//import android.os.Bundle;
//import android.os.Handler;
//import android.view.Display;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.RelativeLayout;
//
//public class BlockActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_block);
//        ImageView Ball = findViewById(R.id.ball);
//        ImageView Bar = findViewById(R.id.bar);
//        ImageView Block1 = findViewById(R.id.block1);
//        ImageView Block2 = findViewById(R.id.block2);
//
//        //変数　宣言
//        float ball_x = Ball.getX();
//        float ball_y = Ball.getY();
//        float bar_x = Bar.getMaxWidth();
//        float bar_y = Bar.getMaxHeight();
//        int block1_x = Block1.getMaxWidth();
//        int block1_y = Block1.getMaxHeight();
//        int block2_x = Block2.getMaxWidth();
//        int block2_y = Block2.getMaxHeight();
//        float touchpointX = 0;
//        float touchpointY = 0;
//
//        //ボールの移動変数
//        float ballVx = 10;
//        float ballVy = 9;
//        ball_x += ballVx;
//        ball_y += ballVy;
//
//
//
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        //画面（View）が押されたのかを判定
//        if(event.getAction() == MotionEvent.ACTION_MOVE) {
//
//            touchpointX = event.getX();    //X座標を変数にセット
//            touchpointY = event.getY();    //Y座標を変数にセット
//        }
//
//        bar_x = touchpointX;
//        bar_y = touchpointY;
//
//        //画面の更新（onDrawの呼び出し）
//        //invalidate();
//
//        return true;
//    }
//}