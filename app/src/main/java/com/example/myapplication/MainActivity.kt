package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Create Fragment objects in the MainActivity
    private val homeFragment = HomeFragment()
    private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //Initialize the button view and implement the onClickListeners
        val button:Button = findViewById(R.id.button)
        val button2:Button = findViewById(R.id.button2)

        button.setOnClickListener(){
            loadHome()

        }

        button2.setOnClickListener(){
            loadSettings()

        }

    }

    //implement the loadHome function
    private fun loadHome(){
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if(fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, homeFragment).commit()
        } else{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, homeFragment).commit()
        }

    }


    //implement the loadSettings function
    private fun loadSettings(){
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if(fragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, settingsFragment).commit()
        } else{
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, settingsFragment).commit()
        }
    }
}