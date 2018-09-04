package e.par.connectingmist_30;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    CardView login;
    TextView register;
    private EditText mail,pass;
    private ProgressDialog pdialog;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login= (CardView)findViewById(R.id.cardView);
        register=findViewById(R.id.textreg);
        mail=findViewById(R.id.mailtext);
        pass=findViewById(R.id.pass);

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
    void signIn()
    {
        Intent i= new Intent(Login.this,HomeActivity.class);
        startActivity(i);
    }
}
