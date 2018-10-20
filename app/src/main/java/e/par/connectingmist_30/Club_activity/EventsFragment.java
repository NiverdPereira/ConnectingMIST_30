package e.par.connectingmist_30.Club_activity;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

import e.par.connectingmist_30.NewsAdapter;
import e.par.connectingmist_30.NewsInfo;
import e.par.connectingmist_30.Newsfeed_Notice.NewsActivity;
import e.par.connectingmist_30.R;


public class EventsFragment extends Fragment {

    int t;

    private ArrayList<Events> allevents;
    private DatabaseReference refDatabase;


    int[] images = { R.drawable.event };

    public EventsFragment() {
        // Required empty public constructor
    }

    public void setT(int t) {
        this.t = t;
    }

    public void setAllevents(ArrayList<Events> allevents) {
        this.allevents = allevents;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_mccevents, container, false);
        ListView li=(ListView)v.findViewById(R.id.listView1);


        if(t==1)
        {

            refDatabase= FirebaseDatabase.getInstance().getReference("MCC_Events");
        }
        else if(t==2)
        {
            refDatabase= FirebaseDatabase.getInstance().getReference("MLC_Events");
        }
        else if(t==3)
        {
            refDatabase= FirebaseDatabase.getInstance().getReference("MDFS_Events");
        }
        else if(t==4)
        {
            refDatabase= FirebaseDatabase.getInstance().getReference("MRC_Events");
        }
        else if(t==5)
        {
            refDatabase= FirebaseDatabase.getInstance().getReference("MPS_Events");
        }
       // getAlldataFromDB();
        Adapter adapter = new Adapter(getContext(),R.layout.mcceventadapter, allevents);
        li.setAdapter(adapter);

       // Toast.makeText(getContext(), "Done",Toast.LENGTH_SHORT).show();

        li.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String msg= "";
                String head = "";
                head= head+allevents.get( position ).headline.trim();
                msg=msg+allevents.get( position ).content;
                openDialog(head,msg);
            }
        });
        return v;
    }



    public void openDialog(String head,String msg1) {

        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
        // Set Custom Title
        TextView title = new TextView(getContext());
        // Title Properties
        title.setText(head);
        title.setPadding(10, 10, 10, 10);   // Set Position
        title.setGravity(Gravity.CENTER);
        title.setTextColor(Color.BLACK);
        title.setTextSize(20);
        alertDialog.setCustomTitle(title);
        // Set Message
        TextView msg = new TextView(getContext());
        // Message Properties
        msg.setText(msg1);
        msg.setGravity(Gravity.CENTER_HORIZONTAL);
        msg.setTextColor(Color.BLACK);
        alertDialog.setView(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Perform Action on Button
            }
        });
        new Dialog(getContext());
        alertDialog.show();
        final Button okBT = alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
        LinearLayout.LayoutParams neutralBtnLP = (LinearLayout.LayoutParams) okBT.getLayoutParams();
        neutralBtnLP.gravity = Gravity.FILL_HORIZONTAL;
        okBT.setPadding(500, 10, 10, 10);   // Set Position
        okBT.setTextColor(Color.BLUE);
        okBT.setLayoutParams(neutralBtnLP);
    }

    public class Adapter extends ArrayAdapter<Events> {

        public Adapter(Context context,int resource, ArrayList<Events> users) {
            super(context, resource, users);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Events user = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.mcceventadapter, parent, false);
            }
            // Lookup view for data population
            TextView tvHeading = (TextView) convertView.findViewById(R.id.textView1);
            TextView tvdate = (TextView) convertView.findViewById(R.id.textView2);
            ImageView img = (ImageView) convertView.findViewById(R.id.imageView1);
            //TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
            // Populate the data into the template view using the data object
            tvHeading.setText(user.headline.trim());
            tvdate.setText(user.date);
            img.setBackgroundResource(images[0]);
            //tvHome.setText(user.hometown);
            // Return the completed view to render on screen
            return convertView;
        }
    }

    private void getAlldataFromDB()
    {
        refDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    Events value= data.getValue(Events.class);
                    allevents.add(value);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });
    }
}
