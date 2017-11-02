package cn.coder.toolset.adapter;

/**
 * Created by Administrator on 2017/8/7.
 */


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import cn.coder.toolset.BuildConfig;
import cn.coder.toolset.manager.TabPageManager;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
    private final static String TAG = "tab_page_fragment";
    private Context mContext;

    public SectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (BuildConfig.DEBUG) Log.d(TAG, "getItem() " + position);
        // getItem is called to instantiate the fragment for the given page.
        // Return a TabPageFragment (defined as a static inner class below).
        return TabPageManager.getNewInstance(position, mContext);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Feature Entry";
            case 1:
                return "Tools Set";
            case 2:
                return "Tec Storage";
        }
        return null;
    }
}
