package e.par.connectingmist_30.Newsfeed_Notice;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import e.par.connectingmist_30.HomeActivity;
import e.par.connectingmist_30.Login;
import e.par.connectingmist_30.Nav_Drawer.NavNewsfeed;
import e.par.connectingmist_30.R;

public class NewsfeedActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    //nav drawer
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private android.widget.Toolbar mt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //Call Read rss asyntask to fetch rss
        ReadRSS readRss = new ReadRSS(this, recyclerView);
        readRss.execute();

        //nav drawer
        dl = (DrawerLayout)findViewById(R.id.activity_newsfeed);
        t = new ActionBarDrawerToggle(this,dl,0,0);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Menu profile, home, logout;
                switch (id) {
                    case R.id.profile:
                        Toast.makeText(NewsfeedActivity.this, "My profile", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.home:
                        Intent hm = new Intent(NewsfeedActivity.this, HomeActivity.class);
                        startActivity(hm);
                        break;

                    case R.id.logout:
                        //Toast.makeText(NewsfeedActivity.this, "logged out", Toast.LENGTH_SHORT).show();
                        Intent lg = new Intent(NewsfeedActivity.this, Login.class);
                        startActivity(lg);
                        break;
                    default:
                        return true;
                }
                return false;
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

}