package e.par.connectingmist_30.Club_activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MCCPageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    MCCPageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MCCEventsFragment();
            case 1:
                return new MCCNewsFragment();
            case 2:
                return new MCCStatusFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}

