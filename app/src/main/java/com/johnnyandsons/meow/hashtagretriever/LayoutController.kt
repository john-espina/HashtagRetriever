package com.johnnyandsons.meow.hashtagretriever

import android.app.Activity
import android.app.ListActivity
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView


/**
 * Created by espinajohn on 11/12/2017.
 */
class LayoutController (activity: Activity, currentLayout:Int) : ListActivity() {

    var layout = currentLayout
    var activity = activity


    init {

        when (layout) {

            R.layout.activity_main -> setHomePage()
            R.layout.activity_display_results -> setResultPage(input.text.toString())

        }
    }


    fun setHomePage (){

        layout = R.layout.activity_main
        activity.setContentView(R.layout.activity_main)
        input = activity.findViewById(R.id.search_edit_text) as EditText
        Log.d ("current inout", input.toString())
        input.setOnEditorActionListener { v, actionId, event ->

            val handled = false
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                setResultPage(input.text.toString())
            }
            true
        }
    }

    fun setResultPage(inputFromUser : String){

        layout = R.layout.activity_display_results
        activity.setContentView(R.layout.activity_display_results)
        displayHash = activity.findViewById(R.id.display_results) as TextView
        Hashtag().execute(inputFromUser)
    }


    companion object {
        internal lateinit var input: EditText
        internal lateinit var displayHash: TextView
    }

}