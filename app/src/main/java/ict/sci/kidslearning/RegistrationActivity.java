package ict.sci.kidslearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegistrationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);




    }



    public void next(View v){
        Intent i = new Intent(RegistrationActivity.this, HomeActivity.class);
        //Intent i = new Intent(MainActivity.this, WordListActivity.class);
        startActivity(i);
    }


}
