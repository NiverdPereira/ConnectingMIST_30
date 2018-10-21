package e.par.connectingmist_30.Newsfeed_Notice;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;

import e.par.connectingmist_30.AboutActivity;
import e.par.connectingmist_30.Calender_view.Notice_cal;
import e.par.connectingmist_30.HomeActivity;
import e.par.connectingmist_30.Login;
import e.par.connectingmist_30.MyprofileActivity;
import e.par.connectingmist_30.NewsAdapter;
import e.par.connectingmist_30.NewsInfo;
import e.par.connectingmist_30.NoticeAdapter;
import e.par.connectingmist_30.NoticeInfo;
import e.par.connectingmist_30.R;

public class NoticeActivity extends AppCompatActivity {
    private ListView noticeListView;
    private ArrayList<NoticeInfo> allNotice;
    ArrayList<String > d,h,de;

    private DatabaseReference refDatabase;

    EditText editsearch;
    private SharedPreferences mPreferences;

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private android.widget.Toolbar mt;
    Button nov;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice1);
        noticeListView = findViewById(R.id.listnotice);
        allNotice = new ArrayList<>();
        d = new ArrayList<>();
        h = new ArrayList<>();
        de = new ArrayList<>();

        nov = findViewById( R.id.nov );
        editsearch = findViewById( R.id.editText1 );
        refDatabase= FirebaseDatabase.getInstance().getReference("Notice");
        getAlldataFromDB();
        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this,dl,0,0);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        editsearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {

                if(hasFocus){
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editsearch.getWindowToken(), 0);
                }
            }
        });

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.profile:
                        Intent pr= new Intent(NoticeActivity.this,MyprofileActivity.class);
                        startActivity(pr);
                        break;
                    case R.id.home:
                        Intent hm = new Intent(NoticeActivity.this,HomeActivity.class);
                        startActivity(hm);
                        break;
                    case R.id.logout:
                        mPreferences = getSharedPreferences("Session", MODE_PRIVATE);
                        SharedPreferences.Editor editor = mPreferences.edit();
                        editor.clear();   // This will delete all your preferences, check how to delete just one
                        editor.commit();
                        Intent i= new Intent(NoticeActivity.this,Login.class);
                        startActivity(i);
                        break;
                    case R.id.about:
                        Intent ab= new Intent(NoticeActivity.this,AboutActivity.class);
                        startActivity(ab);
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });

        editsearch.addTextChangedListener(new TextWatcher() { //edit search
            //Event when changed word on EditTex
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<NoticeInfo> temp = new ArrayList<NoticeInfo>();
                int textlength = editsearch.getText().length();

                temp.clear();
                for (int i = 0; i < allNotice.size(); i++)
                {
                    int pp=0;
                    pp=allNotice.get(i).getDetails().length();
                    if (textlength <= pp)
                    {
                        if(editsearch.getText().toString().equalsIgnoreCase(
                                (String)
                                        allNotice.get(i).getDetails().subSequence(0,
                                                textlength)))
                        {
                            temp.add(allNotice.get(i));
                        }
                    }
                }
                NoticeAdapter noticeAdapter = new NoticeAdapter(NoticeActivity.this, temp);
                noticeListView.setAdapter(noticeAdapter);
                //noticeListView.setAdapter(new CustomeArrayAdapter(MainActivity.this, temp));
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });



        nov.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedIntent=new Intent(NoticeActivity.this, Notice_cal.class);
                feedIntent.putExtra( "com",6 );
                feedIntent.putStringArrayListExtra( "date",d );
                feedIntent.putStringArrayListExtra( "head",h );
                feedIntent.putStringArrayListExtra( "detail",de );
                startActivity( feedIntent );
            }
        } );
    }



    private void getAlldataFromDB()
    {
        refDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int i=0;
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    NoticeInfo value= data.getValue(NoticeInfo.class);
                    allNotice.add(value);
                    d.add( value.getDate() );
                    h.add( value.getHeadline() );
                    de.add( value.getDetails() );

                    i++;
                }
                NoticeAdapter noticeAdapter = new NoticeAdapter(NoticeActivity.this, allNotice);
                noticeListView.setAdapter(noticeAdapter);

                noticeListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        String msg= "";
                        String head = "";
                        head= head+allNotice.get( position ).getHeadline();
                        msg=msg+allNotice.get( position ).getDetails();
                        openDialog(head,msg);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());

            }
        });

    }

    public void openDialog(String head,String msg1) {

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        // Set Custom Title
        TextView title = new TextView(this);
        // Title Properties
        title.setText(head);
        title.setPadding(10, 10, 10, 10);   // Set Position
        title.setGravity(Gravity.CENTER);
        title.setTextColor(Color.BLACK);
        title.setTextSize(20);
        alertDialog.setCustomTitle(title);
        // Set Message
        TextView msg = new TextView(this);
        // Message Properties
        msg.setText(msg1);
        msg.setGravity(Gravity.CENTER_HORIZONTAL);
        msg.setTextColor(Color.BLACK);
        alertDialog.setView(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Perform Action on Button
            }
        });
        new Dialog(this);
        alertDialog.show();
        final Button okBT = alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
        LinearLayout.LayoutParams neutralBtnLP = (LinearLayout.LayoutParams) okBT.getLayoutParams();
        neutralBtnLP.gravity = Gravity.FILL_HORIZONTAL;
        okBT.setPadding(500, 10, 10, 10);   // Set Position
        okBT.setTextColor(Color.BLUE);
        okBT.setLayoutParams(neutralBtnLP);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

}