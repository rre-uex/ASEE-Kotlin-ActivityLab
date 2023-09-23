package es.unex.giiis.activitylabkotlin

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityOne : AppCompatActivity() {

    private val RESTART_KEY = "restart"
    private val RESUME_KEY = "resume"
    private val START_KEY = "start"
    private val CREATE_KEY = "create"
    private val STOP_KEY = "stop"
    private val PAUSE_KEY = "pause"

    // tag para logcat
    private val TAG = "Lab-ActivityOne"

    // contadores
    private var mCreate = 0
    private var mRestart = 0
    private var mStart = 0
    private var mResume = 0
    private var mPause = 0
    private var mStop = 0

    // etiquetas de la IU para mostrar contadores
    private lateinit var mTvCreate: TextView
    private lateinit var mTvRestart: TextView
    private lateinit var mTvStart: TextView
    private lateinit var mTvResume: TextView
    private lateinit var mTvPause: TextView
    private lateinit var mTvStop: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        mTvCreate = findViewById<View>(R.id.create) as TextView
        mTvRestart = findViewById<View>(R.id.restart) as TextView
        mTvStart = findViewById<View>(R.id.start) as TextView
        mTvResume = findViewById<View>(R.id.resume) as TextView
        mTvPause = findViewById<View>(R.id.pause) as TextView
        mTvStop = findViewById<View>(R.id.stop) as TextView

        val launchActivityTwoButton = findViewById<View>(R.id.bLaunchActivityTwo) as Button
        launchActivityTwoButton.setOnClickListener {
            val act2 = Intent(this@ActivityOne, ActivityTwo::class.java)
            startActivity(act2)
        }

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
        mPause++
    }

    override fun onStop() {
        super.onStop()

        Log.i(TAG, "onStop")
        mStop++
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
        mTvCreate.text = "onCreate(): $mCreate"
        mTvStart.text = "onStart(): $mStart"
        mTvResume.text = "onResume(): $mResume"
        mTvRestart.text = "onRestart(): $mRestart"
        mTvPause.text = "onPause(): $mPause"
        mTvStop.text = "onStop(): $mStop"
    }
}
