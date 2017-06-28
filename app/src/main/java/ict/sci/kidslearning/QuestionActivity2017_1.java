package ict.sci.kidslearning;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import ict.sci.kidslearning.utils.AlertMessage;

public class QuestionActivity2017_1 extends AppCompatActivity {

    private Context con;
    private ImageButton imb1,imb2,imb3,imb4,imb5,imb6;

    private TextView question,group;
    int indexArray=0,question_ind=0;

    int counter=11, lettersor=0;

    private int[] imageArray = {
            R.drawable.a15,R.drawable.a16,R.drawable.a17,R.drawable.a20, R.drawable.a14,R.drawable.a13,
            R.drawable.a18,R.drawable.a23,
          R.drawable.a24,R.drawable.a22,  R.drawable.a19,R.drawable.a21,
           R.drawable.a12,R.drawable.a25,R.drawable.a36,R.drawable.blank, R.drawable.blank, R.drawable.blank

    };

    String instr ="";
    private CommentsDataSource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_al_2016_1);


        con = this;
        indexArray=0;




        group = (TextView)findViewById(R.id.group1);


        question = (TextView)findViewById(R.id.question_id);

        int a = getIntent().getIntExtra("val",5);
        counter =15+a;

        Log.d("next-----"+a, "start===="+counter);

        imb1 = (ImageButton)findViewById(R.id.x1);
        imb2 = (ImageButton)findViewById(R.id.x2);
        imb3 = (ImageButton)findViewById(R.id.x3);
        imb4 = (ImageButton)findViewById(R.id.y1);
        imb5 = (ImageButton)findViewById(R.id.y2);
        imb6 = (ImageButton)findViewById(R.id.y3);

        int i = indexArray;
        imb1.setImageResource(imageArray[i]);
        imb2.setImageResource(imageArray[i+1]);
        imb3.setImageResource(imageArray[i+2]);
        imb4.setImageResource(imageArray[i+3]);
        imb5.setImageResource(imageArray[i+4]);
        imb6.setImageResource(imageArray[i+5]);

        datasource = new CommentsDataSource(this);
        datasource.open();

        indexArray = 6;

      //  question.setText(""+getResources().getStringArray(R.array.question_set_2016_1)[question_ind]);
        group.setText("বর্ণজ্ঞান");
        question.setText("১.২  শিক্ষার্থী  কি এলোমেলো ১৫টি ব্যঞ্জনবর্ণের সবগুলো চিনতে পারে?  ");
        question_ind++;

        instr = "যেভাবে সম্পাদন করতে হবে: শিক্ষার্থীকে নিচের এলোমেলোভাবে সাজানো বর্ণমালার চার্টটি পড়তে দিন। শিক্ষার্থী যে বর্ণগুলো চিনে পড়তে পেরেছে সেগুলোতে টিকচিহ্ন দিন।  ";
    }


    public void oneone(View v){
        if(counter>1)
            counter--;
        Toast.makeText(con,"Counted"+counter,Toast.LENGTH_LONG).show();
    }
    public void onetwo(View v){

        if(counter>1)
            counter--;
        Toast.makeText(con,"Counted"+counter,Toast.LENGTH_LONG).show();

    }
    public void onethree(View v){


        counter--;
        Toast.makeText(con,"Counted"+counter,Toast.LENGTH_LONG).show();
    }
    public void twoone(View v){

        if(counter>1)
            counter--;
        Toast.makeText(con,"Counted"+counter,Toast.LENGTH_LONG).show();

    }
    public void twotwo(View v){

        Toast.makeText(con,"Counted"+counter,Toast.LENGTH_LONG).show();

        if(counter>1)
            counter--;
    }
    public void twothree(View v){

        Toast.makeText(con,"Counted"+counter,Toast.LENGTH_LONG).show();
        if(counter>1)
            counter--;
    }

    public void showbox(View v){

       // String instr = ""+getResources().getStringArray(R.array.instruction_set_2016_1)[question_ind];
        AlertMessage.showMessage(con,"Instruction",instr);
    }

    public void next(View v){

        Log.d("next-----", "start===="+indexArray);
       // for(int i=indexArray;i<imageArray.length;i+=6){
        group.setText("বর্ণজ্ঞান");
        question.setText("১.২  শিক্ষার্থী  কি এলোমেলো ১৫টি ব্যঞ্জনবর্ণের সবগুলো চিনতে পারে?  ");

        int i = indexArray;
    //    question.setText(""+getResources().getStringArray(R.array.question_set_2016_1)[question_ind]);
        question_ind++;

        if(question_ind == 3){
            lettersor = counter;

           // counter = 25;
        }


        if(i<=imageArray.length-6){
            imb1.setImageResource(imageArray[i]);
            imb2.setImageResource(imageArray[i+1]);
            imb3.setImageResource(imageArray[i+2]);
            imb4.setImageResource(imageArray[i+3]);
            imb5.setImageResource(imageArray[i+4]);
            imb6.setImageResource(imageArray[i+5]);

            indexArray = i+6;
            Log.d("next-----"+i, "start===="+indexArray);
        }else {
           // Log.d("size]]]]]]>>>----"+datasource.getAllComments().size(), "start====");




//            int arr= datasource.getAllComments().size()-1;
//            String id = "" + datasource.getAllComments().get(arr).getId();
//            Log.d("lettersor-----"+lettersor, "counter===="+counter);
//
//            if( counter >=15)
//                datasource.updateOrderItems(id, "Mastery-LK");
//            else if( counter >=10)
//                datasource.updateOrderItems(id, "Developed-LK");
//            else
//                datasource.updateOrderItems(id, "Not yet \nDeveloped-LK");

//            if(lettersor>=7 && counter >=13)
//                datasource.updateOrderItems(id, "Mastery-LK");
//            else if(lettersor>=5 && counter >=10)
//                datasource.updateOrderItems(id, "Developed-LK");
//            else
//                datasource.updateOrderItems(id, "Not yet \nDeveloped-LK");

           // Intent img = new Intent(QuestionActivity.this, AboutActivity.class);
            Intent img = new Intent(QuestionActivity2017_1.this, WordListActivity2017_1_13.class);
            img.putExtra("val",counter);
            startActivity(img);
            this.finish();
        }

    }

    public void back(View v){

        Log.d("back-----", "start===="+indexArray);
        group.setText("বর্ণজ্ঞান");
        question.setText("১.২  শিক্ষার্থী  কি এলোমেলো ১৫টি ব্যঞ্জনবর্ণের সবগুলো চিনতে পারে?  ");

        int i = indexArray;

        if(question_ind>0)
            question_ind--;
     //   question.setText(""+getResources().getStringArray(R.array.question_set_2016_1)[question_ind]);


        //for(int i = indexArray;i>6;i-=6) {
        if(i>5){
            imb1.setImageResource(imageArray[i - 6]);
            imb2.setImageResource(imageArray[i - 5]);
            imb3.setImageResource(imageArray[i - 4]);
            imb4.setImageResource(imageArray[i - 3]);
            imb5.setImageResource(imageArray[i - 2]);
            imb6.setImageResource(imageArray[i-1]);

            indexArray = i-6;
            Log.d("back-----"+i, "start===="+indexArray);

        }else{
            Intent img = new Intent(QuestionActivity2017_1.this, WordListActivity2017_1.class);
            startActivity(img);
            this.finish();
        }

    }


}
