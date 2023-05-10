package com.example.movie_info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import com.example.movie_info.Fragments.First_Fragment
import com.example.movie_info.Fragments.Second_Fragment
import com.example.movie_info.Fragments.Third_Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    val fragment1: Fragment = First_Fragment()
    val fragment2: Fragment = Second_Fragment()
    val fragment3: Fragment = Third_Fragment()
    val fm: FragmentManager = supportFragmentManager
    var active = fragment1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setupBottomNavigation()




    }

    private fun setupBottomNavigation() {
        fm.beginTransaction().add(R.id.nav_host_fragment, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment,fragment1, "1").commit();
        val navigation = findViewById<View>(R.id.nvg) as BottomNavigationView

        navigation.setOnItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener= NavigationBarView.OnItemSelectedListener {
        when(it.itemId){
            R.id.display-> {
                supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                fm.beginTransaction().hide(active).show(fragment1).commit()
                active = fragment1
            }
            R.id.fav-> {
                supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                fm.beginTransaction().hide(active).show(fragment2).commit()
                active = fragment2
            }
            R.id.profile-> {
                supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                fm.beginTransaction().hide(active).show(fragment3).commit()
                active = fragment3
            }
        }
        false
    }





}