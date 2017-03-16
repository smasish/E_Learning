package ict.sci.kidslearning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import ict.sci.kidslearning.utils.AlertMessage;

public class Activity_Onepic_2016_4 extends Activity {

    private Context con;

    private TextView story;
    int indexArray=0,question_ind=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.one_story_question);
        con = this;
        //getActionBar().setBackgroundDrawable((getResources().getDrawable(R.drawable.actionbar)));


        story = (TextView)findViewById(R.id.des_id);

        story.setText(R.string.story_2016_4);

        question_ind=0;

    }

    public void showbox(View v){

        String instr = ""+getResources().getStringArray(R.array.instruction_set_2016_4)[question_ind];
        AlertMessage.showMessage(con,"Instruction",instr);
    }

    public void back(View v){
        this.finish();

    }

    public void next(View v){
        Intent i = new Intent(Activity_Onepic_2016_4.this, WordListActivity2016_4_4.class);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        startActivity(i);
        this.finish();
    }

}
