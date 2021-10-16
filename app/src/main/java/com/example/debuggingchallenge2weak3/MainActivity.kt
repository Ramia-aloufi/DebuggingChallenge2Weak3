package com.example.debuggingchallenge2weak3

import ListSelectionRecyclerViewAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
data class contryesCapital(val country:String,val capital: String)

class MainActivity : AppCompatActivity() {
    lateinit var listsRecyclerView: RecyclerView
    lateinit var fabButton: FloatingActionButton
    lateinit var alertDialogSubmitBtn: Button
    private var arrayListOfCountriesAndCapitals = arrayListOf(
        contryesCapital("Saudi Arabia", "Riyadh"),
        contryesCapital("Nigeria", "Abuja"),
        contryesCapital("Rwanda", "Kigali"),
        contryesCapital("USA", "Washington"),
        contryesCapital("China", "Beijing")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabButton = findViewById(R.id.fabBtn)


        fabButton.setOnClickListener {

            //AlertDialog
            val (dialogView, alertDialog) = setupAlertDialog()

            //Initialize edit texts
            val countryET = dialogView.findViewById<EditText>(R.id.countryEt)
            val capitalET = dialogView.findViewById<EditText>(R.id.capitalEt)

            //Store user's input text to variables


            alertDialogSubmitBtn.setOnClickListener {
                val countryText = countryET.text.toString()
                val capitalText = capitalET.text.toString()
                if (countryText.isEmpty() || capitalText.isEmpty() ){
                    Toast.makeText(this,"empty!",Toast.LENGTH_SHORT).show()
                }else{
                    arrayListOfCountriesAndCapitals.add(contryesCapital(countryText,capitalText))
                    alertDialog.dismiss()
                }
                //Add both texts to list

                //Add single entry list to Global list
                listsRecyclerView.adapter?.notifyDataSetChanged()



            }

        }
        setupRecyclerView()

    }

    private fun setupAlertDialog(): Pair<View, AlertDialog> {
        //Inflate layout for Alert Dialog
        val dialogView = LayoutInflater.from(this).inflate(R.layout.alert_dialog_layout, null)

        val builder = AlertDialog.Builder(this).setView(dialogView).setTitle("Country/Capital Form")
        val alertDialog = builder.show()
        alertDialogSubmitBtn = dialogView.findViewById(R.id.submitBtn)
        return Pair(dialogView, alertDialog)
    }

    private fun setupRecyclerView() {
        listsRecyclerView = findViewById(R.id.lists_recyclerview)
        listsRecyclerView.layoutManager = LinearLayoutManager(this)
        listsRecyclerView.adapter =
            ListSelectionRecyclerViewAdapter(arrayListOfCountriesAndCapitals)

    }
}