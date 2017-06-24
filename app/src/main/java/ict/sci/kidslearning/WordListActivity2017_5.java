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

public class WordListActivity2017_5 extends Activity {

    Context con;
    ListView lv;
    StateAdapter adapter;
    Adapter_spelling spell_adapter;
    StateAdapter_last adapter_last;

    StateAdapter_second adapter_second;
    StateAdapter_single adapter_single;

    int flag_next = 0;
    private CommentsDataSource datasource;
    private TextView question,group;
    int indexArray=0,question_ind=0;
int counter =20;

    private int[] karArray = {
            R.drawable.pepe, R.drawable.beli_ful, R.drawable.anaros, R.drawable.rail, R.drawable.angul
    };

    String instr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.word_list_2016_1);
        con = this;



        indexArray=0;
        question_ind = 7;
        counter =20;

        question = (TextView)findViewById(R.id.question_id);

        group = (TextView)findViewById(R.id.group1);

        group.setText("শব্দভাণ্ডার  ");
        question.setText("৩.১  শিক্ষার্থী  নিচের যুক্তবর্ণ যুক্ত শব্দ পড়তে পারে কি ?  ");
        instr = "যেভাবে সম্পাদন করতে হবে : শিক্ষার্থীকে প্রদত্ত টেবিল থেকে  যুক্তবর্ণ যুক্ত শব্দগুলো পড়তে দিন।  পড়তে পারলে হ্যাঁ তে টিক চিহ্ন দিন না পারলে না তে টিকচিহ্ন দিন। ";

    //    question.setText(""+getResources().getStringArray(R.array.question_set_2016_1)[question_ind]);
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

      //  String instr = ""+getResources().getStringArray(R.array.instruction_set_2016_1)[question_ind];
        AlertMessage.showMessage(con,"Instruction",instr);
    }


    public void single_toggle(View v){

        Toast.makeText(con,"Wrong",Toast.LENGTH_LONG).show();
        counter--;

    }

    public void back(View v){

      //  Intent img = new Intent(WordListActivity2017_5.this, HomeActivity.class);
     //   startActivity(img);


        if(flag_next>0)
            flag_next--;

        if(question_ind>0)
            question_ind--;
  //      question.setText(""+getResources().getStringArray(R.array.question_set_2016_1)[question_ind]);

       if(flag_next == 1) {
           group.setText("শব্দভাণ্ডার  ");
           question.setText("উপকরণের ছবি থেকে নীচের প্রশ্নের উত্তর দিতে পারে কি? ");
           adapter_single = new StateAdapter_single(this);
           lv.setAdapter(adapter_single);

        }else {
           this.finish();
       }

//        if(flag_next>0)
//        flag_next--;
    }

    public void next(View v){
        flag_next++;
        Log.d("=k=size=="+datasource.getAllComments().size(), "...id..>>"+flag_next );
        question_ind++;
   //     question.setText(""+getResources().getStringArray(R.array.question_set_2016_1)[question_ind]);

        if(flag_next==3){
          //  String id = "" + datasource.getAllComments().get(0).getId();

            int arr= datasource.getAllComments().size()-1;
            String id = "" + datasource.getAllComments().get(arr).getId();
            Log.d("=k=size=="+datasource.getAllComments().size(), ".." );
            if(counter>=16)
                datasource.updatevocabulary(id, "Mastery");
            else  if(counter>=10)
                datasource.updatevocabulary(id, "Developed");
            else
                datasource.updatevocabulary(id, "Need \nImprovement");



           // Intent img = new Intent(WordListActivity.this, AboutActivity.class);
            Intent img = new Intent(WordListActivity2017_5.this, Activity_Onepic_2017_5.class);
            startActivity(img);
            this.finish();
       }

        else if(flag_next == 2) {
            group.setText("শব্দভাণ্ডার  ");
            question.setText("৩.২/৩.৩ শিক্ষার্থী ছবির নাম ও ঐ শব্দ দিয়ে বাক্য বলতে পারে কি ? ");
            instr = "  যেভাবে সম্পাদন করতে হবে :\n" +
                    "শিক্ষার্থীদের  টেবিলে প্রদত্ত ছবির নাম বলতে বলুন। যদি বলতে পারে ‘হ্যাঁ’ তে টিক চিহ্ন দিন না পারলে ‘না’ তে টিক চিহ্ন দিন। এরপর ঐ শব্দ দিয়ে  বাক্য তৈরি করতে বলুন। যদি বাক্য তৈরি করতে পারে ‘হ্যাঁ’ তে টিক চিহ্ন দিন না পারলে ‘না’ তে টিক চিহ্ন দিন।\n";

            adapter_last = new StateAdapter_last(this);
            lv.setAdapter(adapter_last);

        }

    }



    private class StateAdapter_single extends ArrayAdapter<String> {
        // StateListActivty context;
        private final Context con;

        public StateAdapter_single(final Context c) {
            super(c, R.layout.word_singleletter, getResources().getStringArray(R.array.word_list_2017_5_31));
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
                v = vi.inflate(R.layout.word_singleletter, null);
            }
            final TextView textView = (TextView) v
                    .findViewById(R.id.single_letter);
            textView.setText(""+getResources().getStringArray(R.array.word_list_2017_5_31)[position]);

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
            super(c, R.layout.word_singleletter, getResources().getStringArray(R.array.word_list_2017_4_23));
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
                v = vi.inflate(R.layout.word_singleletter, null);
            }
            final TextView textView = (TextView) v
                    .findViewById(R.id.single_letter);
            textView.setText(""+getResources().getStringArray(R.array.word_list_2017_4_23)[position]);

//            final TextView textView2 = (TextView) v
//                    .findViewById(R.id.bottom_row);
//            textView2.setText(""+getResources().getStringArray(R.array.wordmeaning_1st_letter)[position]);

            return v;
        }
    }

    private class Adapter_spelling extends ArrayAdapter<String> {
        // StateListActivty context;
        private final Context con;

        public Adapter_spelling(final Context c) {
            super(c, R.layout.spelling_sound, getResources().getStringArray(R.array.spelling_sound));
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
                v = vi.inflate(R.layout.spelling_sound, null);
            }
            final TextView textView = (TextView) v
                    .findViewById(R.id.single_letter);
            textView.setText(""+getResources().getStringArray(R.array.spelling_sound)[position]);

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
            super(c, R.layout.imagerow_word_sent, getResources().getStringArray(R.array.word_list_2017_5_32));
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
                v = vi.inflate(R.layout.imagerow_word_sent, null);
            }
            final TextView textView = (TextView) v
                    .findViewById(R.id.top_row);
            textView.setText(""+getResources().getStringArray(R.array.word_list_2017_5_32)[position]);

            final ImageView img = (ImageView) v
                    .findViewById(R.id.img_id);
            img.setImageResource(karArray[position]);
            //img.setImageResource(""+getResources().getStringArray(R.array.single_letter)[position]);

            final TextView textView2 = (TextView) v
                    .findViewById(R.id.top_row2);
            textView2.setText(""+getResources().getStringArray(R.array.word_list_2017_5_32_right)[position]);

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
            super(c, R.layout.wordmeaning_1st, getResources().getStringArray(R.array.word_list_2017_2_13));
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
                v = vi.inflate(R.layout.wordmeaning_1st, null);
            }
            final TextView textView = (TextView) v
                    .findViewById(R.id.top_row);
            textView.setText(""+getResources().getStringArray(R.array.word_list_2017_2_13)[position]);

//            final TextView textView2 = (TextView) v
//                    .findViewById(R.id.bottom_row);
//            textView2.setText(""+getResources().getStringArray(R.array.wordmeaning_1st_letter)[position]);

            return v;
        }
    }




}
