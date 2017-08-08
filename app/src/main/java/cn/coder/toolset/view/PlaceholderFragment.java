package cn.coder.toolset.view;

/**
 * Created by Administrator on 2017/8/7.
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import cn.coder.toolset.Common.Feature;
import cn.coder.toolset.R;
import cn.coder.toolset.Util.SimilateBatteryChange;
import cn.coder.toolset.manager.FeatureManager;
import cn.coder.toolset.model.ClearPSDataFeature;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";


    private MyGridView mGridView;
    private FeatureGridAdapter mFeatureAdapter;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
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
        }
        return rootView;
    }

    private View getFeatureEntryView(LayoutInflater inflater, ViewGroup container) {
        final View rootView = inflater.inflate(R.layout.feature_entry, container, false);

        ArrayList<Feature> clearPSDataFeatureSets = FeatureManager.getsInstance().getFeatureSet();

        mGridView = (MyGridView) rootView.findViewById(R.id.feature_grid);
        mFeatureAdapter = new FeatureGridAdapter(inflater, clearPSDataFeatureSets);
        mGridView.setAdapter(mFeatureAdapter);

        rootView.findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String battery = ((EditText)rootView.findViewById(R.id.et_percent_power)).getText().toString();

                SimilateBatteryChange.send(Float.valueOf(battery));
            }
        });
        return rootView;
    }

    private View getAppMgrView(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.app_mgr, container, false);
        return rootView;
    }

    private class FeatureGridAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private ArrayList<Feature> mList = new ArrayList<>();
        private FeatureGridAdapter(LayoutInflater inflater, ArrayList<Feature> features) {
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
                ((TextView)contentView.findViewById(R.id.tv_feature_title)).setText(mList.get(position).mFeatureTitle);
                ((TextView)contentView.findViewById(R.id.tv_feature_des)).setText(mList.get(position).mFeatureDes);
                contentView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Feature featureAction = mList.get(position);
                        featureAction.action();
                    }
                });
            }
            return contentView;
        }
    }
}
