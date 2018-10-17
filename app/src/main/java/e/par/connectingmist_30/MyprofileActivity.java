package e.par.connectingmist_30;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import e.par.connectingmist_30.Newsfeed_Notice.NewsActivity;

public class MyprofileActivity extends AppCompatActivity {
    //private DatabaseReference refDatabase;
    FirebaseUser user;
    TextView name,id,dept,sess,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
        name=findViewById(R.id.tvname);
        id=findViewById(R.id.tvid);
        dept=findViewById(R.id.tvdept);
        sess=findViewById(R.id.tvsession);
        email=findViewById(R.id.tvemail);

        user=FirebaseAuth.getInstance().getCurrentUser();
        String userid=user.getUid();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users");
        ref.child(userid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //String name1=dataSnapshot.child("name").getValue().toString();
                UserInfo user = dataSnapshot.getValue(UserInfo.class);
                name.setText("Name: "+user.getName());
                //String roll1=dataSnapshot.child("roll").getValue().toString();
                id.setText("Id: "+user.getRoll());
                //String dept1=dataSnapshot.child("dept").getValue().toString();
                dept.setText("Department: "+user.getDept());
                //String sess1=dataSnapshot.child("session").getValue().toString();
                sess.setText("Session: "+user.getSession());
                //String email1=dataSnapshot.child("email").getValue().toString();
                email.setText("Email: "+user.getEmail());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
