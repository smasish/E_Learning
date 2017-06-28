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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ict.sci.kidslearning.utils.AlertMessage;

public class HomeActivity extends AppCompatActivity {


    private Spinner year,class_sp,period;
    List<String> categories,class_category,period_category;
    ArrayAdapter<String> dataAdapter,classAdapter,peirodAdapter;

    private Button gone1,gone2,gone3,gtwo1,gtwo2,gtwo3,gthree1,gthree2,gthree3;
    private Context con;

    int year_flag = 0;

    LinearLayout l1,l2,l3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.test);
        setContentView(R.layout.testgrade);


        con = this;
        year = (Spinner)findViewById(R.id.spinner);

        class_sp = (Spinner)findViewById(R.id.spinner_class);
        period = (Spinner)findViewById(R.id.spinner_period);

        l1 = (LinearLayout)findViewById(R.id.g1);
        l2 = (LinearLayout)findViewById(R.id.g2);
        l3 = (LinearLayout)findViewById(R.id.g3);

        categories = new ArrayList<String>();
        categories.add(" বছর  নির্বাচন করুন");
      //  categories.add("২০১৫");
        categories.add("২০১৭");
        categories.add("২০১৬");




        // Creating adapter for spinner
        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        year.setAdapter(dataAdapter);
        year_flag = year.getSelectedItemPosition();

        class_category = new ArrayList<String>();
        class_category.add(" শ্রেণী নির্বাচন করুন");
        class_category.add("One");
        class_category.add("Two");
        class_category.add("Three");


        classAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, class_category);
        class_sp.setAdapter(classAdapter);

        period_category = new ArrayList<String>();
        period_category.add(" পিরিয়ড নির্বাচন করুন");
        period_category.add("One");
        period_category.add("Two");
        period_category.add("Three");


        peirodAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, period_category);
        period.setAdapter(peirodAdapter);


        period.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                if(position == 1) {
                   l1.setVisibility(View.VISIBLE);
                    l2.setVisibility(View.GONE);
                    l3.setVisibility(View.GONE);
                }
                else  if(position == 2) {
                    l2.setVisibility(View.VISIBLE);
                    l1.setVisibility(View.GONE);
                    l3.setVisibility(View.GONE);
                }
                else if(position == 3) {
                    l3.setVisibility(View.VISIBLE);
                    l1.setVisibility(View.GONE);
                    l2.setVisibility(View.GONE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

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
            Intent i = new Intent(HomeActivity.this, WordListActivity2017_1.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();

        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, QuestionActivity2016_1.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();
        }
    }

    public void g1b2(View v){
        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );
        if(year_flag == 1) {
            Intent i = new Intent(HomeActivity.this, QuestionActivity2017_2.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();
        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, QuestionActivity2016_2.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();
        }
    }

    public void g1b3(View v){
        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );
        if(year_flag == 1) {
            Intent i = new Intent(HomeActivity.this, QuestionActivity2017_3.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();
        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, QuestionActivity2016_3.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();
        }
    }

    public void g2b1(View v){
        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );

        if(year_flag == 1){
            Intent i = new Intent(HomeActivity.this, WordListActivity2017_4.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();

        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, QuestionActivity2016_4.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();
        }
    }
    public void g2b2(View v){
        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );

        if(year_flag == 1){
            Intent i = new Intent(HomeActivity.this, WordListActivity2017_5.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();

        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, Activity_Onepic_2016_5.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();
        }
    }
    public void g2b3(View v){
        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );

        if(year_flag == 1){
            Intent i = new Intent(HomeActivity.this, Activity_Onepic_2017_6.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();

        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, Activity_Onepic_2016_6.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();
        }
    }

    public void g3b1(View v){
        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );

        if(year_flag == 1){
            Intent i = new Intent(HomeActivity.this, Activity_Onepic_2017_7.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();
        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, Activity_Onepic_2016_7.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();
        }
    }

    /////////  need to change activity

    public void g3b2(View v){

        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );

        if(year_flag == 1){
            Intent i = new Intent(HomeActivity.this, Activity_Onepic_2017_8.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();
        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, Activity_Onepic_2016_8.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();
        }

    }

    /////////  need to change activity
    public void g3b3(View v){

        year_flag = year.getSelectedItemPosition();
        Log.d("=year===", "..year..>>"+year_flag );

        if(year_flag == 1){
            Intent i = new Intent(HomeActivity.this, Activity_Onepic_2017_9.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();
        }
        else if(year_flag == 2){
            Intent i = new Intent(HomeActivity.this, Activity_Onepic_2016_9.class);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            startActivity(i);
            this.finish();
        }

    }

//    public void next(View v){
////        Intent i = new Intent(HomeActivity.this, AboutActivity.class);
////        startActivity(i);
//
//            Intent i = new Intent(HomeActivity.this, ResultListActivity.class);
//            startActivity(i);
//       // }
//    }


}
