package e.par.connectingmist_30;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import e.par.connectingmist_30.HomeCollection;
import e.par.connectingmist_30.Calender_view.Notice_cal;
import e.par.connectingmist_30.Newsfeed_Notice.NewsActivity;
import e.par.connectingmist_30.Newsfeed_Notice.NoticeActivity;

public class HomeActivity extends AppCompatActivity {
    private CardView newsfeed,location,notice,club,logout,nov;
    private ImageView iAdmin;
    private TextView tVerify;
    private SharedPreferences mPreferences;
    private DatabaseReference refDatabase;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private Toolbar mt;
    Button bt11;
    Button bt12;
    Handler handler;


    private ArrayList<NoticeInfo> allNotice;
    private ArrayList<Integer> mark;

    int tt;
    int[] p = new int[1];
    int[] sl= new int[1];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       // Intent j=getIntent();
       // startActivity(j);
        newsfeed=findViewById(R.id.feedCard);
        location=findViewById(R.id.locCard);
        notice=findViewById(R.id.noticeCard);
        club=findViewById(R.id.clubCard);
        tVerify=findViewById(R.id.tVerify);
        //iAdmin=findViewById(R.id.iAdmin);
        logout=findViewById(R.id.logout);
        nov=findViewById(R.id.nov);

        refDatabase= FirebaseDatabase.getInstance().getReference("Notice");
        allNotice = new ArrayList<>();
        mark = new ArrayList<>();

        mPreferences = getSharedPreferences( "Session", MODE_PRIVATE );
       // SharedPreferences.Editor editor = mPreferences.edit();
      // editor.putString( "date", "10/04/18" );
       // editor.commit();


//        bt12.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mPreferences = getSharedPreferences( "Session", MODE_PRIVATE );
//                SharedPreferences.Editor editor = mPreferences.edit();
//                editor.remove("count");
//                editor.putInt( "count", 0 );
//                editor.putInt( "prev", 0 );
//                editor.putInt( "flag", 0 );
//                editor.putInt( "flagm", 0 );
//
//                editor.commit();
//                allNotice.clear();
//            }
//        } );

//        bt11.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        } );

        tt=0;

        handler = new Handler();
        final int delay = 5000; //milliseconds

        handler.postDelayed(new Runnable(){
            public void run(){
                //do something
                tt=tt+1;
                //sendNotification( tt );
                notifi();
                handler.postDelayed(this, delay);
            }
        }, delay);


        user=FirebaseAuth.getInstance().getCurrentUser();
        if(user.isEmailVerified()){
            tVerify.setText("Welcome");

        }
        else{
            tVerify.setText("Please Verify. Click Here");
            tVerify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(HomeActivity.this,"Email sent",Toast.LENGTH_SHORT).show();
                            tVerify.setText("Welcome");
                        }
                    });
                }
            });
        }

        newsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!user.isEmailVerified()) Toast.makeText(HomeActivity.this,"Please verify Email",Toast.LENGTH_LONG).show();
                else {
                    Intent feedIntent = new Intent(HomeActivity.this, NewsActivity.class);
                    startActivity(feedIntent);
                }
            }
        });
        nov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!user.isEmailVerified()) Toast.makeText(HomeActivity.this,"Please verify Email",Toast.LENGTH_LONG).show();
                else {
                    Intent locIntent = new Intent(HomeActivity.this, SearchActivity.class);
                    startActivity(locIntent);
                }
            }
        });
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!user.isEmailVerified()) Toast.makeText(HomeActivity.this,"Please verify Email",Toast.LENGTH_LONG).show();
                else {
                    Intent noticeIntent = new Intent(HomeActivity.this, NoticeActivity.class);
                    startActivity(noticeIntent);
                }
            }
        });
        club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!user.isEmailVerified()) Toast.makeText(HomeActivity.this,"Please verify Email",Toast.LENGTH_LONG).show();
                else {
                    Intent clubIntent = new Intent(HomeActivity.this, ClubActivity.class);
                    startActivity(clubIntent);
                }
            }
        });
        /*iAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToInsertion();
            }
        });*/

        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this,dl,0,0);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.profile:
                        Intent pr= new Intent(HomeActivity.this,MyprofileActivity.class);
                        startActivity(pr);
                        break;
                    case R.id.home:
                        Intent hm = new Intent(HomeActivity.this,HomeActivity.class);
                        startActivity(hm);

                        /*Bundle bundle= new Bundle();
                        bundle.putString("url","https://www.twitter.com/android_hunger");*/

                        break;
                    case R.id.logout:
                        mPreferences = getSharedPreferences("Session", MODE_PRIVATE);
                        SharedPreferences.Editor editor = mPreferences.edit();
                        editor.clear();   // This will delete all your preferences, check how to delete just one
                        editor.commit();
                        Intent i= new Intent(HomeActivity.this,Login.class);
                        startActivity(i);
                        break;
                    case R.id.about:
                        Intent ab= new Intent(HomeActivity.this,AboutActivity.class);
                        startActivity(ab);
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }

    public void notifi()
    {
        getAlldataFromDB();
        Date now = new Date();
        Date current= new Date(  ),prevdate=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        String nowAsString = new SimpleDateFormat("MM/dd/yy").format(now);
        try {
            current = sdf.parse( nowAsString );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mPreferences = getSharedPreferences( "Session", MODE_PRIVATE );
        String st = mPreferences.getString("date", "");
        try {
            prevdate = sdf.parse( st );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String temp;
        Date d= new Date(  );
        int f=0;
        int fm=0;
        for(int i=0;i<allNotice.size();i++) {
            temp = allNotice.get( i ).getDate();
            try {
                d = sdf.parse( temp );
                //if(d.compareTo(prevdate) > 0 && mark.get( i )!=1 )
                if(mark.get(i).equals( 0 ))
                {
                    f++;
                   // startService(new Intent(getApplicationContext(), NotificationService.class));
                    sendNotification(f, allNotice.get( i ).headline.trim());
                    SharedPreferences.Editor editor = mPreferences.edit();
                    editor.putString( "date", nowAsString );


                    //mark.add( i,1 );
                    mark.set( i,1 );
                    editor.putInt( "flag", mark.get( i ) );
                    editor.commit();
                    //break;
                }
                else
                {
                    fm++;
                    SharedPreferences.Editor editor = mPreferences.edit();
                    editor.putInt( "flagm", fm );
                    editor.commit();
                }
            } catch (ParseException ex) {
            }
        }
    }

    public void sendNotification(int tt,String s) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this);
        //Create the intent that’ll fire when the user taps the notification//
        Intent intent = new Intent(this, NoticeActivity.class );
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.drawable.ic_launcher_background);
        mBuilder.setContentTitle("New Notice Added");
        mBuilder.setContentText("Tap to see "+tt+" new notice");
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(001, mBuilder.build());
    }
    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }

    private void getAlldataFromDB()
    {
        p[0]=0;

        refDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    NoticeInfo value= data.getValue(NoticeInfo.class);

                    int flg=0;
                    for(int i=0;i<allNotice.size();i++) {
                        if(allNotice.get( i ).getHeadline().trim().equals( value.getHeadline().trim() ))
                        {
                            flg=1;break;
                        }
                    }

                    if(flg==0)
                    {
                        allNotice.add( value );
                        mark.add( 0 );
                    }
                    p[0]++;
                }
                Toast.makeText(getApplicationContext(),"Invalid info",Toast.LENGTH_SHORT);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());

            }
        });

    }

    protected void goToInsertion()
    {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email1 = user.getEmail();
        Toast.makeText(this, email1, Toast.LENGTH_SHORT).show();
        if (user != null) {
            String email = user.getEmail();
            //String uid = user.getUid();
            if(email.equals("admin@mist.com")){
                Intent adminIntent=new Intent(HomeActivity.this,AdminMenuActivity.class);
                Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
                startActivity(adminIntent);
            }
        }

    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

}
