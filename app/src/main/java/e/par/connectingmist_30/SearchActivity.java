package e.par.connectingmist_30;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

public class SearchActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    CardView bSearch,bMap;
    TextView bShow;
    Spinner spinner;
    String sShow;

    private SharedPreferences mPreferences;


    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private Toolbar mt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        spinner = (Spinner) findViewById(R.id.spPlaces);
        bSearch=findViewById(R.id.bSearch);
        bMap=findViewById(R.id.bMap);
        bShow=findViewById(R.id.textView13);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.places_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        bMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent=new Intent(SearchActivity.this,MapsActivity.class);
                startActivity(mapIntent);
            }
        });
        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this,dl,0,0);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.profile:
                        Intent pr= new Intent(SearchActivity.this,MyprofileActivity.class);
                        startActivity(pr);
                        break;
                    case R.id.home:
                        Intent hm = new Intent(SearchActivity.this,HomeActivity.class);
                        startActivity(hm);
                        break;
                    case R.id.logout:
                        mPreferences = getSharedPreferences("User", MODE_PRIVATE);
                        SharedPreferences.Editor editor = mPreferences.edit();
                        editor.clear();   // This will delete all your preferences, check how to delete just one
                        editor.commit();
                        Intent i= new Intent(SearchActivity.this,Login.class);
                        startActivity(i);
                        break;
                    case R.id.about:
                        Intent ab= new Intent(SearchActivity.this,AboutActivity.class);
                        startActivity(ab);
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }
    public void onItemSelected(AdapterView<?> parent, View view,int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        sShow=parent.getItemAtPosition(pos).toString();
        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sShow.equals("Network Lab")) bShow.setText("Tower 1 6th floor");
                else if(sShow.equals("Artificial Intelligence Lab")) bShow.setText("Tower 1 4th floor");
                else if(sShow.equals("Commandants Office")) bShow.setText("Admin Building");
                else if(sShow.equals("CSE Department")) bShow.setText("Tower 1 8th floor");
                else if(sShow.equals("CSE 1st Year")) bShow.setText("Tower 2 3rd floor");
                else if(sShow.equals("CSE 2nd Year")) bShow.setText("Tower 1 6th floor");
                else if(sShow.equals("CSE 3rd Year")) bShow.setText("Tower 2 5th floor");
                else if(sShow.equals("Tailor Shop")) bShow.setText("MIST Cafeteria 2nd floor");
            }
        });
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
