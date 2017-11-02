package cn.coder.toolset.log.readme;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentController;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.lang.annotation.Documented;

import cn.coder.toolset.BuildConfig;
import cn.coder.toolset.Common.ToolSetApplication;

/**
 * Created by Administrator on 2017/11/1.
 */

public abstract class Readme {
    private final static String TAG = "";
    private final FragmentManager mFragmentManager = FragmentController.createController(null).getSupportFragmentManager();
    private FragmentTransaction mCurTransaction = null;
    /**
     * 1、SurfaceView实现很玄彩的动画；
     * 2、recyclerview的使用，用以替换gridview，listview等传统控件。
     */

    /**
     * 1、在当前工程中的tab切换技术：android.support.v4.view.ViewPager；
     * 2、这个viewpager的adapter是FragmentPagerAdapter extends PagerAdapter，和普通PagerAdapter的区别是FragmentPagerAdapter的getItem返回的是Fragment，
     * 3、PagerAdapter核心函数见Code 1，普通函数是将当前位置position对应的view，执行container.addview，而FragmentPagerAdapter的实现见code2.
     */

    /**
     * Code 1
     * Create the page for the given position.  The adapter is responsible
     * for adding the view to the container given here, although it only
     * must ensure this is done by the time it returns from
     * {@link #finishUpdate(ViewGroup)}.
     *
     * @param container The containing View in which the page will be shown.
     * @param position  The page position to be instantiated.
     * @return Returns an Object representing the new page.  This does not
     * need to be a View, but can be some other container of the page.
     */
    public Object instantiateItem(ViewGroup container, int position) {
        return instantiateItem((View) container, position);
    }


    /**
     * Code 2
     *
     * @param container
     * @param position
     * @return
     */
    public Object instantiateItem(ViewGroup container, int position) {
        if (mCurTransaction == null) {
            mCurTransaction = mFragmentManager.beginTransaction();
        }

        final long itemId = getItemId(position);

        // Do we already have this fragment?
        String name = makeFragmentName(container.getId(), itemId);
        Fragment fragment = mFragmentManager.findFragmentByTag(name);
        if (fragment != null) {
            if (BuildConfig.DEBUG) Log.v(TAG, "Attaching item #" + itemId + ": f=" + fragment);
            mCurTransaction.attach(fragment);
        } else {
            fragment = getItem(position);
            if (BuildConfig.DEBUG) Log.v(TAG, "Adding item #" + itemId + ": f=" + fragment);
            mCurTransaction.add(container.getId(), fragment,
                    makeFragmentName(container.getId(), itemId));
        }
        if (fragment != mCurrentPrimaryItem) {
            fragment.setMenuVisibility(false);
            fragment.setUserVisibleHint(false);
        }

        return fragment;
    }

    private static String makeFragmentName(int viewId, long id) {
        return "android:switcher:" + viewId + ":" + id;
    }

    public abstract Fragment getItem(int position);

    public long getItemId(int position) {
        return position;
    }
}
