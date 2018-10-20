package e.par.connectingmist_30;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import e.par.connectingmist_30.Club_activity.ClubDetailActivity;
import e.par.connectingmist_30.Club_activity.Events;

public class ClubActivity extends AppCompatActivity {

    private CardView mccCV,mdfsCV,mlcCV,mrcCV,mpsCV;
    private SharedPreferences mPreferences;


    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private Toolbar mt;
    private ArrayList<Events> alleventsmcc;
    private ArrayList<Events> alleventsmlc;
    private ArrayList<Events> alleventsmdfs;
    private ArrayList<Events> alleventsmrc;
    private ArrayList<Events> alleventsmps;

    private ArrayList<Events> allnewsmcc;
    private ArrayList<Events> allnewsmlc;
    private ArrayList<Events> allnewsmdfs;
    private ArrayList<Events> allnewsmrc;
    private ArrayList<Events> allnewsmps;
    DatabaseReference refDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        mccCV=findViewById(R.id.mccCard);
        mdfsCV=findViewById(R.id.mdfsCard);
        mlcCV=findViewById(R.id.mlcCard);
        mrcCV=findViewById(R.id.mrcCard);
        mpsCV=findViewById(R.id.mpsCard);
        /*mccCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mccIntent = new Intent( ClubActivity.this, ClubDetailActivity.class );
                startActivity( mccIntent );
            }
        });*/

        alleventsmcc=new ArrayList<>(  );
        alleventsmlc=new ArrayList<>(  );
        alleventsmdfs=new ArrayList<>(  );
        alleventsmrc=new ArrayList<>(  );
        alleventsmps=new ArrayList<>(  );

        allnewsmcc=new ArrayList<>(  );
        allnewsmlc=new ArrayList<>(  );
        allnewsmdfs=new ArrayList<>(  );
        allnewsmrc=new ArrayList<>(  );
        allnewsmps=new ArrayList<>(  );

//        alleventsmps.clear();
//        alleventsmrc.clear();
//        alleventsmdfs.clear();
//        alleventsmcc.clear();
//        //alleventsmlc.clear();
        refDatabase= FirebaseDatabase.getInstance().getReference("MCC_Events");
        getAlldataFromDBmcc();
        refDatabase= FirebaseDatabase.getInstance().getReference("MLC_Events");
        getAlldataFromDBmlc();
        refDatabase= FirebaseDatabase.getInstance().getReference("MDFS_Events");
        getAlldataFromDBmdfs();
        refDatabase= FirebaseDatabase.getInstance().getReference("MRC_Events");
        getAlldataFromDBmrc();
        refDatabase= FirebaseDatabase.getInstance().getReference("MPS_Events");
        getAlldataFromDBmps();

        refDatabase= FirebaseDatabase.getInstance().getReference("MCC_News");
        ngetAlldataFromDBmcc();
        refDatabase= FirebaseDatabase.getInstance().getReference("MLC_News");
        ngetAlldataFromDBmlc();
        refDatabase= FirebaseDatabase.getInstance().getReference("MDFS_NEWS");
        ngetAlldataFromDBmdfs();
        refDatabase= FirebaseDatabase.getInstance().getReference("MRC_NEWS");
        ngetAlldataFromDBmrc();
        refDatabase= FirebaseDatabase.getInstance().getReference("MPS_NEWS");
        ngetAlldataFromDBmps();

        mccCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mcIntent=new Intent(ClubActivity.this, ClubDetailActivity.class);
                int intValue =1;
                mcIntent.putExtra("VariableName", intValue);
                Bundle bundle = new Bundle(  );
                bundle.putSerializable( "events",alleventsmcc );
                bundle.putSerializable( "news",allnewsmcc );
                mcIntent.putExtras( bundle );
                startActivity(mcIntent);
            }
        });

        mlcCV.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mlcIntent=new Intent(ClubActivity.this, ClubDetailActivity.class);
                int intValue =2;
                mlcIntent.putExtra("VariableName", intValue);
                Bundle bundle = new Bundle(  );
                bundle.putSerializable( "events",alleventsmlc );
                bundle.putSerializable( "news", alleventsmlc);
                mlcIntent.putExtras( bundle );
                startActivity(mlcIntent);
            }
        } );

        mdfsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mdfsIntent=new Intent(ClubActivity.this, ClubDetailActivity.class);
                int intValue =3;
                mdfsIntent.putExtra("VariableName", intValue);

                Bundle bundle = new Bundle(  );
                bundle.putSerializable( "events",alleventsmdfs );
                bundle.putSerializable( "news", alleventsmdfs);
                mdfsIntent.putExtras( bundle );
                startActivity(mdfsIntent);
            }
        });

        mrcCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mrcIntent=new Intent(ClubActivity.this, ClubDetailActivity.class);
                int intValue =4;
                mrcIntent.putExtra("VariableName", intValue);
                Bundle bundle = new Bundle(  );
                bundle.putSerializable( "events",alleventsmrc );
                bundle.putSerializable( "news", alleventsmrc);
                mrcIntent.putExtras( bundle );
                startActivity(mrcIntent);
            }
        });
        mpsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mpsIntent=new Intent(ClubActivity.this, ClubDetailActivity.class);
                int intValue =5;
                mpsIntent.putExtra("VariableName", intValue);
                Bundle bundle = new Bundle(  );
                bundle.putSerializable( "events",alleventsmps );
                bundle.putSerializable( "news", alleventsmps);
                mpsIntent.putExtras( bundle );
                startActivity(mpsIntent);
            }
        });

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
                        Intent pr= new Intent(ClubActivity.this,MyprofileActivity.class);
                        startActivity(pr);
                        break;
                    case R.id.home:
                        Intent hm = new Intent(ClubActivity.this,HomeActivity.class);
                        startActivity(hm);
                        break;
                    case R.id.logout:
                        mPreferences = getSharedPreferences("User", MODE_PRIVATE);
                        SharedPreferences.Editor editor = mPreferences.edit();
                        editor.clear();   // This will delete all your preferences, check how to delete just one
                        editor.commit();
                        Intent i= new Intent(ClubActivity.this,Login.class);
                        startActivity(i);
                        break;
                    case R.id.about:
                        Intent ab= new Intent(ClubActivity.this,AboutActivity.class);
                        startActivity(ab);
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


    private void getAlldataFromDBmcc()
    {
        refDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    Events value= data.getValue(Events.class);
                    alleventsmcc.add(value);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });
    }
    private void getAlldataFromDBmlc()
    {
        refDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    Events value= data.getValue(Events.class);
                    alleventsmlc.add(value);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });
    }
    private void getAlldataFromDBmdfs()
    {
        refDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    Events value= data.getValue(Events.class);
                    alleventsmdfs.add(value);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });
    }
    private void getAlldataFromDBmrc()
    {
        refDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    Events value= data.getValue(Events.class);
                    alleventsmrc.add(value);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });
    }
    private void getAlldataFromDBmps()
    {
        refDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    Events value= data.getValue(Events.class);
                    alleventsmps.add(value);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });
    }


    private void ngetAlldataFromDBmcc()
    {
        refDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    Events value= data.getValue(Events.class);
                    allnewsmcc.add(value);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });
    }
    private void ngetAlldataFromDBmlc()
    {
        refDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    Events value= data.getValue(Events.class);
                    allnewsmlc.add(value);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });
    }
    private void ngetAlldataFromDBmdfs()
    {
        refDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    Events value= data.getValue(Events.class);
                    allnewsmdfs.add(value);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });
    }
    private void ngetAlldataFromDBmrc()
    {
        refDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    Events value= data.getValue(Events.class);
                    allnewsmrc.add(value);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });
    }
    private void ngetAlldataFromDBmps()
    {
        refDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    Events value= data.getValue(Events.class);
                    allnewsmps.add(value);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });
    }

}
