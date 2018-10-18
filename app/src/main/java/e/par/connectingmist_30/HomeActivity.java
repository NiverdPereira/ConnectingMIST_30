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
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import e.par.connectingmist_30.Newsfeed_Notice.Edit_NewsfeedActivity;
import e.par.connectingmist_30.Newsfeed_Notice.NewsActivity;
import e.par.connectingmist_30.Newsfeed_Notice.NewsfeedActivity;
import e.par.connectingmist_30.Newsfeed_Notice.NoticeActivity;

public class HomeActivity extends AppCompatActivity {
    private CardView newsfeed,location,notice,club,logout;
    private ImageView iAdmin;
    private SharedPreferences mPreferences;

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private Toolbar mt;


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
        //iAdmin=findViewById(R.id.iAdmin);
        logout=findViewById(R.id.logout);




        newsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent feedIntent=new Intent(HomeActivity.this, NewsActivity.class);
                startActivity(feedIntent);
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locIntent=new Intent(HomeActivity.this,SearchActivity.class);
                startActivity(locIntent);
            }
        });
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent noticeIntent=new Intent(HomeActivity.this, NoticeActivity.class);
                startActivity(noticeIntent);
            }
        });
        club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent clubIntent= new Intent(HomeActivity.this, ClubActivity.class);
                startActivity(clubIntent);
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
                        break;
                    case R.id.logout:
                        mPreferences = getSharedPreferences("Session", MODE_PRIVATE);
                        SharedPreferences.Editor editor = mPreferences.edit();
                        editor.clear();   // This will delete all your preferences, check how to delete just one
                        editor.commit();
                        Intent i= new Intent(HomeActivity.this,Login.class);
                        startActivity(i);
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
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
