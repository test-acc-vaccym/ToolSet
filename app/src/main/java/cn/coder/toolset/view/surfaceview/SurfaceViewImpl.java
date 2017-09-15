package cn.coder.toolset.view.surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.VideoView;

/**
 * Created by Administrator on 2017/9/2.
 */

public class SurfaceViewImpl extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    // SurfaceHolder
    private SurfaceHolder mSurfaceHolder;
    // 画布
    private Canvas mCanvas;
    // 子线程标志位
    private boolean isDrawing;

    public SurfaceViewImpl(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {//创建
        isDrawing = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {//改变

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {//销毁
        isDrawing = false;
    }

    @Override
    public void run() {
        while (isDrawing) {
            drawing();
        }
    }

    private void drawing() {
        try {
            mCanvas = mSurfaceHolder.lockCanvas();
            //这里进行内容的绘制

        } finally {
            if (mCanvas != null) {
                mSurfaceHolder.unlockCanvasAndPost(mCanvas);
            }
        }
    }
}