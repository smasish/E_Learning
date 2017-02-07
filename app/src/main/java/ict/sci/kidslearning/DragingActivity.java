package ict.sci.kidslearning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ict.sci.kidslearning.utils.AlertMessage;
//import com.javapapers.android.drag_drop.R;


public class DragingActivity extends Activity implements OnTouchListener, OnDragListener {


	private ImageView img1,img2,img3;
	private Context con;
int  flag_next = 0;
	private TextView question;
	int indexArray=0,question_ind=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drag);

		con = this;
		flag_next = 0;

		indexArray=0;
		question_ind = 13;

		question = (TextView)findViewById(R.id.question_id);

		question.setText(""+getResources().getStringArray(R.array.question_set)[question_ind]);
		//question_ind++;
		//set ontouch listener for box views
//		findViewById(R.id.box_view1).setOnTouchListener(this);
//		findViewById(R.id.box_view2).setOnTouchListener(this);
//		findViewById(R.id.box_view3).setOnTouchListener(this);
//		findViewById(R.id.box_view4).setOnTouchListener(this);

		img1 = (ImageView)findViewById(R.id.box_view1);
		img1.setOnTouchListener(this);

		img2 = (ImageView)findViewById(R.id.box_view2);
		img2.setOnTouchListener(this);

		img3 = (ImageView)findViewById(R.id.box_view3);
		img3.setOnTouchListener(this);

		img1.setBackgroundResource(R.drawable.ball);
		img2.setBackgroundResource(R.drawable.math);
		img3.setBackgroundResource(R.drawable.play_football);

		//set ondrag listener for right and left parent views
		findViewById(R.id.left_view).setOnDragListener(this);
//		findViewById(R.id.right_view).setOnDragListener(this);
	}


	public void showbox(View v){

		String instr = ""+getResources().getStringArray(R.array.instruction_set)[question_ind];
		AlertMessage.showMessage(con,"Instruction",instr);
	}


	public void back(View v){

		if(question_ind>0)
			question_ind--;
		question.setText(""+getResources().getStringArray(R.array.question_set)[question_ind]);

		if(flag_next==0){
			img1.setBackgroundResource(R.drawable.ball);
			img2.setBackgroundResource(R.drawable.math);
			img3.setBackgroundResource(R.drawable.play_football);

			//flag_next = 1;

		}else if(flag_next==2){

			img1.setBackgroundResource(R.drawable.fall);
			img2.setBackgroundResource(R.drawable.paki);
			img3.setBackgroundResource(R.drawable.paki_fall);
			//flag_next =0;
		}
		else if(flag_next == 1) {
			img1.setBackgroundResource(R.drawable.ful);
			img2.setBackgroundResource(R.drawable.mala);
			img3.setBackgroundResource(R.drawable.mala_golay);
			//flag_next =2;
		}
		if(flag_next>0)
			flag_next--;
	}

	public void next(View v){

		question_ind++;
		question.setText(""+getResources().getStringArray(R.array.question_set)[question_ind]);


		if(flag_next==0){
			img1.setBackgroundResource(R.drawable.ball);
			img2.setBackgroundResource(R.drawable.math);
			img3.setBackgroundResource(R.drawable.play_football);

			//flag_next = 1;

		}else if(flag_next==2){

			img1.setBackgroundResource(R.drawable.fall);
			img2.setBackgroundResource(R.drawable.paki);
			img3.setBackgroundResource(R.drawable.paki_fall);
			//flag_next =3;
		}
		else if(flag_next == 1) {
			img1.setBackgroundResource(R.drawable.ful);
			img2.setBackgroundResource(R.drawable.mala);
			img3.setBackgroundResource(R.drawable.mala_golay);
			//flag_next =2;
		}
		else{
			this.finish();
		}
		flag_next++;
	}

	public void single_toggle(View v){

		Toast.makeText(con,"Wrong",Toast.LENGTH_LONG).show();

	}


	@Override
	public boolean onDrag(View v, DragEvent event) {
		// TODO Auto-generated method stub
		if (event.getAction() == DragEvent.ACTION_DROP) {
			//we want to make sure it is dropped only to left and right parent view
			View view = (View) event.getLocalState();

			if (v.getId() == R.id.left_view){// || v.getId() == R.id.right_view) {

				ViewGroup source = (ViewGroup) view.getParent();
				source.removeView(view);

				LinearLayout target = (LinearLayout) v;
				target.addView(view);
			}
			//make view visible as we set visibility to invisible while starting drag
			view.setVisibility(View.VISIBLE);
		}
		return true;
	}

	@Override
	public boolean onTouch(View view, MotionEvent event) {
		// TODO Auto-generated method stub
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			DragShadowBuilder shadowBuilder = new DragShadowBuilder(view);
			view.startDrag(null, shadowBuilder, view, 0);
			view.setVisibility(View.INVISIBLE);
			return true;
		}
		return false;
	}
}