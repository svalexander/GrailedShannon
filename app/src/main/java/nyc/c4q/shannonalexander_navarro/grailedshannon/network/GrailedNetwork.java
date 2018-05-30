package nyc.c4q.shannonalexander_navarro.grailedshannon.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shannonalexander-navarro on 5/26/18.
 */

public class GrailedNetwork {

    static final String BASE_URL = "https://www.grailed.com/";

    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ArticleService createArticleService(){

        ArticleService articleService = retrofit.create(ArticleService.class);

        return  articleService;
    }

}
