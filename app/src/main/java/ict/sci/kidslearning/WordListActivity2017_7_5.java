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

public class WordListActivity2017_7_5 extends Activity {

    Context con;
    ListView lv;
    StateAdapter adapter;
    Adapter_spelling spell_adapter;
    StateAdapter_last adapter_last;


    int flag_next = 0;
    private CommentsDataSource datasource;
    private TextView question,group;
    int indexArray=0,question_ind=0;
    int counter =3;

    private int[] imageArray = {
            R.drawable.dab, R.drawable.tv, R.drawable.chair, R.drawable.mas, R.drawable.train,
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
        setContentView(R.layout.word_list_2016_2_43);
        con = this;



        indexArray=0;
        question_ind = 7;
        counter =3;

        question = (TextView)findViewById(R.id.question_id);
        group = (TextView)findViewById(R.id.group1);

        group.setText(" বোধগম্যতা");
        question.setText("উপকরণের ছবি থেকে নীচের প্রশ্নের উত্তর দিতে পারে কি? ");

   //     question.setText(""+getResources().getStringArray(R.array.question_set_2016_1)[question_ind]);
        //question_ind++;

        lv = (ListView) findViewById(R.id.listView1);

        datasource = new CommentsDataSource(this);
        datasource.open();


        ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.word_set, android.R.layout.simple_list_item_1);
       // lv.setAdapter(aa);
        flag_next = 1;
       // adapter = new StateAdapter(this);
       // lv.setAdapter(adapter);


        spell_adapter = new Adapter_spelling(this);
        lv.setAdapter(spell_adapter);

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

        String instr = ""+getResources().getStringArray(R.array.instruction_set_2016_1)[question_ind];
        AlertMessage.showMessage(con,"Instruction",instr);
    }


    public void single_toggle(View v){

        Toast.makeText(con,"Wrong",Toast.LENGTH_LONG).show();
        if(counter>0)
            counter--;

    }

    public void back(View v){

        if(flag_next>0)
            flag_next--;
        if(question_ind>0)
            question_ind--;
        question.setText(""+getResources().getStringArray(R.array.question_set_2016_1)[question_ind]);

        if(flag_next==0){
//            String id = "" + datasource.getAllComments().get(0).getId();
//            datasource.updateOrderItems(id, "6");


            // Intent img = new Intent(WordListActivity.this, AboutActivity.class);
            Intent img = new Intent(WordListActivity2017_7_5.this, Activity_Onepic_2017_7_5.class);
            startActivity(img);
            this.finish();
        }



    }

    public void next(View v){

        flag_next++;

        Log.d("=k=size=="+datasource.getAllComments().size(), "...id..>>"+flag_next );
        question_ind++;
        question.setText(""+getResources().getStringArray(R.array.question_set_2016_1)[question_ind]);

       // if(flag_next==1){
          //  String id = "" + datasource.getAllComments().get(0).getId();

            int arr= datasource.getAllComments().size()-1;
            String id = "" + datasource.getAllComments().get(arr).getId();
            Log.d("=k=size=="+datasource.getAllComments().size(), ".." );
            if(counter>=3)
                datasource.updatevocabulary(id, "Mastery-bud");
            else  if(counter>=2)
                datasource.updatevocabulary(id, "Developed-bud");
            else
                datasource.updatevocabulary(id, "Need \nImprovement-bud");

            Log.d("=k=size==", ".flaginnggggggg." +flag_next);

           // Intent img = new Intent(WordListActivity.this, AboutActivity.class);
         //   Intent img = new Intent(WordListActivity2016_7_4.this, Activity_Onepic_2016_7_4.class);
         //   startActivity(img);
            this.finish();
   //     }



    }





    private class Adapter_spelling extends ArrayAdapter<String> {
        // StateListActivty context;
        private final Context con;

        public Adapter_spelling(final Context c) {
            super(c, R.layout.spelling_sound, getResources().getStringArray(R.array.word_list_2017_7_51));
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
            textView.setText(""+getResources().getStringArray(R.array.word_list_2017_7_51)[position]);

//            final ImageView img = (ImageView) v
//                    .findViewById(R.id.img_id);
//            img.setImageResource(imageArray2[position]);
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
            super(c, R.layout.wordmeaning_1st, getResources().getStringArray(R.array.word_set));
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
            textView.setText(""+getResources().getStringArray(R.array.wordmeaning_1st_letter)[position]);

//            final TextView textView2 = (TextView) v
//                    .findViewById(R.id.bottom_row);
//            textView2.setText(""+getResources().getStringArray(R.array.wordmeaning_1st_letter)[position]);

            return v;
        }
    }
}
