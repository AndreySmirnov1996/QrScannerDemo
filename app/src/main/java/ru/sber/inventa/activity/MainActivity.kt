package ru.sber.inventa.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
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
            intentIntegrator.captureActivity = ScanActivity::class.java
            startForResult.launch(Intent(this, ScanActivity::class.java))
            intentIntegrator.initiateScan()
        }
    }

    //callback for get data from ScanActivity
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val data: Intent? = result.data

                val intentResult = IntentIntegrator.parseActivityResult(
                    result.resultCode, data
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
}