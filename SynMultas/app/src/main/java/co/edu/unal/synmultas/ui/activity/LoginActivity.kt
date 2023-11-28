package co.edu.unal.synmultas.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import co.edu.unal.synmultas.R

class LoginActivity : AppCompatActivity() {

    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        setSupportActionBar(findViewById(R.id.toolbar))

        loginButton = findViewById(R.id.button_login)

        loginButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            this.startActivity(intent)
        }
    }
}