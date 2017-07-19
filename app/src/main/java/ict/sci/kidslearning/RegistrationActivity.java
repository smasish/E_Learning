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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
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
            "Arjundara GPS",
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

    int code_flag = 0,dis_index=0,gender_ind=0;
    String gen="";
    private RadioGroup radioGroup;
    private RadioButton radioButton;


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

        gender_ind=0;
       // code_flag = school_code.getSelectedItemPosition();
        dis_index=0;


        RadioGroup  group= (RadioGroup) findViewById(R.id.radiotype);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View radioButton = radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);
                gender_ind=index;
                Log.d("=----=index=="+index, ".." +index);
            }
        });

        Log.d("=----=gender_ind=="+gender_ind, ".." +gender_ind);

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


        HSSFWorkbook hwb = new HSSFWorkbook();
        HSSFSheet sheet = hwb.createSheet("IAT_RESULT");

        String[] schoolbag = new String[datasource.getAllComments().size()];
        String[] name = new String[datasource.getAllComments().size()];

        for(int x = 0; x < datasource.getAllComments().size(); x++) {
            schoolbag[x] = datasource.getAllComments().get(x).getPhone();
            Log.d("=----schoolbag==", ".schoolbag[x]." +schoolbag[x]);
            name[x] = datasource.getAllComments().get(x).getStudent();
        }

        for(int x = 0; x < datasource.getAllComments().size(); x++)
        {
            //   String[] arr = schoolbag[x];
            HSSFRow row = sheet.createRow(x);
            int i =0;
//            for(int i = 0; i< schoolbag.length; i++)
//            {
//                HSSFCell cell = row.createCell(i);
//                String data = schoolbag[i];
//                Log.d("=-i---schoolbag==", ".schoolbag[x]." +schoolbag[i]);
//                cell.setCellValue(data);
//
//            }
            HSSFCell cell = row.createCell(i);
            cell.setCellValue("Name");
            String data = datasource.getAllComments().get(x).getStudent();
            cell.setCellValue(data);
            i++;
            cell = row.createCell(i);
            cell.setCellValue("Roll No");
            data = datasource.getAllComments().get(x).getRoll();
            cell.setCellValue(data);
            i++;

            cell = row.createCell(i);
            cell.setCellValue("Gender");
            data = datasource.getAllComments().get(x).getGen();
            cell.setCellValue(data);
            i++;

            cell = row.createCell(i);
            cell.setCellValue("Class Name");
            data = datasource.getAllComments().get(x).getClas();
            cell.setCellValue(data);
            i++;

            cell = row.createCell(i);
            cell.setCellValue("School Name");
            data = datasource.getAllComments().get(x).getSchool();
            cell.setCellValue(data);
            i++;

             cell = row.createCell(i);
             data = datasource.getAllComments().get(x).getLetter();
            cell.setCellValue(data);
            i++;
            cell = row.createCell(i);
             data = datasource.getAllComments().get(x).get_vocabulary();
            cell.setCellValue(data);
            i++;
            cell = row.createCell(i);
            data = datasource.getAllComments().get(x).getPhone();
            cell.setCellValue(data);
            i++;

            cell = row.createCell(i);
            data = datasource.getAllComments().get(x).getDat();
            cell.setCellValue(data);


           // i++;


        }
        try {
            // FileOutputStream fileOut = new FileOutputStream(Environment.getExternalStorageDirectory() + APP_FILES_PATH + "file.xls");
            FileOutputStream fileOut = new FileOutputStream("/sdcard/Download/" + "IAT2017.xls");


            Log.d("=k=size==", ".flaginnggggggg." +fileOut);
            hwb.write(fileOut);
            fileOut.close();
        }catch (Exception e){

        }
    }

    public void result(View v){


        Intent i = new Intent(RegistrationActivity.this, ResultListActivity.class);
        startActivity(i);
    }

    public void next(View v){

      //  str_school=school.getText().toString();

//
//        RadioGroup  group= (RadioGroup) findViewById(R.id.radiotype);
//        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                View radioButton = radioGroup.findViewById(i);
//                int index = radioGroup.indexOfChild(radioButton);
//                gender_ind=index;
//                Log.d("=----=index=="+index, ".." +index);
//            }
//        });
//
        Log.d("=----=gender_ind=="+gender_ind, ".." +gender_ind);

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
//        else if(str_class.length()<1){
//            AlertMessage.showMessage(con, "Sorry", "Wrong class name.");
//        }
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

            if(gender_ind == 0)
                gen = "Male";
            else
                gen = "Female";


        Comment comment = null;
            datasource.createComment(str_school,str_stud,str_class,dat,"-","-","-",0,str_roll,gen);
            List<Comment> values = datasource.getAllComments();

            Log.d("====k===="+values.get(0).getScore(), "...id..>>" + values.get(0).getSchool());

        SharedPreferencesHelper.setName(con,str_school);
        SharedPreferencesHelper.setClass(con,str_class);

            Intent i = new Intent(RegistrationActivity.this, HomeActivity.class);
            //Intent i = new Intent(MainActivity.this, WordListActivity.class);
            startActivity(i);
           // this.finish();

            student.setText("");
            roll.setText("");

        }
    }


}
