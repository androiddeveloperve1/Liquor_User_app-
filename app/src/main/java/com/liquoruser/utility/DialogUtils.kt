package com.liquoruser.utility

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class DialogUtils {
    companion object{

        fun onAlertDialog(context: Context, view: View) {
            //Instantiate builder variable
            val builder = AlertDialog.Builder(view.context)

            // set title
            builder.setTitle("New Update found")

            //set content area
            builder.setMessage("Update your android 9.0 to 10.0")

            //set negative button
            builder.setPositiveButton(
                "Update Now") { dialog, id ->
                // User clicked Update Now button
                Toast.makeText(context, "Updating your device",Toast.LENGTH_SHORT).show()
            }

            //set positive button
            builder.setNegativeButton(
                "Cancel") { dialog, id ->
                // User cancelled the dialog
            }

            //set neutral button
            builder.setNeutralButton("Reminder me latter") {dialog, id->
                // User Click on reminder me latter
            }
            builder.show()
        }
    }
}