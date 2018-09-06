package e.par.connectingmist_30.Newsfeed_Notice;

import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import e.par.connectingmist_30.R;

public class NoticeActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //Call Read rss asyntask to fetch rss
        ReadRSS_notice readRss = new ReadRSS_notice(this, recyclerView);
        readRss.execute();
    }

}