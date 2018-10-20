package e.par.connectingmist_30.Club_activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import e.par.connectingmist_30.Calender_view.Notice_cal;
import e.par.connectingmist_30.ClubActivity;
import e.par.connectingmist_30.Newsfeed_Notice.NoticeActivity;
import e.par.connectingmist_30.R;

public class ClubDetailActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter MCCPageAdapter;
    TabItem tabChats;
    TabItem tabStatus;
    TabItem tabCalls;
    Button ov;
    FloatingActionButton floatingActionButton;
    ArrayList<String > d,h,de;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_club_mcc );

        final ArrayList<Events>ev;
        final ArrayList<Events>ne;
        Bundle bo= getIntent().getExtras();
        ev = (ArrayList<Events>)bo.getSerializable( "events" ) ;
        ne = (ArrayList<Events>) bo.getSerializable( "news" );
        d = new ArrayList<>();
        h = new ArrayList<>();
        de = new ArrayList<>();
        for(int i=0;i<ev.size();i++)
        {
            d.add( ev.get( i ).getDate() );
            h.add( ev.get( i ).getHeadline() );
            de.add( ev.get( i ).getContent() );
        }



        toolbar =  findViewById(R.id.toolbar);

        ov= findViewById( R.id.ov );
        floatingActionButton =  findViewById(R.id.floatingActionButton);
        Intent mIntent = getIntent();
        final int intValue = mIntent.getIntExtra("VariableName", 0);

        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        //toolbar.setTitle(getResources().getString(R.string.app_name));
        if(intValue==1)
            toolbar.setTitle("Mist Computer Club");
        else if(intValue==2)
            toolbar.setTitle("Mist Literature Club");
        else if(intValue==3)
            toolbar.setTitle("Mist Drama and Film Society");
        else if(intValue==4)
            toolbar.setTitle("Mist Robotics Club");
        else if(intValue==5)
            toolbar.setTitle("Mist Photographic Society");

        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        //}
//        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tablayout);
        tabChats = findViewById(R.id.tabChats);
        tabStatus = findViewById(R.id.tabStatus);
        tabCalls = findViewById(R.id.tabCalls);
        viewPager = findViewById(R.id.viewPager);



        MCCPageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount(),intValue,ev,ne);
        viewPager.setAdapter( MCCPageAdapter );

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                /*if(tab.getPosition() == 1)
                {
                    toolbar.setBackgroundColor(ContextCompat.getColor(ClubDetailActivity.this, R.color.colorAccent));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(ClubDetailActivity.this , R.color.colorAccent));

                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    {
                        getWindow().setStatusBarColor(ContextCompat.getColor(ClubDetailActivity.this,R.color.colorAccent));
                    }
                }
                else if(tab.getPosition() == 2)
                {
                    toolbar.setBackgroundColor(ContextCompat.getColor(ClubDetailActivity.this, R.color.colorPrimary));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(ClubDetailActivity.this , R.color.colorPrimary));

                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    {
                        getWindow().setStatusBarColor(ContextCompat.getColor(ClubDetailActivity.this,R.color.colorPrimary));
                    }
                }
                else if(tab.getPosition() == 3)
                {*/
                toolbar.setBackgroundColor( ContextCompat.getColor(ClubDetailActivity.this, R.color.colorPrimaryDark));
                tabLayout.setBackgroundColor(ContextCompat.getColor(ClubDetailActivity.this , R.color.colorPrimaryDark));

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    getWindow().setStatusBarColor(ContextCompat.getColor(ClubDetailActivity.this,R.color.colorPrimaryDark));
                }
                //}
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        ov.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //if(intValue==1)
                //{

                     Intent feedIntent=new Intent(ClubDetailActivity.this, Notice_cal.class);
                     feedIntent.putExtra( "com",intValue );
                     feedIntent.putStringArrayListExtra( "date",d );
                     feedIntent.putStringArrayListExtra( "head",h );
                     feedIntent.putStringArrayListExtra( "detail",de );
                     startActivity( feedIntent );

//                }
//                else if(intValue==2)
//                {
//                    toolbar.setTitle("Mist Literature Club");
//                }
//                else if(intValue==3)
//                {
//                    toolbar.setTitle("Mist Drama and Film Society");
//                }
//                else if(intValue==4)
//                {
//                    toolbar.setTitle("Mist Robotics Club");
//                }
//                else if(intValue==5)
//                {
//                    toolbar.setTitle("Mist Photographic Society");
//                }
            }
        } );


        floatingActionButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );
    }

}
