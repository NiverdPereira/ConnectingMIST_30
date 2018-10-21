package e.par.connectingmist_30;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import e.par.connectingmist_30.Newsfeed_Notice.NewsActivity;

public class MyprofileActivity extends AppCompatActivity {
    //private DatabaseReference refDatabase;
    FirebaseUser user;
    TextView name,id,dept,sess,email;
    private CardView updateC;

    ImageView image;

    Button btnpic;

    private String idpic;
    public String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
        name=findViewById(R.id.tvname);
        id=findViewById(R.id.tvid);
        dept=findViewById(R.id.tvdept);
        sess=findViewById(R.id.tvsession);
        email=findViewById(R.id.tvemail);
        updateC=findViewById(R.id.cUpdate);

        image=findViewById(R.id.propic);
        btnpic=findViewById(R.id.pic);

        user=FirebaseAuth.getInstance().getCurrentUser();
        final String userid=user.getUid();
        updateC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateIntent=new Intent(MyprofileActivity.this,UpdateActivity.class);
                startActivity(updateIntent);
            }
        });

        btnpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent picup=new Intent(MyprofileActivity.this,ProviderPicUpload.class);
                startActivity(picup);

            }
        });

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


                StorageReference sref = FirebaseStorage.getInstance().getReference("Profilepic").child(user.getRoll());


                try {
                    final File localFile = File.createTempFile("temp", "jpg");
                    sref.getFile(localFile)
                            .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                            File imgFile = new  File("/sdcard/Images/test_image.jpg");

                                    if (localFile.exists()) {

                                        Bitmap myBitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                                        image.setImageBitmap(myBitmap);
                                        //Toast.makeText(MyprofileActivity.this, ""+idpic, Toast.LENGTH_SHORT).show();

                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            // Handle failed download
                            // ...
                            Toast.makeText(MyprofileActivity.this, "Download failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //String st="201614040";
        /*DatabaseReference d = FirebaseDatabase.getInstance().getReference("Profilepic");
        d.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot i:dataSnapshot.getChildren()){
                    Upload ss = i.getValue(Upload.class);

                    Picasso.get()
                            .load(ss.getImageUrl())
                            .into(image);
                    //ss er moddhe object chole asche,now etake chaile arraylist e vore rakhte paro
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MyprofileActivity.this, "failed", Toast.LENGTH_SHORT).show();

            }
        });*/
    }

}
