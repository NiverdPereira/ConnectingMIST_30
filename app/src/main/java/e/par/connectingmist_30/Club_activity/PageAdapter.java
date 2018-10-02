package e.par.connectingmist_30.Club_activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
    int st;

    PageAdapter(FragmentManager fm, int numOfTabs, int st) {
        super(fm);
        this.numOfTabs = numOfTabs;
        this.st=st;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                EventsFragment mf= new EventsFragment();
                mf.setT( st );
                return mf;
            case 1:
                NewsFragment nf= new NewsFragment();
                nf.setT( st );
                return nf;
            case 2:
                StatusFragment sf= new StatusFragment();
                sf.setT( st );
                return sf;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}

