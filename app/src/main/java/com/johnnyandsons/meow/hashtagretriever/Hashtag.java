package com.johnnyandsons.meow.hashtagretriever;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by Meow on 10/12/2017.
 */

public class Hashtag   extends AsyncTask<String, Object, QueryResult> {

    String hashTag = MainActivity.hashTag;
    int count = MainActivity.count;
    TextView displayHash = DisplayResults.displayHash;
    Twitter twitter = MainActivity.twitter;
    QueryResult resultTweet;


    @Override
    protected QueryResult doInBackground(String... params) {

        String status = params[0];
        Query queryMax = new Query(status);
        queryMax.setCount(count);
        String tweetString = null;
        try {

            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey("ZsvNpBlaEHp6gEv4OarzvOk9k")
                    .setOAuthConsumerSecret("xf1cqLJb5alINyrzh3YbqE57VTjxn8NLCwAEZ3r0ocER4NA5oN")
                    .setOAuthAccessToken("3300968563-19zGnWR491v3UDKfUXbZMPMBX5dS7zNmff8n7xp")
                    .setOAuthAccessTokenSecret("hVRdrQF7WY4SvZLllRxGSdPCWtpklSUulrYRJFK7gPmQw");

            TwitterFactory tf = new TwitterFactory(cb.build());
            twitter4j.Twitter twitter = tf.getInstance();
            resultTweet = twitter.search(queryMax);



        } catch (TwitterException te) {
            System.out.println("Couldn't connect: " + te);
            System.exit(-1);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
            System.exit(-1);
        }
        return resultTweet;
    }


    protected void onProgressUpdate(Object... progress) {
    }

    protected void onPostExecute(QueryResult result) {
        displayMessage(result);
    }

    private void displayMessage(QueryResult result) {

        for (twitter4j.Status status: result.getTweets()) {
                displayHash.append("\n"
                + status.getUser().getScreenName().toUpperCase() + ":\n"
                + status.getText() + "\n"
                + status.getCreatedAt() + "\n");
                }

        }
}


//    Query queryMax = new Query(hashTag);
//        queryMax.setCount(count);
//
//                try {
//                QueryResult resultTweet = params[0].search(queryMax);
//
//                if(resultTweet.getTweets()==null || resultTweet.getTweets().isEmpty()){
//                displayHash.setText("null");
//                }
//
//                else{
//                displayHash.setText(resultTweet.getTweets().toString());
//
//
//

