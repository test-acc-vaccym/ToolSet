package cn.coder.toolset.view.page;

/**
 * Created by Administrator on 2017/8/7.
 */


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.coder.toolset.BuildConfig;
import cn.coder.toolset.feature.Feature;
import cn.coder.toolset.R;
import cn.coder.toolset.manager.FeatureManager;
import cn.coder.toolset.manager.TecStorageManager;
import cn.coder.toolset.manager.ToolManager;

/**
 * A placeholder fragment containing a simple view.
 * 怎么判断当前显示的是哪个页面？
 */
public abstract class TabPageFragment extends Fragment {
    private final static String TAG = "tab_page_fragment";
    private static Context mContext;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    public static final String ARG_SECTION_NUMBER = "section_number";

    public TabPageFragment() {
        if (BuildConfig.DEBUG) Log.d(TAG, "TabPageFragment()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int pageCount = getArguments().getInt(ARG_SECTION_NUMBER);
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreateView " + pageCount);
        return getFragmentView(inflater, container);
    }

    abstract protected View getFragmentView(LayoutInflater inflater, ViewGroup container);

    protected class GridAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private ArrayList<Feature> mList = new ArrayList<>();

        protected GridAdapter(LayoutInflater inflater, ArrayList<Feature> features) {
            mInflater = inflater;
            mList.addAll(features);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View contentView, ViewGroup parent) {
            if (contentView == null) {
                contentView = mInflater.inflate(R.layout.feature_item, null);
                ((TextView) contentView.findViewById(R.id.tv_feature_title)).setText(mList.get(position).mFeatureTitle);
                ((TextView) contentView.findViewById(R.id.tv_feature_des)).setText(mList.get(position).mFeatureDes);
                contentView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Feature featureAction = mList.get(position);
                        featureAction.action(mContext);
                    }
                });
            }
            return contentView;
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        if (BuildConfig.DEBUG) Log.d(TAG, "onDetach : " + getArguments().getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (BuildConfig.DEBUG) Log.d(TAG, "onAttach : " + getArguments().getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if (BuildConfig.DEBUG) Log.d(TAG, "onDestroy : " + getArguments().getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        if (BuildConfig.DEBUG) Log.d(TAG, "onDestroyView : " + getArguments().getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public void onResume(){
        super.onResume();
        if (BuildConfig.DEBUG) Log.d(TAG, "onResume : " + getArguments().getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public void onStart(){
        super.onStart();
        if (BuildConfig.DEBUG) Log.d(TAG, "onStart : " + getArguments().getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public void onPause(){
        super.onPause();
        if (BuildConfig.DEBUG) Log.d(TAG, "onPause : " + getArguments().getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public void onStop(){
        super.onStop();
        if (BuildConfig.DEBUG) Log.d(TAG, "onStop : " + getArguments().getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (BuildConfig.DEBUG) Log.d(TAG, "onOptionsItemSelected : " + getArguments().getInt(ARG_SECTION_NUMBER) + " " + item.isVisible());
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionsMenuClosed(Menu item){
        if (BuildConfig.DEBUG) Log.d(TAG, "onOptionsMenuClosed : " + getArguments().getInt(ARG_SECTION_NUMBER) + " " + item.hasVisibleItems());
        super.onOptionsMenuClosed(item);
    }

}
