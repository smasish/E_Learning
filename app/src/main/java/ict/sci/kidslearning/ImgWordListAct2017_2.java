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

public class ImgWordListAct2017_2 extends Activity {

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

    private int[] imageArray = {
            R.drawable.chosma, R.drawable.dab_kai, R.drawable.dul_bajai, R.drawable.boi_pori, R.drawable.bang,
    };

    private int[] karArray = {
            R.drawable.chuk, R.drawable.pata, R.drawable.tala, R.drawable.moyur, R.drawable.apel,
    };

    private int[] imageArray2 = {
            R.drawable.dabkai, R.drawable.maskini, R.drawable.fishing, R.drawable.noukaychori, R.drawable.basibajai,
    };

    String instr = "" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.word_list_2016_3);
        con = this;



        indexArray=0;
        question_ind = 5;
        counter =15;

        group = (TextView)findViewById(R.id.group1);

        question = (TextView)findViewById(R.id.question_id);


        group.setText("শব্দভাণ্ডার  ");
        question.setText("২.১ শিক্ষার্থী কি ছবি দেখে নাম /শব্দ বলতে পারে ?");
        instr = "যেভাবে সম্পাদন করতে হবে: শিক্ষার্থীকে বাম পাশে টেবিলে থাকা ছবি দেখে নাম/শব্দ বলতে বলুন। শিক্ষার্থী ছবি দেখে সঠিক শব্দটি বলতে পারলে  প্রদত্ত টেবিলের ‘হ্যাঁ’ কলামে টিকচিহ্ন দিন। না পারলে ‘না’ কলামে টিকচিহ্ন দিন। " ;

   //     question.setText(""+getResources().getStringArray(R.array.question_set_2016_3)[question_ind]);
        //question_ind++;

        lv = (ListView) findViewById(R.id.listView1);

        datasource = new CommentsDataSource(this);
        datasource.open();


        ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.word_list_2017_2_21, android.R.layout.simple_list_item_1);
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

     //   String instr = ""+getResources().getStringArray(R.array.instruction_set_2016_3)[question_ind];
        AlertMessage.showMessage(con,"Instruction",instr);
    }


    public void single_toggle(View v){

        Toast.makeText(con,"Wrong",Toast.LENGTH_LONG).show();
        counter--;

    }

    public void back(View v){

        if(flag_next>0)
            flag_next--;

        if(question_ind>0)
            question_ind--;
        question.setText(""+getResources().getStringArray(R.array.question_set_2016_3)[question_ind]);


        if(flag_next == 2) {
            group.setText("শব্দভাণ্ডার  ");
            question.setText("২.২ শিক্ষার্থী পাঠে ও সমমানের বইয়ে ব্যবহৃত শব্দ শুদ্ধভাবে পড়তে পারে ?");
            instr = "যেভাবে সম্পাদন করতে হবে: শিক্ষার্থীকে বাম পাশে টেবিলে থাকা শব্দগুলো পড়তে দিন। শিক্ষার্থী যে শব্দটি শুদ্ধভাবে পড়তে পারবে, প্রদত্ত টেবিলের ‘হ্যাঁ’ কলামে টিকচিহ্ন দিন। না পারলে ‘না’ কলামে টিকচিহ্ন দিন। ";
            adapter = new StateAdapter(this);
            lv.setAdapter(adapter);

        }
        else if(flag_next==0){

            Intent img = new Intent(ImgWordListAct2017_2.this, WordListActivity2017_2.class);
            startActivity(img);
            this.finish();
            // lv.setAdapter(adapter_single);
        }
        else if(flag_next == 1) {
            group.setText("শব্দভাণ্ডার  ");
            question.setText("২.১ শিক্ষার্থী কি ছবি দেখে নাম /শব্দ বলতে পারে ?");
            instr = "যেভাবে সম্পাদন করতে হবে: শিক্ষার্থীকে বাম পাশে টেবিলে থাকা ছবি দেখে নাম/শব্দ বলতে বলুন। শিক্ষার্থী ছবি দেখে সঠিক শব্দটি বলতে পারলে  প্রদত্ত টেবিলের ‘হ্যাঁ’ কলামে টিকচিহ্ন দিন। না পারলে ‘না’ কলামে টিকচিহ্ন দিন। " ;

            adapter_single = new StateAdapter_single(this);
            lv.setAdapter(adapter_single);

        }

    }

    public void next(View v){

        flag_next++;
        Log.d("=k=size=="+datasource.getAllComments().size(), "...id..>>"+flag_next );
        question_ind++;
     //   question.setText(""+getResources().getStringArray(R.array.question_set_2016_3)[question_ind]);

        if(flag_next==4){
          //  String id = "" + datasource.getAllComments().get(0).getId();

            int arr= datasource.getAllComments().size()-1;
            String id = "" + datasource.getAllComments().get(arr).getId();
            Log.d("=k=size=="+datasource.getAllComments().size(), ".." );
            if(counter>=9)
                datasource.updatevocabulary(id, "Mastery-VOCA");
            else  if(counter>=6)
                datasource.updatevocabulary(id, "Developed-VOCA");
            else
                datasource.updatevocabulary(id, "Not yet \nDeveloped-VOCA");



           // Intent img = new Intent(WordListActivity.this, AboutActivity.class);

            this.finish();
        }
        if(flag_next==3){
          //  group = (TextView)findViewById(R.id.group1);
            group.setText("শব্দভাণ্ডার  ");
            question.setText("২.৩ শিক্ষার্থী কি ছবি দেখে ছবি সংশ্লিষ্ট শব্দ দিয়ে বাক্য বলতে পারে ?");

            instr = "যেভাবে সম্পাদন করতে হবে: শিক্ষার্থীকে বাম পাশে টেবিলে থাকা ছবিগুলো দেখে ছবি সংশ্লিষ্ট শব্দটি বলতে বলুন এবং প্রদত্ত টেবিলের বাক্য কলামের শব্দের সাথে মিলিয়ে একটি বাক্য বলতে বলুন। শিক্ষার্থী বাক্য তৈরি করে বলতে পারলে, টেবিলের ‘হ্যাঁ’ কলামে টিকচিহ্ন দিন। না পারলে ‘না’ কলামে টিকচিহ্ন দিন। ";

                    adapter_last = new StateAdapter_last(this);
            lv.setAdapter(adapter_last);

        }

        else if(flag_next == 2) {

            group.setText("শব্দভাণ্ডার  ");
            question.setText("২.২ শিক্ষার্থী পাঠে ও সমমানের বইয়ে ব্যবহৃত শব্দ শুদ্ধভাবে পড়তে পারে ?");
            instr = "যেভাবে সম্পাদন করতে হবে: শিক্ষার্থীকে বাম পাশে টেবিলে থাকা শব্দগুলো পড়তে দিন। শিক্ষার্থী যে শব্দটি শুদ্ধভাবে পড়তে পারবে, প্রদত্ত টেবিলের ‘হ্যাঁ’ কলামে টিকচিহ্ন দিন। না পারলে ‘না’ কলামে টিকচিহ্ন দিন। ";
            adapter = new StateAdapter(this);
            lv.setAdapter(adapter);

        }

    }



    private class StateAdapter_single extends ArrayAdapter<String> {
        // StateListActivty context;
        private final Context con;

        public StateAdapter_single(final Context c) {
            super(c, R.layout.imagerow_list, getResources().getStringArray(R.array.word_list_2017_2_21));
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
            textView.setText(""+getResources().getStringArray(R.array.word_list_2017_2_21)[position]);

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
            super(c, R.layout.imagerow_list, getResources().getStringArray(R.array.word_list_2017_2_23));
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
            textView.setText(""+getResources().getStringArray(R.array.word_list_2017_2_23)[position]);

            final ImageView img = (ImageView) v
                    .findViewById(R.id.img_id);
            img.setImageResource(imageArray[position]);
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
            super(c, R.layout.wordmeaning_1st, getResources().getStringArray(R.array.word_list_2017_2_22));
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
            textView.setText(""+getResources().getStringArray(R.array.word_list_2017_2_22)[position]);

//            final TextView textView2 = (TextView) v
//                    .findViewById(R.id.bottom_row);
//            textView2.setText(""+getResources().getStringArray(R.array.wordmeaning_1st_letter)[position]);

            return v;
        }
    }
}
