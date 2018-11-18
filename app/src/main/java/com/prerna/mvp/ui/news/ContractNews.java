package com.prerna.mvp.ui.news;

import android.content.Context;

import com.prerna.mvp.data.local.entities.ArticleEntity;
import com.prerna.mvp.ui.base.IBaseView;

import java.util.List;

/**
 * Created by prernaakumaree on 18/11/2018
 * prernaakumaree@gmail.com
 */

public interface ContractNews {

    interface ContractPresenter{

        void getArticles(Context context);

        void getArticlesFromApi();

        void getArticleFromDb();

        void saveArticles(List<ArticleEntity> items);

    }

    interface ContractView extends IBaseView {

        void onArtilesReady(List<ArticleEntity> items);

    }
}
