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
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import e.par.connectingmist_30.Club_activity.ClubDetailActivity;

public class ClubActivity extends AppCompatActivity {

    private CardView mccCV,mdfsCV,mlcCV,mrcCV,mpsCV;
    private SharedPreferences mPreferences;


    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private Toolbar mt;

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
        mccCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mcIntent=new Intent(ClubActivity.this, ClubDetailActivity.class);
                int intValue =1;
                mcIntent.putExtra("VariableName", intValue);
                startActivity(mcIntent);
            }
        });

        mlcCV.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mlcIntent=new Intent(ClubActivity.this, ClubDetailActivity.class);
                int intValue =2;
                mlcIntent.putExtra("VariableName", intValue);
                startActivity(mlcIntent);
            }
        } );

        mdfsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mdfsIntent=new Intent(ClubActivity.this, ClubDetailActivity.class);
                int intValue =3;
                mdfsIntent.putExtra("VariableName", intValue);
                startActivity(mdfsIntent);
            }
        });

        mrcCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mrcIntent=new Intent(ClubActivity.this, ClubDetailActivity.class);
                int intValue =4;
                mrcIntent.putExtra("VariableName", intValue);
                startActivity(mrcIntent);
            }
        });
        mpsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mpsIntent=new Intent(ClubActivity.this, ClubDetailActivity.class);
                int intValue =5;
                mpsIntent.putExtra("VariableName", intValue);
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
                        Toast.makeText(ClubActivity.this, "My profile",Toast.LENGTH_SHORT).show();
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
}
