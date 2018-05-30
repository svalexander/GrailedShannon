package nyc.c4q.shannonalexander_navarro.grailedshannon.models;

import java.util.List;

/**
 * Created by shannonalexander-navarro on 5/26/18.
 */

public class ArticleResponse {

    private Metadata metadata;
    private List<Data> data;

    public List<Data> getdata() {
        return data;
    }

    public Metadata getMetadata() {
        return metadata;
    }

}
