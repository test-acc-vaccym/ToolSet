package cn.coder.toolset.view.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cn.coder.toolset.R;
import cn.coder.toolset.feature.Feature;
import cn.coder.toolset.manager.ToolManager;

/**
 * Created by Administrator on 2017/11/2.
 */

public class ToolPage extends TabPageFragment {
    @Override
    protected View getFragmentView(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.tool_entry, container, false);

        ArrayList<Feature> toolSet = ToolManager.getInstance().getToolSet();

        cn.coder.toolset.view.MyGridView mGridView;

        mGridView = (cn.coder.toolset.view.MyGridView) rootView.findViewById(R.id.tool_grid);
        GridAdapter toolAdapter = new GridAdapter(inflater, toolSet);
        mGridView.setAdapter(toolAdapter);
        return rootView;
    }
}
