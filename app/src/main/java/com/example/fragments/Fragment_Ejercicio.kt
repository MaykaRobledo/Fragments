package com.example.fragments

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView


class Fragment_Ejercicio : Fragment() {
    private lateinit var spinner: Spinner
    private lateinit var textSeleccion: TextView

    private lateinit var equipos: Array<String>
    private val imagenes = intArrayOf(
        R.drawable.realmadrid,
        R.drawable.barca,
        R.drawable.atleticomadrid,
        R.drawable.manchestercity
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        return inflater.inflate(R.layout.fragment_activity, container, false)


    }


    // Este método se llama después de que la vista del fragmento haya sido creada.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) // Llamada al método de la superclase.
        equipos = resources.getStringArray(R.array.equipos_array)

        spinner = view.findViewById(R.id.spinner)
        textSeleccion = view.findViewById(R.id.equipoSeleccionada)

        // Adaptador personalizado
        val adaptador = object : ArrayAdapter<String>(requireContext(), R.layout.lineas_spinner, equipos) {

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                return crearFila(position, convertView, parent)
            }

            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                return crearFila(position, convertView, parent)
            }

            private fun crearFila(position: Int, convertView: View?, parent: ViewGroup): View {
                val rowView = convertView ?: LayoutInflater.from(context)
                    .inflate(R.layout.lineas_spinner, parent, false)

                val nombre = rowView.findViewById<TextView>(R.id.nombre)
                val imagen = rowView.findViewById<ImageView>(R.id.imagenEscudo)

                nombre.text = equipos[position]
                imagen.setImageResource(imagenes[position])

                return rowView
            }
        }

        spinner.adapter = adaptador

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                textSeleccion.text = "Seleccionaste: ${equipos[position]}"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                textSeleccion.text = "Nada seleccionado!"
            }
        }
    }
}