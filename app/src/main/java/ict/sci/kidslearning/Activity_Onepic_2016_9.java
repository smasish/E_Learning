package ict.sci.kidslearning;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Activity_Onepic_2016_9 extends Activity {

    Context context;

    private TextView story;
    private TextView question;
    int indexArray=0,question_ind=0;
    int counter =20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.one_pic_ques_2016_9);
        context = this;
        //getActionBar().setBackgroundDrawable((getResources().getDrawable(R.drawable.actionbar)));


        story = (TextView)findViewById(R.id.des_id);

        story.setText(R.string.story_2016_9);


        indexArray=0;
        question_ind = 1;
        counter =20;

        question = (TextView)findViewById(R.id.question_id);

        question.setText(""+getResources().getStringArray(R.array.word_list_2016_6)[question_ind]);

    }


    public void next(View v){



    }

    public void back(View v){


    }



}
