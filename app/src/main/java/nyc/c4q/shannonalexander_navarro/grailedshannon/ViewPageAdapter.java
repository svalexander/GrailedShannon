package nyc.c4q.shannonalexander_navarro.grailedshannon;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shannonalexander-navarro on 5/26/18.
 */

public class ViewPageAdapter extends FragmentPagerAdapter {

    List<Fragment> frags = new ArrayList<>();
    List<String> fragTitles = new ArrayList<>();

    public ViewPageAdapter(FragmentManager fm) {
        super(fm);

        fragTitles.add("Articles");
        fragTitles.add("Saved Searches");
    }

    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragTitles.get(position);
    }

    public void addFragment(Fragment fragment) {

        frags.add(fragment);
    }
}
