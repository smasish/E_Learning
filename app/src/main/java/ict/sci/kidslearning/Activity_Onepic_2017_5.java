package ict.sci.kidslearning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import ict.sci.kidslearning.utils.AlertMessage;

public class Activity_Onepic_2017_5 extends Activity {



    private TextView story;
    Context con;
    private TextView question,group;
    int indexArray=0,question_ind=0;
    int counter =3;
    private ImageButton img;

    String instr = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.one_pic_ques_2017_3);

        //getActionBar().setBackgroundDrawable((getResources().getDrawable(R.drawable.actionbar)));

        con = this;

        img = (ImageButton)findViewById(R.id.x1);

        img.setImageResource(R.drawable.story_17_5);

        indexArray=0;
        question_ind = 0;
        counter =3;

        question = (TextView)findViewById(R.id.question_id);


        group = (TextView)findViewById(R.id.group1);

        group.setText("বোধগম্যতা   ");
        question.setText("উপকরণের ছবি থেকে নীচের প্রশ্নের উত্তর দিতে পারে কি? ");
         instr = "যেভাবে সম্পাদন করতে হবে :\n" +
                 "শিক্ষার্থীকে উপরের গল্পটি পড়তে দিন। শিক্ষার্থী গল্পটি পড়ে বুঝতে পেড়েছে কি না তা নিচের তিনটি প্রশ্নের আলোকে যাচাই করুন। প্রশ্নের উত্তর দিতে পারলে ‘হ্যাঁ’ তে টিক চিহ্ন দিন না পারলে ‘না’ তে টিকচিহ্ন দিন।    \n";

                //    question.setText(""+getResources().getStringArray(R.array.word_list_2016_8)[question_ind]);

        story = (TextView)findViewById(R.id.des_id);

        story.setText(R.string.story_2017_5);



    }

    public void showbox(View v){

      //  String instr = ""+getResources().getStringArray(R.array.instructions_16_8)[question_ind];
        AlertMessage.showMessage(con,"Instruction",instr);
    }

    public void next(View v){

        Intent i = new Intent(Activity_Onepic_2017_5.this, WordListActivity2017_5_51.class);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        startActivity(i);
        this.finish();
    }

    public void back(View v){

        Intent i = new Intent(Activity_Onepic_2017_5.this, WordListActivity2017_5.class);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        startActivity(i);
        this.finish();
    }



}
