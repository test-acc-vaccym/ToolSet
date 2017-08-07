package cn.coder.toolset.view;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyGridView extends GridView {
    private float mTouchX;
    private float mTouchY;
    private OnTouchBlankPositionListener mTouchBlankPosListener;

    public MyGridView(android.content.Context context,
                      android.util.AttributeSet attrs) {
        super(context, attrs);
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mTouchBlankPosListener != null) {
            if (!isEnabled()) {
                return isClickable() || isLongClickable();
            }
            int action = event.getActionMasked();
            float x = event.getX();
            float y = event.getY();
            final int motionPosition = pointToPosition((int) x, (int) y);
            if (motionPosition == INVALID_POSITION) {
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        mTouchX = x;
                        mTouchY = y;
                        mTouchBlankPosListener.onTouchBlank(event);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (Math.abs(mTouchX - x) > 10
                                || Math.abs(mTouchY - y) > 10) {
                            mTouchBlankPosListener.onTouchBlank(event);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        mTouchX = 0;
                        mTouchY = 0;
                        mTouchBlankPosListener.onTouchBlank(event);
                        break;
                }
            }
        }
        return super.onTouchEvent(event);
    }

    /**
     * 设置GridView的空白区域的触摸事件
     *
     * @param listener
     */
    public void setOnTouchBlankPositionListener(
            OnTouchBlankPositionListener listener) {
        mTouchBlankPosListener = listener;
    }

    public interface OnTouchBlankPositionListener {
        void onTouchBlank(MotionEvent event);
    }


}
