package nyc.c4q.shannonalexander_navarro.grailedshannon;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import nyc.c4q.shannonalexander_navarro.grailedshannon.fragments.ArticleFragment;
import nyc.c4q.shannonalexander_navarro.grailedshannon.fragments.SavedSearchFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPageAdapter viewPageAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createViewPager();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void createViewPager() {

        viewPager = findViewById(R.id.view_pager);
        viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPageAdapter);

        viewPageAdapter.addFragment(new ArticleFragment());
        viewPageAdapter.addFragment(new SavedSearchFragment());


        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public void onBackPressed() {

        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }

    }

}
