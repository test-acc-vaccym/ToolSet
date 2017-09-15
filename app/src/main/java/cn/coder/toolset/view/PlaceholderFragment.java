package cn.coder.toolset.view;

/**
 * Created by Administrator on 2017/8/7.
 */


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cn.coder.toolset.TecStorage.TecStorage;
import cn.coder.toolset.feature.Feature;
import cn.coder.toolset.R;
import cn.coder.toolset.manager.FeatureManager;
import cn.coder.toolset.manager.TecStorageManager;
import cn.coder.toolset.manager.ToolManager;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    private static Context mContext;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";



    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber, Context context) {
        mContext = context;
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = null;
        int pageCount = getArguments().getInt(ARG_SECTION_NUMBER);
        if (pageCount == 0) {
            rootView = getFeatureEntryView(inflater, container);
        } else if (pageCount == 1) {
            rootView = getAppMgrView(inflater, container);
        }else if (pageCount == 2){
            rootView = getTecStorageView(inflater, container);
        }
        return rootView;
    }

    private View getFeatureEntryView(LayoutInflater inflater, ViewGroup container) {
        final View rootView = inflater.inflate(R.layout.feature_entry, container, false);

        ArrayList<Feature> clearPSDataFeatureSets = FeatureManager.getInstance().getFeatureSet();

        MyGridView mGridView;

        mGridView = (MyGridView) rootView.findViewById(R.id.feature_grid);
        GridAdapter featureAdapter = new GridAdapter(inflater, clearPSDataFeatureSets);
        mGridView.setAdapter(featureAdapter);
        return rootView;
    }

    private View getAppMgrView(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.tool_entry, container, false);

        ArrayList<Feature> toolSet = ToolManager.getInstance().getToolSet();

        MyGridView mGridView;

        mGridView = (MyGridView) rootView.findViewById(R.id.tool_grid);
        GridAdapter toolAdapter = new GridAdapter(inflater, toolSet);
        mGridView.setAdapter(toolAdapter);
        return rootView;
    }

    private View getTecStorageView(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.tool_entry, container, false);

        ArrayList<Feature> tecStorages = TecStorageManager.getInstance().getTecStorages();

        MyGridView mGridView;

        mGridView = (MyGridView) rootView.findViewById(R.id.tool_grid);
        GridAdapter toolAdapter = new GridAdapter(inflater, tecStorages);
        mGridView.setAdapter(toolAdapter);
        return rootView;
    }

    private class GridAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private ArrayList<Feature> mList = new ArrayList<>();

        private GridAdapter(LayoutInflater inflater, ArrayList<Feature> features) {
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
}
