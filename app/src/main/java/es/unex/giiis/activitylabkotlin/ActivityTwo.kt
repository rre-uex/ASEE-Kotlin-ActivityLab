package es.unex.giiis.activitylabkotlin

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityTwo : AppCompatActivity() {

    private val RESTART_KEY = "restart"
    private val RESUME_KEY = "resume"
    private val START_KEY = "start"
    private val CREATE_KEY = "create"

    // tag para logcat
    private val TAG = "Lab-ActivityTwo"

    // contadores
    private var mCreate: Short = 0
    private var mRestart: Short = 0
    private var mStart: Short = 0
    private var mResume: Short = 0

    // etiquetas de la IU para mostrar contadores
    var mTvCreate: TextView? = null
    var mTvRestart: TextView? = null
    var mTvStart: TextView? = null
    var mTvResume: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        mTvCreate = findViewById<View>(R.id.create) as TextView
        mTvRestart = findViewById<View>(R.id.restart) as TextView
        mTvStart = findViewById<View>(R.id.start) as TextView
        mTvResume = findViewById<View>(R.id.resume) as TextView

        val closeButton = findViewById<View>(R.id.bClose) as Button
        closeButton.setOnClickListener { finish() }

        // Comprobar si estado previo guardado
        if (savedInstanceState != null) {
            // TODO Restaurar estado anterior
        }

        Log.i(TAG, "onCreate")
        mCreate++
        mostrarContadores()
    }

    override fun onStart() {
        super.onStart()

        Log.i(TAG, "onStart")
        mStart++
        mostrarContadores()
    }

    override fun onResume() {
        super.onResume()

        Log.i(TAG, "onResume")
        mResume++
        mostrarContadores()
    }

    override fun onPause() {
        super.onPause()

        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i(TAG, "onRestart")
        mRestart++
        mostrarContadores()
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i(TAG, "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        // TODO Guardar estado actual antes de recreación

        super.onSaveInstanceState(outState, outPersistentState)
    }

    // Actualizar IU con valor de contadores (estado Activity)
    fun mostrarContadores() {
        mTvCreate!!.text = "onCreate(): $mCreate"
        mTvStart!!.text = "onStart(): $mStart"
        mTvResume!!.text = "onResume(): $mResume"
        mTvRestart!!.text = "onRestart(): $mRestart"
    }
}
