package cn.coder.toolset.view.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import cn.coder.toolset.R;
import cn.coder.toolset.feature.Feature;
import cn.coder.toolset.manager.TecStorageManager;

/**
 * Created by Administrator on 2017/11/2.
 */

public class TecStoragePage extends TabPageFragment {
    @Override
    protected View getFragmentView(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.tool_entry, container, false);

        ArrayList<Feature> tecStorages = TecStorageManager.getInstance().getTecStorages();

        GridView mGridView;

        mGridView = (GridView) rootView.findViewById(R.id.tool_grid);
        GridAdapter toolAdapter = new GridAdapter(inflater, tecStorages);
        mGridView.setAdapter(toolAdapter);
        return rootView;
    }
}
