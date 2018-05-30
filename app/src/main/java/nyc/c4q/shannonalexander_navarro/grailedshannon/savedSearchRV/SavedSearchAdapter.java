package nyc.c4q.shannonalexander_navarro.grailedshannon.savedSearchRV;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.grailedshannon.R;
import nyc.c4q.shannonalexander_navarro.grailedshannon.models.SavedSearchData;

/**
 * Created by shannonalexander-navarro on 5/27/18.
 */

public class SavedSearchAdapter extends RecyclerView.Adapter<SavedSearchViewHolder> {

    private List<SavedSearchData> searchData = new ArrayList<>();

    public SavedSearchAdapter(List<SavedSearchData> savedSearchToDisplay) {

        this.searchData = savedSearchToDisplay;
    }

    @Override
    public SavedSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item_view, parent, false);
        return new SavedSearchViewHolder(root);
    }

    @Override
    public void onBindViewHolder(SavedSearchViewHolder holder, int position) {

        SavedSearchData data = searchData.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return searchData.size();
    }
}
