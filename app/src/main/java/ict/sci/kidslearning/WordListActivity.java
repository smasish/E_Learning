package ict.sci.kidslearning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class WordListActivity extends Activity {

    Context context;
    ListView lv;
    RadioAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.word_list);
        context = this;

        lv = (ListView) findViewById(R.id.listView1);


        ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.word_set, android.R.layout.simple_list_item_1);
        lv.setAdapter(aa);

        adapter = new RadioAdapter(this);


    }



    private class RadioAdapter extends ArrayAdapter<InfoData> {
        // StateListActivty context;
        private final Context con;

        public RadioAdapter(final Context cont) {
            //super(c, R.layout.imagerow, AllInfoData.getAllDataBytitle());
            //super(cont, R.layout.imagerow, AllInfoData.getAllDataBytitle());

            super(cont,R.layout.imagerow,AllInfoData.getAllData().size());
            con = cont;
            // TODO Auto-generated constructor stub
        }

        @Override
        public View getView(final int position, final View convertView,
                            final ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                final LayoutInflater vi = (LayoutInflater) con
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.imagerow, null);
            }

            Log.d("*******size******====", ""
                    + AllInfoData.getAllDataBytitle().size());
            if (position < AllInfoData.getAllDataBytitle().size()) {
                final InfoData offer = AllInfoData.getData(position);

                Log.d("*************====", "" + offer.getPage_title());

                final TextView textView = (TextView) v
                        .findViewById(R.id.feedrowitem);

                final TextView text = (TextView) v
                        .findViewById(R.id.address_id);



				/*
				 * if (offer.getBitmap() != null) {
				 * offerLogo.setImageBitmap(offer.getBitmap()); }
				 */

                textView.setText(offer.getPage_title().toString().trim());

                text.setText(offer.getDescription().toString().trim());
            }

            return v;
        }
    }
}
