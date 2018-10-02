package e.par.connectingmist_30.Club_activity;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.Toast;

import e.par.connectingmist_30.R;

/**
 * A fragment with a Google +1 button.
 */
public class NewsFragment extends Fragment {

    int t;
    String[] news = new String[] { "News1", "News2", "News3", "News4", "News5","News6" };
    String[] mccnews = { "mccNews1", "mccNews2", "mccNews3", "mccNews4", "mccNews5","mccNews6" };
    String[] mlcnews = { "mlcNews1", "mlcNews2", "mlcNews3", "mlcNews4", "mlcNews5","mlcNews6" };
    String[] mrcnews = { "mrcNews1", "mrcNews2", "mrcNews3", "mrcNews4", "mrcNews5","mrcNews6" };
    String[] mdfsnews = { "mdfsNews1", "mdfsNews2", "mdfsNews3", "mdfsNews4", "mdfsNews5","mdfsNews6" };
    String[] mpsnews = { "mpsNews1", "mpsNews2", "mpsNews3", "mpsNews4", "mpsNews5","mpsNews6" };

    String[] mccdescriptions = { "Description1sdggggd,,,,,,,,,,,,,,,,,,,,,ssssssssssssssssssssssssssssssssss", "Description2", "Description3", "Description4", "Description5", "Description6" };
    String[] mlcdescriptions = { "Description1", "Description2", "Description3", "Description4", "Description5", "Description6" };
    String[] mdfsdescriptions = { "Description1", "Description2", "Description3", "Description4", "Description5", "Description6" };
    String[] mrcdescriptions = { "Description1", "Description2", "Description3", "Description4", "Description5", "Description6" };
    String[] mpsdescriptions = { "Description1", "Description2", "Description3", "Description4", "Description5", "Description6" };

    int[] images = { R.drawable.news };


    public NewsFragment() {
        // Required empty public constructor
    }
    public void setT(int t) {
        this.t = t;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mccnews, container, false);
        ListView li=(ListView)v.findViewById(R.id.listView1);
        li.setAdapter(new NewsFragment.Adapter(getActivity(),R.layout.mcceventadapter,news));

        li.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String msg= "";
                String head = "";
                if(t==1)
                {
                    head= head+mccnews[position];
                    msg=msg+mccdescriptions[position];
                }
                else if(t==2)
                {
                    head= head+mlcnews[position];
                    msg=msg+mlcdescriptions[position];
                }
                else if(t==3)
                {
                    head= head+mdfsnews[position];
                    msg=msg+mdfsdescriptions[position];
                }
                else if(t==4)
                {
                    head= head+mrcnews[position];
                    msg=msg+mrcdescriptions[position];
                }
                else if(t==5)
                {
                    head= head+mpsnews[position];
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

    /// adapter for list
    class Adapter extends ArrayAdapter {

        public Adapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=((Activity)getContext()).getLayoutInflater().inflate(R.layout.mcceventadapter,null);
            TextView txt1 = (TextView) v.findViewById(R.id.textView1);
            //TextView txt2 = (TextView) v.findViewById(R.id.textView2);
            ImageView img = (ImageView) v.findViewById(R.id.imageView1);

            if(t==1)
            {
                txt1.setText(mccnews[position]);
                //txt2.setText(mccdescriptions[position]);
            }
            else if(t==2)
            {
                txt1.setText(mlcnews[position] );
               // txt2.setText(mlcdescriptions[position]);
            }
            else if(t==3)
            {
                txt1.setText( mdfsnews[position] );
                //txt2.setText(mdfsdescriptions[position]);
            }
            else if(t==4)
            {
                txt1.setText( mrcnews[position] );
                //txt2.setText(mrcdescriptions[position]);
            }
            else if(t==5)
            {
                txt1.setText( mpsnews[position] );
                //txt2.setText(mpsdescriptions[position]);
            }

            img.setBackgroundResource(images[0]);
            return v;
        }


    }


}
