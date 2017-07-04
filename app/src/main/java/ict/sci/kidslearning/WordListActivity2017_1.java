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

public class WordListActivity2017_1 extends Activity {


    ListView lv;
    StateAdapter adapter;
    Adapter_spelling spell_adapter;
    StateAdapter_last adapter_last;
    StateAdapter_image  stateAdapter_image;
    StateAdapter_single adapter_single;
    StateAdapter_dhoni stateAdapter_dhoni;
    StateAdapter_shobdo stateAdapter_shobdo;

    int flag_next = 0;
    private CommentsDataSource datasource;
    Context con;
    private TextView question,group;
    int indexArray=0,question_ind=0;
    int counter =9;

    private int[] imageArray = {
            R.drawable.chata, R.drawable.gura, R.drawable.dim, R.drawable.ful3, R.drawable.belun,
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
        setContentView(R.layout.word_list_2017_1);
        con = this;



        indexArray=0;
        question_ind = 0;
        counter =15;

        group = (TextView)findViewById(R.id.group1);


        question = (TextView)findViewById(R.id.question_id);

       // question.setText(""+getResources().getStringArray(R.array.word_list_2016_9)[question_ind]);
        group.setText("ধ্বনিসচেতনতা ");
        question.setText("২.১ শিক্ষার্থী কি ছবি দেখে ছবির নাম ও  প্রথম ধ্বনি বলতে পারে ?");
        //question_ind++;

        lv = (ListView) findViewById(R.id.listView1);

        datasource = new CommentsDataSource(this);
        datasource.open();


        ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.word_set, android.R.layout.simple_list_item_1);
       // lv.setAdapter(aa);
        flag_next = 1;
       // adapter = new StateAdapter(this);
       // lv.setAdapter(adapter);


        stateAdapter_image = new StateAdapter_image(this);
        lv.setAdapter(stateAdapter_image);

   //     adapter_single = new StateAdapter_single(this);
  //      lv.setAdapter(adapter_single);

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

        instr = "যেভাবে সম্পাদন করতে হবে: শিক্ষার্থীকে উদাহরণ দিয়ে বলুন এটি একটি গাছের ছবি। গাছ বলতে গেলে প্রথম ধ্বনি হয় গা। এরকমভাবে প্রদত্ত টেবিলের ছবিগুলো দেখিয়ে  জিজ্ঞেস করুন ছবিটি কিসের এবং এর প্রথম ধ্বনিটি কি? পাচঁটি শব্দের মধ্যে শিক্ষার্থী যে শব্দগুলোর প্রথম ধ্বনি বলতে পেরেছে, টেবিলের প্রথম ধ্বনি কলামে হ্যাঁ এ টিকচিহ্ন দিন। না পারলে ‘না’ এ টিকচিহ্ন দিন।    ";

    }


    public void showbox(View v){


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
       // question.setText(""+getResources().getStringArray(R.array.word_list_2016_9)[question_ind]);

        if(flag_next == 1) {
            group.setText("ধ্বনিসচেতনতা ");
            question.setText("২.১ শিক্ষার্থী কি ছবি দেখে ছবির নাম ও  প্রথম ধ্বনি বলতে পারে ?");

            stateAdapter_image = new StateAdapter_image(this);
            lv.setAdapter(stateAdapter_image);
        }

        else if(flag_next == 2) {
            group.setText("ধ্বনিসচেতনতা ");
            question.setText("২.২ শিক্ষার্থী কি শব্দের শেষ বর্ণের বা শব্দাংশের ধ্বনির মিল বুঝতে পারে ?");
            instr = "যেভাবে সম্পাদন করতে হবে: প্রথমে শিক্ষার্থীকে উদাহরণ দিয়ে বলুন বক, চক, মই এই শব্দ তিনটি  মধ্যে বক এবং চক এই শব্দ দু‘টির শেষে একই ধ্বনি রয়েছে। এবার নিচের টেবিল থেকে তিনটি করে শব্দ পড়ে শিক্ষার্থীকে শোনান এবং জিজ্ঞেস করুন বলতো কোন্ দু‘টির শেষ ধ্বনিতে মিল আছে? শিক্ষার্থী শেষ ধ্বনির মিল বলতে পারলে প্রদত্ত টেবিলের ‘হ্যাঁ’  লেখা কলামে টিকচিহ্ন দিন এবং না পারলে ‘না’  কলামে টিকচিহ্ন দিন। ";
            adapter_single = new StateAdapter_single(this);
            lv.setAdapter(adapter_single);
        }
        else if(flag_next == 3) {
            group.setText("ধ্বনিসচেতনতা ");
            question.setText("২.৩ শিক্ষার্থী কি একটি শব্দের প্রথম বর্ণের বা শব্দাংশের ধ্বনির অনুরূপ, আরেকটি শব্দ বলতে পারে?");
            instr =" যেভাবে সম্পাদন করতে হবে: প্রথমে শিক্ষার্থীকে উদাহরণ দিয়ে বলুন, আমি একটি শব্দ বলবো, যেমন ধরো আতা। এর প্রথম ধ্বনি হলো আ। আরও বলুন যে, আ আছে এরকম আকেটি শব্দ হলো আম। এবার নিচের টেবিল থেকে শব্দ বলুন এবং শব্দটির প্রথম ধ্বনি শিক্ষার্থীকে শোনান। পরবর্তীতে তাকে উক্ত ধ্বনি দিয়ে অনুরূপ আরেকটি শব্দ বলতে বলুন? শিক্ষার্থী শব্দের প্রথম ধ্বনির অনুরূপ আরেকটি শব্দ বলতে পারলে প্রদত্ত টেবিলের ‘হ্যাঁ’  লেখা কলামে টিকচিহ্ন দিন এবং না পারলে ‘না’  কলামে টিকচিহ্ন দিন।  ";

            stateAdapter_dhoni = new  StateAdapter_dhoni(this);
            lv.setAdapter(stateAdapter_dhoni);
        }

        else if(flag_next == 0) {
          //  Intent img = new Intent(WordListActivity2017_1.this, HomeActivity.class);
         //   startActivity(img);
           this.finish();
        }

    }

    public void next(View v){

        flag_next++;


        if(flag_next == 2) {
            group.setText("ধ্বনিসচেতনতা ");
            question.setText("শিক্ষার্থী কি শব্দের শেষ বর্ণের বা শব্দাংশের ধ্বনির মিল বুঝতে পারে ?");
            adapter_single = new StateAdapter_single(this);
                  lv.setAdapter(adapter_single);
        }

        else if(flag_next == 3) {
            group.setText("ধ্বনিসচেতনতা ");
            question.setText("২.৩ শিক্ষার্থী কি একটি শব্দের প্রথম বর্ণের বা শব্দাংশের ধ্বনির অনুরূপ, আরেকটি শব্দ বলতে পারে?");
            instr =" যেভাবে সম্পাদন করতে হবে: প্রথমে শিক্ষার্থীকে উদাহরণ দিয়ে বলুন, আমি একটি শব্দ বলবো, যেমন ধরো আতা। এর প্রথম ধ্বনি হলো আ। আরও বলুন যে, আ আছে এরকম আকেটি শব্দ হলো আম। এবার নিচের টেবিল থেকে শব্দ বলুন এবং শব্দটির প্রথম ধ্বনি শিক্ষার্থীকে শোনান। পরবর্তীতে তাকে উক্ত ধ্বনি দিয়ে অনুরূপ আরেকটি শব্দ বলতে বলুন? শিক্ষার্থী শব্দের প্রথম ধ্বনির অনুরূপ আরেকটি শব্দ বলতে পারলে প্রদত্ত টেবিলের ‘হ্যাঁ’  লেখা কলামে টিকচিহ্ন দিন এবং না পারলে ‘না’  কলামে টিকচিহ্ন দিন।  ";

            stateAdapter_dhoni = new  StateAdapter_dhoni(this);
            lv.setAdapter(stateAdapter_dhoni);
        }
        else if(flag_next == 4) {
            group.setText("বর্ণজ্ঞান");
            question.setText("১.১ শিক্ষার্থী কি নির্দিষ্ট বর্ণের পরের বর্ণটি পড়তে পারে  ?");
            instr ="যেভাবে সম্পাদন করতে হবে: শিক্ষার্থীকে বাম পাশের টেবিলে থাকা বর্ণসহ পরের বর্ণটি কী; সেটি জিজ্ঞেস করে পড়তে বলুন। শিক্ষার্থী যে বর্ণগুলো পড়তে পেরেছে, সেগুলো ডানপাশের টেবিলে থাকা বর্ণগুলোতে টিকচিহ্ন দিন ।";
            stateAdapter_shobdo = new StateAdapter_shobdo(this);
            lv.setAdapter(stateAdapter_shobdo);

            int arr = datasource.getAllComments().size() - 1;
            String id = "" + datasource.getAllComments().get(arr).getId();
            Log.d("=k=size==" + datasource.getAllComments().size(), "..");
            if (counter >= 9)
                datasource.updatePhonetics(id, "Mastery-PA");
            else if (counter >= 6)
                datasource.updatePhonetics(id, "Developed-PA");
            else
                datasource.updatePhonetics(id, "Not yet \nDeveloped-PA");

            Log.d("=k=size==", ".flaginnggggggg." + flag_next);
            counter = 5;
        }


        else if(flag_next == 5) {
            Log.d("=k=size==" + datasource.getAllComments().size(), "...id..>>" + flag_next);
            question_ind++;
       //     question.setText("" + getResources().getStringArray(R.array.word_list_2016_9)[question_ind]);

            //  String id = "" + datasource.getAllComments().get(0).getId();



            // Intent img = new Intent(WordListActivity.this, AboutActivity.class);
            Intent img = new Intent(WordListActivity2017_1.this, QuestionActivity2017_1.class);
            img.putExtra("val",counter);
            startActivity(img);
            this.finish();

        }


    }


    private class StateAdapter_image extends ArrayAdapter<String> {
        // StateListActivty context;
        private final Context con;

        public StateAdapter_image(final Context c) {
            super(c, R.layout.imagerow_list, getResources().getStringArray(R.array.word_list_2017_21));
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
            textView.setText(""+getResources().getStringArray(R.array.word_list_2017_21)[position]);

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



    private class StateAdapter_shobdo extends ArrayAdapter<String> {
        // StateListActivty context;
        private final Context con;

        public StateAdapter_shobdo(final Context c) {
            super(c, R.layout.word_sent_17_1, getResources().getStringArray(R.array.word_list_2017_1));
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
            left.setText(""+getResources().getStringArray(R.array.word_list_2017_1)[position]);
            //img.setImageResource(""+getResources().getStringArray(R.array.single_letter)[position]);

//            final TextView textView2 = (TextView) v
//                    .findViewById(R.id.bottom_row);
//            textView2.setText(""+getResources().getStringArray(R.array.wordmeaning_1st_letter)[position]);

            return v;
        }
    }

    private class StateAdapter_dhoni extends ArrayAdapter<String> {
        // StateListActivty context;
        private final Context con;

        public StateAdapter_dhoni(final Context c) {
            super(c, R.layout.word_sent_17_1, getResources().getStringArray(R.array.word_list_2017_23));
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
            left.setText(""+getResources().getStringArray(R.array.word_list_2017_23)[position]);
            //img.setImageResource(""+getResources().getStringArray(R.array.single_letter)[position]);

//            final TextView textView2 = (TextView) v
//                    .findViewById(R.id.bottom_row);
//            textView2.setText(""+getResources().getStringArray(R.array.wordmeaning_1st_letter)[position]);

            return v;
        }
    }


    private class StateAdapter_single extends ArrayAdapter<String> {
        // StateListActivty context;
        private final Context con;

        public StateAdapter_single(final Context c) {
            super(c, R.layout.word_sent_17_1, getResources().getStringArray(R.array.word_list_2017_22));
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
            left.setText(""+getResources().getStringArray(R.array.word_list_2017_22)[position]);
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
                    .findViewById(R.id.top_row2);
            textView.setText(""+getResources().getStringArray(R.array.spelling_sound)[position]);

            final ImageView img = (ImageView) v
                    .findViewById(R.id.img_id);
            img.setImageResource(imageArray2[position]);
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
