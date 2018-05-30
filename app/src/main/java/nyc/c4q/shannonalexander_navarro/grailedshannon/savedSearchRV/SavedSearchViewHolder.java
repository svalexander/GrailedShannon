package nyc.c4q.shannonalexander_navarro.grailedshannon.savedSearchRV;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.shannonalexander_navarro.grailedshannon.R;
import nyc.c4q.shannonalexander_navarro.grailedshannon.models.SavedSearchData;

/**
 * Created by shannonalexander-navarro on 5/27/18.
 */

public class SavedSearchViewHolder extends RecyclerView.ViewHolder {

    private TextView nameTV;
    private ImageView imageView;

    public SavedSearchViewHolder(View itemView) {
        super(itemView);
        nameTV = itemView.findViewById(R.id.article_title);
        imageView = itemView.findViewById(R.id.article_imageView);
    }

    public void bind(SavedSearchData data) {

        nameTV.setText(data.getName());

        String url = data.getImage_url();
        Picasso.with(itemView.getContext()).load(url).into(imageView);
    }
}
