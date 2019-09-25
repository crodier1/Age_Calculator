package christianrodier.com


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar as Calendar
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Build
import android.os.PersistableBundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import christianrodier.com.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDate.parse
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityMainBinding

    lateinit var etYear: EditText
    lateinit var tvAge: TextView

    lateinit var btnCalc: Button
    lateinit var button0: Button
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button

    lateinit var buttonback: Button

    var age: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)





        etYear = findViewById(R.id.etYear)
        tvAge = findViewById(R.id.tvAge)
        btnCalc = findViewById(R.id.btnCalc)

        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)


        buttonback = findViewById(R.id.buttonBack)


        binding.button0.setOnClickListener{
            etYear.append(button0.text)
        }

       binding.button1.setOnClickListener {
            etYear.append(button1.text)
        }

        binding.button2.setOnClickListener{
            etYear.append(button2.text)
        }

        binding.button3.setOnClickListener{
            etYear.append(button3.text)
        }

        binding.button4.setOnClickListener{
            etYear.append(button4.text)
        }

        binding.button5.setOnClickListener{
            etYear.append(button5.text)
        }

        binding.button6.setOnClickListener{
            etYear.append(button6.text)
        }

        binding.button7.setOnClickListener{
            etYear.append(button7.text)
        }

        binding.button8.setOnClickListener{
            etYear.append(button8.text)
        }

        binding.button9.setOnClickListener{
            etYear.append(button9.text)
        }

        binding.buttonBack.setOnClickListener{
            etYear.setText(etYear.text.dropLast(1))
        }

    }




    @RequiresApi(Build.VERSION_CODES.O)
    fun btnCalcClick(view: View) {

        val currentYear: Calendar = Calendar.getInstance()


        var solution =  currentYear.get(Calendar.YEAR) - etYear.text.toString().toInt()


        if(solution >= 0){

            age  = "Age: $solution"

            tvAge.text = age

            etYear.setText("")

        } else {

            Toast.makeText(applicationContext, "Invalid year entered", Toast.LENGTH_SHORT).show()
        }

    }



    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)

        if(!age.isNullOrBlank()){

            outState!!.putString("Age", age)
        }


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        age = savedInstanceState!!.getString("Age")

        tvAge.text = age
    }
}
