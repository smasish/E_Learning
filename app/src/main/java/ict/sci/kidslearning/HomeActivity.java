package ict.sci.kidslearning;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ict.sci.kidslearning.utils.AlertMessage;

public class HomeActivity extends AppCompatActivity {


    private Spinner year;
    List<String> categories;
    ArrayAdapter<String> dataAdapter;

    private Button gone1,gone2,gone3,gtwo1,gtwo2,gtwo3,gthree1,gthree2,gthree3;
    private Context con;

    int year_flag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.test);
        setContentView(R.layout.test);


        con = this;
        year = (Spinner)findViewById(R.id.spinner);

        categories = new ArrayList<String>();
        categories.add("Select Car");
        categories.add("2015");
        categories.add("2016");
        categories.add("2017");



        // Creating adapter for spinner
        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        year.setAdapter(dataAdapter);
        year_flag = year.getSelectedItemPosition();
//        year.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(final AdapterView<?> parent,
//                                    final View view, final int position, final long id) {
////				Toast.makeText(getApplicationContext(),
////						String.valueOf(position), Toast.LENGTH_LONG).show();
//
//                year_flag = position;
//                Toast.makeText(con,"Counted",Toast.LENGTH_LONG).show();
////				final Intent imageshow = new Intent(SecondActivity.this,
////						GalleryActivity.class);
//
//
//
//            }
//        });


        gone1 = (Button)findViewById(R.id.button3);



    }


    public void g1b1(View v){
        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );

        if(year_flag == 1){
            Intent i = new Intent(HomeActivity.this, QuestionActivity.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);

        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, QuestionActivity2016_1.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
        }
    }

    public void g1b2(View v){
        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );
        if(year_flag == 1) {
            Intent i = new Intent(HomeActivity.this, QuestionActivity_g1b2.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, QuestionActivity2016_2.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
        }
    }

    public void g1b3(View v){
        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );
        if(year_flag == 1) {
        Intent i = new Intent(HomeActivity.this, WordListActivity_G1q3.class);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        startActivity(i);
        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, QuestionActivity2016_3.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
        }
    }

    public void g2b1(View v){
        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );

        if(year_flag == 1){
            Intent i = new Intent(HomeActivity.this, QuestionActivity.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);

        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, QuestionActivity2016_1.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
        }
    }
    public void g2b2(View v){
        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );

        if(year_flag == 1){
            Intent i = new Intent(HomeActivity.this, QuestionActivity.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);

        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, Activity_Onepic_2016_5.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
        }
    }
    public void g2b3(View v){
        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );

        if(year_flag == 1){
            Intent i = new Intent(HomeActivity.this, QuestionActivity.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);

        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, QuestionActivity2016_1.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
        }
    }

    public void g3b1(View v){
        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );

        if(year_flag == 1){
            Intent i = new Intent(HomeActivity.this, QuestionActivity.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, Activity_Onepic_2016_7.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
        }
    }

    /////////  need to change activity

    public void g3b2(View v){

        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );

        if(year_flag == 1){
            Intent i = new Intent(HomeActivity.this, QuestionActivity.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, Activity_Onepic_2016_8.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
        }

    }

    /////////  need to change activity
    public void g3b3(View v){

        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );

        if(year_flag == 1){
            Intent i = new Intent(HomeActivity.this, QuestionActivity.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, Activity_Onepic_2016_7.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
        }

    }

    public void next(View v){
        Intent i = new Intent(HomeActivity.this, AboutActivity.class);
        startActivity(i);
    }


}
