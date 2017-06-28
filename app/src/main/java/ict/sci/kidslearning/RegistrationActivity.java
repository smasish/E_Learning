package ict.sci.kidslearning;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ict.sci.kidslearning.utils.AlertMessage;
import ict.sci.kidslearning.utils.SharedPreferencesHelper;

public class RegistrationActivity extends AppCompatActivity {

    private CommentsDataSource datasource;
    private EditText school,student,roll; //class_name
    private int mYear, mMonth, mDay, mHour, mMinute,ampm;
    String str_school="",str_stud="",str_class="",str_roll="";
    private Context con;

    private Spinner school_code,jila_code;

//    String code[] = { "নির্বাচন করুন",
//            "55495217003",
//            "55495217005",
//            "55499422007",
//            "55499433008",
//            "55499439003",
//            "55499444009",
//            "55499450002",
//            "55499450007",
//            "55495228005",
//            "55495238017",
//            "55495238014",
//            "55495247001",
//            "55495257003",
//            "55495257008",
//            "55495276006",
//            "55495299009",
//            "55499455001",
//            "55499499012",
//            "55499499014",
//            "55495285001",
//    };

    String dis_code[] = { "নির্বাচন করুন","Barguna","Kurigram","Naogaon","Patuakhali"};


    String code_naog[] = { "নির্বাচন করুন",
            "Palsha Krishnopur GPS",
            "Trimohoni GPS",
            "Lohachura GPS",
            "Mokimpur GPS",
            "HatNaogaon GPS",
            "Gangjoar GPS",
            "Jaboi GPS",
            "Sapahar Model GPS",
            "Aihai GPS",
            "Nitpur Diyarapara  Model GPS",
            "Pahariapukur  GPS",
            "Moshidpur  GPS",
            "Mohadevpur Model GPS",
            "Chalkgouri GPS",
            "Chandas GPS",
            "Dhamoirhat Model GPS",
            "Chakmoyrom GPS",
            "Horitaki Danga GPS",};

    String code_patu[] = { "নির্বাচন করুন",
            "Dibuapur Model GPS",
            "Botolbunia GPS",
            "Matherbunia GPS",
            "Pachim Marichbunia GPS",
            "Kalikapur GPS",
            "Pachim Awliapur GPS",
            "Ballovpur GPS",
            "Pachim Kalikapur GPS",
            "Pasuribunia GPS",
            "Golachipa GPS"
    };

    String code_bar[] = { "নির্বাচন করুন",
            "Amtali AK High GPS",
            "Amtali Bandor madel GPS",
            "Cila H B GPS",
            "E. Cawra GPS",
            "kukua Hat GPS",
            "kukua Goskhali GPS",
            "S. Kawabunia GPS",
            "Gajipur bandor GPS",
            "Cawra Calitabunia GPS",
            "Ghatkhali GPS"

    };

    String code_kuri[] = { "নির্বাচন করুন",
            "Belgacha",
            "Kashiabari ModhoPara",
            "Kharija Kamal GPS",
            "Daldalia GPS",
            "Dhamserni Baraibari GPS",
            "Malatibari Dighor GPS",
            "Durgapur GPS",
            "Jamuna Beparipara GPS",
            "Rasulpur",
            "Suvarkuthi GPS",
            "Moddo Khamar Holokhana GPS",
            "Chakenda Khanpara GPS",
            "Horishwer GPS",
            "TalukKalua GPS",
            "Sener Khamar",
            "Karimer khamar",
            "Gunaigach GPS",
            "Ulipur GPS",
            "Narical Bari GPS",
            "Araji Bhog Danga",
    };


    List<String> categories;
    ArrayAdapter<String> dataAdapter;

    ArrayAdapter<String> districtadapter;

    int code_flag = 0,dis_index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        con = this;

        datasource = new CommentsDataSource(this);
        datasource.open();

      //  school = (EditText) findViewById(R.id.school_id);
        student = (EditText) findViewById(R.id.student_id);
      //  class_name = (EditText) findViewById(R.id.class_id);
        roll = (EditText) findViewById(R.id.roll_id);

        school_code = (Spinner)findViewById(R.id.school_id);

        jila_code = (Spinner)findViewById(R.id.dist_id);
      //  categories = new ArrayList<String>();
        code_flag = 0;


       // code_flag = school_code.getSelectedItemPosition();
        dis_index=0;

        districtadapter  = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dis_code);
        jila_code.setAdapter(districtadapter);

        jila_code.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                if(position == 1) {
                    dataAdapter = new ArrayAdapter<String>(con, android.R.layout.simple_spinner_item, code_bar);
                    school_code.setAdapter(dataAdapter);
                    dis_index=1;
                }
                else if(position == 2) {
                    dataAdapter = new ArrayAdapter<String>(con, android.R.layout.simple_spinner_item, code_kuri);
                    school_code.setAdapter(dataAdapter);
                    dis_index=2;
                }
                else if(position == 3) {
                    dis_index=3;
                    dataAdapter = new ArrayAdapter<String>(con, android.R.layout.simple_spinner_item, code_naog);
                    school_code.setAdapter(dataAdapter);
                }
                else if(position == 4) {
                    dis_index=4;
                    dataAdapter = new ArrayAdapter<String>(con, android.R.layout.simple_spinner_item, code_patu);
                    school_code.setAdapter(dataAdapter);
                }

                //code_flag = school_code.getSelectedItemPosition();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

//        if(SharedPreferencesHelper.getName(con).length()>2){
//           // school.setText(""+SharedPreferencesHelper.getName(con));
//            class_name.setText(""+SharedPreferencesHelper.getClass(con));
//        }


    }
//    public void next(View v){
////        Intent i = new Intent(HomeActivity.this, AboutActivity.class);
////        startActivity(i);
//
//        Intent i = new Intent(HomeActivity.this, ResultListActivity.class);
//        startActivity(i);
//        // }
//    }


    public void export(View v){

        Toast.makeText(RegistrationActivity.this, "Exported result into \nMyfile > Downloads > IAT RESULT 2017", Toast.LENGTH_SHORT).show();

    }

    public void result(View v){


        Intent i = new Intent(RegistrationActivity.this, ResultListActivity.class);
        startActivity(i);
    }

    public void next(View v){

      //  str_school=school.getText().toString();
        if(dis_index == 0)
            AlertMessage.showMessage(con, "Sorry", "Wrong school name.");
        else
        code_flag = school_code.getSelectedItemPosition();

        Log.d("=k=size=="+str_school, ".." +code_flag);
        if(dis_index==0)
            str_school = code_naog[code_flag];
        else  if(dis_index==1)
            str_school = code_bar[code_flag];
        else  if(dis_index==2)
            str_school = code_kuri[code_flag];
        else  if(dis_index==3)
            str_school = code_patu[code_flag];

        str_stud=student.getText().toString();
        //str_class=class_name.getText().toString();
        str_roll=roll.getText().toString();

        Log.d("====str_roll===="+str_roll, "...id..>>" + str_roll);


        if(code_flag == 0){
            AlertMessage.showMessage(con, "Sorry", "Wrong school name.");
        }else if(str_stud.length()<3){
            AlertMessage.showMessage(con, "Sorry", "Wrong student name.");
        }
        else if(str_class.length()<1){
            AlertMessage.showMessage(con, "Sorry", "Wrong class name.");
        }
        else if(str_roll.length()<1 || str_roll.length()>3){
            AlertMessage.showMessage(con, "Sorry", "Wrong roll no.");
        }
        else {

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        int mon = mMonth+1;
        String dat = mDay+"-"+mon+"-"+mYear;

        Log.d("=str_school==="+str_school, "..year..>>"+mYear+"---day: "+mDay );

        Comment comment = null;
            datasource.createComment(str_school,str_stud,str_class,dat,"Developed","Need \nImprovement","Developed",0,str_roll);
            List<Comment> values = datasource.getAllComments();

            Log.d("====k===="+values.get(0).getScore(), "...id..>>" + values.get(0).getComment());

        SharedPreferencesHelper.setName(con,str_school);
        SharedPreferencesHelper.setClass(con,str_class);

            Intent i = new Intent(RegistrationActivity.this, HomeActivity.class);
            //Intent i = new Intent(MainActivity.this, WordListActivity.class);
            startActivity(i);
           // this.finish();

        }
    }


}
