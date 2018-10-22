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
public class StatusFragment extends Fragment {

    int t;
    public StatusFragment() {
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
            tv.setText( "Welcome to MIST Computer Club.\n" + "\n" + "Today’s world is now ruled by ‘COMPUTER’. To cope with this era, it is totally impossible without computer and its surrounding arena. In Bangladesh, today “Digital Bangladesh” is not a dream, it is the fact. So every people of Bangladesh should come forward to educate their selves is this aspect.\n" + "\n" + "Considering the above situation, from the very beginning MIST, specially CSE department had taken remarkable initiatives. Currently this department is continuing its journey with PhD, M.Sc and B.Sc. programs smoothly.  CSE department of MIST has seven modern and international level laboratories. As a result this department is offering different short courses for IT people regularly and also conducting different training programs for government organizations.\n"  );
        }
        else if(t==2)
        {
            tv.setText( "Welcome to MIST Literature Club.\n"+"On 19 April 1998, Military Institute of Science and Technology (MIST) have started its journey. From the very beginning, it was sincere to ensure not only the proper engineering and technological opportunities but also a good environment to take part in various extra-curricular activities. To make this environment more cooperative and to create an inspiring and sustainable platform for the MIST students, MIST Literature and Cultural Club was introduced.\n" + "\n" + "MIST Literature and Cultural Club is dedicated to create various opportunities to practice art and our culture via organizing various workshops, events.");
        }
        else if(t==3)
        {
            tv.setText( "Welcome to MIST Drama Society" );
        }
        else if(t==4)
        {
            tv.setText( "Mist Robotics Club mostly known as MRC is one of the most active Robotics club of the country established on 2003. Under the supervision of EECE department of MIST, this club grew soon to become one of the most prominent club in Bangladesh by arranging national level robotics competition and workshops.\n" + "\n" + "Mist Robotics Club aim to spread the enthusiasm of Robotics among students all throughout the country. The club regularly arranges routine classes and workshops among freshmen and has arranged festivals on the occasion of different days. MRC has since been glorified the institution as well by arranging National level competitions with huge success. MRC believes that beside the sincere efforts undertaken by MIST ensure proper engineering education the club can enhance a student’s caliber by making him interested in more practical works in such an aspiring line. Mist Robotics Club believes that MIST students can do wonders in this field as reflected by its motto,\n" + "“Soar High, Sky is the Limit”." );
        }
        else if(t==5)
        {
            tv.setText( "Welcome to Photographic Society" );
        }
        return v;

    }

}
