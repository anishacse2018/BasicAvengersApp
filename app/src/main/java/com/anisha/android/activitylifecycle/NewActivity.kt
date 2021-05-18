package com.anisha.android.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class NewActivity : AppCompatActivity(){
    lateinit var sharedPreferences: SharedPreferences
    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val validMobileNumber="1234567890"
    val validPassword=arrayOf("thanos","steve","tony","bruce")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
         val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_new)
        if(isLoggedIn) {
            val intent = Intent(this@NewActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        title="Log In"

        etMobileNumber=findViewById(R.id.etMobileNumber)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
        txtForgotPassword=findViewById(R.id.txtForgotPassword)
        txtRegister=findViewById(R.id.txtRegister)


        btnLogin.setOnClickListener{
            val mobileNumber=etMobileNumber.text.toString()
            val password=etPassword.text.toString()
            val intent= Intent(this@NewActivity,MainActivity::class.java)
            var nameOfAvenger="Avenger"
            if(mobileNumber==validMobileNumber)
            {
               if(password==validPassword[0]) {

                    nameOfAvenger="The Avengers"
                   savePreferences(nameOfAvenger)

                   startActivity(intent)

               }
                else if(password==validPassword[1]) {

                    nameOfAvenger="Captain America"
                   savePreferences(nameOfAvenger)

                    startActivity(intent)

                }
                else if(password==validPassword[2]) {
                    nameOfAvenger="Tony Stark"
                   savePreferences(nameOfAvenger)

                    startActivity(intent)

                }
                else if(password==validPassword[3]) {

                    nameOfAvenger="Hulk"
                   savePreferences(nameOfAvenger)

                    startActivity(intent)

                }
                else{
                   Toast.makeText(
                       this@NewActivity,
                       "Incorrect Credentials!Pls enter Valid mobile number and password",
                       Toast.LENGTH_LONG
                   ).show()
               }

            }else {
                Toast.makeText(
                    this@NewActivity,
                    "Incorrect Credentials!Pls enter Valid mobile number and password",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }
    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}
