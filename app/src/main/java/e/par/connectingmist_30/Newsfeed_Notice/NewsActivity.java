package e.par.connectingmist_30.Newsfeed_Notice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import e.par.connectingmist_30.NewsAdapter;
import e.par.connectingmist_30.NewsInfo;
import e.par.connectingmist_30.R;

public class NewsActivity extends AppCompatActivity {
    private ListView newsListView;
    private ArrayList<NewsInfo> allNews;
    private DatabaseReference refDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        newsListView = findViewById(R.id.listFeed);
        allNews = new ArrayList<>();
        refDatabase= FirebaseDatabase.getInstance().getReference("Users");
        getAlldataFromDB();
    }
    private void getAlldataFromDB()
    {
        refDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    NewsInfo value= data.getValue(NewsInfo.class);
                    allNews.add(value);
                }
                NewsAdapter newsAdapter = new NewsAdapter(NewsActivity.this, allNews);
                newsListView.setAdapter(newsAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());

            }
        });
    }
}
