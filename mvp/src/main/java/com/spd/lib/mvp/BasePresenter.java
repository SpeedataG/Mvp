package com.spd.lib.mvp;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * @author :Reginer in  2017/9/18 13:14.
 * 联系方式:QQ:282921012
 * 功能描述:Presenter基类
 */
public abstract class BasePresenter<V, M extends BaseModel> {
    protected M mModel;

    public BasePresenter() {
        mModel = createModel();
    }

    private Reference<V> mViewRef;

    private CompositeDisposable mDisposables;

    void attachView(V view) {
        mViewRef = new WeakReference<>(view);
        mDisposables = new CompositeDisposable();
    }

    public void addDisposable(Disposable disposable) {
        mDisposables.add(disposable);
    }

    public V getView() {
        if (mViewRef == null) {
            return null;
        }
        return mViewRef.get();
    }

    private boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }


    void detachView() {
        if (isViewAttached()) {
            mViewRef.clear();
            mViewRef = null;
        }
        mDisposables.clear();
    }

    /**
     * 创建model
     *
     * @return model
     */
    protected abstract M createModel();
}