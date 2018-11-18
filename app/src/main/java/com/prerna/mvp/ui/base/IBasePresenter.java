package com.prerna.mvp.ui.base;

/**
 * Created by prernaakumaree on 13/04/2018.
 * prernaakumaree@gmail.com
 */

public interface IBasePresenter<V extends IBaseView> {

    void attachView(V view);

    void detachView();

    boolean isViewAttached();
}
