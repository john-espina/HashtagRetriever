package com.johnnyandsons.meow.hashtagretriever;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class MainActivity extends AppCompatActivity {

    static  EditText input;
    static  int  count= 50;
    static String hashTag;
    static Twitter twitter;
   // Button searchHash;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent displayHashtags = new Intent(this, DisplayResults.class);

        input = (EditText) findViewById(R.id.editText);


        input.setOnEditorActionListener(new TextView.OnEditorActionListener() {


            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    hashTag = v.getText().toString();
                    Toast.makeText(MainActivity.this, hashTag, Toast.LENGTH_SHORT).show();
                    startActivity(displayHashtags);
                }
                return true;
            }
        });



//        searchHash = (Button) findViewById(R.id.button);
//        searchHash.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(displayHashtags);
//            }
//        });


    }
}

