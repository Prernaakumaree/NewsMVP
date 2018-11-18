package com.prerna.mvp.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.prerna.mvp.data.local.entities.ArticleEntity;

import java.util.List;

import io.reactivex.Flowable;


/**
 * Created by prernaakumaree on 18/11/2018
 * prernaakumaree@gmail.com
 */

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM article")
    Flowable<List<ArticleEntity>> getArticlesFromDb();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveArticles(List<ArticleEntity> items);

    @Query("DELETE FROM article")
    void deleteArticles();
}
