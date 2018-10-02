package e.par.connectingmist_30.Club_activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import e.par.connectingmist_30.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MCCStatusFragment extends Fragment {

    int t;
    public MCCStatusFragment() {
        // Required empty public constructor
    }
    public void setT(int t) {
        this.t = t;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate( R.layout.fragment_mccstatus, container, false);
        TextView tv= v.findViewById( R.id.tid );
        if(t==1)
        {
            tv.setText( "This is MIST Computer CLub" );
        }
        else if(t==2)
        {
            tv.setText( "This is MIST Literature  CLub" );
        }
        else if(t==3)
        {
            tv.setText( "This is MIST Drama Society" );
        }
        else if(t==4)
        {
            tv.setText( "This is MIST Robotics CLub" );
        }
        else if(t==5)
        {
            tv.setText( "This is MIST Photographic Society" );
        }
        return v;

    }

}
