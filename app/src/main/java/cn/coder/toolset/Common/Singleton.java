package cn.coder.toolset.Common;

/**
 * Created by Administrator on 2017/8/16.
 */

/**
 * Singleton helper class for lazily initialization.
 * <p>
 * Modeled after frameworks/base/include/utils/Singleton.h
 *
 * @hide
 */
public abstract class Singleton<T> {
    private T mInstance;

    protected abstract T create();

    public final T get() {
        if (mInstance == null) {
            synchronized (this) {
                if (mInstance == null) {
                    mInstance = create();
                }
            }
        }
        return mInstance;
    }
}
