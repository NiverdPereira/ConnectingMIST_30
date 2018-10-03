package e.par.connectingmist_30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import e.par.connectingmist_30.Club_activity.AddInfo;
import e.par.connectingmist_30.Club_activity.ClubDetailActivity;
import e.par.connectingmist_30.Newsfeed_Notice.Edit_NewsfeedActivity;
import e.par.connectingmist_30.Newsfeed_Notice.Edit_NoticeActivity;
import e.par.connectingmist_30.R;

public class AdminMenuActivity extends AppCompatActivity {

    private CardView newsCV,noticeCV,mccCV,mdfsCV,mlcCV,mrcCV,mpsCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        newsCV=findViewById(R.id.newsCard);
        noticeCV=findViewById(R.id.noticeCard);
        mccCV=findViewById(R.id.mccCard);
        mdfsCV=findViewById(R.id.mdfsCard);
        mlcCV=findViewById(R.id.mlcCard);
        mrcCV=findViewById(R.id.mrcCard);
        mpsCV=findViewById(R.id.mpsCard);

        newsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editnews=new Intent(AdminMenuActivity.this,Edit_NewsfeedActivity.class);
                startActivity(editnews);

            }
        });
        noticeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editnotice=new Intent(AdminMenuActivity.this,Edit_NoticeActivity.class);
                startActivity(editnotice);

            }
        });
        mccCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mcIntent=new Intent(AdminMenuActivity.this, AddInfo.class);
                int intValue =1;
                mcIntent.putExtra("VariableName", intValue);
                startActivity(mcIntent);

            }
        });
        mdfsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mcIntent=new Intent(AdminMenuActivity.this, AddInfo.class);
                int intValue =2;
                mcIntent.putExtra("VariableName", intValue);
                startActivity(mcIntent);

            }
        });
        mlcCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mcIntent=new Intent(AdminMenuActivity.this, AddInfo.class);
                int intValue =3;
                mcIntent.putExtra("VariableName", intValue);
                startActivity(mcIntent);

            }
        });
        mrcCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mcIntent=new Intent(AdminMenuActivity.this, AddInfo.class);
                int intValue =4;
                mcIntent.putExtra("VariableName", intValue);
                startActivity(mcIntent);

            }
        });
        mpsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mcIntent=new Intent(AdminMenuActivity.this, AddInfo.class);
                int intValue =5;
                mcIntent.putExtra("VariableName", intValue);
                startActivity(mcIntent);

            }
        });
    }
}
