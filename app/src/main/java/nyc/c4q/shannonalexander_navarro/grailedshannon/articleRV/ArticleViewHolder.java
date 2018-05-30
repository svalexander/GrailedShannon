package nyc.c4q.shannonalexander_navarro.grailedshannon.articleRV;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

import nyc.c4q.shannonalexander_navarro.grailedshannon.R;
import nyc.c4q.shannonalexander_navarro.grailedshannon.models.Data;

/**
 * Created by shannonalexander-navarro on 5/26/18.
 */

public class ArticleViewHolder extends ViewHolder {

    private TextView articleTitle, articleDate;
    private ImageView articleImage;
    private String formattedDate;

    public ArticleViewHolder(View itemView) {
        super(itemView);

        articleTitle = itemView.findViewById(R.id.article_title);
        articleDate = itemView.findViewById(R.id.article_date);
        articleImage = itemView.findViewById(R.id.article_imageView);
    }

    public void bind(Data data) {

        articleTitle.setText(data.getTitle());

        formatDate(data);
        articleDate.setText(formattedDate);

        String imgUrl = data.getHero();

        Picasso.with(itemView.getContext()).load(imgUrl).into(articleImage);
    }

    private void formatDate(Data data) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        Date date = data.getPublished_at();
        formattedDate = simpleDateFormat.format(date);
    }
}
