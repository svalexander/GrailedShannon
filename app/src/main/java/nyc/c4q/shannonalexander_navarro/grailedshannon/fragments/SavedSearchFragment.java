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
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.grailedshannon.R;
import nyc.c4q.shannonalexander_navarro.grailedshannon.savedSearchRV.SavedSearchAdapter;
import nyc.c4q.shannonalexander_navarro.grailedshannon.models.SavedSearchData;
import nyc.c4q.shannonalexander_navarro.grailedshannon.models.SavedSearchResponse;
import nyc.c4q.shannonalexander_navarro.grailedshannon.network.ArticleService;
import nyc.c4q.shannonalexander_navarro.grailedshannon.network.GrailedNetwork;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shannonalexander-navarro on 5/26/18.
 */

public class SavedSearchFragment extends Fragment {

    private RecyclerView savedSearchRV;
    private SavedSearchAdapter savedSearchAdapter;
    private List<SavedSearchData> savedSearchToDisplay = new ArrayList<>();
    private ArticleService articleService = GrailedNetwork.createArticleService();
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.saved_search_fragment, container, false);

        progressBar = getActivity().findViewById(R.id.progressBar);

        initRV(root);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();

        callForArticles();
    }

    private void initRV(View root) {

        savedSearchRV = root.findViewById(R.id.saved_search_rv);
        savedSearchRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        savedSearchAdapter = new SavedSearchAdapter(savedSearchToDisplay);
        savedSearchRV.setAdapter(savedSearchAdapter);
    }

    private void callForArticles() {

        progressBar.setVisibility(View.VISIBLE);

        Call<SavedSearchResponse> dataCall = articleService.getSavedSearches();
        dataCall.enqueue(new Callback<SavedSearchResponse>() {
            @Override
            public void onResponse(Call<SavedSearchResponse> call, Response<SavedSearchResponse> response) {
                SavedSearchResponse savedSearchResponse = response.body();

                List<SavedSearchData> dataResponse = savedSearchResponse.getData();
                savedSearchToDisplay.clear();
                savedSearchToDisplay.addAll(dataResponse);
                savedSearchAdapter.notifyDataSetChanged();

                if (response.isSuccessful()) {
                    Log.d("success?", savedSearchResponse.toString());
                    progressBar.setVisibility(View.INVISIBLE);
                } else {
                    Log.d("failure", response.errorBody().toString() + "");
                }
            }

            @Override
            public void onFailure(Call<SavedSearchResponse> call, Throwable t) {

            }
        });

    }
}
