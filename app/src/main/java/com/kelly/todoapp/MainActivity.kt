package com.kelly.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val validUserName: String = "Admin"
    val validPassWord: String = "Admin"

    //Layout variables
    private lateinit var userNameInput: EditText
    private lateinit var passWordInput: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userNameInput = findViewById(R.id.userNameInput)
        passWordInput = findViewById(R.id.passWordInput)
        submitButton = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            val username = userNameInput.text.toString()
            val password = passWordInput.text.toString()

            login(username, password)
        }
    }

    fun login(username: String, password: String) {
        if (isValidCredentials(username, password)) {
            val intent: Intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        } else {
            Toast.makeText(
                applicationContext,
                "You don type wrong details bros",
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }


    private fun isValidCredentials(username: String, password: String): Boolean {
        if (username == validUserName && password == validPassWord) return true
        return false
    }
}