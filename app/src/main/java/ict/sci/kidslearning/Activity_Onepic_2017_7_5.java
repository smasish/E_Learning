package ict.sci.kidslearning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

public class Activity_Onepic_2017_7_5 extends Activity {

    Context context;

    private TextView story,group;
    private TextView question;
    int indexArray=0,question_ind=0;
    int counter =5;
    private ImageButton img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.one_pic_ques_2016_7_4);
        context = this;
        //getActionBar().setBackgroundDrawable((getResources().getDrawable(R.drawable.actionbar)));

        img = (ImageButton)findViewById(R.id.x1);

        img.setImageResource(R.drawable.story_burushiyal);

        story = (TextView)findViewById(R.id.des_id);

        story.setText(R.string.story_2017_7);

        question = (TextView)findViewById(R.id.question_id);


        group = (TextView)findViewById(R.id.group1);

        group.setText(" বোধগম্যতা");
        question.setText("উপকরণের ছবি থেকে নীচের প্রশ্নের উত্তর দিতে পারে কি? ");

     //   question.setText(""+getResources().getStringArray(R.array.question_set_2016_1)[question_ind]);


    }


    public void next(View v){

        Intent i = new Intent(Activity_Onepic_2017_7_5.this, WordListActivity2017_7_5.class);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        startActivity(i);
        this.finish();
    }

    public void back(View v){

        Intent i = new Intent(Activity_Onepic_2017_7_5.this, WordListActivity2017_7_31.class);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        startActivity(i);
        this.finish();
    }



}
