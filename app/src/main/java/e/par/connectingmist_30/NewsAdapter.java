package e.par.connectingmist_30;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class NewsAdapter extends BaseAdapter {

    private Context activity;
    private ArrayList<NewsInfo> allNews = new ArrayList<>();
    private LayoutInflater layoutInflater = null;

    private SharedPreferences mPreferences;

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private Toolbar mt;

    public NewsAdapter(Context activity, ArrayList<NewsInfo> allNews) {
        this.activity = activity;
        this.allNews = allNews;
        this.layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return allNews.size();
    }

    @Override
    public Object getItem(int i) {
        return allNews.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos=i;
        if(view==null){
            viewHolder=new ViewHolder();
            view=layoutInflater.inflate(R.layout.feed_item_style,null);
            viewHolder.author=view.findViewById(R.id.tAuthor);
            viewHolder.headline=view.findViewById(R.id.tHeader);
            viewHolder.date=view.findViewById(R.id.tDate);
            viewHolder.content=view.findViewById(R.id.tContent);
            view.setTag(viewHolder);
        }
        else{

            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.author.setText(allNews.get(pos).getAuthor());
        viewHolder.content.setText(allNews.get(pos).getContent());
        viewHolder.date.setText(allNews.get(pos).getDate());
        viewHolder.headline.setText(allNews.get(pos).getHeadline());
        return view;
    }
    private static class ViewHolder{
        TextView author,content,date,headline;
    }
    private ViewHolder viewHolder = null;
}
