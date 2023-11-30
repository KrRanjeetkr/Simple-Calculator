package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.calc.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            expresions("1")
        }
        binding.button2.setOnClickListener {
            expresions("2")
        }
        binding.button3.setOnClickListener {
            expresions("3")
        }
        binding.button4.setOnClickListener {
            expresions("4")
        }
        binding.button5.setOnClickListener {
            expresions("5")
        }
        binding.button6.setOnClickListener {
            expresions("6")
        }
        binding.button7.setOnClickListener {
            expresions("7")
        }
        binding.button8.setOnClickListener {
            expresions("8")
        }
        binding.button9.setOnClickListener {
            expresions("9")
        }
        binding.button0.setOnClickListener {
            expresions("0")
        }
        binding.button00.setOnClickListener {
            expresions("00")
        }
        binding.dot.setOnClickListener {
            expresions(".")
        }
        binding.pluse.setOnClickListener {
            expresions("+")
        }
        binding.minus.setOnClickListener {
            expresions("-")
        }
        binding.multyply.setOnClickListener {
            expresions("*")
        }
        binding.divid.setOnClickListener {
            expresions("/")
        }
        binding.percentage.setOnClickListener {
            expresions("%")
        }
        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        binding.equal.setOnClickListener {
           try {
               val expression = ExpressionBuilder(binding.inputtext.text.toString()).build()
               val result  = expression.evaluate()
               val longResult = result.toLong()
               if (result == longResult.toDouble()){
                   binding.result.text = longResult.toString()
               }else{
                   binding.result.text = result.toString()
               }
           }catch (e : Exception){
               binding.result.text = "Error"
           }
        }

//        binding.allClear.setOnClickListener {
//            delete()
//        }
        binding.allClear.setOnClickListener {
            allclear()
        }
    }

    private fun allclear() {
        binding.inputtext.text = ""
    }

//    private fun delete() {
//        val currentText = binding.inputtext.text.toString()
//        if (currentText.isNotEmpty()){
//            binding.inputtext.setText((currentText.substring(0,currentText.length -1)))
//        }
//    }

    private fun expresions(value: String) {

        binding.inputtext.append(value)

    }
}