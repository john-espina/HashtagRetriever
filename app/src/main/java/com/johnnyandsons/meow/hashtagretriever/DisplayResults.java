package com.johnnyandsons.meow.hashtagretriever;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DisplayResults extends AppCompatActivity {

    static TextView displayHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);

        displayHash = (TextView) findViewById(R.id.textView);
        displayHash.setMovementMethod(new ScrollingMovementMethod());
        new Hashtag().execute(MainActivity.hashTag);

    }
}
