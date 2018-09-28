package e.par.connectingmist_30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import e.par.connectingmist_30.Club_activity.ClubMCCActivity;

public class ClubActivity extends AppCompatActivity {

    private CardView mccCV,mdfsCV,mlcCV,mrcCV,mpsCV;

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
                Intent mccIntent = new Intent( ClubActivity.this, ClubMCCActivity.class );
                startActivity( mccIntent );
            }
        });*/
        mccCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mcIntent=new Intent(ClubActivity.this, ClubMCCActivity.class);
                startActivity(mcIntent);
            }
        });

        mdfsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mdfsIntent;
            }
        });
        mlcCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mlcIntent;
            }
        });
        mrcCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mrcIntent;
            }
        });
        mpsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mpsIntent;
            }
        });
    }
}
