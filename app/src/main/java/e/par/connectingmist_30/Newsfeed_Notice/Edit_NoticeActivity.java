package e.par.connectingmist_30.Newsfeed_Notice;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import e.par.connectingmist_30.R;

public class Edit_NoticeActivity extends AppCompatActivity {

    EditText date,details;
    Button save;
    private DatabaseReference refDatabase;
    private Notice_Element notice;
    String sDate,sDetails;
    Calendar myCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__notice);

        date=findViewById(R.id.date);
        details=findViewById(R.id.details);
        // refDatabase=FirebaseDatabase.getInstance().getReference("Newsfeed");


        //for calender
        final DatePickerDialog.OnDateSetListener Date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Edit_NoticeActivity.this, Date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //calender ends here


        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                getAllInputData();
                createStudent();
                createAccountAndSaveInfo();
            }
        });
    }
    void getAllInputData(){
        sDate=date.getText().toString();
        sDetails=details.getText().toString();


    }
    void  createStudent(){
        notice=new Notice_Element(sDate,sDetails);
    }
    void createAccountAndSaveInfo(){
        refDatabase= FirebaseDatabase.getInstance().getReference("Notice");
        String pk=refDatabase.push().getKey();
        refDatabase.child(pk).setValue(notice);

    }

    //for calender
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        date.setText(sdf.format(myCalendar.getTime()));
        sDate = date.getText().toString().trim();
    }

}