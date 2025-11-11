package com.example.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

            // Comenzamos una transacción de fragmentos con el administrador de fragmentos (FragmentManager).
            supportFragmentManager.beginTransaction()
                // Añadimos una instancia de EjemploFragment al contenedor de fragmentos.
                // 'R.id.fragment_container' es el ID del FrameLayout en el layout 'activity_main.xml' donde queremos colocar el fragmento.
                // EjemploFragment() crea una nueva instancia de nuestro fragmento personalizado.
                .add(R.id.fragment_container, Fragment_Ejercicio())
                // Confirmamos la transacción. Esto efectivamente agrega el fragmento a la interfaz de usuario.
                .commit()
        }
    }
}

