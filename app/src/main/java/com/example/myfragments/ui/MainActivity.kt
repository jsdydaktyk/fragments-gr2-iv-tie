package com.example.myfragments.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.myfragments.R
import com.example.myfragments.ui.fragments.ArrowFragment
import com.example.myfragments.ui.fragments.ContactFragment
import com.example.myfragments.ui.fragments.WelcomeFragment
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var myToolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myToolbar=findViewById(R.id.my_toolbar)
        setSupportActionBar(myToolbar)

        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.welcome_fragment_container, WelcomeFragment())
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.arrow_forward -> replaceFragment(ArrowFragment())
            R.id.home -> replaceFragment(WelcomeFragment())
            R.id.contact_page -> replaceFragment(ContactFragment())
        }

        return super.onOptionsItemSelected(item)

    }

    private fun replaceFragment(fragment: Fragment){
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.welcome_fragment_container, fragment)
//            .commit()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
//https://www.tutlane.com/tutorial/android/android-animations-with-examples
        fragmentTransaction.setCustomAnimations(
            R.anim.slide_up,
            R.anim.slide_down,
        )

        fragmentTransaction.replace(
            R.id.welcome_fragment_container,
            fragment)
        fragmentTransaction.commit()
    }

}














//penis