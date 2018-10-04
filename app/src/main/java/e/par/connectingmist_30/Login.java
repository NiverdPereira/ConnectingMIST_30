package e.par.connectingmist_30;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    CardView login;
    TextView register;
    private EditText mail,pass;
    private FirebaseAuth mAuth;
    private ProgressDialog pdialog;
    private String email, password;
    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pdialog=new ProgressDialog(this);
        login= (CardView)findViewById(R.id.cardView);
        register=findViewById(R.id.textreg);
        mail=findViewById(R.id.mailtext);
        pass=findViewById(R.id.pass);
        mAuth=FirebaseAuth.getInstance();
        mPreferences = getSharedPreferences("Session", MODE_PRIVATE);

        if (mPreferences.contains("username")) {
            Intent i= new Intent(Login.this,HomeActivity.class);
            startActivity(i);
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Login.this,RegisterActivity.class);
                startActivity(j);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    void signIn()
    {
         email=mail.getText().toString().trim();
         password=pass.getText().toString().trim();
         if(email.isEmpty())
         {
             return;
         }
         pdialog.setMessage("Verifying");
         pdialog.show();
         mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                 if(task.isSuccessful()){
                     FirebaseUser user=mAuth.getCurrentUser();
                     Intent i= new Intent(Login.this,HomeActivity.class);
                     startActivity(i);
                     SharedPreferences.Editor editor = mPreferences.edit();
                     editor.putString("username", email);
                     editor.commit();
                     Toast.makeText(getApplicationContext(),"LogInSuccess", Toast.LENGTH_SHORT).show();
                 }
                 else{
                     Toast.makeText(Login.this,"Invalid info",Toast.LENGTH_SHORT);
                 }
                 pdialog.dismiss();
             }

         });
    }
}
