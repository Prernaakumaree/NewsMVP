package com.prerna.mvp.di.module;

import com.prerna.mvp.data.local.LocalDataSource;
import com.prerna.mvp.data.remote.RemoteDataSource;
import com.prerna.mvp.di.scope.NewsScope;
import com.prerna.mvp.ui.news.NewsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by prernaakumaree on 26/04/2018.
 * prernaakumaree@gmail.com
 */

@Module
public class NewsModule {

    @Provides
    @NewsScope
    public NewsPresenter providesNewsPresenter(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        return new NewsPresenter(localDataSource, remoteDataSource);
    }
}
