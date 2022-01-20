package com.apsnonaccurate

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.apsnonaccurate.activity.LoginActivity
import com.apsnonaccurate.fragment.*
import com.apsnonaccurate.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val fragmentHome : Fragment = HomeFragment()
    private val fragmentProduk : Fragment = ProdukFragment()
    private val fragmentScanner : Fragment = ScannerFragment()
    private val fragmentSupport : Fragment = SupportFragment()
    private val fragmentProfil : Fragment = ProfilFragment()
    private val fm: FragmentManager = supportFragmentManager
    private var active : Fragment = fragmentHome

    private lateinit var menu : Menu
    private lateinit var menuItem: MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    private val statusLogin = false

    private lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        s = SharedPref(this)

        setUpBottomNav()

    }

    fun setUpBottomNav(){
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentProduk).hide(fragmentProfil).commit()
        fm.beginTransaction().add(R.id.container, fragmentScanner).hide(fragmentScanner).commit()
        fm.beginTransaction().add(R.id.container, fragmentSupport).hide(fragmentSupport).commit()
        fm.beginTransaction().add(R.id.container, fragmentProfil).hide(fragmentProfil).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when(item.itemId){
                R.id.navigation_home ->{
                    callFragment(0,fragmentHome)
                }
                R.id.navigation_produk ->{
                    callFragment(1,fragmentProduk)
                }
                R.id.navigation_scanner ->{
                    callFragment(2,fragmentScanner)
                }
                R.id.navigation_support ->{
                    callFragment(3,fragmentSupport)
                }
                R.id.navigation_profil ->{
                    if (s.getStatusLogin()){
                        callFragment(4,fragmentProfil)
                    }else{
                        startActivity(Intent(this, LoginActivity::class.java))
                    }

                }
            }

            false
        }
    }

    fun callFragment(int: Int, fragment: Fragment){
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}