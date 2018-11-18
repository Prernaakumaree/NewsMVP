package com.prerna.mvp.data.remote;

import com.prerna.mvp.data.remote.model.News;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by prernaakumaree on 18/04/2018.
 * prernaakumaree@gmail.com
 */

public interface RemoteService {

    @GET(".")
    Flowable<Response<News>> getArticleFroimApi();
}
