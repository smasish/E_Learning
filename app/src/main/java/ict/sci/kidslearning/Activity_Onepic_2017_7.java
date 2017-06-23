package ict.sci.kidslearning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

public class Activity_Onepic_2017_7 extends Activity {

    Context con;
    private TextView question,group;
    int indexArray=0,question_ind=0;
    int counter =20;
  //  private TextView story;

    private ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.one_pic_ques_2017_7);
        con = this;

        img = (ImageButton)findViewById(R.id.x1);

        img.setImageResource(R.drawable.story7);


        indexArray=0;
        question_ind = 0;
        counter =6;
        group = (TextView)findViewById(R.id.group1);


        question = (TextView)findViewById(R.id.question_id);

        group.setText("শব্দভা-ার");
        question.setText("উপকরণের ছবি থেকে নীচের প্রশ্নের উত্তর দিতে পারে কি? ");


    //    question.setText(""+getResources().getStringArray(R.array.word_list_2016_8)[question_ind]);

    //    story = (TextView)findViewById(R.id.des_id);

    //    story.setText(R.string.story_2016_7);


    }


    public void next(View v){

        Intent i = new Intent(Activity_Onepic_2017_7.this, WordListActivity2017_7_31.class);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        startActivity(i);
        this.finish();
    }

    public void back(View v){
        this.finish();

    }



}
