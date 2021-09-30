package ru.sber.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.sber.App
import ru.sber.R
import ru.sber.service.SecurityService
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var securityService: SecurityService
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        (application as App).appComponent.injectLoginActivity(this)

        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            if (securityService.checkUser()){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("key", "value")
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Try again, bitch", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }
}