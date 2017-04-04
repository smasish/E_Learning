package ict.sci.kidslearning;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import ict.sci.kidslearning.utils.AlertMessage;


public class ImageWordActivity16_1 extends AppCompatActivity {

	private Context con;
	private ImageButton imb1,imb2 ; // ,imb3,imb4,imb5,imb6;
	private TextView question;
//	private int[] imageArray = {
//			R.drawable.img1, R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,
//			R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10,
//			R.drawable.img11,R.drawable.img12,R.drawable.img13,R.drawable.img14,R.drawable.img15,
//			R.drawable.img16,R.drawable.img17,R.drawable.img18,R.drawable.img19,R.drawable.img20,
//			R.drawable.img20,R.drawable.a22,R.drawable.a23,R.drawable.a24,R.drawable.a25
//
//	};

	private int[] imageArray = {
			R.drawable.img1, R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,
			R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10

	};

	private String[] imglist = {
			"তালা","থালা","গাড়ি","ঘড়ি","ডাল","ঢাল","ঢাক","ডাব","জগ","ঝড়"
	};

	int indexArray=0,question_ind=0;
	int counter =20;
	private CommentsDataSource datasource;

	private TextView title1,title2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.question_image);

		//http://stackoverflow.com/questions/18207470/adding-table-rows-dynamically-in-android



		con = this;
		indexArray=0;

		indexArray=0;
		question_ind = 8;
		counter =20;

		title1 = (TextView)findViewById(R.id.t1);

		title2 = (TextView)findViewById(R.id.t2);




		question = (TextView)findViewById(R.id.question_id);

		question.setText(""+getResources().getStringArray(R.array.question_set_2016_1)[question_ind]);

		imb1 = (ImageButton)findViewById(R.id.x1);
		imb2 = (ImageButton)findViewById(R.id.x2);


		int i = indexArray;
		imb1.setImageResource(imageArray[i]);
		imb2.setImageResource(imageArray[i+1]);

		title1.setText(""+imglist[i]);
		title2.setText(""+imglist[i+1]);

		datasource = new CommentsDataSource(this);
		datasource.open();
		String id = "" + datasource.getAllComments().get(0).getScore();

		Log.d("next-----", "start===="+id);
		indexArray = 2;

	}

	public void leftimage(View v){
		Toast.makeText(con,"Counted",Toast.LENGTH_LONG).show();
	}

	public void rightimage(View v){
		Toast.makeText(con,"Counted",Toast.LENGTH_LONG).show();
	}


	public void showbox(View v){

		String instr = ""+getResources().getStringArray(R.array.instruction_set_2016_1)[question_ind];
		AlertMessage.showMessage(con,"Instruction",instr);
	}

	public void next(View v){

		Log.d("next-----", "start===="+indexArray);
		// for(int i=indexArray;i<imageArray.length;i+=6){

		question_ind++;
		question.setText(""+getResources().getStringArray(R.array.question_set_2016_1)[question_ind]);

		String id = "" + datasource.getAllComments().get(0).getId();
		datasource.updateOrderItems(id, "66");

		int i = indexArray;

		if(i<=imageArray.length-2){
			imb1.setImageResource(imageArray[i]);
			imb2.setImageResource(imageArray[i+1]);

			indexArray = i+2;
			Log.d("next-----", "start===="+indexArray);

			title1.setText(""+imglist[i]);
			title2.setText(""+imglist[i+1]);
		}else{
			Intent img = new Intent(ImageWordActivity16_1.this, WordListActivity2016_1_5.class);
			   startActivity(img);
			this.finish();
		}

	}

	public void back(View v){

		Log.d("back-----", "start===="+indexArray);
		int i = indexArray;

		if(question_ind>0)
			question_ind--;
		question.setText(""+getResources().getStringArray(R.array.question_set_2016_1)[question_ind]);

		//for(int i = indexArray;i>6;i-=6) {
		if(i>=2){
			imb1.setImageResource(imageArray[i-2]);
			imb2.setImageResource(imageArray[i - 1]);


			indexArray = i-2;
			Log.d("back-----", "start===="+indexArray);

		}

	}


}
