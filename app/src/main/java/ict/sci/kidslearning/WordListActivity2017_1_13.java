package ict.sci.kidslearning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import ict.sci.kidslearning.utils.AlertMessage;

public class WordListActivity2017_1_13 extends Activity {


    ListView lv;
    StateAdapter adapter;

    StateAdapter_single adapter_single;


    int flag_next = 0;
    private CommentsDataSource datasource;
    Context con;
    private TextView question,group;
    int indexArray=0,question_ind=0;
    int counter =9;


    String instr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.word_list_2017_1);
        con = this;



        indexArray=0;
        question_ind = 0;

        int a = getIntent().getIntExtra("val",5);
        counter =5+a;
      //  counter =9;

        group = (TextView)findViewById(R.id.group1);


        question = (TextView)findViewById(R.id.question_id);

     //   question.setText(""+getResources().getStringArray(R.array.word_list_2016_9)[question_ind]);
        //question_ind++;

        group.setText("বর্ণজ্ঞান");
        question.setText("১.৩. শিক্ষার্থী  নির্দিষ্ট শব্দের বর্ণগুলো সনাক্ত করতে পারে কি? ");

        lv = (ListView) findViewById(R.id.listView1);

        datasource = new CommentsDataSource(this);
        datasource.open();


        ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.word_set, android.R.layout.simple_list_item_1);
       // lv.setAdapter(aa);
        flag_next = 0;
       // adapter = new StateAdapter(this);
       // lv.setAdapter(adapter);



        adapter_single = new StateAdapter_single(this);
        lv.setAdapter(adapter_single);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(final AdapterView<?> parent,
                                    final View view, final int position, final long id) {
//				Toast.makeText(getApplicationContext(),
//						String.valueOf(position), Toast.LENGTH_LONG).show();

                Toast.makeText(con,"Counted",Toast.LENGTH_LONG).show();
//				final Intent imageshow = new Intent(SecondActivity.this,
//						GalleryActivity.class);



            }
        });

        instr = "যেভাবে সম্পাদন করতে হবে: শিক্ষার্থীকে বলুন যেমন ধর মই, এখানে প্রথম বর্ণ আছে ম এবং শেষ বর্ণ হলো ই। এখন প্রদত্ত টেবিল থেকে ৫টি শব্দের বর্ণগুলো সনাক্ত করে বলতে বলুন। শব্দের যে বর্ণগুলো শিক্ষার্থী সঠিক উচ্চারণে  পড়তে পেরেছে, প্রদত্ত টেবিলের দ্বিতীয় কলামে থাকা সেই বর্ণগুলোতে  টিকচিহ্ন দিন।";

    }


    public void showbox(View v){

     //   String instr = ""+getResources().getStringArray(R.array.instructions_16_9)[question_ind];
        AlertMessage.showMessage(con,"Instruction",instr);
    }


    public void single_toggle(View v){

        Toast.makeText(con,"Wrong",Toast.LENGTH_LONG).show();
        if(counter>=1)
            counter--;

    }

    public void back(View v){

        if(flag_next>0)
            flag_next--;
        if(question_ind>0)
            question_ind--;
      //  question.setText(""+getResources().getStringArray(R.array.word_list_2016_9)[question_ind]);

        if(flag_next == 1) {
            group.setText("বর্ণজ্ঞান");
         //   adapter = new StateAdapter(this);
        //    lv.setAdapter(adapter);
        }
        else if(flag_next == 0) {
            Intent img = new Intent(WordListActivity2017_1_13.this, QuestionActivity2017_1.class);
            startActivity(img);
            this.finish();
        }
    }

    public void next(View v){

        flag_next++;


         if(flag_next == 1) {
            Log.d("=k=size==" + datasource.getAllComments().size(), "...id..>>" + flag_next);
            question_ind++;
            question.setText("" + getResources().getStringArray(R.array.word_list_2016_9)[question_ind]);

            //  String id = "" + datasource.getAllComments().get(0).getId();

             int arr= datasource.getAllComments().size()-1;
             String id = "" + datasource.getAllComments().get(arr).getId();


             if( counter >=15)
                 datasource.updateOrderItems(id, "Mastery-LK");
             else if( counter >=10)
                 datasource.updateOrderItems(id, "Developed-LK");
             else
                 datasource.updateOrderItems(id, "Not yet \nDeveloped-LK");

            Log.d("=k=size==", ".flaginnggggggg." + flag_next);

            // Intent img = new Intent(WordListActivity.this, AboutActivity.class);
         //   Intent img = new Intent(WordListActivity2017_1_13.this, QuestionActivity2017_1.class);
        //    startActivity(img);
            this.finish();

        }


    }





    private class StateAdapter_single extends ArrayAdapter<String> {
        // StateListActivty context;
        private final Context con;

        public StateAdapter_single(final Context c) {
            super(c, R.layout.word_sent_17_1, getResources().getStringArray(R.array.word_list_2017_1_3));
            con = c;
            //flag_next = 1;
            // TODO Auto-generated constructor stub
        }

        @Override
        public View getView(final int position, final View convertView,
                            final ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                final LayoutInflater vi = (LayoutInflater) con
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.word_sent_17_1, null);
            }


            final TextView left = (TextView) v
                    .findViewById(R.id.left1);
            //left.setText(""+getResources().getStringArray(R.array.word_list_2016_7_5)[position]);
            left.setText(""+getResources().getStringArray(R.array.word_list_2017_1_3)[position]);
            //img.setImageResource(""+getResources().getStringArray(R.array.single_letter)[position]);

//            final TextView textView2 = (TextView) v
//                    .findViewById(R.id.bottom_row);
//            textView2.setText(""+getResources().getStringArray(R.array.wordmeaning_1st_letter)[position]);

            return v;
        }
    }



/*
	 * first adapter for state
	 */

    private class StateAdapter extends ArrayAdapter<String> {
        // StateListActivty context;
        private final Context con;

        public StateAdapter(final Context c) {
            super(c, R.layout.word_sent_16_8_5, getResources().getStringArray(R.array.word_list_2016_9_left));
            con = c;
            // TODO Auto-generated constructor stub
        }

        @Override
        public View getView(final int position, final View convertView,
                            final ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                final LayoutInflater vi = (LayoutInflater) con
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.word_sent_16_8_5, null);
            }
            final TextView textView = (TextView) v
                    .findViewById(R.id.top_row);
            textView.setText(""+getResources().getStringArray(R.array.word_list_2016_9_right)[position]);

            final TextView textView2 = (TextView) v
                    .findViewById(R.id.left1);
            textView2.setText(""+getResources().getStringArray(R.array.word_list_2016_9_left)[position]);

            return v;
        }
    }
}
