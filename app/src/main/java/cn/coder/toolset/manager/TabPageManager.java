package cn.coder.toolset.manager;

import android.content.Context;
import android.os.Bundle;

import cn.coder.toolset.view.page.FeaturePage;
import cn.coder.toolset.view.page.TabPageFragment;
import cn.coder.toolset.view.page.TecStoragePage;
import cn.coder.toolset.view.page.ToolPage;

import static cn.coder.toolset.view.page.TabPageFragment.ARG_SECTION_NUMBER;

/**
 * Created by Administrator on 2017/11/2.
 */

public class TabPageManager {
    private static Context mContext;


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     * 在创建fragment的时候，通过setArguments为fragment设置Bundle参数。
     * 在fragment执行onCreateView的时候通过getArguments()获取Bundle参数。
     */
    /**
     * 根据Android文档说明，当一个fragment重新创建的时候，系统会再次调用 Fragment中的默认构造函数。 注意这里：是 默认构造函数。
     这句话更直白的意思就是：当你小心翼翼的创建了一个带有重要参数的Fragment的之后，一旦由于什么原因（横竖屏切换）导致你的Fragment重新创建。——-很遗憾的告诉你，你之前传递的参数都不见了，因为recreate你的Fragment的时候，调用的是默认构造函数。
     setArguments方法的调用必须要在Fragment与Activity关联之前。
     这句话可以这样理解，setArgument方法的使用必须要在FragmentTransaction 的commit之前使用。
     activity重新建立的时候会调用newIntent，Fragment会调用默认构造函数，所以需要通过setArguments保存参数。
     Fragment是一个微型的Activity。
     我们知道设备横竖屏切换的话，当前展示给用户的Activity默认情况下会重新创建并展现给用户。
     Activity重新创建时，会重新构建它所管理的Fragment，原先的Fragment的字段值将会全部丢失，但是通过Fragment.setArguments(Bundle bundle)方法设置的bundle会保留下来。所以尽量使用Fragment.setArguments(Bundle bundle)方式来传递参数。
     * @param sectionNumber
     * @param context
     * @return
     */
    public static TabPageFragment getNewInstance(int sectionNumber, Context context) {
        mContext = context;
        TabPageFragment fragment = null;
        switch (sectionNumber){
            case 0:{
                fragment = new FeaturePage();
                break;
            }
            case 1:{
                fragment = new ToolPage();
                break;
            }
            case 2:{
                fragment = new TecStoragePage();
                break;
            }
        }
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
}
