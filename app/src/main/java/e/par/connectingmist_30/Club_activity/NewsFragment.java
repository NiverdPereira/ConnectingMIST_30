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

/**
 * A fragment with a Google +1 button.
 */
public class NewsFragment extends Fragment {

    int t;
    String[] news = { "News1", "News2", "News3", "News4", "News5","News6" };
    String[] mccnews = { "mccNews1", "mccNews2", "mccNews3", "mccNews4", "mccNews5","mccNews6" };
    String[] mlcnews = { "mlcNews1", "mlcNews2", "mlcNews3", "mlcNews4", "mlcNews5","mlcNews6" };
    String[] mrcnews = { "mrcNews1", "mrcNews2", "mrcNews3", "mrcNews4", "mrcNews5","mrcNews6" };
    String[] mdfsnews = { "mdfsNews1", "mdfsNews2", "mdfsNews3", "mdfsNews4", "mdfsNews5","mdfsNews6" };
    String[] mpsnews = { "mpsNews1", "mpsNews2", "mpsNews3", "mpsNews4", "mpsNews5","mpsNews6" };

    String[] mccdescriptions = { "Description1", "Description2", "Description3", "Description4", "Description5", "Description6" };
    String[] mlcdescriptions = { "Description1", "Description2", "Description3", "Description4", "Description5", "Description6" };
    String[] mdfsdescriptions = { "Description1", "Description2", "Description3", "Description4", "Description5", "Description6" };
    String[] mrcdescriptions = { "Description1", "Description2", "Description3", "Description4", "Description5", "Description6" };
    String[] mpsdescriptions = { "Description1", "Description2", "Description3", "Description4", "Description5", "Description6" };

    int[] images = { R.mipmap.ic_launcher_round };


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
            TextView txt2 = (TextView) v.findViewById(R.id.textView2);
            ImageView img = (ImageView) v.findViewById(R.id.imageView1);

            if(t==1)
            {
                txt1.setText(mccnews[position]);
                txt2.setText(mccdescriptions[position]);
            }
            else if(t==2)
            {
                txt1.setText(mlcnews[position] );
                txt2.setText(mlcdescriptions[position]);
            }
            else if(t==3)
            {
                txt1.setText( mdfsnews[position] );
                txt2.setText(mdfsdescriptions[position]);
            }
            else if(t==4)
            {
                txt1.setText( mrcnews[position] );
                txt2.setText(mrcdescriptions[position]);
            }
            else if(t==5)
            {
                txt1.setText( mpsnews[position] );
                txt2.setText(mpsdescriptions[position]);
            }

            img.setBackgroundResource(images[0]);
            return v;
        }
    }


}
