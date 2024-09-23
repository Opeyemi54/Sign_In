package com.hfad.signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val passwordEditText: TextInputLayout = findViewById(R.id.textInputLayout)
        val validatePassword :TextInputEditText = findViewById(R.id.LayoutPassword)

        validatePassword.setOnClickListener(){
            val enterPassword = passwordEditText.editText?.text.toString()
            if
                    (isStrongPassword(enterPassword)){
                passwordEditText.isErrorEnabled
            } else {
                Toast.makeText(this,"Password must be at least 8 characters long and contain" +
                        "at least one uppercase letter, one lowercase letter, and one digit.",Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun
            isStrongPassword(password: String): Boolean {
        val regex = Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}\$")
        return regex.matches(password)
    }
}