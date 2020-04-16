package com.rsanchez.appareaseys.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.rsanchez.appareaseys.R
import com.rsanchez.appareaseys.ui.fragment.ListaFragment


class MainActivity : AppCompatActivity() {

    val TAG = "Fragment_lista"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentTransaction(ListaFragment.newInstance())

    }

    private fun fragmentTransaction(fragment : Fragment){
        supportFragmentManager.
            beginTransaction()
            .add(R.id.container,fragment,TAG)
            .commit()
    }


}
