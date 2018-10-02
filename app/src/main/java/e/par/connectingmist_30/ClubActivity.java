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
                int intValue =1;
                mcIntent.putExtra("VariableName", intValue);
                startActivity(mcIntent);
            }
        });

        mlcCV.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mlcIntent=new Intent(ClubActivity.this, ClubMCCActivity.class);
                int intValue =2;
                mlcIntent.putExtra("VariableName", intValue);
                startActivity(mlcIntent);
            }
        } );

        mdfsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mdfsIntent=new Intent(ClubActivity.this, ClubMCCActivity.class);
                int intValue =3;
                mdfsIntent.putExtra("VariableName", intValue);
                startActivity(mdfsIntent);
            }
        });

        mrcCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mrcIntent=new Intent(ClubActivity.this, ClubMCCActivity.class);
                int intValue =4;
                mrcIntent.putExtra("VariableName", intValue);
                startActivity(mrcIntent);
            }
        });
        mpsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mpsIntent=new Intent(ClubActivity.this, ClubMCCActivity.class);
                int intValue =5;
                mpsIntent.putExtra("VariableName", intValue);
                startActivity(mpsIntent);
            }
        });
    }
}
