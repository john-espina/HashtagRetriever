package com.johnnyandsons.meow.hashtagretriever

import android.os.AsyncTask
import android.util.Log
import com.johnnyandsons.meow.hashtagretriever.LayoutController.Companion.displayHash

import twitter4j.Query
import twitter4j.QueryResult
import twitter4j.Twitter
import twitter4j.TwitterException
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder

/**
 * Created by Meow on 10/12/2017.
 */

class Hashtag : AsyncTask<String, Any, QueryResult>() {

        internal var count = 50;
        internal lateinit var resultTweet: QueryResult
        internal lateinit var twitter : Twitter


    override fun doInBackground(vararg params: String): QueryResult {


        Log.d("HASHTAG EXECUTE", "Executed")
        val status = params[0]
        val queryMax = Query(status)
        queryMax.count = count
        Log.d("STATUS", status )
        Log.d("QueryMax", queryMax.toString())
        try {

            Log.d( "TRYING CONNECTION....", "Trying....")
            var cb = ConfigurationBuilder()
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey("")
                    .setOAuthConsumerSecret("")
                    .setOAuthAccessToken("")
                    .setOAuthAccessTokenSecret("")

            Log.d("CONNECTION SUCCESFUL", "Now Connected???")
            var tf = TwitterFactory(cb.build())
            Log.d("TF", tf.getInstance().toString())
            var twitter: twitter4j.Twitter
            twitter = tf.getInstance()
            Log.d("TWITTER", twitter.screenName)
            resultTweet = twitter.search(queryMax)

            Log.d("RESULTS", resultTweet.toString())


        } catch (te: TwitterException) {
            println("Couldn't connect: " + te)
            System.exit(-1)
        } catch (e: Exception) {
            println("Something went wrong: " + e)
            System.exit(-1)
        }

        return resultTweet
    }


    override fun onProgressUpdate(vararg progress: Any) {Log.d ("HASHTAG PROCEEDED", "Proceede")}

    override fun onPostExecute(result: QueryResult) {
        displayMessage(result)
    }


    private fun displayMessage(result: QueryResult) {

        for (status in result.tweets) {

            displayHash.append("\n"
                    + status.user.screenName.toUpperCase() + ":\n"
                    + status.text + "\n"
                    + status.createdAt + "\n")
            Log.d("result", displayHash.text.toString())
        }

    }
}


