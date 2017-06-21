package ict.sci.kidslearning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import ict.sci.kidslearning.utils.AlertMessage;

public class ResultListActivity extends Activity {

    Context con;
    ListView lv;

    StateAdapter_single adapter_single;

    int flag_next = 0;
    private CommentsDataSource datasource;
    private TextView question;
    int indexArray=0,question_ind=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.result_list);
        con = this;



        indexArray=0;
        question_ind = 1;


        //question_ind++;

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

                Toast.makeText(con,"Coming soon.",Toast.LENGTH_LONG).show();
//				final Intent imageshow = new Intent(SecondActivity.this,
//						GalleryActivity.class);



            }
        });

    }


    public void showbox(View v){

        String instr = ""+getResources().getStringArray(R.array.instruction_set)[question_ind];
        AlertMessage.showMessage(con,"Instruction",instr);
    }


    public void single_toggle(View v){

        Toast.makeText(con,"Wrong",Toast.LENGTH_LONG).show();

    }

    public void back(View v){

        if(question_ind>0)
            question_ind--;
        question.setText(""+getResources().getStringArray(R.array.question_set)[question_ind]);

        if(flag_next==3){
            String id = "" + datasource.getAllComments().get(0).getId();
            datasource.updateOrderItems(id, "6");


            // Intent img = new Intent(WordListActivity.this, AboutActivity.class);
            Intent img = new Intent(ResultListActivity.this, QuestionActivity.class);
            startActivity(img);
        }



    }

    public void next(View v){

        Log.d("=k===", "...id..>>"+flag_next );
        question_ind++;
        question.setText(""+getResources().getStringArray(R.array.question_set)[question_ind]);

        if(flag_next==3){
            String id = "" + datasource.getAllComments().get(0).getId();
            datasource.updateOrderItems(id, "6");


           // Intent img = new Intent(WordListActivity.this, AboutActivity.class);
            Intent img = new Intent(ResultListActivity.this, DragingActivity.class);
            startActivity(img);
        }

    }



    private class StateAdapter_single extends ArrayAdapter<Comment> {
        // StateListActivty context;
        private final Context con;

        public StateAdapter_single(final Context c) {
            super(c, R.layout.result_llist_individualtest, datasource.getAllComments());
            con = c;
            //flag_next = 1;
            // TODO Auto-generated constructor stub
            Log.d("=ssize===", "...id..>>"+datasource.getAllComments().size() );

        }

        @Override
        public View getView(final int position, final View convertView,
                            final ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                final LayoutInflater vi = (LayoutInflater) con
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.result_llist_individualtest, null);
            }
            final TextView dat = (TextView) v
                    .findViewById(R.id.dat_id);
            String dates = "" + datasource.getAllComments().get(position).getDat();
            dat.setText(dates);

            final TextView textView = (TextView) v
                    .findViewById(R.id.phonetic_id);

            String id = "" + datasource.getAllComments().get(position).getPhone();
            if(id.equalsIgnoreCase("Mastery")){
                textView.setTextColor(Color.GREEN);
            }
           else if(id.equalsIgnoreCase("Developed")){
                textView.setTextColor(Color.YELLOW);
            }
            Log.d("=id phone===", "...id..>>"+id );

            textView.setText(""+id);

            final TextView letter = (TextView) v
                    .findViewById(R.id.letter_id);

            String leter = "" + datasource.getAllComments().get(position).getLetter();

            if(leter.equalsIgnoreCase("Mastery")){
                letter.setTextColor(Color.GREEN);
            }
            else if(leter.equalsIgnoreCase("Developed")){
                letter.setTextColor(Color.YELLOW);
            }
            letter.setText(""+leter);


            final TextView voca = (TextView) v
                    .findViewById(R.id.vocab_id);

            String vocab = "" + datasource.getAllComments().get(position).get_vocabulary();
            if(vocab.equalsIgnoreCase("Mastery")){
                voca.setTextColor(Color.GREEN);
            }
            voca.setText(""+vocab);

            final TextView name_tx = (TextView) v
                    .findViewById(R.id.name_id);

            String name = "" + datasource.getAllComments().get(position).getStudent();
            name_tx.setText("Name: "+name);
            Log.d("=nameeeeee==="+name, "---------." );

            final TextView class_tx = (TextView) v
                    .findViewById(R.id.grade_id);

            String class_t = "" + datasource.getAllComments().get(position).getClas();
            class_tx.setText("Grade: "+class_t);

            final TextView roll_tx = (TextView) v
                    .findViewById(R.id.roll_id);

            String roll_t = "" + datasource.getAllComments().get(position).getRoll();
            roll_tx.setText("Roll No: "+roll_t);


//            final TextView textView2 = (TextView) v
//                    .findViewById(R.id.bottom_row);
//            textView2.setText(""+getResources().getStringArray(R.array.wordmeaning_1st_letter)[position]);

            return v;
        }
    }


}
