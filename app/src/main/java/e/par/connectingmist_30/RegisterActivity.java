package e.par.connectingmist_30;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private CardView Reg;
    private ProgressDialog pBar;
    private FirebaseAuth mAuth;
    private DatabaseReference refDatabase;
    private String sName,sDept,sRoll,sEmail,sSession,sPassword;
    private EditText eName,eDept,eRoll,eEmail,eSession,ePassword;
    private UserInfo uInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        pBar=new ProgressDialog(this);
        Reg=findViewById(R.id.regbutton);
        eName=findViewById(R.id.editText7);
        eDept=findViewById(R.id.editText6);
        eRoll=findViewById(R.id.editText3);
        eEmail=findViewById(R.id.editText10);
        eSession=findViewById(R.id.editText4);
        ePassword=findViewById(R.id.editText9);
        mAuth=FirebaseAuth.getInstance();
        refDatabase= FirebaseDatabase.getInstance().getReference("Users");
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllInputData();
                createUser();
                createAccountandSaveInfo();
            }
        });
    }
    protected void getAllInputData()
    {
        sName=eName.getText().toString().trim();
        sDept=eDept.getText().toString().trim();
        sRoll=eRoll.getText().toString().trim();
        sEmail=eEmail.getText().toString().trim();
        sSession=eSession.getText().toString().trim();
        sPassword=ePassword.getText().toString().trim();
    }
    protected void createUser()
    {
        uInfo=new UserInfo(sName,sDept,sRoll,sEmail,sSession);
    }
    protected void createAccountandSaveInfo(){
        pBar.setMessage("Creating");
        pBar.show();
        mAuth.createUserWithEmailAndPassword(sEmail,sPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user=mAuth.getCurrentUser();
                    refDatabase=FirebaseDatabase.getInstance().getReference("Users");
                    refDatabase.child(user.getUid()).setValue(uInfo);
                    Intent k=new Intent(RegisterActivity.this,Login.class);
                    startActivity(k);
                }
                else{
                    Toast.makeText(RegisterActivity.this,"Failed",Toast.LENGTH_SHORT);
                }
                pBar.dismiss();
            }
        });
    }
}
