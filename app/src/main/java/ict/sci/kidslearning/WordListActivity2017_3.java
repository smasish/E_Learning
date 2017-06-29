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

public class WordListActivity2017_3 extends Activity {

    Context con;
    ListView lv;
    StateAdapter adapter;
    Adapter_spelling spell_adapter;
    StateAdapter_last adapter_last;
    StateAdapter_single adapter_single;

    int flag_next = 0;
    private CommentsDataSource datasource;
    private TextView question,group;
    int indexArray=0,question_ind=0;
int counter =20;

    private int[] karArray = {
            R.drawable.tree, R.drawable.gori, R.drawable.ful, R.drawable.dul, R.drawable.moyur
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
        int a = getIntent().getIntExtra("val",5);
        counter =10+a;

        question = (TextView)findViewById(R.id.question_id);

        group = (TextView)findViewById(R.id.group1);

        group.setText("বর্ণজ্ঞান  ");
        question.setText("১.২ শিক্ষার্থী কি ব্যঞ্জনবর্ণের সঙ্গে ব্যঞ্জনবর্ণ (যুক্তবর্ণ) যুক্ত করে পড়তে পারে?  ");

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
       instr = "যেভাবে সম্পাদন করতে হবে: শিক্ষার্থীকে  উপরের বক্সে থাকা শব্দগুলোর পাশাপাশি পাশের বক্সে থাকা যুক্তবর্ণগুলোও পড়তে বলুন। শিক্ষার্থী যদি ব্যঞ্জনবর্ণের সাথে ব্যঞ্জনবর্ণ যুক্ত করে  শুদ্ধভাবে পড়তে পারে, তবে প্রদত্ত বক্সে টিকচিহ্ন দিন। না পারলে ক্রসচিহ্ন দিন। ";

    }


    public void showbox(View v){

      //  String instr = ""+getResources().getStringArray(R.array.instruction_set_2016_1)[question_ind];
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

        if(flag_next == 1) {
            group.setText("বর্ণজ্ঞান  ");
            question.setText("১.২ শিক্ষার্থী কি ব্যঞ্জনবর্ণের সঙ্গে ব্যঞ্জনবর্ণ (যুক্তবর্ণ) যুক্ত করে পড়তে পারে?  ");
            instr = "যেভাবে সম্পাদন করতে হবে: শিক্ষার্থীকে  উপরের বক্সে থাকা শব্দগুলোর পাশাপাশি পাশের বক্সে থাকা যুক্তবর্ণগুলোও পড়তে বলুন। শিক্ষার্থী যদি ব্যঞ্জনবর্ণের সাথে ব্যঞ্জনবর্ণ যুক্ত করে  শুদ্ধভাবে পড়তে পারে, তবে প্রদত্ত বক্সে টিকচিহ্ন দিন। না পারলে ক্রসচিহ্ন দিন। ";

            adapter_single = new StateAdapter_single(this);
            lv.setAdapter(adapter_single);

        }
        else if(flag_next == 0) {
            Intent img = new Intent(WordListActivity2017_3.this, QuestionActivity2017_3.class);
            startActivity(img);
            this.finish();

        }

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
            if(counter>=30)
                datasource.updateOrderItems(id, "Mastery-LK");
            else  if(counter>=20)
                datasource.updateOrderItems(id, "Developed-LK");
            else
                datasource.updateOrderItems(id, "Not yet \nDeveloped-LK");



           // Intent img = new Intent(WordListActivity.this, AboutActivity.class);
            Intent img = new Intent(WordListActivity2017_3.this, Activity_Onepic_2017_3.class);
            startActivity(img);
            this.finish();
       }


        else if(flag_next == 2) {
            group.setText("বর্ণজ্ঞান  ");
            question.setText("১.৩  শিক্ষার্থী কি ছবি দেখে ছবি সংশ্লিষ্ট শব্দে কী কী কার-চিহ্ন আছে তা পড়তে পারে? ");
            instr = "যেভাবে সম্পাদন করতে হবে: শিক্ষার্থীকে বাম পাশের টেবিলে থাকা  ছবি দেখে ছবিটির নাম/শব্দ বলতে বলুন এবং শব্দে কী কী কার-চিহ্ন আছে জিজ্ঞেস করুন। শিক্ষার্থী যদি ছবি সংশ্লিষ্ট শব্দের কার-চিহ্নগুলো  শুদ্ধভাবে বলতে পারে তবে প্রদত্ত টেবিলের ‘হ্যাঁ’ কলামে টিকচিহ্ন দিন। না পারলে ‘না’ কলামে টিকচিহ্ন দিন।  ";

            adapter_last = new StateAdapter_last(this);
            lv.setAdapter(adapter_last);

        }

    }



    private class StateAdapter_single extends ArrayAdapter<String> {
        // StateListActivty context;
        private final Context con;

        public StateAdapter_single(final Context c) {
            super(c, R.layout.word_singleletter, getResources().getStringArray(R.array.word_list_2017_3_12));
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
            textView.setText(""+getResources().getStringArray(R.array.word_list_2017_3_12)[position]);

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
            super(c, R.layout.imagerow_list, getResources().getStringArray(R.array.word_list_2017_3_13));
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
                v = vi.inflate(R.layout.imagerow_list, null);
            }
            final TextView textView = (TextView) v
                    .findViewById(R.id.top_row);
            textView.setText(""+getResources().getStringArray(R.array.word_list_2017_3_13)[position]);

            final ImageView img = (ImageView) v
                    .findViewById(R.id.img_id);
            img.setImageResource(karArray[position]);
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
