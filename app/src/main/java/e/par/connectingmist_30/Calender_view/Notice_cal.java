package e.par.connectingmist_30.Calender_view;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import e.par.connectingmist_30.Calender_view.HomeCollection;
import e.par.connectingmist_30.NoticeInfo;
import e.par.connectingmist_30.R;

public class Notice_cal extends AppCompatActivity {
    public GregorianCalendar cal_month, cal_month_copy;
    private HwAdapter hwAdapter;
    private TextView tv_month;

    private DatabaseReference refDatabase;
    private ArrayList<NoticeInfo> allNotice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_cal);

        refDatabase= FirebaseDatabase.getInstance().getReference("Notice");

       // allNotice = getIntent().getParcelableExtra("mylist");
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        allNotice = (ArrayList<NoticeInfo>) args.getSerializable("ARRAYLIST");





       // HomeCollection.date_collection_arr = (ArrayList<HomeCollection >) getIntent().getSerializableExtra("mylist");
       // HomeCollection.date_collection_arr = getIntent().getParcelableExtra("mylist");


        HomeCollection.date_collection_arr=new ArrayList<HomeCollection>();

        for(int i=0;i<allNotice.size();i++)
        {
           //String head= allNotice.get( i ).gethead;
           String date= allNotice.get( i ).getDate();
            String detail= allNotice.get( i ).getDetails();
            HomeCollection.date_collection_arr.add( new HomeCollection("2018-10-08" ,detail,"Holiday"));
           // HomeCollection.date_collection_arr.add( new HomeCollection("2017-07-08" ,"Diwali","Holiday"));
           // HomeCollection.date_collection_arr.add( new HomeCollection("2017-07-08" ,"Diwali","Holiday"));
          //  HomeCollection.date_collection_arr.add( new HomeCollection("2017-07-08" ,"Diwali","Holiday"));
           // HomeCollection.date_collection_arr.add( new HomeCollection("2017-07-08" ,"Diwali","Holiday"));
        }
    //  HomeCollection.date_collection_arr.add( new HomeCollection("2017-07-08" ,"Diwali","Holiday","this is holiday"));
     //  HomeCollection.date_collection_arr.add( new HomeCollection("2017-07-08" ,"Holi","Holiday","this is holiday"));
      //  HomeCollection.date_collection_arr.add( new HomeCollection("2017-07-08" ,"Statehood Day","Holiday","this is holiday"));
      //  HomeCollection.date_collection_arr.add( new HomeCollection("2017-08-08" ,"Republic Unian","Holiday","this is holiday"));
       /// HomeCollection.date_collection_arr.add( new HomeCollection("2017-07-09" ,"ABC","Holiday","this is holiday"));
      //  HomeCollection.date_collection_arr.add( new HomeCollection("2017-06-15" ,"demo","Holiday","this is holiday"));
      //  HomeCollection.date_collection_arr.add( new HomeCollection("2017-09-26" ,"weekly off","Holiday","this is holiday"));
     //   HomeCollection.date_collection_arr.add( new HomeCollection("2018-01-08" ,"Events","Holiday","this is holiday"));
     //   HomeCollection.date_collection_arr.add( new HomeCollection("2018-01-16" ,"Dasahara","Holiday","this is holiday"));
     //   HomeCollection.date_collection_arr.add( new HomeCollection("2018-02-09" ,"Christmas","Holiday","this is holiday"));
        cal_month = (GregorianCalendar) GregorianCalendar.getInstance();
        cal_month_copy = (GregorianCalendar) cal_month.clone();
        hwAdapter = new HwAdapter(this, cal_month,HomeCollection.date_collection_arr);

        tv_month = (TextView) findViewById(R.id.tv_month);
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));


        ImageButton previous = (ImageButton) findViewById(R.id.ib_prev);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if (cal_month.get(GregorianCalendar.MONTH) == 4&&cal_month.get(GregorianCalendar.YEAR)==2017) {
                //cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1), cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);
                // Toast.makeText(MainActivity.this, "Event Detail is available for current session only.", Toast.LENGTH_SHORT).show();
                // }
                // else {
                setPreviousMonth();
                refreshCalendar();
                //}


            }
        });
        ImageButton next = (ImageButton) findViewById(R.id.Ib_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  if (cal_month.get(GregorianCalendar.MONTH) == 5&&cal_month.get(GregorianCalendar.YEAR)==2018) {
                //cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
                // Toast.makeText(MainActivity.this, "Event Detail is available for current session only.", Toast.LENGTH_SHORT).show();
                // }
                // else {
                setNextMonth();
                refreshCalendar();
                //}
            }
        });
        GridView gridview = (GridView) findViewById(R.id.gv_calendar);
        gridview.setAdapter(hwAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String selectedGridDate = HwAdapter.day_string.get(position);
                ((HwAdapter) parent.getAdapter()).getPositionList(selectedGridDate, Notice_cal.this);
            }

        });
    }


    private void getAlldataFromDB()
    {
        refDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    NoticeInfo value= data.getValue(NoticeInfo.class);
                    allNotice.add(value);
                }
                Toast.makeText(getApplicationContext(),"Invalid info",Toast.LENGTH_SHORT);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());

            }
        });

    }

    protected void setNextMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMaximum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH,
                    cal_month.get(GregorianCalendar.MONTH) + 1);
        }
    }

    protected void setPreviousMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMinimum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1), cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH, cal_month.get(GregorianCalendar.MONTH) - 1);
        }
    }

    public void refreshCalendar() {
        hwAdapter.refreshDays();
        hwAdapter.notifyDataSetChanged();
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));
    }
}
