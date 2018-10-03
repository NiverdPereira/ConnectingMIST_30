package e.par.connectingmist_30;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoticeAdapter extends BaseAdapter {
    private Context activity;
    private ArrayList<NoticeInfo> allNotice = new ArrayList<>();
    private LayoutInflater layoutInflater = null;

    public NoticeAdapter(Context activity, ArrayList<NoticeInfo> allNotice) {
        this.activity = activity;
        this.allNotice = allNotice;
        this.layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        final int pos=i;
        if(view==null){
            viewHolder=new NoticeAdapter.ViewHolder();
            view=layoutInflater.inflate(R.layout.notice_item_style,null);
            viewHolder.details=view.findViewById(R.id.tDetail);
            viewHolder.date=view.findViewById(R.id.tDate);

            view.setTag(viewHolder);
        }
        else{

            viewHolder= (NoticeAdapter.ViewHolder) view.getTag();
        }
        viewHolder.details.setText(allNotice.get(pos).getDetails());
        viewHolder.date.setText(allNotice.get(pos).getDate());

        return view;
    }
    private static class ViewHolder{
        TextView date,details;
    }
    private NoticeAdapter.ViewHolder viewHolder = null;
}
