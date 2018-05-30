package nyc.c4q.shannonalexander_navarro.grailedshannon.network;

import nyc.c4q.shannonalexander_navarro.grailedshannon.models.ArticleResponse;
import nyc.c4q.shannonalexander_navarro.grailedshannon.models.SavedSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shannonalexander-navarro on 5/26/18.
 */

public interface ArticleService {

    @GET("api/articles/ios_index")
    Call<ArticleResponse> getArticles(@Query("page") int page);

    @GET("api/merchandise/marquee")
    Call<SavedSearchResponse> getSavedSearches();

}
