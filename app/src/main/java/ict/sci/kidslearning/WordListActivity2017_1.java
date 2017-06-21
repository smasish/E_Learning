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
        counter =9;

        group = (TextView)findViewById(R.id.group1);
        group.setText("সাবলীলতা");

        question = (TextView)findViewById(R.id.question_id);

        question.setText(""+getResources().getStringArray(R.array.word_list_2016_9)[question_ind]);
        //question_ind++;

        lv = (ListView) findViewById(R.id.listView1);

        datasource = new CommentsDataSource(this);
        datasource.open();


        ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.word_set, android.R.layout.simple_list_item_1);
       // lv.setAdapter(aa);
        flag_next = 0;
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

    }


    public void showbox(View v){

        String instr = ""+getResources().getStringArray(R.array.instructions_16_9)[question_ind];
        AlertMessage.showMessage(con,"Instruction",instr);
    }


    public void single_toggle(View v){

        Toast.makeText(con,"Wrong",Toast.LENGTH_LONG).show();
        if(counter>1)
            counter--;

    }

    public void back(View v){

        if(flag_next>0)
            flag_next--;
        if(question_ind>0)
            question_ind--;
        question.setText(""+getResources().getStringArray(R.array.word_list_2016_9)[question_ind]);

        if(flag_next == 1) {
            group.setText("সাবলীলতা");
            adapter_single = new StateAdapter_single(this);
            lv.setAdapter(adapter_single);
        }

        else if(flag_next == 2) {
            group.setText("সাবলীলতা");
            stateAdapter_dhoni = new  StateAdapter_dhoni(this);
            lv.setAdapter(stateAdapter_dhoni);
        }
        else if(flag_next == 3) {
            group.setText("সাবলীলতা");
            stateAdapter_shobdo = new StateAdapter_shobdo(this);
            lv.setAdapter(stateAdapter_shobdo);
        }

        else if(flag_next == 0) {

            stateAdapter_image = new StateAdapter_image(this);
            lv.setAdapter(stateAdapter_image);

        }
        else{
            this.finish();
        }
    }

    public void next(View v){

        flag_next++;


        if(flag_next == 1) {
            group.setText("সাবলীলতা");
            adapter_single = new StateAdapter_single(this);
                  lv.setAdapter(adapter_single);
        }

        else if(flag_next == 2) {
            group.setText("সাবলীলতা");
            stateAdapter_dhoni = new  StateAdapter_dhoni(this);
            lv.setAdapter(stateAdapter_dhoni);
        }
        else if(flag_next == 3) {
            group.setText("সাবলীলতা");
            stateAdapter_shobdo = new StateAdapter_shobdo(this);
            lv.setAdapter(stateAdapter_shobdo);
        }


        else if(flag_next == 4) {
            Log.d("=k=size==" + datasource.getAllComments().size(), "...id..>>" + flag_next);
            question_ind++;
            question.setText("" + getResources().getStringArray(R.array.word_list_2016_9)[question_ind]);

            //  String id = "" + datasource.getAllComments().get(0).getId();

            int arr = datasource.getAllComments().size() - 1;
            String id = "" + datasource.getAllComments().get(arr).getId();
            Log.d("=k=size==" + datasource.getAllComments().size(), "..");
            if (counter >= 5)
                datasource.updatevocabulary(id, "Mastery");
            else if (counter >= 4)
                datasource.updatevocabulary(id, "Developed");
            else
                datasource.updatevocabulary(id, "Need Improvement");

            Log.d("=k=size==", ".flaginnggggggg." + flag_next);

            // Intent img = new Intent(WordListActivity.this, AboutActivity.class);
            Intent img = new Intent(WordListActivity2017_1.this, QuestionActivity2017_1.class);
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
