package cn.coder.toolset.view;

/**
 * Created by Administrator on 2017/8/7.
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.coder.toolset.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";


    private MyGridView mMyGridView;

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
        if (pageCount == 1){
            rootView = inflater.inflate(R.layout.feature_entry, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, pageCount));

            mMyGridView = (MyGridView) rootView.findViewById(R.id.gv_scan_icons);
        }else if (pageCount == 2){
            rootView = inflater.inflate(R.layout.app_mgr, container, false);
        }
        return rootView;
    }
}
