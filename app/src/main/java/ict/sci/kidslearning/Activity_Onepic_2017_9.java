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

public class Activity_Onepic_2017_9 extends Activity {

    Context con;

    private TextView story;
    private TextView question,group;
    int indexArray=0,question_ind=0;
    int counter =3;
    private ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.one_pic_ques_2016_9);
        con = this;
        //getActionBar().setBackgroundDrawable((getResources().getDrawable(R.drawable.actionbar)));

        img = (ImageButton)findViewById(R.id.x1);

        img.setImageResource(R.drawable.story_17_9);


        group = (TextView)findViewById(R.id.group1);
        group.setText("সাবলীলতা");

        story = (TextView)findViewById(R.id.des_id);

        story.setText(R.string.story_2017_9);


        indexArray=0;
        question_ind = 1;
        counter =6;

        question = (TextView)findViewById(R.id.question_id);

        question.setText(""+getResources().getStringArray(R.array.word_list_2016_6)[question_ind]);

    }


    public void showbox(View v){

        String instr = ""+getResources().getStringArray(R.array.instructions_16_8)[question_ind];
        AlertMessage.showMessage(con,"Instruction",instr);
    }

    public void next(View v){

        Intent i = new Intent(Activity_Onepic_2017_9.this, WordListActivity2017_9.class);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        startActivity(i);
        this.finish();
    }

    public void back(View v){
        this.finish();

    }



}
