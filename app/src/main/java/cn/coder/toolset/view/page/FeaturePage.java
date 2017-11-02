package cn.coder.toolset.view.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import cn.coder.toolset.R;
import cn.coder.toolset.feature.Feature;
import cn.coder.toolset.manager.FeatureManager;

/**
 * Created by Administrator on 2017/11/2.
 */

public class FeaturePage extends TabPageFragment {
    @Override
    protected View getFragmentView(LayoutInflater inflater, ViewGroup container) {
        final View rootView = inflater.inflate(R.layout.feature_entry, container, false);

        ArrayList<Feature> clearPSDataFeatureSets = FeatureManager.getInstance().getFeatureSet();

        GridView mGridView;

        mGridView = (GridView) rootView.findViewById(R.id.feature_grid);
        GridAdapter featureAdapter = new GridAdapter(inflater, clearPSDataFeatureSets);
        mGridView.setAdapter(featureAdapter);
        return rootView;
    }
}
