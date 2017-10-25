package cn.coder.toolset.activity;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import cn.coder.toolset.R;
import cn.coder.toolset.Util.Log;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SurfaceActivity extends AppCompatActivity implements SurfaceHolder.Callback{
    private final static String LOG_TAG = "SurfaceActivity";
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;

    private SurfaceView mSurfaceView;

    int left;
    int right;
    int top;
    int bottom;
    int width;
    int height;
    SurfaceHolder surfaceHolder;
    boolean isSurfaceCreated;

    boolean isCreating;

    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
//                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_surface);


        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);


        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                toggle();
            }
        });
        
        findViewById(R.id.dummy_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("dummy_button).setOnClickListener onClick.");
                if (isSurfaceCreated){
                    new MyThread().start();
                }
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);

        mSurfaceView = (SurfaceView)findViewById(R.id.surfaceview_impl);
        mSurfaceView.setZOrderOnTop(true);
        surfaceHolder = mSurfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setFormat(PixelFormat.TRANSLUCENT);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isSurfaceCreated = true;
        left = mSurfaceView.getLeft();
        top = mSurfaceView.getTop();
        right = mSurfaceView.getRight();
        bottom = mSurfaceView.getBottom();
        width = mSurfaceView.getWidth();
        height = mSurfaceView.getHeight();
        Log.d("left = "+left+" top = "+top+" right = "+right+" bootom = "+bottom);
        Log.d("width = "+width+" height = "+height);
        Canvas canvas = mSurfaceView.getHolder().lockCanvas(null);
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    private class MyThread extends Thread{
        private boolean isDrawing = true;
        private Paint paint = new Paint();
        RectF rectF = new RectF(20,20,right-left-20,bottom-top-20);
        int num = 360;
        int current =0;
        @Override
        public void run() {
            Log.d("run");
            super.run();
            Canvas canvas = null;
            while (isDrawing){
                Log.d("isDrawing");
                canvas = surfaceHolder.lockCanvas();//
                canvas.drawColor(Color.WHITE);
                paint.setAntiAlias(true);
                paint.setStrokeWidth(12.0f);
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.rgb(0xe9, 0xe9, 0xe9));

                canvas.drawArc(rectF,-90,360,false,paint);//-90表示从竖直上的方向开始顺时针绘制 第三个参数false 画弧度的时候 边框不显示

                paint.setColor(Color.rgb(0xf8, 0x60, 0x30));
                canvas.drawArc(rectF,-90,current,false,paint);//

                paint.setStyle(Paint.Style.FILL);
                paint.setStrokeWidth(1.0f);
                paint.setTextSize(50);
                paint.setColor(Color.BLUE);
                paint.setTextAlign(Paint.Align.CENTER);
                float baseX = width/2;
                float baseY = height/2;
                canvas.drawText((current*100)/360+"%",baseX,baseY,paint);
                try {
                    if(current >=360){
                        isDrawing =false;
                        current = 360;
                    }else{
                        current = current+10;
                    }
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                surfaceHolder.unlockCanvasAndPost(canvas);
            }
            isDrawing = true;
        }
    }
}
