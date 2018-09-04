package e.par.connectingmist_30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    private CardView Reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Reg=findViewById(R.id.regbutton);
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(RegisterActivity.this,Login.class);
                startActivity(k);
            }
        });
    }
}
