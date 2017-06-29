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

public class WordListActivity2017_8 extends Activity {


    ListView lv;
    StateAdapter adapter;

    StateAdapter_last adapter_last;
    StateAdapter_single adapter_single;
    StateAdapter_second adapter_second;

    int flag_next = 0;
    private CommentsDataSource datasource;
    Context con;
    private TextView question,group;

    int indexArray=0,question_ind=0;
    int counter =9;

    private int[] imageArray = {
            R.drawable.dab, R.drawable.tv, R.drawable.chair, R.drawable.mas, R.drawable.train,
    };

    private int[] imageArray2 = {
            R.drawable.dabkai, R.drawable.maskini, R.drawable.fishing, R.drawable.noukaychori, R.drawable.basibajai,
    };

    String instr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.word_list_2016_2_43);
        con = this;




        indexArray=0;
        question_ind = 0;
        counter =3;

        group = (TextView)findViewById(R.id.group1);


        question = (TextView)findViewById(R.id.question_id);


        group.setText("সাবলীলতা");
        question.setText("৪. ১.: শিক্ষার্থী অধিকাংশ শব্দ শুদ্ধ উচ্চারণে পড়তে পারে");
        instr = "যেভাবে সম্পাদন করতে হবে: শিক্ষার্থীকে নিচের গল্পটি পড়তে দিন। শিক্ষার্থী গল্পটি পড়বে, শিক্ষক তার উপর ভিত্তি করে নিচের সামর্থ্যগুলো যাচাই করবেন। পারলে “হ্যাঁ” না পারলে “না”তে টিক দিন।";


        //   question.setText(""+getResources().getStringArray(R.array.word_list_2016_8)[question_ind]);
        //question_ind++;

        lv = (ListView) findViewById(R.id.listView1);

        datasource = new CommentsDataSource(this);
        datasource.open();


        ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.word_set, android.R.layout.simple_list_item_1);
       // lv.setAdapter(aa);
        flag_next = 1;
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

    }


    public void showbox(View v){

    //    String instr = ""+getResources().getStringArray(R.array.instructions_16_8)[question_ind];
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
  //      question.setText(""+getResources().getStringArray(R.array.question_set_2016_1)[question_ind]);


      if(flag_next==0){
            Intent img = new Intent(WordListActivity2017_8.this, Activity_Onepic_2017_8.class);
            startActivity(img);
            this.finish();

        }
        else if(flag_next == 1) {
          group.setText("বোধগম্যতা");
          question.setText("গল্পটি পড়ার পর শিক্ষার্থীকে নিচের তিনটি প্রশ্ন জিজ্ঞেস করুন");
          instr = "যেভাবে সম্পাদন করতে হবে: শিক্ষার্থীকে নিচের গল্পটি পড়তে দিন। শিক্ষার্থী গল্পটি পড়বে, শিক্ষক তার উপর ভিত্তি করে নিচের সামর্থ্যগুলো যাচাই করবেন। পারলে “হ্যাঁ” না পারলে “না”তে টিক দিন।";

          adapter_single = new StateAdapter_single(this);
          lv.setAdapter(adapter_single);

        }

    }

    public void next(View v){

        flag_next++;


        Log.d("=k=size=="+datasource.getAllComments().size(), "...id..>>"+flag_next );
        question_ind++;
    //    question.setText(""+getResources().getStringArray(R.array.question_set_2016_1)[question_ind]);

        if(flag_next == 2) {
            group.setText("বোধগম্যতা");
            question.setText("গল্পটি পড়ার পর শিক্ষার্থীকে নিচের তিনটি প্রশ্ন জিজ্ঞেস করুন");
            instr = "\tযেভাবে সম্পাদন করতে হবে: শিক্ষার্থীকে গল্পটি পড়তে দিন । গল্পটি পড়ার পর শিক্ষার্থীকে নিচের তিনটি প্রশ্ন জিজ্ঞেস করুন। পারলে “হ্যাঁ” না পারলে “না”তে টিক দিন। (উত্তরগুলো কাছাকাছি হলেও সঠিক বলে ধরে নিন)।";
            adapter_second = new StateAdapter_second(this);
            lv.setAdapter(adapter_second);

            int arr= datasource.getAllComments().size()-1;
            String id = "" + datasource.getAllComments().get(arr).getId();
            Log.d("=k=size=="+datasource.getAllComments().size(), ".." );
            if(counter>=2)
                datasource.updatePhonetics(id, "Mastery-FLU");
            else  if(counter>=1)
                datasource.updatePhonetics(id, "Developed-FLU");
            else
                datasource.updatePhonetics(id, "Not yet \nDeveloped-FLU");

            counter = 3;
        }
        else if(flag_next==3){
          //  String id = "" + datasource.getAllComments().get(0).getId();

            int arr= datasource.getAllComments().size()-1;
            String id = "" + datasource.getAllComments().get(arr).getId();
            Log.d("=k=size=="+datasource.getAllComments().size(), ".." );
            if(counter>=2)
                datasource.updatevocabulary(id, "Mastery-COMP");
            else  if(counter>=1)
                datasource.updatevocabulary(id, "Developed-COMP");
            else
                datasource.updatevocabulary(id, "Not yet \nDeveloped-COMP");

            Log.d("=k=size==", ".flaginnggggggg." +flag_next);

           // Intent img = new Intent(WordListActivity.this, AboutActivity.class);
         //   Intent img = new Intent(WordListActivity2016_7_4.this, Activity_Onepic_2016_7_4.class);
         //   startActivity(img);
            this.finish();
        }



    }



    private class StateAdapter_single extends ArrayAdapter<String> {
        // StateListActivty context;
        private final Context con;

        public StateAdapter_single(final Context c) {
            super(c, R.layout.word_sent_16_8, getResources().getStringArray(R.array.word_list_2017_7_41));
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
                v = vi.inflate(R.layout.word_sent_16_8, null);
            }


            final TextView left = (TextView) v
                    .findViewById(R.id.left1);
            //left.setText(""+getResources().getStringArray(R.array.word_list_2016_7_5)[position]);
            left.setText(""+getResources().getStringArray(R.array.word_list_2017_7_41)[position]);
            //img.setImageResource(""+getResources().getStringArray(R.array.single_letter)[position]);

//            final TextView textView2 = (TextView) v
//                    .findViewById(R.id.bottom_row);
//            textView2.setText(""+getResources().getStringArray(R.array.wordmeaning_1st_letter)[position]);

            return v;
        }
    }

    private class StateAdapter_second extends ArrayAdapter<String> {
        // StateListActivty context;
        private final Context con;

        public StateAdapter_second(final Context c) {
            super(c, R.layout.word_sent_16_8, getResources().getStringArray(R.array.word_list_2017_8));
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
                v = vi.inflate(R.layout.word_sent_16_8, null);
            }


            final TextView left = (TextView) v
                    .findViewById(R.id.left1);
            //left.setText(""+getResources().getStringArray(R.array.word_list_2016_7_5)[position]);
            left.setText(""+getResources().getStringArray(R.array.word_list_2017_8)[position]);
            //img.setImageResource(""+getResources().getStringArray(R.array.single_letter)[position]);

//            final TextView textView2 = (TextView) v
//                    .findViewById(R.id.bottom_row);
//            textView2.setText(""+getResources().getStringArray(R.array.wordmeaning_1st_letter)[position]);

            return v;
        }
    }


    private class StateAdapter_last extends ArrayAdapter<String> {
        // StateListActivty context;
        private final Context con;

        public StateAdapter_last(final Context c) {
            super(c, R.layout.image_word2016_2, getResources().getStringArray(R.array.word2016_2_43));
            con = c;
           // flag_next = 2;
            // TODO Auto-generated constructor stub


        }

        @Override
        public View getView(final int position, final View convertView,
                            final ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                final LayoutInflater vi = (LayoutInflater) con
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.image_word2016_2, null);
            }
            final TextView textView = (TextView) v
                    .findViewById(R.id.top_row);
            textView.setText(""+getResources().getStringArray(R.array.word2016_2_43)[position]);
            final ImageView img = (ImageView) v
                    .findViewById(R.id.img_id);
            img.setImageResource(imageArray2[position]);



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
            super(c, R.layout.word_sent_16_8_5, getResources().getStringArray(R.array.word_list_2016_8_left));
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
            textView.setText(""+getResources().getStringArray(R.array.word_list_2016_8_right)[position]);

            final TextView textView2 = (TextView) v
                    .findViewById(R.id.left1);
            textView2.setText(""+getResources().getStringArray(R.array.word_list_2016_8_left)[position]);

            return v;
        }
    }
}
