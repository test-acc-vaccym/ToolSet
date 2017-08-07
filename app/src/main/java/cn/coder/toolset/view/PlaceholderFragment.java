package cn.coder.toolset.view;

/**
 * Created by Administrator on 2017/8/7.
 */


import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.coder.toolset.R;
import cn.coder.toolset.model.FeatureSet;

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
        View rootView = inflater.inflate(R.layout.feature_entry, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);

        ArrayList<FeatureSet> featureSets = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            featureSets.add(new FeatureSet("feature" + i, "des " + i));
        }

        mGridView = (MyGridView) rootView.findViewById(R.id.feature_grid);
        mFeatureAdapter = new FeatureGridAdapter(inflater, featureSets);
        mGridView.setAdapter(mFeatureAdapter);
        return rootView;
    }

    private View getAppMgrView(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.app_mgr, container, false);
        return rootView;
    }

    private class FeatureGridAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private ArrayList<FeatureSet> mList = new ArrayList<>();
        private FeatureGridAdapter(LayoutInflater inflater, ArrayList<FeatureSet> featureSets) {
            mInflater = inflater;
            mList.addAll(featureSets);
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
                ((TextView)contentView.findViewById(R.id.tv_feature_title)).setText(mList.get(position).FeatureTitle);
                ((TextView)contentView.findViewById(R.id.tv_feature_des)).setText(mList.get(position).FeatureDes);
                contentView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        guideAction();
                    }
                });
            }
            return contentView;
        }
    }
}
