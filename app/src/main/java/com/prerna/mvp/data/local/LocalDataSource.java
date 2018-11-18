package com.prerna.mvp.data.local;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.prerna.mvp.data.local.dao.ArticleDao;
import com.prerna.mvp.data.local.entities.ArticleEntity;

import javax.inject.Singleton;

/**
 * Created by prernaakumaree on 18/11/2018
 * prernaakumaree@gmail.com
 */

@Singleton
@Database(entities = ArticleEntity.class, version = 1)
public abstract class LocalDataSource extends RoomDatabase {

    public abstract ArticleDao getArticleDao();

}

