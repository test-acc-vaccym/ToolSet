package cn.coder.toolset.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * Created by Administrator on 2017/8/16.
 */

public class PopupWindowActivity extends Activity {
    PopupWindow pop;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_popup_window);
//        btn = (Button) findViewById(R.id.btnShowWindow);
//
//        LayoutInflater inflater = LayoutInflater.from(this);
//        // 引入窗口配置文件 - 即弹窗的界面
//        View view = inflater.inflate(R.layout.my_popup_window, null);
//        // PopupWindow实例化
//        pop = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT, false);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (pop.isShowing()) {
//                    // 隐藏窗口，如果设置了点击窗口外消失，则不需要此方式隐藏
//                    pop.dismiss();
//                } else {
//                    // 弹出窗口显示内容视图,默认以锚定视图的左下角为起点，这里为点击按钮
//                    pop.showAsDropDown(v);
//                }
//            }
//        });

    }
}
