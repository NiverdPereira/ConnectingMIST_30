package e.par.connectingmist_30;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateActivity extends AppCompatActivity {
    FirebaseUser user;
    private EditText eName, eMail, ePass,ecPass;
    private DatabaseReference ref;
    private String sName, sPass, sMail, uid,scPass,scMail;
    private CardView bUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        eName = findViewById(R.id.uName);
        ePass = findViewById(R.id.uPass);
        eMail = findViewById(R.id.uMail);
        ecPass = findViewById(R.id.ucPass);

        bUpdate = findViewById(R.id.bUpdate);



        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();
        ref = FirebaseDatabase.getInstance().getReference("Users");

        bUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passUpdate();
                infoUpdate();
            }
        });

// See the UserRecord reference doc for the contents of userRecord.
        //System.out.println("Successfully fetched user data: " + userRecord.getUid());

    }
    protected void infoUpdate(){
        ref.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserInfo user1=dataSnapshot.getValue(UserInfo.class);
                sName = eName.getText().toString().trim();
                sPass = ePass.getText().toString().trim();
                sMail = eMail.getText().toString().trim();
                scMail=user1.getEmail();

                scPass = ecPass.getText().toString().trim();
                if(scPass==null || sPass==null){
                    Toast.makeText(UpdateActivity.this, "Please Enter Current Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    AuthCredential credential = EmailAuthProvider
                            .getCredential(scMail, scPass);
                    user.reauthenticate(credential)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        user.updatePassword(sPass).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Log.d(" ", "Password updated");
                                                } else {
                                                    Log.d(" ", "Error password not updated");
                                                }
                                            }
                                        });
                                    } else {
                                        Log.d(" ", "Error auth failed");
                                    }
                                }
                            });
                }

                if(sName.length()>0)ref.child(uid).child("name").setValue(sName);
                if(sMail.length()>0)ref.child(uid).child("email").setValue(sMail);
                Intent goBack=new Intent(UpdateActivity.this,MyprofileActivity.class);
                startActivity(goBack);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
