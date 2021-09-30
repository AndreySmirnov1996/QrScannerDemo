package ru.sber.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import ru.sber.R

class MainActivity : AppCompatActivity() {

    lateinit var btScan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btScan = findViewById(R.id.btnScan)
        btScan.setOnClickListener {
            val intentIntegrator = IntentIntegrator(this)
            intentIntegrator.setPrompt("For flash use volume up key")
            intentIntegrator.setBeepEnabled(true)
            intentIntegrator.setOrientationLocked(true)
            intentIntegrator.captureActivity = Capture::class.java
            intentIntegrator.initiateScan()

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val intentResult = IntentIntegrator.parseActivityResult(
            requestCode, resultCode, data
        )

        if (intentResult.contents != null) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Result")
            builder.setMessage(intentResult.contents)
            builder.setPositiveButton("OK") { dialogInterface, _ -> dialogInterface.dismiss() }
            builder.show()
        } else {
            Toast.makeText(applicationContext, "Oops you didn't scan anything", Toast.LENGTH_SHORT)
                .show()
        }


    }

}