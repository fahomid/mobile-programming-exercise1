package com.cdnbeats.mobileprogramming
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting views
        var flag : String = "sum"
        val spinnerVal : Spinner = findViewById(R.id.option)
        val options = arrayOf("sum","multiply")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        // handling spinner event
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val input1: EditText = findViewById(R.id.input1)
        val input2: EditText = findViewById(R.id.input2)
        val result: TextView = findViewById(R.id.result)
        val button: Button = findViewById(R.id.button)

        // on click button check  and calculate result
        button.setOnClickListener{ view ->
            //code here
            val x: Int = input1.text.toString().toInt();
            val y: Int = input2.text.toString().toInt();
            if(flag =="sum")
                result.text = sum(x,y).toString();
            else
                result.text = multiply(x,y).toString();
        }
    }
    // function for summation
    private fun sum(a: Int, b: Int): Int {
        return a+b
    }
    // function for multiplication
    private fun multiply(a: Int, b: Int): Int {
        return a*b
    }
}