package e.par.connectingmist_30;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends BaseAdapter {

    private Context activity;
    private ArrayList<NewsInfo> allNews = new ArrayList<>();
    private LayoutInflater layoutInflater = null;

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
            viewHolder.dept=view.findViewById(R.id.tAuthor);
            viewHolder.name=view.findViewById(R.id.tHeader);
            viewHolder.roll=view.findViewById(R.id.tDate);
            viewHolder.email=view.findViewById(R.id.tContent);
            view.setTag(viewHolder);
        }
        else{

            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.name.setText(allNews.get(pos).getName());
        viewHolder.roll.setText(allNews.get(pos).getRoll());
        viewHolder.email.setText(allNews.get(pos).getEmail());
        viewHolder.dept.setText(allNews.get(pos).getDept());
        return view;
    }
    private static class ViewHolder{
        TextView dept,email,name,roll,session;
    }
    private ViewHolder viewHolder = null;
}
