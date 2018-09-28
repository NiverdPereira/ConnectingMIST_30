package e.par.connectingmist_30.Club_activity;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import e.par.connectingmist_30.R;


public class MCCEventsFragment extends Fragment {


    String[] names = { "Event1", "Event2", "Event3", "Event4", "Event5","Event6" };
    String[] locations = { "Description1", "Description2", "Description3", "Description4",
            "Description5", "Description6" };
    int[] images = { R.mipmap.ic_launcher_round };

    public MCCEventsFragment() {
        // Required empty public constructor
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
        li.setAdapter(new Adapter(getActivity(), R.layout.mcceventadapter,names));
        return v;
    }


    class Adapter extends ArrayAdapter {

        public Adapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=((Activity)getContext()).getLayoutInflater().inflate(R.layout.mcceventadapter,null);
            TextView txt1 = (TextView) v.findViewById(R.id.textView1);
            txt1.setText(names[position]);
            TextView txt2 = (TextView) v.findViewById(R.id.textView2);
            txt2.setText(locations[position]);
            ImageView img = (ImageView) v.findViewById(R.id.imageView1);
            img.setBackgroundResource(images[0]);
            return v;
        }
    }




}
