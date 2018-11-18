package com.prerna.mvp.ui.news;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.prerna.mvp.data.local.LocalDataSource;
import com.prerna.mvp.data.local.entities.ArticleEntity;
import com.prerna.mvp.data.remote.RemoteDataSource;
import com.prerna.mvp.ui.base.BasePresenter;
import com.prerna.mvp.utils.NetworkUtil;

import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by prernaakumaree on 18/11/2018
 * prernaakumaree@gmail.com
 */

public class NewsPresenter extends BasePresenter<ContractNews.ContractView> implements ContractNews.ContractPresenter {

    private static final String TAG = NewsPresenter.class.getSimpleName();

    LocalDataSource mLocalDataSource;
    RemoteDataSource mRemoteDataSource;

    public NewsPresenter(LocalDataSource mLocalDataSource, RemoteDataSource mRemoteDataSource) {

        this.mLocalDataSource = mLocalDataSource;
        this.mRemoteDataSource = mRemoteDataSource;
    }

    @Override
    public void getArticles(Context context) {

        if (NetworkUtil.isNetworkConnected(context))
            getArticlesFromApi();
        else
            getArticleFromDb();
    }

    @Override
    public void getArticlesFromApi() {

        getView().showLoading();

        mDisposable = mRemoteDataSource.getArticlesFromApi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {

                            if(!isViewAttached())
                                return;

                            getView().hideLoading();
                            if (response.isSuccessful()) {

                                saveArticles(response.body().getmArticles());
                                getView().onArtilesReady(response.body().getmArticles());
                            }
                        },
                        throwable -> {
                            getView().hideLoading();
                            Log.e(TAG, throwable.getMessage());
                        });

    }

    @Override
    public void getArticleFromDb() {

        getView().showLoading();

        mLocalDataSource.getArticleDao().getArticlesFromDb()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {

                            if(!isViewAttached())
                                return;

                            getView().hideLoading();
                            getView().onArtilesReady(response);

                        },
                        throwable -> {
                            getView().hideLoading();
                            Log.e(TAG, throwable.getMessage());
                        });

    }

    @Override
    public void saveArticles(List<ArticleEntity> items) {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                mLocalDataSource.getArticleDao().deleteArticles();
                mLocalDataSource.getArticleDao().saveArticles(items);
                return null;
            }
        }.execute();

    }

}
