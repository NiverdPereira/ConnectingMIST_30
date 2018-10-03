package e.par.connectingmist_30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

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
                Intent addNews=new Intent(AdminMenuActivity.this, Edit_NewsfeedActivity.class);
                startActivity(addNews);
            }
        });
        noticeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addNotice=new Intent(AdminMenuActivity.this, Edit_NoticeActivity.class);
                startActivity(addNotice);
            }
        });
        mccCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mdfsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mlcCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mrcCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mpsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
