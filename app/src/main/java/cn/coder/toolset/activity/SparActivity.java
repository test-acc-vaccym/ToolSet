package cn.coder.toolset.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.coder.toolset.R;
import cn.coder.toolset.view.surfaceview.SparkView;

// http://blog.csdn.net/a396901990/article/details/43944761
public class SparActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_spar);
        SparkView sparkView = new SparkView(this);
        setContentView(sparkView);
    }
}
