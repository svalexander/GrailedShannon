package nyc.c4q.shannonalexander_navarro.grailedshannon.articleRV;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.grailedshannon.R;
import nyc.c4q.shannonalexander_navarro.grailedshannon.models.Data;

/**
 * Created by shannonalexander-navarro on 5/26/18.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

   List<Data> articles = new ArrayList<>();

    public ArticleAdapter(List<Data> articlesToDisplay) {
        this.articles = articlesToDisplay;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item_view, parent, false);

        return new ArticleViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {

        Data data = articles.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {

        return articles.size();
    }
}
