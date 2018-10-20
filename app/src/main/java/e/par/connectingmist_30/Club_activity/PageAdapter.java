package e.par.connectingmist_30.Club_activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;
    int st;
    ArrayList<Events>temp;
    ArrayList<Events> nn;

    PageAdapter(FragmentManager fm, int numOfTabs, int st, ArrayList<Events> temp, ArrayList<Events> nn) {
        super(fm);
        this.numOfTabs = numOfTabs;
        this.st=st;
        this.temp= temp;
        this.nn= nn;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                EventsFragment mf= new EventsFragment();
                mf.setT( st );
                mf.setAllevents( temp );
                return mf;
            case 1:
                NewsFragment nf= new NewsFragment();
                nf.setT( st );
                nf.setAllnews( nn );
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

