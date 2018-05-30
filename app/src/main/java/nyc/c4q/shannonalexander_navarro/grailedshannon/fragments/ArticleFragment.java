package nyc.c4q.shannonalexander_navarro.grailedshannon.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.grailedshannon.articleRV.ArticleAdapter;
import nyc.c4q.shannonalexander_navarro.grailedshannon.R;
import nyc.c4q.shannonalexander_navarro.grailedshannon.models.ArticleResponse;
import nyc.c4q.shannonalexander_navarro.grailedshannon.models.Data;
import nyc.c4q.shannonalexander_navarro.grailedshannon.models.Pagination;
import nyc.c4q.shannonalexander_navarro.grailedshannon.network.ArticleService;
import nyc.c4q.shannonalexander_navarro.grailedshannon.network.GrailedNetwork;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shannonalexander-navarro on 5/26/18.
 */

public class ArticleFragment extends Fragment {

    private RecyclerView rv;
    private ArticleAdapter articleAdapter;
    private List<Data> articlesToDisplay = new ArrayList<>();
    private ArticleService articleService = GrailedNetwork.createArticleService();
    private Button previousBtn, nextBtn;
    int currentPg = 1;
    private Pagination pagination;
    private String nextPage, prevPage;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.article_fragment, container, false);

        initRV(root);
        initViews(root);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();

        callForArticles();
    }

    private void initRV(View root) {

        rv = root.findViewById(R.id.article_rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        articleAdapter = new ArticleAdapter(articlesToDisplay);
        rv.setAdapter(articleAdapter);
    }

    private void initViews(View view) {
        previousBtn = view.findViewById(R.id.btn1);
        nextBtn = view.findViewById(R.id.btn2);
        progressBar = getActivity().findViewById(R.id.progressBar);

    }

    private int determinePageNumber() {

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPg > 1) {

                    prevPage = pagination.getPrevious_page();
                    String sub = prevPage.substring(prevPage.indexOf("=") + 1);
                    currentPg = Integer.parseInt(sub);

                    callForArticles();
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nextPage = pagination.getNext_page();
                String sub = nextPage.substring(nextPage.indexOf("=") + 1);
                currentPg = Integer.parseInt(sub);

                callForArticles();
            }
        });

        return currentPg;
    }

    private void callForArticles() {

        progressBar.setVisibility(View.VISIBLE);

        int pg = determinePageNumber();

        Call<ArticleResponse> dataCall = articleService.getArticles(pg);
        dataCall.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {

                ArticleResponse articleResponse = response.body();

                List<Data> dataResponse = articleResponse.getdata();
                articlesToDisplay.clear();
                articlesToDisplay.addAll(dataResponse);
                articleAdapter.notifyDataSetChanged();

                pagination = articleResponse.getMetadata().getPagination();

                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.INVISIBLE);
                    Log.d("success?", articleResponse.toString());
                } else {
                    Log.d("failure", response.errorBody().toString() + "");
                }
            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {

            }
        });

    }
}
