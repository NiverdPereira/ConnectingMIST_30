package e.par.connectingmist_30.Club_activity;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import e.par.connectingmist_30.R;


public class EventsFragment extends Fragment {

    int t;

    String[] events = { "Event1", "Event2", "Event3", "Event4", "Event5","Event6" };
    String[] mccevents = { "mccEvent1", "mccEvent2", "mccEvent3", "mccEvent4", "mccEvent5","mccEvent6" };
    String[] mlcevents = { "mlcEvent1", "mlcEvent2", "mlcEvent3", "mlcEvent4", "mlcEvent5","mlcEvent6" };
    String[] mdfsevents = { "mdfsEvent1", "mdfsEvent2", "mdfsEvent3", "mdfsEvent4", "mdfsEvent5","mdfsEvent6" };
    String[] mrcevents = { "mrcEvent1", "mrcEvent2", "mrcEvent3", "mrcEvent4", "mrcEvent5","mrcEvent6" };
    String[] mpsevents = { "mpsEvent1", "mpsEvent2", "mpsEvent3", "mpsEvent4", "mpsEvent5","mpsEvent6" };

    String[] mccdescriptions = { "Description1", "Description2", "Description3", "Description4", "Description5", "Description6" };
    String[] mlcdescriptions = { "Description1", "Description2", "Description3", "Description4", "Description5", "Description6" };
    String[] mdfsdescriptions = { "Description1", "Description2", "Description3", "Description4", "Description5", "Description6" };
    String[] mrcdescriptions = { "Description1", "Description2", "Description3", "Description4", "Description5", "Description6" };
    String[] mpsdescriptions = { "Description1", "Description2", "Description3", "Description4", "Description5", "Description6" };
    int[] images = { R.drawable.event };

    public EventsFragment() {
        // Required empty public constructor
    }

    public void setT(int t) {
        this.t = t;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       /* View rootView = inflater.inflate( R.layout.fragment_events,
                container, false);

        ListView listview = (ListView) rootView.findViewById(R.id.listView1);
       String[] items = new String[] { "Item 1", "Item 2", "Item 3" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, items);
        listview.setAdapter(adapter);
        return rootView;*/

        View v = inflater.inflate(R.layout.fragment_mccevents, container, false);
        ListView li=(ListView)v.findViewById(R.id.listView1);
        li.setAdapter(new Adapter(getActivity(), R.layout.mcceventadapter,events));

        li.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String msg= "";
                String head = "";
                if(t==1)
                {
                    head= head+mccevents[position];
                    msg=msg+mccdescriptions[position];
                }
                else if(t==2)
                {
                    head= head+mlcevents[position];
                    msg=msg+mlcdescriptions[position];
                }
                else if(t==3)
                {
                    head= head+mdfsevents[position];
                    msg=msg+mdfsdescriptions[position];
                }
                else if(t==4)
                {
                    head= head+mrcevents[position];
                    msg=msg+mrcdescriptions[position];
                }
                else if(t==5)
                {
                    head= head+mpsevents[position];
                    msg=msg+mpsdescriptions[position];
                }
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


    class Adapter extends ArrayAdapter {

        public Adapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=((Activity)getContext()).getLayoutInflater().inflate(R.layout.mcceventadapter,null);
            TextView txt1 = (TextView) v.findViewById(R.id.textView1);
           // TextView txt2 = (TextView) v.findViewById(R.id.textView2);
            ImageView img = (ImageView) v.findViewById(R.id.imageView1);

            if(t==1)
            {
                txt1.setText(mccevents[position]);
                //txt2.setText(mccdescriptions[position]);
            }
            else if(t==2)
            {
                txt1.setText( mlcevents[position] );
                //txt2.setText(mlcdescriptions[position]);
            }
            else if(t==3)
            {
                txt1.setText( mdfsevents[position] );
                //txt2.setText(mdfsdescriptions[position]);
            }
            else if(t==4)
            {
                txt1.setText( mrcevents[position] );
                //txt2.setText(mrcdescriptions[position]);
            }
            else if(t==5)
            {
                txt1.setText( mpsevents[position] );
                //txt2.setText(mpsdescriptions[position]);
            }




            img.setBackgroundResource(images[0]);
            return v;
        }
    }




}
