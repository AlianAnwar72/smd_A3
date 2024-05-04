//package com.hamdan.i210724

/*import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class EditProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
    }

    fun toMyProfile(view: View) {
        val intent = Intent(this,MyProfile::class.java)
        view.context.startActivity(intent)
        finish()
    }
}*/

package com.alian.i210730

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class EditProfile : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDatabase: FirebaseDatabase
    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var editTextCountry: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance()

        editTextName = findViewById(R.id.editTextName)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPhoneNumber = findViewById(R.id.editContactNumber)
        editTextCountry = findViewById(R.id.editTextCountry)

        // Retrieve user profile data and set it to EditText fields
        val currentUser = mAuth.currentUser
        currentUser?.let { user ->
            editTextName.setText(user.displayName)
            editTextEmail.setText(user.email)
            // Assuming phone number is stored in user's profile
            editTextPhoneNumber.setText(user.phoneNumber)
        }
    }

    fun backtoMyProfile(view: View) {
        val intent = Intent(this, MyProfile::class.java)
        startActivity(intent)
        finish()
    }

    fun toMyProfile(view: View) {
        // Update user profile data in Realtime Database
        val userId = mAuth.currentUser?.uid
        val name = editTextName.text.toString()
        val email = editTextEmail.text.toString()
        val phoneNumber = editTextPhoneNumber.text.toString()
        val country = editTextCountry.text.toString()

        userId?.let {
            val currentUserRef = mDatabase.getReference("users").child(it)
            currentUserRef.child("name").setValue(name)
            currentUserRef.child("email").setValue(email)
            currentUserRef.child("phoneNumber").setValue(phoneNumber)
            currentUserRef.child("country").setValue(country)

            Toast.makeText(this@EditProfile, "Profile updated successfully", Toast.LENGTH_SHORT).show()
        }

        // Navigate back to MyProfile activity
        val intent = Intent(this, MyProfile::class.java)
        startActivity(intent)
        finish()
    }
}
