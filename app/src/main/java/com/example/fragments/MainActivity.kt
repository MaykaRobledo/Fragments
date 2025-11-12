package com.example.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// Comprobamos si hay un estado previamente guardado (savedInstanceState).
        // Si savedInstanceState es null, significa que la actividad está comenzando por primera vez.
        // Si no es null, significa que la actividad se está recreando, por ejemplo, después de un cambio de orientación.
        if (savedInstanceState == null) {

//            val fragmentManager = supportFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            val fragment = EjemploFragment()
//            fragmentTransaction.add(R.id.fragment_container, fragment)
//            fragmentTransaction.commit()

            if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Fragment_Ejercicio())
                    .commit()
            }
        }
    }
}

