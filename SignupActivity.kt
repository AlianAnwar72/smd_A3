package com.alian.i210730

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDatabase: FirebaseDatabase
    private lateinit var mUsersRef: DatabaseReference
    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var editTextCountry: EditText
    private lateinit var editTextCity: EditText
    private lateinit var editTextPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance()
        mUsersRef = mDatabase.getReference("users")
        editTextName = findViewById(R.id.editTextName)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber)
        editTextCountry = findViewById(R.id.editTextCountry)
        editTextCity = findViewById(R.id.editTextCity)
        editTextPassword = findViewById(R.id.editTextPassword)
    }

    fun toLogin(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    //fun toVerify(view: View) {
    //  val intent = Intent(this, VerificationActivity::class.java)
    // startActivity(intent)
    //  finish()
    //}

    fun signup(view: View) {
        val name = editTextName.text.toString().trim()
        val email = editTextEmail.text.toString().trim()
        val phonenumber = editTextPhoneNumber.text.toString().trim()
        val country = editTextCountry.text.toString().trim()
        val city = editTextCity.text.toString().trim()
        val password = editTextPassword.text.toString().trim()
        println("Name: $name, Email: $email, Phone Number: $phonenumber, Country: $country, City: $city, Password: $password")

        if (email.isEmpty()) {
            editTextEmail.error = "Email is required"
            return
        }

        if (password.isEmpty()) {
            editTextPassword.error = "Password is required"
            return
        }

        if (password.length < 8) {
            editTextPassword.error = "Password must be at least 8 characters long"
            return
        }

        // Register the user
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Save additional user information to Realtime Database
                    val userId = mAuth.currentUser!!.uid
                    val currentUserRef = mUsersRef.child(userId)
                    currentUserRef.child("name").setValue(name)
                    currentUserRef.child("email").setValue(email)
                    currentUserRef.child("phonenumber").setValue(phonenumber)
                    currentUserRef.child("country").setValue(country)
                    currentUserRef.child("city").setValue(city)
                    currentUserRef.child("password").setValue(password)

                    Toast.makeText(this@SignupActivity, "User registered successfully", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@SignupActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this@SignupActivity, "Registration failed: " + task.exception?.message, Toast.LENGTH_SHORT).show()
                    Log.e("TAG", "Registration failed", task.exception)
                }
            }
    }
}
