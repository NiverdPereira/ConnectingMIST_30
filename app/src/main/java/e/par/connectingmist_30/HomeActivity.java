package e.par.connectingmist_30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import e.par.connectingmist_30.Newsfeed_Notice.NewsfeedActivity;
import e.par.connectingmist_30.Newsfeed_Notice.NoticeActivity;

public class HomeActivity extends AppCompatActivity {

    CardView newsfeed,notice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        newsfeed = (CardView) findViewById(R.id.cview1);
        notice = (CardView) findViewById(R.id.cview4);

        newsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, NewsfeedActivity.class);
                startActivity(i);
            }
        });

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, NoticeActivity.class);
                startActivity(i);
            }
        });
    }


}
