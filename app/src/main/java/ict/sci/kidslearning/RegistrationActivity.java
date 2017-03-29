package ict.sci.kidslearning;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.Calendar;
import java.util.List;

import ict.sci.kidslearning.utils.AlertMessage;
import ict.sci.kidslearning.utils.SharedPreferencesHelper;

public class RegistrationActivity extends AppCompatActivity {

    private CommentsDataSource datasource;
    private EditText school,student,class_name,roll;
    private int mYear, mMonth, mDay, mHour, mMinute,ampm;
    String str_school="",str_stud="",str_class="",str_roll="";
    private Context con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        con = this;

        datasource = new CommentsDataSource(this);
        datasource.open();

        school = (EditText) findViewById(R.id.school_id);
        student = (EditText) findViewById(R.id.student_id);
        class_name = (EditText) findViewById(R.id.class_id);
        roll = (EditText) findViewById(R.id.roll_id);


        if(SharedPreferencesHelper.getName(con).length()>2){
            school.setText(""+SharedPreferencesHelper.getName(con));
            class_name.setText(""+SharedPreferencesHelper.getClass(con));
        }


    }



    public void result(View v){


        Intent i = new Intent(RegistrationActivity.this, ResultListActivity.class);
        startActivity(i);
    }

    public void next(View v){

        str_school=school.getText().toString();
        str_stud=student.getText().toString();
        str_class=class_name.getText().toString();
        str_roll=roll.getText().toString();

//        if(str_school.length()<2){
//            AlertMessage.showMessage(con, "Sorry", "Invalied school name.");
//        }else if(str_stud.length()<3){
//            AlertMessage.showMessage(con, "Sorry", "Invalied student name.");
//        }
//        else if(str_class.length()<1){
//            AlertMessage.showMessage(con, "Sorry", "Invalied class name.");
//        }
//        else if(str_roll.length()<3){
//            AlertMessage.showMessage(con, "Sorry", "Invalied roll no.");
//        }
//        else {

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        int mon = mMonth+1;
        String dat = mDay+"-"+mon+"-"+mYear;

        Log.d("=year==="+dat, "..year..>>"+mYear+"---day: "+mDay );

        Comment comment = null;
            datasource.createComment(str_school,str_stud,str_class,dat,"Developed","Need Improvement","Developed",0,str_roll);
            List<Comment> values = datasource.getAllComments();

            Log.d("====k===="+values.get(0).getScore(), "...id..>>" + values.get(0).getComment());

        SharedPreferencesHelper.setName(con,str_school);
        SharedPreferencesHelper.setClass(con,str_class);

            Intent i = new Intent(RegistrationActivity.this, HomeActivity.class);
            //Intent i = new Intent(MainActivity.this, WordListActivity.class);
            startActivity(i);
            this.finish();

 //       }
    }


}
