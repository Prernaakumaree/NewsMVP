package com.prerna.mvp.di.component;

import com.prerna.mvp.data.local.LocalDataSource;
import com.prerna.mvp.data.remote.RemoteDataSource;
import com.prerna.mvp.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by prernaakumaree on 12/03/2018.
 * prernaakumaree@gmail.com
 */

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    LocalDataSource roomDataSource();

    RemoteDataSource remoteDataSource();
}
