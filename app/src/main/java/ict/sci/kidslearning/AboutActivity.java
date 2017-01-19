package ict.sci.kidslearning;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import ict.sci.kidslearning.utils.AlertMessage;
import ict.sci.kidslearning.utils.AppConstants;


public class AboutActivity extends AppCompatActivity {

	private Context con;
	private ImageButton imb1,imb2 ; // ,imb3,imb4,imb5,imb6;

	private int[] imageArray = {
			R.drawable.img1, R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,
			R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10,
			R.drawable.img11,R.drawable.img12,R.drawable.img13,R.drawable.img14,R.drawable.img15,
			R.drawable.img16,R.drawable.img17,R.drawable.img18,R.drawable.img19,R.drawable.img20,
			R.drawable.img20,R.drawable.a22,R.drawable.a23,R.drawable.a24,R.drawable.a25,
			R.drawable.a26,R.drawable.a27,R.drawable.a28,R.drawable.a29,R.drawable.a30,
			R.drawable.a31,R.drawable.a32,R.drawable.a33,R.drawable.a34,R.drawable.a35,
			R.drawable.a36,R.drawable.a37,R.drawable.a38,R.drawable.a39,R.drawable.a40,
			R.drawable.a41,R.drawable.a42,R.drawable.a43,R.drawable.a44,R.drawable.a45,
			R.drawable.a46,R.drawable.a47,R.drawable.a48,R.drawable.a49,R.drawable.a50

	};

	int indexArray=0;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.question_image);

		//http://stackoverflow.com/questions/18207470/adding-table-rows-dynamically-in-android



		con = this;
		indexArray=0;

		imb1 = (ImageButton)findViewById(R.id.x1);
		imb2 = (ImageButton)findViewById(R.id.x2);


		int i = indexArray;
		imb1.setImageResource(imageArray[i]);
		imb2.setImageResource(imageArray[i+1]);



		indexArray = 2;

	}

	public void leftimage(View v){
		Toast.makeText(con,"Counted",Toast.LENGTH_LONG).show();
	}

	public void rightimage(View v){
		Toast.makeText(con,"Counted",Toast.LENGTH_LONG).show();
	}


	public void showbox(View v){

		AlertMessage.showMessage(con,"Title",""+getString(R.string.question12));
	}

	public void next(View v){

		Log.d("next-----", "start===="+indexArray);
		// for(int i=indexArray;i<imageArray.length;i+=6){

		int i = indexArray;

		if(i<imageArray.length-2){
			imb1.setImageResource(imageArray[i]);
			imb2.setImageResource(imageArray[i+1]);

			indexArray = i+2;
			Log.d("next-----", "start===="+indexArray);
		}

	}

	public void back(View v){

		Log.d("back-----", "start===="+indexArray);
		int i = indexArray;
		//for(int i = indexArray;i>6;i-=6) {
		if(i>=2){
			imb1.setImageResource(imageArray[i-2]);
			imb2.setImageResource(imageArray[i - 1]);


			indexArray = i-2;
			Log.d("back-----", "start===="+indexArray);

		}

	}


}
