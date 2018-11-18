package com.prerna.mvp;

import android.app.Application;

import com.prerna.mvp.di.component.AppComponent;
import com.prerna.mvp.di.component.DaggerAppComponent;
import com.prerna.mvp.di.component.DaggerNewsComponent;
import com.prerna.mvp.di.module.AppModule;
import com.prerna.mvp.di.component.NewsComponent;
import com.prerna.mvp.di.module.NewsModule;

public class NewsApp extends Application{

    private static NewsComponent mNewsComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeDagger();

    }

    /**
     * Initialize {@link AppComponent}
     *
     */
    private void initializeDagger(){

        mNewsComponent = DaggerNewsComponent.builder().appComponent(DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build()).newsModule(new NewsModule()).
                build();

    }

    public static NewsComponent getNewsComponent() {
        return mNewsComponent;
    }


}
