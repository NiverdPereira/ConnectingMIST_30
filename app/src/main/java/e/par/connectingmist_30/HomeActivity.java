package e.par.connectingmist_30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class HomeActivity extends AppCompatActivity {
    private CardView newsfeed,location,notice,club;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        newsfeed=findViewById(R.id.feedCard);
        location=findViewById(R.id.locCard);
        notice=findViewById(R.id.noticeCard);
        club=findViewById(R.id.clubCard);
        newsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent feedIntent;
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locIntent;
            }
        });
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent noticeIntent;
            }
        });
        club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent clubIntent= new Intent(HomeActivity.this,ClubActivity.class);
            }
        });
    }
}
