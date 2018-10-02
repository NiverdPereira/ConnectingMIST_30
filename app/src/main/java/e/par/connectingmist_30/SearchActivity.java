package e.par.connectingmist_30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    CardView bSearch,bMap;
    TextView bShow;
    Spinner spinner;
    String sShow;
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
            }
        });
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
