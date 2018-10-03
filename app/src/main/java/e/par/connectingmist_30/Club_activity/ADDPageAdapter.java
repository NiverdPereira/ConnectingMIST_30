package e.par.connectingmist_30.Club_activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ADDPageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
    int st;

    ADDPageAdapter(FragmentManager fm, int numOfTabs, int st) {
        super(fm);
        this.numOfTabs = numOfTabs;
        this.st=st;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AddEventFragment mf= new AddEventFragment();
                mf.setT( st );
                return mf;
            case 1:
                AddNewsFragment nf= new AddNewsFragment();
                nf.setT( st );
                return nf;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}

