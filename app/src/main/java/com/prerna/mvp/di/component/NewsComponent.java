package com.prerna.mvp.di.component;

import com.prerna.mvp.di.module.NewsModule;
import com.prerna.mvp.di.scope.NewsScope;
import com.prerna.mvp.ui.news.NewsActivity;

import dagger.Component;

/**
 * Created by prernaakumaree on 26/04/2018.
 * prernaakumaree@gmail.com
 */

@NewsScope
@Component(modules = {NewsModule.class}, dependencies = {AppComponent.class})
public interface NewsComponent {

    void inject(NewsActivity view);
}
